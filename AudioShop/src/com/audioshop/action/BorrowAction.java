package com.audioshop.action;

import java.awt.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;

import com.audioshop.model.Audio;
import com.audioshop.model.BorrowRecord;
import com.audioshop.model.User;
import com.audioshop.service.AudioService;
import com.audioshop.service.BorrowRecordService;
import com.audioshop.util.IDTools;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class BorrowAction extends ActionSupport{
	@Resource
	private BorrowRecordService borrowRecordService;
	@Resource
	private AudioService audioService;
	
	String audioID;	
	public String getAudioID() {
		return audioID;
	}
	public void setAudioID(String audioID) {
		this.audioID = audioID;
	}
	
	String userID;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	
	//添加借资料项
	public String addBorrowAudio(){
		
		Map<String, Object> session = ActionContext.getContext().getSession(); 
		ArrayList<Audio> audioList=(ArrayList<Audio>)session.get("audioList");
		
		if(audioList==null){
			audioList=new ArrayList<Audio>();
		}
		
		//Audio audio=audioService.findObjectById(audioID);
		Audio audio=audioService.findObjectById("123");
		audioList.add(audio);
		
		ActionContext.getContext().getSession().put("audioList", audioList);
		
		return SUCCESS;
	}
	
	
	//确认借资料
	public String borrow(){
		
		Map<String, Object> session = ActionContext.getContext().getSession(); 
		ArrayList<Audio> audioList=(ArrayList<Audio>)session.get("audioList");
		
		HashMap<String, Integer> audioMap=new HashMap<String, Integer>();	
		Iterator<Audio> iterator=audioList.iterator();	
		while (iterator.hasNext()){
			Audio audio=new Audio();
			audio=(Audio)iterator.next();
			Integer number=1;
			if(audioMap.containsKey(audio.getId())){
				number=audioMap.get(audio.getId())+1;
			}

			audioMap.put(audio.getId(), number);			
		}
		
		Iterator<Map.Entry<String, Integer>> iterator2=audioMap.entrySet().iterator();
		while (iterator2.hasNext()){
			Map.Entry<String, Integer> entry=(Map.Entry<String, Integer>)iterator2.next();
			Audio audio=audioService.findObjectById(entry.getKey());			
			Integer n=entry.getValue();
			
			int stock=audio.getStock();
			audio.setStock(stock-n);
			audioService.update(audio);
			
			BorrowRecord borrowRecord=new BorrowRecord();
			borrowRecord.setId(IDTools.getId());
			borrowRecord.setAudio(audio);
			borrowRecord.setBorrowDate(new Date());
			borrowRecord.setNumber(n.toString());
			User user=new User();
			//user.setId(userID);
			user.setId(1);
			borrowRecord.setUser(user);
			borrowRecordService.save(borrowRecord);
		}
		
		ActionContext.getContext().getSession().put("audioList", null);
		
		return SUCCESS;
	}
	
}
