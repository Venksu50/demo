package com.example.demo.service;

import com.example.demo.entity.Employer;

public interface EmployerService 
{
	public long getEmployerCount();
	
	public long getPendingEmployers();
	
	public long getApprovedEmployers();
	
	public Employer createEmployer(Employer theEmployee);
}
