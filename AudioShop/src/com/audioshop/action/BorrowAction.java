package com.audioshop.action;

import java.awt.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.audioshop.common.Msg;
import com.audioshop.model.Audio;
import com.audioshop.model.BorrowRecord;
import com.audioshop.model.ReservationRecord;
import com.audioshop.model.User;
import com.audioshop.service.AudioService;
import com.audioshop.service.BorrowRecordService;
import com.audioshop.service.ReservationRecordService;
import com.audioshop.service.UserService;
import com.audioshop.util.IDTools;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class BorrowAction extends ActionSupport{
	@Resource
	private BorrowRecordService borrowRecordService;
	@Resource
	private AudioService audioService;
	@Resource
	private UserService userService;
	@Resource
	private ReservationRecordService reservationRecordService;
	
	int audioID;	
	public int getAudioID() {
		return audioID;
	}
	public void setAudioID(int audioID) {
		this.audioID = audioID;
	}
	
	int userID;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String toBorrow(){
		return "toBorrow";
	}
	
	//确认借阅人
	public String checkUser(){
		
		User user=userService.findObjectById(userID);
		
		if(user==null||user.getAuthor()!=1){
			
			Msg msg=new Msg();
			msg.setMsg("无该用户信息！");
			msg.setState(0);
			ServletActionContext.getRequest().setAttribute("msg", msg);
			return "showMsg";
		}
		else{
			ActionContext.getContext().getSession().put("borrowUserID", userID);
			
			ArrayList<ReservationRecord> reservationRecordList=reservationRecordService.findByUser(user);
			ArrayList<Audio> audioList=new ArrayList<Audio>();
			
			if(reservationRecordList.size()>0){
				Iterator<ReservationRecord> iterator=reservationRecordList.iterator();
				while (iterator.hasNext()) {
					Audio audio=new Audio();
					ReservationRecord reservationRecord=new ReservationRecord();
					reservationRecord=(ReservationRecord)iterator.next();
					audio=reservationRecord.getAudio();
					audioList.add(audio);		
				}
				ActionContext.getContext().getSession().put("reservationRecordList", reservationRecordList);
				ActionContext.getContext().getSession().put("borrowAudioList", audioList);			
			}
			
		}
		
		return SUCCESS;
	}
	
	//添加借资料项
	public String addBorrowAudio(){
		
		Map<String, Object> session = ActionContext.getContext().getSession(); 
		ArrayList<Audio> audioList=(ArrayList<Audio>)session.get("borrowAudioList");
		
		if(audioList==null){
			audioList=new ArrayList<Audio>();
		}
		
		Audio audio=audioService.findObjectById(audioID);
		//Audio audio=audioService.findObjectById(123);
		if(audio!=null){
			audioList.add(audio);
		}
		
		
		ActionContext.getContext().getSession().put("borrowAudioList", audioList);

		return SUCCESS;
	}
	
	
	//确认借资料
	public String borrow(){
		
		//获取SESSION
		Map<String, Object> session = ActionContext.getContext().getSession(); 
		ArrayList<Audio> audioList=(ArrayList<Audio>)session.get("borrowAudioList");
		int borrowUserID=Integer.parseInt(session.get("borrowUserID").toString());
		ArrayList<ReservationRecord> reservationRecordList=(ArrayList<ReservationRecord>)session.get("reservationRecordList");
		
		HashMap<Integer, Integer> audioMap=new HashMap<Integer, Integer>();	
		Iterator<Audio> iterator=audioList.iterator();	
		while (iterator.hasNext()){
			Audio audio=new Audio();
			audio=(Audio)iterator.next();
			Integer number=1;
			
			if(audio!=null){
				if(audioMap.containsKey(audio.getId())){
					number=audioMap.get(audio.getId())+1;
				}

				audioMap.put(audio.getId(), number);
			}
		}
		
		Iterator<Map.Entry<Integer, Integer>> iterator2=audioMap.entrySet().iterator();
		while (iterator2.hasNext()){
			Map.Entry<Integer, Integer> entry=(Map.Entry<Integer, Integer>)iterator2.next();
			Audio audio=audioService.findObjectById(entry.getKey());			
			Integer n=entry.getValue();
			
			int stock=audio.getStock();
			audio.setStock(stock-n);
			audioService.update(audio);
			
			//增加借阅记录
			BorrowRecord borrowRecord=new BorrowRecord();
			borrowRecord.setId(IDTools.getId());
			borrowRecord.setAudio(audio);
			borrowRecord.setBorrowDate(new Date());
			borrowRecord.setNumber(n.toString());
			User user=new User();
			user.setId(borrowUserID);
			borrowRecord.setUser(user);
			borrowRecordService.save(borrowRecord);
			
			
		}
		
		//删除预约记录
		if(reservationRecordList!=null){
			Iterator<ReservationRecord> iterator3=reservationRecordList.iterator();
			while (iterator3.hasNext()) {
				ReservationRecord reservationRecord=new ReservationRecord();
				reservationRecord=iterator3.next();
				Audio audio=new Audio();
				audio=reservationRecord.getAudio();
				reservationRecordService.delete(reservationRecord.getId());
				int reservation=audio.getReservation()-1;
				audio.setReservation(reservation);
				audioService.update(audio);
			
			}
		}
		
		
		ActionContext.getContext().getSession().put("reservationRecordList", null);
		ActionContext.getContext().getSession().put("borrowUserID", null);			
		ActionContext.getContext().getSession().put("borrowAudioList", null);
		
		return SUCCESS;
	}
	
}
