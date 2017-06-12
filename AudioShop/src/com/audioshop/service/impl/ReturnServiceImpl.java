package com.audioshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.audioshop.dao.AudioDao;
import com.audioshop.dao.BorrowRecordDao;
import com.audioshop.model.Audio;
import com.audioshop.model.BorrowRecord;
import com.audioshop.service.ReturnService;

@Service("returnService")
public class ReturnServiceImpl extends BaseServiceImpl<Audio> implements
		ReturnService {

	private AudioDao audioDao;
	private BorrowRecordDao borrowRecordDao;
	public BorrowRecordDao getBorrowRecordDao() {
		return borrowRecordDao;
	}
	@Resource
	public void setBorrowRecordDao(BorrowRecordDao borrowRecordDao) {
		this.borrowRecordDao = borrowRecordDao;
	}
	@Resource
	public void setAudioDao(AudioDao audioDao) {
		super.setBaseDao(audioDao);
		this.audioDao = audioDao;
	}
	@Override
	public List<BorrowRecord> findAudiosbyUserId(int user_id) {
		// TODO Auto-generated method stub
		return borrowRecordDao.findAudiosbyUserId(user_id);
	}

}
