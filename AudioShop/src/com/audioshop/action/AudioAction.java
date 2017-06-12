package com.audioshop.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.audioshop.common.Msg;
import com.audioshop.model.Audio;
import com.audioshop.model.BorrowRecord;
import com.audioshop.model.Category;
import com.audioshop.service.AudioService;
import com.audioshop.service.BorrowRecordService;
import com.audioshop.service.CategoryService;
import com.audioshop.util.PageResult;
import com.audioshop.util.QueryHelper;
import com.opensymphony.xwork2.ActionSupport;

public class AudioAction extends ActionSupport {
	private Audio audio;
	private Integer pageNo;
	@Resource
	private BorrowRecordService borrowRecordService;
	@Resource
	private CategoryService categoryService;
	@Resource
	private AudioService audioService;
	
	public Audio getAudio() {
		return audio;
	}
	public void setAudio(Audio audio) {
		this.audio = audio;
	}
	


	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public String toAddAudio() {
		ServletActionContext.getRequest().setAttribute("categorys", categoryService.findObjects());
		return "showAddAudio";
	}
	public String showAudio(){
		QueryHelper queryHelper=new QueryHelper(Audio.class, "a");
		PageResult pageResult;
		if(pageNo==null){
			 pageResult=audioService.getPageResult(queryHelper, 1, 20);
			
		}else{
			 pageResult=audioService.getPageResult(queryHelper, pageNo, 20);
		}
		ServletActionContext.getRequest().setAttribute("pageResult", pageResult);
		//ServletActionContext.getRequest().setAttribute("audios", pageResult.getItems());
		
		return "showAllAudio";
	}
	
	public String toVipShowAudio(){
	    List<Audio> allAudioList=audioService.findObjects();
	    ServletActionContext.getRequest().setAttribute("allAudioList", allAudioList);
		return "toVipShowAudio";
	}
	
	public String doAddAudio(){
		
		Msg msg=new Msg();
		
		if(StringUtils.isBlank(audio.getName())||StringUtils.isBlank(audio.getOtherItem())
				||StringUtils.isBlank(audio.getCategory().getId())||audio.getStock()==null){
			msg.setMsg("添加失败！");
			msg.setState(0);
			ServletActionContext.getRequest().setAttribute("msg", msg);
			//msg.setUrl(ServletActionContext.getRequest().getRequestURL().toString());
			return "showMsg";
		}
		audioService.save(audio);
		msg.setMsg("添加成功！");
		msg.setUrl("audio_showAudio.action");
		msg.setState(1);
		ServletActionContext.getRequest().setAttribute("msg", msg);
		return "showMsg";
	}
	public String toAllAudio() {
		List<Audio> audios=audioService.findObjects();
		ServletActionContext.getRequest().setAttribute("audios", audios);
		return "allAudio";
	}
	public String deleteAudio(){
		/*if(audio.getId()==null){
			
			return "showMsg";
		}
		*/
		Msg msg=new Msg();
		if(audio==null||audio.getId()==null){
			msg.setMsg("资料不存在！");
			msg.setState(0);
			ServletActionContext.getRequest().setAttribute("msg", msg);
			return "showMsg";
		}
		Audio audio1=audioService.findObjectById(audio.getId());
		List<BorrowRecord> borrowRecords=borrowRecordService.findAudioId(audio1.getId());
		int audiolistsize=99;
		if(borrowRecords!=null){
			if(borrowRecords.size()>=0){
				audiolistsize=borrowRecords.size();
			}
		}else{
			audiolistsize=0;
		}

		if(audio1!=null){
			if(audio1.getStock()>0||audio1.getReservation()>0||audiolistsize>0){
				msg.setMsg("该资料已被锁定（剩余库存量不为零|资料被借阅|资料被预约），无法删除！");
				msg.setState(0);
				ServletActionContext.getRequest().setAttribute("msg", msg);
				return "showMsg";
			}
			else{
				audioService.delete(audio1.getId());
				msg.setMsg("删除成功！");
				msg.setState(1);
				msg.setUrl("workerAudio_toAllAudio.action");
				ServletActionContext.getRequest().setAttribute("msg", msg);
				return "showMsg";
			}
		}
		msg.setMsg("无资料ID");
		msg.setState(0);
		ServletActionContext.getRequest().setAttribute("msg", msg);
		return "showMsg";
	}
	public String updateAudioinf(String name, String categoryId, 
			String otheritem, int stock, int reservation){
		return "";
	}
	public String toChangeAudioInfo(){
		Msg  msg=new Msg();
		Audio audio1=audioService.findObjectById(audio.getId());
		List<Category> categories=categoryService.findObjects();
		if(audio1==null){
			msg.setMsg("没有该资料信息！");
			msg.setState(0);
			ServletActionContext.getRequest().setAttribute("msg", msg);
			return "showMsg";
		}else{
			ServletActionContext.getRequest().setAttribute("changeAudio", audio1);
			ServletActionContext.getRequest().setAttribute("changeCategories", categories);
			return "changeAudioInfo";
		}
	}
	public String ChangeAudioInfo() {
		Msg  msg=new Msg();
		Audio audio1=audioService.findObjectById(audio.getId());
		if(audio1==null){
			msg.setMsg("资料信息错误！");
			msg.setState(0);
			ServletActionContext.getRequest().setAttribute("msg", msg);
			return "showMsg";
		}
		
		
		if(audio.getId()==null||StringUtils.isBlank(audio.getName())||StringUtils.isBlank(audio.getCategory().getId())){
			msg.setMsg("资料信息错误！");
			msg.setState(0);
			ServletActionContext.getRequest().setAttribute("msg", msg);
			return "showMsg";
		}
		audio1.setName(audio.getName());
		audio1.setOtherItem(audio.getOtherItem());
		audio1.getCategory().setId(audio.getCategory().getId());
		audioService.update(audio1);
		msg.setMsg("资料已保存！");
		msg.setState(1);
		msg.setUrl("workerAudio_toAllAudio.action");
		ServletActionContext.getRequest().setAttribute("msg", msg);
		return "showMsg";
	}
}
