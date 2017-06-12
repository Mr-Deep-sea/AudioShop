package com.audioshop.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import com.audioshop.service.ReturnService;
import com.audioshop.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ReturnAction extends ActionSupport {
	@Resource
	private BorrowRecordService borrowRecordService;
	@Resource
	private AudioService audioService;
	@Resource
	private ReturnService returnService;
	@Resource
	private UserService userService;
	
	private Integer userID;
	private Integer audioID;

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getAudioID() {
		return audioID;
	}

	public void setAudioID(Integer audioID) {
		this.audioID = audioID;
	}

	public String toReturn() {
		return "toReturn";
	}

	//确认借阅人
	public String checkUser(){
			
		User user=userService.findObjectById(userID);
			
		if(user==null){
			return ERROR;
		}
		else{
			Msg msg=new Msg();
				
			List<BorrowRecord> borrowRecords=returnService.findAudiosbyUserId(userID);
				
			if(borrowRecords==null||borrowRecords.size()==0){
				msg.setMsg("该用户无借阅信息！");
				msg.setState(0);
				ServletActionContext.getRequest().setAttribute("msg", msg);
				return "showMsg";
			}
			else {
				ActionContext.getContext().getSession().put("borrowRecordList", borrowRecords);
				ActionContext.getContext().getSession().put("borrowUserID", userID);
			}
	
		}
			
		return SUCCESS;
	}
		
		
	
	public String deleteborrowRecord() {

		Msg msg = new Msg();
		
		Map<String, Object> session = ActionContext.getContext().getSession(); 		
		List<BorrowRecord> borrowRecordrs =(List<BorrowRecord> )session.get("borrowRecordList");
		
		if (borrowRecordrs != null && borrowRecordrs.size() > 0) {
			Iterator<BorrowRecord> iterator=borrowRecordrs.iterator();
			while(iterator.hasNext()){
				BorrowRecord borrowRecord=new BorrowRecord();
				borrowRecord=iterator.next();
				
				borrowRecordService.delete(borrowRecord.getId());
				Audio audio1 = borrowRecord.getAudio();
				int stock = audio1.getStock()
						+ Integer.parseInt(borrowRecordrs.get(0).getNumber());
				audio1.setStock(stock);
				audioService.update(audio1);
				
			}
			msg.setMsg("还资料成功！");
			msg.setState(1);
			msg.setUrl("workerReturn_toReturn.action");
			ServletActionContext.getRequest().setAttribute("msg", msg);
			
			ActionContext.getContext().getSession().put("borrowUserID", null);
			ActionContext.getContext().getSession().put("borrowRecordList", null);
			return "showMsg";
		}
		
		msg.setMsg("借阅信息不存在！");
		msg.setState(-1);
		ServletActionContext.getRequest().setAttribute("msg", msg);
		
		return "showMsg";
	}
}
