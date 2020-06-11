package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.GovtUserDao;
import com.example.demo.entity.GovtUser;

@Service
public class GovtUserServiceImpl implements GovtUserService
{
	@Autowired
	private GovtUserDao govtUserDao;

	@Override
	public long getGovtUserCount() 
	{
		return govtUserDao.count();
	}

	@Override
	public long getActiveGovtUserCount() 
	{
		return govtUserDao.countByActiveStatus("Active");
	}

	@Override
	public long getInActiveGovtUserCount() 
	{
		return govtUserDao.countByActiveStatus("Inactive");
	}

	@Override
	public GovtUser createGovtUser(GovtUser govtUser) {
		return govtUserDao.save(govtUser);
	}

}
