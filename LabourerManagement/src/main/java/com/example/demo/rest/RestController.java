package com.example.demo.rest;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.entity.Employer;
import com.example.demo.entity.GovtUser;
import com.example.demo.entity.Labourer;
import com.example.demo.entity.Response;
import com.example.demo.service.EmployerService;
import com.example.demo.service.GovtUserService;
import com.example.demo.service.LabourerService;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/LabourMgm")
public class RestController 
{
	@Autowired
	private EmployerService employerService;
	
	@Autowired
	private LabourerService labourerService;
	
	@Autowired
	private GovtUserService govtUserService;
	
	Response response = new Response();
	
	@GetMapping("/dashBoardCounts")
	public Response getDashBoardCounts()
	{
		long employersCount = employerService.getEmployerCount();
		
		long employersApprovedCount = employerService.getApprovedEmployers();
		
		long employersPendingCount = employerService.getPendingEmployers();
		
		long labourersCount = labourerService.getLabourerCount();
		
		long labourerActiveCount = labourerService.getActiveLabourerCount();
		
		long labourerInActiveCount = labourerService.getInActiveLabourerCount();
		
		long govtUserCount = govtUserService.getGovtUserCount();
		
		long govtUserActiveCount = govtUserService.getActiveGovtUserCount();
		
		long govtUserInActiveCount = govtUserService.getInActiveGovtUserCount();
		
		response.setEmployersCount(employersCount);
		 
		response.setApprovedEmployers(employersApprovedCount);
		 
		response.setPendingEmployers(employersPendingCount);
		
		response.setLabourersCount(labourersCount);
		
		response.setActiveLabourers(labourerActiveCount);
		
		response.setInActiveLabourers(labourerInActiveCount);
		
		response.setGovtUserCount(govtUserCount);
		
		response.setActiveGovtUsers(govtUserActiveCount);
		
		response.setInActiveGovtUsers(govtUserInActiveCount);
		
		return response; 
	}
	
	@PostMapping("/employers")
	public Employer createEmployer(@RequestBody Employer theEmployer)
	{
		theEmployer.setEmployerId(0);
		
		theEmployer.setStatus("Pending");
		
		employerService.createEmployer(theEmployer);
		
		return theEmployer;
	}
	
	@PostMapping("/labourers")
	public Labourer addLabourer(@RequestBody Labourer theLabourer)
	{
		theLabourer.setLabourer_id(0);
		
		theLabourer.setCreationDate(new Date());
	
		theLabourer.setLastModifiedDate(new Date());
		
		theLabourer.setActiveStatus("Active");
	
		labourerService.createLabourer(theLabourer);
		
		return theLabourer;
	}
	
	@PostMapping("/govtUsers")
	public GovtUser createGovtUser(@RequestBody GovtUser thegovtUser)
	{
		thegovtUser.setGovtUserId(0);
		
		thegovtUser.setActiveStatus("Active");
		
		govtUserService.createGovtUser(thegovtUser);
		
		return thegovtUser;
	}
}
