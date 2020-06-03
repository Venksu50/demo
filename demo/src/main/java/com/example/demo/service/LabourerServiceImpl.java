package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.LabourerDAO;
import com.example.demo.entity.Labourer;
import com.example.demo.exception.LabourerDataInvalidException;

@Service
public class LabourerServiceImpl implements LabourerService
{
	@Autowired
	private LabourerDAO labourerDAO;
	
	@Override
	public void save(Labourer theLabourer) 
	{ 
		String pinCode = ""+theLabourer.getPermanentAddressPinCode();
		String regex1 = "^[1-9][0-9]{5}$";
		validateData(pinCode, regex1, "pinCode");
		
		String aadharNumber = ""+theLabourer.getAadharNumber();
		String regex2 = "^[0-9]{12}";
		validateData(aadharNumber, regex2, "aadharNumber");
		
		labourerDAO.save(theLabourer);
	}

	@Override
	public List<Labourer> getLabourers() 
	{
		return labourerDAO.findAll();
	}

	@Override
	public Labourer getLabourer(int labourerId) 
	{
		Optional<Labourer> result = labourerDAO.findById(labourerId);
		
		Labourer theLabourer = null;
		
		if(result.isPresent())
		{
			theLabourer = result.get();
		}
		
		return theLabourer;
	}

	@Override
	public void deleteLabourer(int labourerId) 
	{
		labourerDAO.deleteById(labourerId);
	}

	@Override
	public void validateData(String fieldValue, String regex, String fieldName) 
	{
		Pattern pattern = Pattern.compile(regex);
		Matcher  matcher = pattern.matcher(fieldValue); 
		
		if(!matcher.matches())
		{
			throw new LabourerDataInvalidException("Check the Labourer Field: "+fieldName);
		}
	}

}
