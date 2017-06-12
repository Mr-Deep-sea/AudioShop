package com.audioshop.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.audioshop.dao.AudioDao;
import com.audioshop.dao.ReservationRecordDao;
import com.audioshop.dao.UserDao;
import com.audioshop.model.Audio;
import com.audioshop.model.ReservationRecord;
import com.audioshop.model.User;
import com.audioshop.service.ReservationRecordService;

@Service("reservationService")
public class ReservationRecordServiceImpl  extends BaseServiceImpl<ReservationRecord> implements ReservationRecordService{

	private ReservationRecordDao reservationRecordDao;
	private AudioDao audioDao;

	@Resource
	public void setAudioDao(AudioDao audioDao) {
		this.audioDao = audioDao;
	}

	@Resource
	public void setReservationRecordDao(ReservationRecordDao reservationRecordDao) {
		super.setBaseDao(reservationRecordDao);
		this.reservationRecordDao = reservationRecordDao;
	}

	@Override
	public ArrayList<ReservationRecord> findByUser(User user) {
		List<ReservationRecord> list=this.reservationRecordDao.findByUser(user);
		
		ArrayList<ReservationRecord> arrayList=new ArrayList<ReservationRecord>();
		
		if(list.size()>0){
			Iterator<ReservationRecord> iterator=list.iterator();
			while (iterator.hasNext()) {
				arrayList.add((ReservationRecord)iterator.next());			
			}
		}
		
		return arrayList;
	}
	


}
