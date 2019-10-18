package com.comment.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.comment.common.User;
import com.comment.util.EasyUIDataGridResult;

/**
 * 
 * <p>
 * Feign接口，并增加 @FeignClient(name="service-user") 注解用以适应Eureka和Ribbon，
 * 里面的方法是和服务端提供的接口对应的
 * </p>
 *
 * <p>
 * <br>
 *
 * @author
 * @version 2019年2月16日
 */
//注解里面写你在  Eureka注册的提供服务者的名字
//增加 fallbackFactory配置   Hystrix容错处理
//@FeignClient(name="commentAnalysis-provider",fallbackFactory = CommentFeignClientFallback.class)
@FeignClient(name="commentAnalysis-provider")
public interface UserFeignClient {
	/*
	 * @GetMapping("/user/getName") public String getUser();
	 */
	/**
	 * 获取评论统计json数据
	 * 
	 * @return String
	 */
	@GetMapping("/user/getStatistics")
	String getCommentStatistics() ;
	/**
	 * 获取评论列表
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return EasyUIDataGridResult
	 */
	@PostMapping("/user/getCommentList")
	public EasyUIDataGridResult getCommentList(@RequestParam("pageNum") int pageNum,
			@RequestParam("pageSize") int pageSize);

	/**
	 * 上传json 保存评论数据
	 * 
	 * @param jsonObj
	 * @return String
	 */
	@PostMapping(value = "/user/saveJson")
	public String getUserById4(@RequestBody @RequestParam("jsonObj") String jsonObj);

	/**
	 * 获取积极评论
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return EasyUIDataGridResult
	 */
	@PostMapping("/user/getPositiveCommentList")
	public EasyUIDataGridResult getPositiveCommentList(@RequestParam("pageNum") int pageNum,
			@RequestParam("pageSize") int pageSize);

	/**
	 * 获取负面评论
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return EasyUIDataGridResult
	 */
	@PostMapping("/user/getNegativeCommentList")
	public EasyUIDataGridResult getNegativeCommentList(@RequestParam("pageNum") int pageNum,
			@RequestParam("pageSize") int pageSize);

	/**
	 * 获取中性评论
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return EasyUIDataGridResult
	 */
	@PostMapping("/user/getMiddleCommentList")
	public EasyUIDataGridResult getMiddleCommentList(@RequestParam("pageNum") int pageNum,
			@RequestParam("pageSize") int pageSize);

	/**
	 * 获取产品平均分
	 * 
	 * @param asin
	 * @return String
	 */
	@PostMapping("/user/getAverage")
	public String getAverageAsin(@RequestBody @RequestParam("asin") String asin);

	/**
	 * 关键词查找
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param asin
	 * @param reviewerName
	 * @param keyWord
	 * @return EasyUIDataGridResult
	 */
	@PostMapping("/user/getCommentsByKeywords")
	public EasyUIDataGridResult getCommentsByKeywords(@RequestBody @RequestParam("page") int pageNum,
			@RequestParam("rows") int pageSize, @RequestParam(value = "asin", required = false) String asin,
			@RequestParam(value = "reviewerName", required = false) String reviewerName,
			@RequestParam(value = "keyWord", required = false) String keyWord);

	/**
	 * 验证登陆
	 * 
	 * @param name
	 * @param pwd
	 * @return User
	 */
	@PostMapping(value = "/user/loginForm")
	public User ifUserExist(@RequestBody @RequestParam("form-username") String name,
			@RequestParam("form-password") String pwd);

	/**
	 * 返回json数据做词云图
	 * 
	 * @return String
	 */
	@GetMapping("/user/getTextCloudJson")
	public String getTextCloudJson();
}
