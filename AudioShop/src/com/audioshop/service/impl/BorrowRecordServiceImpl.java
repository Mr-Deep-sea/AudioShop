package com.audioshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.audioshop.dao.BorrowRecordDao;
import com.audioshop.model.BorrowRecord;
import com.audioshop.service.BorrowRecordService;

@Service("borrowRecordService")
public class BorrowRecordServiceImpl extends BaseServiceImpl<BorrowRecord>
		implements BorrowRecordService {
	private BorrowRecordDao borrowRecordDao;

	@Resource
	public void setBorrowRecordDao(BorrowRecordDao borrowRecordDao) {
		super.setBaseDao(borrowRecordDao);
		this.borrowRecordDao = borrowRecordDao;
	}
	@Override
	public List<BorrowRecord> findAudioId(int audio_id) {
		return borrowRecordDao.findAudioId(audio_id);
	}

}
