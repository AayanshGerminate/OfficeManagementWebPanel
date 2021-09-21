package com.office.webResponse;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LeaveResponse {
	
	private long id;
	private String name;
	private String department;
	private Date fromDate;
	private Date toDate;
	private String leaveReason;
	

}
