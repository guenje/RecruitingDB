package com.Recruiting.springboot.Recruiting.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "Name")
	private String Name;

	@Column(name = "vorname")
	private String vorname;
	
	@Column(name = "Email")
	private String Email;

	protected User() {
	}

	public User(String Name, String vorname, String Email) {
		this.Name = Name;
		this.vorname = vorname;
		this.Email = Email;
	}

	@Override
	public String toString() {
		return String.format("User[id=%d, Name='%s', Vorname='%s', Email='%s', \n]", id, Name, vorname, Email);
	}
}
