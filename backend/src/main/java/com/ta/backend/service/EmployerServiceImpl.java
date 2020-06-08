package com.ta.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ta.backend.dao.EmployerDao;
import com.ta.backend.entity.Employer;
import com.ta.backend.exception.EmployerException;

@Service
public class EmployerServiceImpl implements EmployerService {

	
	@Autowired
	EmployerDao eDao;
	
	@Override
	public boolean validatePincode(Employer employer) throws EmployerException {
		String pattern="[1-9]{1}[0-9]{5}";
		if(Pattern.matches(pattern, Integer.toString(employer.getPincode())))
			{
			System.out.println("in pincode validation");
			return true;
			}
	return false;
	}

	@Override
	public boolean validatePhoneNo(Employer employer) throws EmployerException {
		String pattern = "[6789]{1}[0-9]{9}";
		if(Pattern.matches(pattern, Long.toString(employer.getPhNo())))
		return true;
	return false;
	}

	@Override
	public boolean validateDate(Employer employer) throws EmployerException {
		if (employer.getCreationDate()!=null && employer.getLastModifiedDate()!=null && employer.getLastModifiedDate().after(employer.getCreationDate()))
		 {
			 return true;
		 }
		return false;
	}

	
	@Override
	public Employer addEmployer(Employer employer) throws EmployerException {
		return eDao.save(employer);
	}

	@Override
	public List<Employer> getEmployers() throws EmployerException {
		
		return eDao.findAll();
	}

	@Override
	public Employer editEmployer(Employer employer) throws EmployerException 
	{		
		return eDao.save(employer);
	}

	@Override
	public Employer getEmployer(int employerId) 
	{
		Optional<Employer> result = eDao.findById(employerId);
		
		Employer theEmployer = null;
		
		if(result.isPresent())
		{
			theEmployer = result.get();
		}
		
		return theEmployer;

	}

	@Override
	public void deleteEmployer(int employerId) 
	{
		eDao.deleteById(employerId);
	}

	

}
