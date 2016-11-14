package com.users.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name = "group_members")
public class GroupMembers {
	
	@Id
	@GeneratedValue(generator="myGenerator")
	@GenericGenerator(name="myGenerator", strategy="foreign", parameters=@Parameter (value="user", name = "property"))
	private long id;
	
	@OneToOne(optional=false)
    @JoinColumn(name="group_id")
	private Group group;
	
	@OneToOne(optional=false)
    @JoinColumn(name="user_id")
	private User user;
	
//	public GroupMembers(){
//		
//	}
//
//	public GroupMembers(long id, Group group, User user) {
//		super();
//		this.id = id;
//		this.group = group;
//		this.user = user;
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
