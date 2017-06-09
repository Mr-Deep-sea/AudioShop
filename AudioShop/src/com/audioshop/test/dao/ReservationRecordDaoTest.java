package com.audioshop.test.dao;

import java.util.List;

import com.audioshop.dao.BorrowRecordDao;
import com.audioshop.dao.ReservationRecordDao;
import com.audioshop.model.BorrowRecord;
import com.audioshop.model.BorrowRecordItem;
import com.audioshop.model.ReservationRecord;
import com.audioshop.model.ReservationRecordItem;
import com.audioshop.util.getObjectBySpring;

public class ReservationRecordDaoTest {
	public static void main(String[] args) {
		ReservationRecordDao reservationRecordDao = (ReservationRecordDao) getObjectBySpring
				.getObject("reservationRecordDao");
		List<ReservationRecord> reservationRecords;
		reservationRecords = reservationRecordDao.findObjects();
		for (ReservationRecordItem reservationRecordItem : reservationRecords.get(0)
				.getReservationRecordItems()) {
			System.out.println(reservationRecordItem.getNumber());
		}
	}
}
