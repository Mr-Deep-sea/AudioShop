package com.audioshop.test.dao;

import java.util.List;

import com.audioshop.dao.BorrowRecordDao;
import com.audioshop.model.BorrowRecord;
import com.audioshop.model.BorrowRecordItem;
import com.audioshop.util.getObjectBySpring;

public class BorrowRecordDaoTest {
	public static void main(String[] args) {
		BorrowRecordDao borrowRecordDao=(BorrowRecordDao)getObjectBySpring.getObject("borrowRecordDao");
		List<BorrowRecord> borrowRecords;
		borrowRecords=borrowRecordDao.findObjects();
		for (BorrowRecordItem borrowRecordItem : borrowRecords.get(0).getBorrowRecordItems()) {
			System.out.println(borrowRecordItem.getNumber());
		}
	}

}
