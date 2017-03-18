package com.gmy.realm;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.gmy.service.IUserService;
import com.gmy.vo.User;

public class MyRealm extends AuthorizingRealm{
	
	@Resource
	private IUserService userService;

	/**
	 *  ⁄»®
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		String userName = (String) pc.getPrimaryPrincipal();
		SimpleAuthorizationInfo author = new SimpleAuthorizationInfo();
		try {
			author.setRoles(this.userService.getRoles(userName));
			author.setStringPermissions(this.userService.getPermissions(userName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return author;
	}

	@Override
	/**
	 * »œ÷§
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName=(String)token.getPrincipal();
		try {
			User user = this.userService.getByUserName(userName);
			if(user != null) {
				AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(),"gmy");
				return authcInfo;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
