package com.audioshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.audioshop.dao.AudioDao;
import com.audioshop.dao.ReservationRecordDao;
import com.audioshop.dao.UserDao;
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
	


}
