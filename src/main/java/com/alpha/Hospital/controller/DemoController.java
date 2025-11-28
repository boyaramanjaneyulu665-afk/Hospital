package com.alpha.Hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.Hospital.ResponceStructure;
import com.alpha.Hospital.entity.Doctor;
import com.alpha.Hospital.service.DoctorService;
@RestController
public class DemoController {
	@GetMapping("/ram")
	public void demo() {
		System.out.println(" is demo method executed");
	}
	
	@Autowired
	private DoctorService ds;
	
	@PostMapping("/saveDoctor")
	public void saveDoctor(@RequestBody Doctor s) {
		ds.saveStu(s);
	}
	
	@PostMapping("/findDoctor")
	public ResponceStructure<Doctor> findStu(@RequestParam int id) {
		return ds.findDoc(id);
		
	}
	
	@PostMapping("/updateDoc")
	public void updateStu(@RequestParam int id,@RequestParam String newname) {
		ds.updateDoc(id,newname);
		
	}
	
	@DeleteMapping("/deleteDoc")
	public void deletDoc(@RequestParam int id) {
		ds.deleteDoc(id);
	}




	


}
