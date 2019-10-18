package com.comment.user;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.comment.user.dao.CommentMapper;
import com.comment.user.model.Comment;
import com.comment.user.model.CommentExample;
import com.comment.user.model.CommentExample.Criteria;
import com.comment.util.EasyUIDataGridResult;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;


//此类为controller类
@RestController
public class GetName {

	@Autowired
	private CommentMapper commentMapper;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	/**
	 * 返回json数据用于生成词云图
	 * 
	 * @return String
	 */
	@ApiOperation(value="返回json数据用于生成词云图",notes="不知道")
	@GetMapping("/user/getTextCloudJson")
	String getTextCloudJson() {
		CommentExample example = new CommentExample();
		List<Comment> selectByExample = commentMapper.selectByExample(example);
		JSONArray json=new JSONArray();
		JSONObject o=null;
		int i=5;
		
		for (Comment comment : selectByExample) {
			 o=new JSONObject();
			 o.put("name", comment.getSummary());//评论关键词
			 if(i>80) {
				 i=5;
			 }
			 o.put("value", i++);//评分
			// o.put("value",(int)(sb));
			//o.put("value",(int)((Double.parseDouble(comment.getOverall())*50)));//评分
			// o.put("value", comment.getReviewtext());//评分
			// o.put("itemStyle", "createRandomItemStyle()");
			 json.add(o);
			 if(json.size()>500) {break;}
		}
		return json.toString();
		
	}
	/**
	 * 获取评论统计json数据
	 * 
	 * @return String
	 */
	@ApiOperation(value="获取评论统计json数据",notes="")
	@GetMapping("/user/getStatistics")
	String getCommentStatistics() {
		JSONArray json=new JSONArray();
		JSONObject o=null;
		CommentExample example = new CommentExample();
		example.createCriteria().andOverallEqualTo("3.0");
		int middle = commentMapper.countByExample(example);
		o=new JSONObject();
		o.put("name", "中性评价");
		o.put("value", middle);
		json.add(o);
		example.clear();
		
		example.createCriteria().andOverallGreaterThan("3");
		int good = commentMapper.countByExample(example);
		o=new JSONObject();
		o.put("name", "正面评价");
		o.put("value", good);
		json.add(o);
		example.clear();
		
		example.createCriteria().andOverallLessThan("3");
		int bad = commentMapper.countByExample(example);
		o=new JSONObject();
		o.put("name", "负面评价");
		o.put("value", bad);
		json.add(o);
		
		return json.toString();
		
	}

	/**
	 * 根据产品id获取产品平均评分
	 * 
	 * @param jsonObj
	 * @return String
	 */
	@ApiOperation(value="根据产品id获取产品平均评分",notes="")
	@PostMapping("/user/getAverage")
	String getAverageAsin(@RequestBody(required = false) @RequestParam("asin") String asin) {
		CommentExample example = new CommentExample();
		example.createCriteria().andAsinEqualTo(asin);
		List<Comment> allComments;
		try {
			allComments = null;
			allComments = commentMapper.selectByExample(example);
			if (allComments == null) {
				return "null";
			}
		} catch (Exception e) {
			return "null";
		}
		double Score = 0;
		int i = 0;
		for (Comment comment : allComments) {
			Score += Double.parseDouble(comment.getOverall());
			i++;
		}
		DecimalFormat df = new DecimalFormat("#.00");
		String str = df.format(Score / i);
		return str;

	}

	/**
	 * 根据关键词查找评论
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return EasyUIDataGridResult
	 */
	@ApiOperation(value="根据关键词查找评论",notes="")
	@PostMapping("/user/getCommentsByKeywords")
	//
	EasyUIDataGridResult getCommentsByKeywords(@RequestBody @RequestParam("page") int pageNum,
			@RequestParam("rows") int pageSize, @RequestParam(value = "asin", required = false) String asin,
			@RequestParam(value = "reviewerName", required = false) String reviewerName,
			@RequestParam(value = "keyWord", required = false) String keyWord)  {
		PageMethod.startPage(pageNum, pageSize);
		CommentExample example = new CommentExample();
		Criteria createCriteria = example.createCriteria();
		if (asin != null  ) {
			if(!asin.equals("")) {
				createCriteria.andAsinEqualTo(asin);
			}
			
		}
		if (reviewerName != null ) {
			if( !reviewerName.equals("")) {
				createCriteria.andReviewernameLike("%"+reviewerName+"%");
			}
		
		}
		if (keyWord != null ) {
			if(!keyWord.equals("")) {
				createCriteria.andReviewtextLike("%"+keyWord+"%");
			}
			
		}
		List<Comment> allComments = commentMapper.selectByExample(example);
		EasyUIDataGridResult dataGridResult = new EasyUIDataGridResult();
		PageInfo<Comment> pageInfo = new PageInfo<>(allComments);
		dataGridResult.setRows(allComments);
		dataGridResult.setTotal(pageInfo.getTotal());
		return dataGridResult;
	}

