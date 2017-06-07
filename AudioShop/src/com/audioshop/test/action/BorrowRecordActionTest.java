package com.audioshop.test.action;

import java.util.List;

import javax.annotation.Resource;

import com.audioshop.model.BorrowRecord;
import com.audioshop.service.BorrowRecordService;
import com.opensymphony.xwork2.ActionSupport;

public class BorrowRecordActionTest extends ActionSupport {
 private BorrowRecordService borrowRecordService;
 private List<BorrowRecord> borrowRecords;
 
 public List<BorrowRecord> getBorrowRecords() {
	return borrowRecords;
}
@Resource
public void setBorrowRecordService(BorrowRecordService borrowRecordService) {
	this.borrowRecordService = borrowRecordService;
}
 public String getBorrowRecord(){
	 borrowRecords=borrowRecordService.findObjects();
	 return SUCCESS;
 }
 
}
