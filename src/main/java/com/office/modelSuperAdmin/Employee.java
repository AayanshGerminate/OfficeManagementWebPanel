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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String designation;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date joiningDate;
	private String address;
	private String status;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;
	private String accountNumber;
	private String ifscCode;
	private String branch;
	 private String profileImage;
	 private String offerLetter;
	 private String appointmentLetter;
	 private String promotionLetter;
	 private String ndaLetter;
	 private String terminationLetter;
	 private String backGroundVerificationLetter;
	 private String sscCertificate;
	 private String hscCertificate;
	 private String graduationCertificate;
	 private String postGraduationCertificate;
	 private String panCard;
	 private String adharCard;
	 private String passport;
	 private String password;
	 
	
}
