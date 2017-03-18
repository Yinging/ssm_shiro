package com.gmy.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gmy.vo.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/login")
	public String login(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(user.getUserName(), user.getPassword());
		try {
			subject.login(token);
			System.out.println("登录成功！");
			return "redirect:/success.jsp";
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("用户名或密码错误！");
			request.setAttribute("errorMsg", "用户名或密码错误！");
			return "login";
		}
	}

}
