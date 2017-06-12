package com.audioshop.service;

import java.util.List;

import com.audioshop.model.BorrowRecord;

public interface BorrowRecordService extends BaseService<BorrowRecord>{
	public List<BorrowRecord> findAudioId(int audio_id);
}
