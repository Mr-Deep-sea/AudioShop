package com.audioshop.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.audioshop.dao.BorrowRecordDao;
import com.audioshop.model.BorrowRecord;

public class BorrowRecordDaoImpl extends BaseDaoImpl<BorrowRecord> implements BorrowRecordDao {
	@Override
	public List<BorrowRecord> findAudioId(int audio_id) {
		Query query = getSession().createQuery(
				"FROM BorrowRecord WHERE audioId=?");
		query.setParameter(0, audio_id);
		return query.list();
	}
	@Override
	public List<BorrowRecord> findAudiosbyUserId(int user_id) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(
				"FROM BorrowRecord where userId=?");
		query.setParameter(0,user_id);	
		return query.list();
	}
}
