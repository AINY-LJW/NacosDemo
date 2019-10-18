package com.comment.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comment.user.dao.UserMapper;
import com.comment.user.model.User;
import com.comment.user.model.UserExample;
import com.comment.user.model.UserExample.Criteria;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

//此类为用户controller类
@RestController
public class UserController {
	@Autowired
	private UserMapper mapper;
	
	@ApiOperation(value="用户登录",notes="根据用户名密码进行校验")
	@ApiImplicitParams({
		@ApiImplicitParam(name="form-username",value="用户名",required =true),
		@ApiImplicitParam(name="form-password",value="密码",required =true,dataType="String")
	})
	@PostMapping(value = "/user/loginForm")
	//RequestBody 接收的是请求体里面的数据；而RequestParam接收的是key-value 里面的参数
	public User ifUserExist(@RequestParam("form-username") String name, @RequestParam("form-password") String pwd) {
		UserExample example = new UserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andPhoneNumberEqualTo(name);
		createCriteria.andPasswordEqualTo(pwd);
		List<User> selectByExample = mapper.selectByExample(example);
		if (selectByExample.size() != 0) {
			return selectByExample.get(0);
		} else {
			return null;
		}
	}
}
