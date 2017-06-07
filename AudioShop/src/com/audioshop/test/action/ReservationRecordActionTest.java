package com.audioshop.test.action;

import java.util.List;

import javax.annotation.Resource;

import com.audioshop.model.BorrowRecord;
import com.audioshop.model.ReservationRecord;
import com.audioshop.service.BorrowRecordService;
import com.audioshop.service.ReservationRecordService;
import com.opensymphony.xwork2.ActionSupport;

public class ReservationRecordActionTest extends ActionSupport {
	private ReservationRecordService reservationRecordService;
	private List<ReservationRecord> reservationRecords;

	public List<ReservationRecord> getReservationRecords() {
		return reservationRecords;
	}

	@Resource
	public void setReservationRecordService(
			ReservationRecordService reservationRecordService) {
		this.reservationRecordService = reservationRecordService;
	}

	public String getborrowRecords() {
		reservationRecords = reservationRecordService.findObjects();
		return SUCCESS;
	}

}
