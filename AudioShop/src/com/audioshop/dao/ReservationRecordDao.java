package com.audioshop.dao;

import java.util.List;

import com.audioshop.model.ReservationRecord;
import com.audioshop.model.User;

public interface ReservationRecordDao extends BaseDao<ReservationRecord>{

	List<ReservationRecord> findByUser(User user);

}
