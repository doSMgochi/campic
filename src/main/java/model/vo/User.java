package model.vo;

import java.sql.Date;

public class User {
	String id;
	String password;
	String nickname;
	String gender;
	Date birth;
	String email;
	String authority;
	
	
	public User() {
		super();
	}


	public User(String id, String password, String nickname, String gender, Date birth, String email,
			String authority) {
		super();
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.gender = gender;
		this.birth = birth;
		this.email = email;
		this.authority = authority;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Date getBirth() {
		return birth;
	}


	public void setBirth(Date birth) {
		this.birth = birth;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAuthority() {
		return authority;
	}


	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
	
}
