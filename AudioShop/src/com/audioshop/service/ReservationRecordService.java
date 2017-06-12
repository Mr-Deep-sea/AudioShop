package com.audioshop.service;

import java.util.ArrayList;

import com.audioshop.model.Audio;
import com.audioshop.model.ReservationRecord;
import com.audioshop.model.User;

public interface ReservationRecordService  extends BaseService<ReservationRecord>{

	ArrayList<ReservationRecord> findByUser(User user);

}
