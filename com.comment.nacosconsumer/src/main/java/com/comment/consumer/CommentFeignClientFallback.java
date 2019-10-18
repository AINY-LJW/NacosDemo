package com.comment.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.comment.common.User;
import com.comment.util.EasyUIDataGridResult;

import feign.hystrix.FallbackFactory;

/**
 * <p>
 * TODO 依赖服务失效之后的处理 微服务的容错处理Hystrix
 * </p>
 *
 * <p>
 * <br>
 *
 * @author lijiawen
 * @version 2019年2月21日
 */
@Component
public class CommentFeignClientFallback 
//implements FallbackFactory<UserFeignClient>
//implements UserFeignClient

{
//	private final Logger logger = LoggerFactory.getLogger(this.getClass());
//	@Override
//	public UserFeignClient create(Throwable cause) {
//		return new UserFeignClient() {
//
//	@Override
//	public EasyUIDataGridResult getCommentList(int pageNum, int pageSize) {
//		// 可把日志记录到其他地方
//		logger.error("获取所有评论异常");
//		return null;
//	}
//
//	@Override
//	public String getUserById4(String jsonObj) {
//		logger.error("上传json 保存评论数据异常");
//		return null;
//	}
//
//	@Override
//	public EasyUIDataGridResult getPositiveCommentList(int pageNum, int pageSize) {
//		logger.error("获取评积极论分析异常");
//		return null;
//	}
//
//	@Override
//	public EasyUIDataGridResult getNegativeCommentList(int pageNum, int pageSize) {
//		logger.error("获取负面评论异常");
//		return null;
//	}
//
//	@Override
//	public EasyUIDataGridResult getMiddleCommentList(int pageNum, int pageSize) {
//		logger.error("获取中性评论异常");
//		return null;
//	}
//
//	@Override
//	public String getAverageAsin(String asin) {
//		logger.error("获取产品平均分异常");
//		return null;
//	}
//
//	@Override
//	public EasyUIDataGridResult getCommentsByKeywords(int pageNum, int pageSize, String asin, String reviewerName,
//			String keyWord) {
//		logger.error("根据关键词获取评论异常");
//		return null;
//	}
//
//	@Override
//	public User ifUserExist(String name, String pwd) {
//		logger.error("登录校验异常");
//		return null;
//	}
//
//	@Override
//	public String getTextCloudJson() {
//		logger.error("获取词云图json数据异常");
//		return null;
//	}
//
//	@Override
//	public String getCommentStatistics() {
//		logger.error("获取评论分析异常");
//		return null;
//	}
//
//		};
//	}
//
}
