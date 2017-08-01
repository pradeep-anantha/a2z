package com.a2z.core.ews;

public class EWSConfiguration {
	
	private String domain;
	private String userName;
	private String password;
	private String EWSUrl;
	
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEWSUrl() {
		return EWSUrl;
	}
	public void setEWSUrl(String eWSUrl) {
		EWSUrl = eWSUrl;
	}
	
}
