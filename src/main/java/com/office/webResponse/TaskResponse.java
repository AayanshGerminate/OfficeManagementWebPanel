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
public class TaskResponse {
	
	private Long id;
	private String projectName;
	private String employeeName;
	private Date date;
	private String scheduledTask;
	private String unScheduledTask;
	private Date scheduledTime;
	private Date actualTime;
	private String priority;
	private String status;
	private Date updatedDate;


}
