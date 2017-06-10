package com.audioshop.action;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.sql.Alias;

import com.audioshop.common.Msg;
import com.audioshop.model.Audio;
import com.audioshop.model.Category;
import com.audioshop.service.AudioService;
import com.audioshop.service.CategoryService;
import com.audioshop.util.PageResult;
import com.audioshop.util.QueryHelper;
import com.opensymphony.xwork2.ActionSupport;

public class AudioAction extends ActionSupport {
	private Audio audio;
	private Integer pageNo;
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
		msg.setUrl("index.jsp");
		msg.setState(1);
		ServletActionContext.getRequest().setAttribute("msg", msg);
		return "showMsg";
	}
}
