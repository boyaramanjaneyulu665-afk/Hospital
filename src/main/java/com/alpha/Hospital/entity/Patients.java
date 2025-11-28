package com.alpha.Hospital.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Patients {
	@Id
	private int pid;
	private String pName;
	private String disease;
	public Patients(int pid, String pName, String disease) {
		super();
		this.pid = pid;
		this.pName = pName;
		this.disease = disease;
	}
	public Patients() {
		super();
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	@Override
	public String toString() {
		return "Patients [pid=" + pid + ", pName=" + pName + ", disease=" + disease + "]";
	}
	

}
