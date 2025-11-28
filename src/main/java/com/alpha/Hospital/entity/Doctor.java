package com.alpha.Hospital.entity;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;
@Entity
public class Doctor {
	@Id
	private int id;
	@Length(min=3,max=20)
	private String name;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor_id")
	@Size(min=1,max=50)
	private List<Patients> plist;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Patients> getPlist() {
		return plist;
	}
	public void setPlist(List<Patients> plist) {
		this.plist = plist;
	}
	public Doctor(int id, String name, List<Patients> plist) {
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
