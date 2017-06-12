package com.audioshop.service;

import java.util.List;

import com.audioshop.model.Audio;
import com.audioshop.model.BorrowRecord;

public interface ReturnService extends BaseService<Audio> {
	public List<BorrowRecord> findAudiosbyUserId(int user_id);
	
}
