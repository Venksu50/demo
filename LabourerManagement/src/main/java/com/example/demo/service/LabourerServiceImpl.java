package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LabourerDao;
import com.example.demo.entity.Labourer;

@Service
public class LabourerServiceImpl implements LabourerService
{
	@Autowired
	private LabourerDao labourerDao;

	@Override
	public long getLabourerCount() 
	{
		return labourerDao.count();
	}

	@Override
	public long getActiveLabourerCount() 
	{
		return labourerDao.countByActiveStatus("Active");
	}

	@Override
	public long getInActiveLabourerCount() 
	{
		return labourerDao.countByActiveStatus("Inactive");
	}

	@Override
	public Labourer createLabourer(Labourer theLabourer) 
	{
		return labourerDao.save(theLabourer);
	}
	
}
