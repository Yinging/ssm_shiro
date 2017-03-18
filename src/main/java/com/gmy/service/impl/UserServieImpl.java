package com.gmy.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gmy.dao.IUserDAO;
import com.gmy.service.IUserService;
import com.gmy.vo.User;

@Service("userService")
public class UserServieImpl implements IUserService{
	
	@Resource
	private IUserDAO userDAO;

	public User getByUserName(String userName) {
		return this.userDAO.getByUserName(userName);
	}

	public Set<String> getRoles(String userName) {
		return this.userDAO.getRoles(userName);
	}

	public Set<String> getPermissions(String userName) {
		return this.userDAO.getPermissions(userName);
	}

}
