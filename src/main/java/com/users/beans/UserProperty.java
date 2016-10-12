package com.users.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_properties")
public class UserProperty {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private int userId;
	private String propName;
	private String propValue;

	protected UserProperty() {}

	public UserProperty(int userId, String propName, String propValue) {
		this.userId = userId;
		this.propName = propName;
		this.propValue = propValue;
	}

	@Override
	public String toString() {
		return "UserProperty [id=" + id + ", userId=" + userId + ", propName=" + propName + ", propValue=" + propValue + "]";
	}

	public int getUserId() {
		return userId;
	}

	public String getPropName() {
		return propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public String getPropValue() {
		return propValue;
	}

	public void setPropValue(String propValue) {
		this.propValue = propValue;
	}

	public long getId() {
		return id;
	}
}
