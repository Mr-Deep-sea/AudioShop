package com.audioshop.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.audioshop.dao.ReservationRecordDao;
import com.audioshop.model.ReservationRecord;
import com.audioshop.model.User;

public class ReservationRecordDaoImpl extends BaseDaoImpl<ReservationRecord> implements ReservationRecordDao{

	@Override
	public List<ReservationRecord> findByUser(User user) {
		Query query = getSession().createQuery(
				"FROM ReservationRecord WHERE user_id=?");
		query.setParameter(0, user.getId());
		return query.list();
	}

}
