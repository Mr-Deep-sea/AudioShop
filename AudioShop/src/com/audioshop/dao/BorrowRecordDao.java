package com.audioshop.dao;

import java.util.List;

import com.audioshop.model.BorrowRecord;

public interface BorrowRecordDao extends BaseDao<BorrowRecord>{
	public List<BorrowRecord> findAudioId(int audio_id);
	public List<BorrowRecord> findAudiosbyUserId(int user_id);

}
