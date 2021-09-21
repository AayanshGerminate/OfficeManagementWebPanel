package com.office.modelSuperAdmin;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
public class Leaves {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
//	private String employeeName;
	private Long employeeId;
	
	private String department;
	private String leaveReason;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fromDate;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date toDate;
	private Date updatedDate=new Date();
	private String description;
	
}
