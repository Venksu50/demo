package com.ta.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ta.backend.entity.Employer;
import com.ta.backend.exception.EmployerException;
import com.ta.backend.service.EmployerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/LabourMgm")
public class Controller {

	@Autowired
	EmployerService eService;

	@PostMapping(path = "/Employer/", consumes = "application/json")
	public Employer enterEmployer(@RequestBody Employer employer) throws EmployerException {

		if (eService.validatePincode(employer) && eService.validatePhoneNo(employer)) {
			employer.setStatus("Pending");
			System.out.println("Employer has a new record");
			return eService.addEmployer(employer);
		}
		return null;
	}

	@GetMapping(path = "/Employer/")
	public List<Employer> getAll() throws EmployerException {

		return eService.getEmployers();

	}

	@PutMapping(path = "/Employer/", consumes = "application/json")
	public Employer editEmployer(@RequestBody Employer employer) throws EmployerException {
		if (eService.validatePincode(employer) && eService.validatePhoneNo(employer)) {
			System.out.println("Employer " + employer.getEmployerId() + " has an updated record");
			return eService.editEmployer(employer);
		}
		return null;
	}

	@GetMapping(path = "/Employer/{employerId}")
	public Employer getEmployerById(@PathVariable int employerId) {
		return eService.getEmployer(employerId);
	}
	
	@DeleteMapping(path="/Employer/{employerId}")
	public void deleteEmployer(@PathVariable int employerId)
	{
		eService.deleteEmployer(employerId);
	}
}
