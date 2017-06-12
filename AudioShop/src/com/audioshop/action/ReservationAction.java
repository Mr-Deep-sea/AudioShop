package com.audioshop.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.audioshop.common.Msg;
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
	

	public String reservation(){

		Msg msg=new Msg();
		//获取SESSION
		User user=(User)ActionContext.getContext().getSession().get("existCommonUser");
		if(user==null){
			return "commonLogin";
		}
		String audioIDString=ServletActionContext.getRequest().getParameter("audioID").toString();
		int audioID=Integer.parseInt(audioIDString);
		
		Audio audio=new Audio();		
		audio=audioService.findObjectById(audioID);
		
		ReservationRecord reservationRecord=new ReservationRecord();
		reservationRecord.setUser(user);
		reservationRecord.setAudio(audio);
		reservationRecord.setDate(new Date());
		reservationRecord.setId(IDTools.getId());		
		if (audio.getStock()-audio.getReservation()>0) {
			reservationRecordService.save(reservationRecord);
			int reservation=audio.getReservation()+1;
			audio.setReservation(reservation);
			audioService.update(audio);
		}
		else{
			msg.setMsg("预约失败！");
			 msg.setState(0);
			 ServletActionContext.getRequest().setAttribute("msg", msg);
			return "showMsg";
		}
		
		 List<Audio> allAudioList=audioService.findObjects();
		 ServletActionContext.getRequest().setAttribute("allAudioList", allAudioList);
		 
		 
		 
		 msg.setMsg("预约成功！");
		 msg.setState(0);
		 ServletActionContext.getRequest().setAttribute("msg", msg);
		return "showMsg";
		
	}
		
		
		
}