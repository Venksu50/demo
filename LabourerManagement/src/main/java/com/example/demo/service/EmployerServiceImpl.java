package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployerDao;
import com.example.demo.entity.Employer;

@Service
public class EmployerServiceImpl implements EmployerService
{
	@Autowired
	private EmployerDao employerDao;
	
	@Override
	public long getEmployerCount() 
	{
		return employerDao.count();
	}

	@Override
	public long getPendingEmployers() 
	{
		return employerDao.countByStatus("pending");
	}

	@Override
	public long getApprovedEmployers() 
	{
		return employerDao.countByStatus("approved");
	}

	@Override
	public Employer createEmployer(Employer theEmployee) 
	{
		return employerDao.save(theEmployee);
	}
	
	
}
