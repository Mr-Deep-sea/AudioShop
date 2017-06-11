package com.audioshop.action;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import com.audioshop.model.Audio;
import com.audioshop.model.ReservationRecord;
import com.audioshop.model.User;
import com.audioshop.service.AudioService;
import com.audioshop.service.ReservationRecordService;
import com.audioshop.util.IDTools;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ReservationAction extends ActionSupport{
	
	@Resource
	private AudioService audioService;
	@Resource
	private ReservationRecordService reservationRecordService;
	
	int audioID;
	
	public int getAudioID() {
		return audioID;
	}

	public void setAudioID(int audioID) {
		this.audioID = audioID;
	}

	public String reservation(){
		
		//获取SESSION
		User user=new User();
		user.setId("1");
		
		Audio audio=new Audio();		
		//audio=audioServiceImpl.findObjectById(audioID);
		audio=audioService.findObjectById("123");
		
		ReservationRecord reservationRecord=new ReservationRecord();
		reservationRecord.setUser(user);
		reservationRecord.setAudio(audio);
		reservationRecord.setDate(new Date());
		reservationRecord.setId(IDTools.getId());		
		if (audio.getStock()-audio.getReservation()>0) {
			reservationRecordService.save(reservationRecord);
		}
		else{
			return ERROR;
		}
		
		return SUCCESS;
	}
		
		
		
}