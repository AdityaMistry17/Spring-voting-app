package com.vote.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "candidate")
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String candidateName;
	
	
	public Candidate() {
		super();
	}
	
//	public Candidate(String name) {
//		super();
//		this.name = name;
//	}



	public Candidate( String username, String candidateName) {
		super();
		this.username = username;
		this.candidateName = candidateName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return username;
	}

	public void setName(String username) {
		this.username = username;
	}

	public String getPassword() {
		return candidateName;
	}

	public void setPassword(String candidateName) {
		this.candidateName = candidateName;
	}

	
	
	
}
