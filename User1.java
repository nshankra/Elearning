package com.elearning.entitites;
import java.util.Objects;

public class User1 {
    private int userId;
    private String name;
    private String phoneNo;
    private String email;
    private String address;
    private String regDate;
    private String password;
    private String uploadPhoto;
	
    

	
	public User1() {
		
	}

	public User1(int userId, String name, String phoneNo, String email, String address, String regDate, String password,
			String uploadPhoto) {
		
		this.userId = userId;
		this.name = name;
		this.phoneNo = phoneNo;
		this.email = email;
		this.address = address;
		this.regDate = regDate;
		this.password = password;
		this.uploadPhoto = uploadPhoto;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUploadPhoto() {
		return uploadPhoto;
	}

	public void setUploadPhoto(String uploadPhoto) {
		this.uploadPhoto = uploadPhoto;
	}

	public int hashCode() {
		return Objects.hash(address, email, name, password, phoneNo, regDate, uploadPhoto, userId);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User1 other = (User1) obj;
		return Objects.equals(address, other.address) && Objects.equals(email, other.email)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& phoneNo == other.phoneNo && Objects.equals(regDate, other.regDate)
				&& Objects.equals(uploadPhoto, other.uploadPhoto) && userId == other.userId;
	}

         public String toString() {
		return "User1 [user_id=" + userId + ", name=" + name + ", phone_no=" + phoneNo + ", email=" + email
				+ ", address=" + address + ", reg_date=" + regDate + ", password=" + password + ", upload_photo="
				+ uploadPhoto + "]";
	}
    
    
}
    
    