	/**
	 * 所有评价
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return EasyUIDataGridResult
	 */
	@PostMapping("/user/getCommentList")
	@ApiOperation(value = "所有评价",notes = "")
	EasyUIDataGridResult getList(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
		PageMethod.startPage(pageNum, pageSize);
		CommentExample example = new CommentExample();
		List<Comment> allComments = commentMapper.selectByExample(example);
		EasyUIDataGridResult dataGridResult = new EasyUIDataGridResult();
		PageInfo<Comment> pageInfo = new PageInfo<>(allComments);
		dataGridResult.setRows(allComments);
		dataGridResult.setTotal(pageInfo.getTotal());
		return dataGridResult;
	}

	/**
	 * 中性评价
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return EasyUIDataGridResult
	 */
	@ApiOperation(value = "中性评价",notes = "")
	@PostMapping("/user/getMiddleCommentList")
	//
	EasyUIDataGridResult getMiddleCommentList(@RequestParam("pageNum") int pageNum,
			@RequestParam("pageSize") int pageSize) {
		PageMethod.startPage(pageNum, pageSize);

		List<String> have = new ArrayList<>();
		have.add("%don't like%");
		have.add("%fuck%");
		have.add("%shit%");
		have.add("%didn't like%");
		List<Comment> allComments = getMiddleCommentByKey(have);
		EasyUIDataGridResult dataGridResult = new EasyUIDataGridResult();
		PageInfo<Comment> pageInfo = new PageInfo<>(allComments);
		dataGridResult.setRows(allComments);
		dataGridResult.setTotal(pageInfo.getTotal());
		return dataGridResult;
	}

	/**
	 * 负面评价
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return EasyUIDataGridResult
	 */
	@ApiOperation(value = "负面评价",notes = "")
	@PostMapping("/user/getNegativeCommentList")
	//
	EasyUIDataGridResult getnegativeCommentList(@RequestParam("pageNum") int pageNum,
			@RequestParam("pageSize") int pageSize) {
		PageMethod.startPage(pageNum, pageSize);

		List<String> have = new ArrayList<>();
		have.add("%don't like%");
		have.add("%fuck%");
		have.add("%shit%");
		have.add("%didn't like%");
		List<Comment> allComments = getNegativeCommentByKey(have);
		EasyUIDataGridResult dataGridResult = new EasyUIDataGridResult();
		PageInfo<Comment> pageInfo = new PageInfo<>(allComments);
		dataGridResult.setRows(allComments);
		dataGridResult.setTotal(pageInfo.getTotal());
		return dataGridResult;
	}

	/**
	 * 正面评价
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return EasyUIDataGridResult
	 */
	@PostMapping("/user/getPositiveCommentList")
	@ApiOperation(value="正面评价",notes = "")
	EasyUIDataGridResult getPositiveCommentList(@RequestParam("pageNum") int pageNum,
			@RequestParam("pageSize") int pageSize) {
		PageMethod.startPage(pageNum, pageSize);

		List<String> list = new ArrayList<>();
		list.add("%good%");
		list.add("%great%");
		list.add("%not bad%");
		List<String> notHave = new ArrayList<>();
		notHave.add("%bad%");
		notHave.add("%fuck%");
		notHave.add("%shit%");
		notHave.add("%didn't like%");
		List<Comment> allComments = getPositiveCommentByKey(list);
		EasyUIDataGridResult dataGridResult = new EasyUIDataGridResult();
		PageInfo<Comment> pageInfo = new PageInfo<>(allComments);
		dataGridResult.setRows(allComments);
		dataGridResult.setTotal(pageInfo.getTotal());
		return dataGridResult;
	}

	/**
	 * 根据关键词列表获取正面评价评论列表
	 * 
	 * @param list
	 * @return List<Comment>
	 */
	@ApiOperation(value="根据关键词列表获取正面评价评论列表")
	public List<Comment> getPositiveCommentByKey(List<String> list) {
		List<Comment> allComments = new ArrayList<>();
		CommentExample example = new CommentExample();

		example.createCriteria().andOverallGreaterThan("3");

		allComments = commentMapper.selectByExample(example);

		return allComments;
	}

