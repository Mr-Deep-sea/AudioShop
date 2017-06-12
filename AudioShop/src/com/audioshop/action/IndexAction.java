package com.audioshop.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.audioshop.model.Audio;
import com.audioshop.service.AudioService;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport{
	@Resource
	private AudioService audioService;
	@Override
	public String execute()  {
		try {
			List<Audio> allAudioList=audioService.findObjects();
		    ServletActionContext.getRequest().setAttribute("allAudioList", allAudioList);
		return SUCCESS;
		} catch (Exception e) {
	}
		return SUCCESS;
}
}
