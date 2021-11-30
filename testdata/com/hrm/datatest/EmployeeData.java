package com.hrm.datatest;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class EmployeeData {
	public static EmployeeData getEmployee() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "\\testdata\\com\\hrm\\datatest\\Employee.json"), EmployeeData.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}

	@JsonProperty("firstname")
	private String firstname;

	@JsonProperty("lastname")
	private String lastname;

	@JsonProperty("fullname")
	private String fullname;

	@JsonProperty("username")
	private String username;

	@JsonProperty("password")
	private String password;

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getFullname() {
		return fullname;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@JsonProperty("ContactDetail")
	ContactDetail contactDetail;

	public static class ContactDetail {
		@JsonProperty("editEmpFirstName")
		private String editEmpFirstName;

		@JsonProperty("editEmpLastName")
		private String editEmpLastName;

		@JsonProperty("editEmpGender")
		private String editEmpGender;

		@JsonProperty("editEmpMaritalStatus")
		private String editEmpMaritalStatus;

		@JsonProperty("editEmpNational")
		private String editEmpNational;
	}

	public String getEditEmpFirstName() {
		return contactDetail.editEmpFirstName;
	}

	public String getEditEmpLastName() {
		return contactDetail.editEmpLastName;
	}

	public String getEditEmpGender() {
		return contactDetail.editEmpGender;
	}

	public String getEditEmpMaritalStatus() {
		return contactDetail.editEmpMaritalStatus;
	}

	public String getEditEmpNational() {
		return contactDetail.editEmpNational;
	}
}
