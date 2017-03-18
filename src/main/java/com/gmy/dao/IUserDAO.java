package com.gmy.dao;

import java.util.Set;

import com.gmy.vo.User;

public interface IUserDAO {
	/**
	 * �����û�����ѯ�û���Ϣ
	 * @param userName �û���
	 * @return �����û�
	 */
	public User getByUserName(String userName) ;
	
	/**
	 * �����û�����ѯ��ɫ����
	 * @param userName �û���
	 * @return ��ɫ���Ƶļ���
	 */
	public Set<String> getRoles(String userName) ;
	
	/**
	 * �����û�����ѯȨ����Ϣ
	 * @param userName �û�
	 * @return Ȩ�����Ƽ���
	 */
	public Set<String> getPermissions(String userName);
}
