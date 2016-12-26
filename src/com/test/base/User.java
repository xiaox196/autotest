package com.test.base;

public class User {
	public String user=null;
	public String code=null;
	public String name=null;
	public String idcard=null;
	public String adds=null;
	public String company=null;
	public String mobile=null;
	
	
	
	public User(String user, String code, String name, String idcard, String adds, String company, String mobile) {
		super();
		this.user = user;
		this.code = code;
		this.name = name;
		this.idcard = idcard;
		this.adds = adds;
		this.company = company;
		this.mobile = mobile;
	}



	public String getUser() {
		return user;
	}



	public void setUser(String user) {
		this.user = user;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getIdcard() {
		return idcard;
	}



	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}



	public String getAdds() {
		return adds;
	}



	public void setAdds(String adds) {
		this.adds = adds;
	}



	public String getCompany() {
		return company;
	}



	public void setCompany(String company) {
		this.company = company;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	@Override
	public String toString() {
		return "User [user=" + user + ", code=" + code + ", name=" + name + ", idcard=" + idcard + ", adds=" + adds
				+ ", company=" + company + ", mobile=" + mobile + "]";
	}

	
}
