package com.comment.consumer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.comment.bean.Comment;
import com.comment.common.User;
import com.comment.util.EasyUIDataGridResult;

@RestController
//@Controller
public class UserConsumerController {
//	@Autowired 
//	private RestTemplate restTemplate;
	// 使用 DiscoveryClient 寻找服务提供者
//	@Autowired
//	 private DiscoveryClient discoveryClient;
	@Autowired(required = false)
	private UserFeignClient userFeignClient;
	@Autowired
	private HttpServletRequest request;

//	@GetMapping("/getUser")
//	public String getUser() {
//		return restTemplate.getForObject("http://127.0.0.1:8801/user/getName", String.class);
//		 List<ServiceInstance> list = discoveryClient.getInstances("porvider-user");
//		   if (list.size() > 0) {
//		      String url = list.get(0).getUri().toString();
//		      return restTemplate.getForObject(url + "/user/getName", String.class);
//		   } else {
//		      return null;
//		   }
		// RestTemplate 甚至可以直接通过服务注册名称去调用API，这是利用Ribbon后开启了虚拟主机的能力。
//		return restTemplate.getForObject("http://porvider-user/user/getName", String.class);
//		return userFeignClient.getUser();
//	}

	@PostMapping("/uploadJson")
	public String getUserById4(@RequestBody @RequestParam("jsonObj") String jsonObj) {
		return userFeignClient.getUserById4(jsonObj);
	}

	/**
	 * 根据关键词查找评论
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return EasyUIDataGridResult
	 */
	@RequestMapping(value = "getCommentsByKeywords", method = RequestMethod.POST)
	public EasyUIDataGridResult getCommentsByKeywords(@RequestBody @RequestParam("page") int pageNum,
			@RequestParam("rows") int pageSize, @RequestParam(value = "asin", required = false) String asin,
			@RequestParam(value = "reviewerName", required = false) String reviewerName,
			@RequestParam(value = "keyWord", required = false) String keyWord) {
		EasyUIDataGridResult commentList = userFeignClient.getCommentsByKeywords(pageNum, pageSize, asin, reviewerName,
				keyWord);
		return commentList;
	}

	/**
	 * 获取所有评论
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return EasyUIDataGridResult
	 */
	@RequestMapping(value = "getCommentList", method = RequestMethod.POST)
	public EasyUIDataGridResult getAllComments(@RequestBody @RequestParam("page") int pageNum,
			@RequestParam("rows") int pageSize) {
		EasyUIDataGridResult commentList = userFeignClient.getCommentList(pageNum, pageSize);
		return commentList;
	}

	/**
	 * 获取积极评论
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return EasyUIDataGridResult
	 */
	@RequestMapping(value = "getPositiveCommentList", method = RequestMethod.POST)
	public EasyUIDataGridResult getAllPositiveComments(@RequestBody @RequestParam("page") int pageNum,
			@RequestParam("rows") int pageSize) {
		EasyUIDataGridResult commentList = userFeignClient.getPositiveCommentList(pageNum, pageSize);
		return commentList;
	}

	/**
	 * 获取负面评论
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return EasyUIDataGridResult
	 */
	@RequestMapping(value = "getNegativeCommentList", method = RequestMethod.POST)
	public EasyUIDataGridResult getNegativeCommentList(@RequestBody @RequestParam("page") int pageNum,
			@RequestParam("rows") int pageSize) {
		EasyUIDataGridResult commentList = userFeignClient.getNegativeCommentList(pageNum, pageSize);
		return commentList;
	}

	/**
	 * 获取中性评论
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return EasyUIDataGridResult
	 */
	@RequestMapping(value = "getMiddleCommentList", method = RequestMethod.POST)
	public EasyUIDataGridResult getMiddleCommentList(@RequestBody @RequestParam("page") int pageNum,
			@RequestParam("rows") int pageSize) {
		EasyUIDataGridResult commentList = userFeignClient.getMiddleCommentList(pageNum, pageSize);
		return commentList;
	}

	/**
	 * 根据产品id获取分数
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return EasyUIDataGridResult
	 */
	@RequestMapping(value = "getAverage", method = RequestMethod.POST)
	public String getAverageAsin(@RequestBody @RequestParam("asin") String asin) {
		String average = userFeignClient.getAverageAsin(asin);
		return average;
	}
	/**
	 * 登陆验证   session添加
	 * 
	 * @param name
	 * @param pwd
	 * @param request
	 * @return User
	 */
	@PostMapping(value = "loginForm")
	 public User ifUserExist(@RequestBody @RequestParam("form-username") String name,@RequestParam("form-password") String pwd) {
		User ifUserExist = userFeignClient.ifUserExist(name, pwd);
		request.getSession().setAttribute("loginUser", ifUserExist);
		return ifUserExist;
	}
	@PostMapping(value = "exitLogin")
	 public void exitLogin() {
		request.getSession().removeAttribute("loginUser");
	}
	/**
	 * 获取json数据生成云图
	 * 
	 * @return String
	 */
	@GetMapping("getTextCloudJson")
	public String getTextCloudJson() {
		return userFeignClient.getTextCloudJson();
	}
	/**
	 * 获取评论统计json数据
	 * 
	 * @return String
	 */
	@GetMapping("getStatistics")
	String getCommentStatistics() {
		return userFeignClient.getCommentStatistics();
	}
	
}
