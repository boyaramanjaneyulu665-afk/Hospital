package com.alpha.Hospital.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Doctor {
	@Id
	private int id;
	private int name;
	private List<Patients> plist;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	public List<Patients> getPlist() {
		return plist;
	}
	public void setPlist(List<Patients> plist) {
		this.plist = plist;
	}
	public Doctor(int id, int name, List<Patients> plist) {
		super();
		this.id = id;
		this.name = name;
		this.plist = plist;
	}
	public Doctor() {
		super();
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", plist=" + plist + "]";
	}
	

}
