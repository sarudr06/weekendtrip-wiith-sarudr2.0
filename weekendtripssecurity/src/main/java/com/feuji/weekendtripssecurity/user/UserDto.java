package com.feuji.weekendtripssecurity.user;

import lombok.Data;

@Data
public class UserDto {

	private Integer id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String role;
	private String status;
	private Long mobileNumber;
	private String gender;
	private int age;
}
