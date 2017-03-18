package com.gmy.dao;

import java.util.Set;

import com.gmy.vo.User;

public interface IUserDAO {
	/**
	 * 根据用户名查询用户信息
	 * @param userName 用户名
	 * @return 返回用户
	 */
	public User getByUserName(String userName) ;
	
	/**
	 * 根据用户名查询角色名称
	 * @param userName 用户名
	 * @return 角色名称的集合
	 */
	public Set<String> getRoles(String userName) ;
	
	/**
	 * 根据用户名查询权限信息
	 * @param userName 用户
	 * @return 权限名称集合
	 */
	public Set<String> getPermissions(String userName);
}
