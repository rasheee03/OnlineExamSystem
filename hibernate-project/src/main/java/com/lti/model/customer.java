package com.lti.model;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
@Entity
@Table(name="TBL_CUST")
public class customer {
	@Id
	@GeneratedValue
	@Column(name="CUST_ID")
	int custid;
	@Column(name="CUST_NAME")	
String name;
	@Column(name="CUST_CITY")
String city;
public int getCustid() {
	return custid;
}
public void setCustid(int custid) {
	this.custid = custid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}

}
