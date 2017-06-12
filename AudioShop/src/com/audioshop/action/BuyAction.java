package com.audioshop.action;

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

public class BuyAction extends ActionSupport{
	@Resource
	private BorrowRecordService borrowRecordService;
	@Resource
	private AudioService audioService;
	
	int BuyaudioID;	
	public int getBuyaudioID() {
		return BuyaudioID;
	}
	public void setBuyaudioID(int buyaudioID) {
		BuyaudioID = buyaudioID;
	}


	public String toBuy(){
		return "toBuy";
	}
	
	//添加卖资料项
	public String addBuyAudio(){
		
		//获取session
		Map<String, Object> session = ActionContext.getContext().getSession(); 
		ArrayList<Audio> BuyaudioList=(ArrayList<Audio>)session.get("BuyaudioList");
		
		if(BuyaudioList==null){
			BuyaudioList=new ArrayList<Audio>();
		}
		
		Audio audio=audioService.findObjectById(BuyaudioID);
		//Audio audio=audioService.findObjectById(123);
		BuyaudioList.add(audio);
		
		ActionContext.getContext().getSession().put("BuyaudioList", BuyaudioList);
		
		return SUCCESS;
	}
	
	
	//确认卖资料
	public String buy(){
		
		Map<String, Object> session = ActionContext.getContext().getSession(); 
		ArrayList<Audio> BuyaudioList=(ArrayList<Audio>)session.get("BuyaudioList");
		
		HashMap<Integer, Integer> audioMap=new HashMap<Integer, Integer>();	
		Iterator<Audio> iterator=BuyaudioList.iterator();	
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
		}
		
		ActionContext.getContext().getSession().put("BuyaudioList", null);
		
		return SUCCESS;
	}
	
}
