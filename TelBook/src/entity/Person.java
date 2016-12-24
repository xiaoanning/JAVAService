package entity;

import java.util.Date;

public class Person
{
 	private	Integer id ;
 	private String name ;
 	private String mobile ;
 	private String telphone ;
 	private String email ;
 	private String city ;
 	private Date birthday ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Person(Integer id, String name, String mobile, String telphone,
			String email, String city, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.telphone = telphone;
		this.email = email;
		this.city = city;
		this.birthday = birthday;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", mobile=" + mobile
				+ ", telphone=" + telphone + ", email=" + email + ", city="
				+ city + ", birthday=" + birthday + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getMobile()=" + getMobile()
				+ ", getTelphone()=" + getTelphone() + ", getEmail()="
				+ getEmail() + ", getCity()=" + getCity() + ", getBirthday()="
				+ getBirthday() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