	/**
	 * 负面评价评论列表 根据关键词列表获取
	 * 
	 * @param list
	 * @return List<Comment>
	 */
	@ApiOperation(value="负面评价评论列表 根据关键词列表获取")
	public List<Comment> getNegativeCommentByKey(List<String> list) {
		// 现根据评分获取差评
		List<Comment> allComments = new ArrayList<>();
		CommentExample example = new CommentExample();
		example.createCriteria().andOverallLessThan("3");
		allComments = commentMapper.selectByExample(example);

		example.clear();
		// 在根据关键词获取差评
		for (String string : list) {
			example.or(example.createCriteria().andReviewtextLike(string));
		}
		// 好评里面找差评
		List<Comment> selectByhave = commentMapper.selectByExample(example);
		for (Comment comment : selectByhave) {
			if (!allComments.contains(comment)) {
				allComments.add(comment);
			}
		}
		return allComments;
	}

	/**
	 * 根据关键词列表获取中性评价评论列表
	 * 
	 * @param list
	 * @return List<Comment>
	 */
	@ApiOperation(value="根据关键词列表获取中性评价评论列表")
	public List<Comment> getMiddleCommentByKey(List<String> list) {
		List<Comment> allComments = new ArrayList<>();
		CommentExample example = new CommentExample();

		example.createCriteria().andOverallEqualTo("3.0");

		allComments = commentMapper.selectByExample(example);
		// 在根据关键词获取差评
		example.clear();
		for (String string : list) {
			example.or(example.createCriteria().andReviewtextLike(string));
		}
		List<Comment> selectByhave = commentMapper.selectByExample(example);
		for (Comment comment : selectByhave) {
			if (allComments.contains(comment)) {
				allComments.remove(comment);
			}
		}
		return allComments;
	}

	/**
	 * 获取JSON数据 并且尝试将json数据添加进数据库
	 * 
	 * @param jsonObj
	 * @return String
	 */
	@ApiOperation(value="获取JSON数据 并且尝试将json数据添加进数据库",notes = "")
	@PostMapping(value = "/user/saveJson")
	public String getUserById4(@RequestBody(required = false) @RequestParam("jsonObj") String jsonObj) {
		JSONArray jsonArray = null;
		try {
			jsonArray = JSON.parseArray(jsonObj);

			if (jsonArray != null) {
				for (Object j : jsonArray) {
					Comment record = new Comment();
					JSONObject json = (JSONObject) j;
					// 用户身份证
					String reviewerID = json.getString("reviewerID");
					// 产品ID
					String asin = json.getString("asin");
					// 用户姓名
					String reviewerName = json.getString("reviewerName");
					// 评估的帮助程度
					String helpful = json.getString("helpful");
					// 审议案文
					String reviewText = json.getString("reviewText");
					// 产品评级
					String overall = json.getString("overall");
					// 审查摘要
					String summary = json.getString("summary");
					// 审查时间(Unix时间)
					String unixReviewTime = json.getString("unixReviewTime");
					// 审查时间(原始)
					String reviewTime = json.getString("reviewTime");
					// 转换时间
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					SimpleDateFormat format1 = new SimpleDateFormat("MM dd, yyyy");
					SimpleDateFormat format2 = new SimpleDateFormat("MM d, yyyy");
					Long time = new Long(unixReviewTime) * 1000;
					String d = format.format(time);
					Date unixreviewtime = format.parse(d);

					Date reviewtime;
					try {
						reviewtime = format1.parse(reviewTime);
					} catch (Exception e) {
						reviewtime = format2.parse(reviewTime);
					}

					record.setAsin(asin);
					record.setHelpful(helpful);
					record.setId(UUID.randomUUID().toString());
					record.setOverall(overall);
					record.setReviewerid(reviewerID);
					record.setReviewername(reviewerName);
					record.setReviewtext(reviewText);
					record.setSummary(summary);
					record.setReviewtime(reviewtime);
					record.setUnixreviewtime(unixreviewtime);
					commentMapper.insert(record);
				}
			} else {
				return "json数据不能等于空";
			}
		} catch (Exception e) {
			return e.getMessage().toString();
		}
		return "ok";

	}
	/**
	 * 测试获取路由中定义变量
	 * 
	 * @param jsonObj
	 * @return
	 * @throws Exception String
	 */
	@ApiIgnore
	@PostMapping("/user/type1/{id}")
	public String getUserById(@PathVariable String jsonObj) throws Exception {
		return jsonObj;

//		

	}
}
