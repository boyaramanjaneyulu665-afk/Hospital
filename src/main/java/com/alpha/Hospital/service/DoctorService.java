package com.alpha.Hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.alpha.Hospital.ResponceStructure;
import com.alpha.Hospital.Exception.DoctorNotFoundEception;
import com.alpha.Hospital.Repository.DoctorRepo;
import com.alpha.Hospital.entity.Doctor;

@Service
public class DoctorService {
	@Autowired
	private DoctorRepo dr;
	
	public void saveStu(Doctor d) {
		dr.save(d);
	}

	public ResponceStructure<Doctor> findDoc(int id) {
		Doctor s=dr.findById(id).orElseThrow(()-> new DoctorNotFoundEception());
		ResponceStructure<Doctor> rs = new  ResponceStructure<Doctor>();
		
			rs.setStatuscode(HttpStatus.FOUND.value());
			rs.setMessage("student with id"+id+"Found");
			rs.setData(s);
		
		return rs;

	}

	public void updateDoc(int id, String newname) {
          Doctor d=dr.findById(id).get();
		
		  d.setName(newname);
		
		  dr.save(d);

		
	}

	public void deleteDoc(int id) {
		dr.deleteById(id);

	}


}
