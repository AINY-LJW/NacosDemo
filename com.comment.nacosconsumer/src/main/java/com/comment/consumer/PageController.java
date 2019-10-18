package com.comment.consumer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.comment.bean.Comment;

@Controller
public class PageController {
//	@Autowired 
//	private RestTemplate restTemplate;
	 @RequestMapping(value = "show", method = RequestMethod.GET)
	    public String show(Model model){
	        model.addAttribute("key","Jerry");
	        List<Comment> comments=new ArrayList<>();
	        model.addAttribute("comments", comments);
	        return "hello.html";
	    }
	/* @RequestMapping(value = "show1", method = RequestMethod.GET)
	    public String showList(Model model){
		 model.addAttribute("key","Jerry");
//		 List<Comment> comments=restTemplate.getForObject("http://porvider-user/user/getList", List.class);
		 List<Comment> comments = userFeignClient.getCommentList();
	     model.addAttribute("comments", comments);
	     return "hello.html";
	    }*/
	 /**
	  * 进入评论列表页
	  * 
	  * @param model
	  * @return String
	  */
	 @RequestMapping(value = "allComment", method = RequestMethod.GET)
	    public String getAllComment(Model model){
//		 List<Comment> comments=restTemplate.getForObject("http://porvider-user/user/getList", List.class);
//		 List<Comment> comments = userFeignClient.getCommentList();
//	     model.addAttribute("comments", comments);
	     return "allComment.html";
	    }
	 /**
	  * 进入登陆页面
	  * 
	  * @param model
	  * @return String
	  */
	 @RequestMapping(value = "login", method = RequestMethod.GET)
	    public String showindex(Model model){	
	     return "login.html";
	    }
	 /**
	  * 进入首页
	  * 
	  * @param model
	  * @return String
	  */
	 @RequestMapping(value = "homePage", method = RequestMethod.GET)
	    public String showHomePage(Model model){	 
	     return "homePage.html";
	    }
	 /**
	  * 首页里的首页。。
	  * 
	  * @param model
	  * @return String
	  */
	 @RequestMapping(value = "homePageIn", method = RequestMethod.GET)
	    public String showHomePageIn(Model model){	 
	     return "homePageIn.html";
	    }
	 /**
	  * 上传json数据保存评论页面
	  * 
	  * @param model
	  * @return String
	  */
	 @RequestMapping(value = "uploadJson", method = RequestMethod.GET)
	    public String showUploadJson(Model model){	 
	     return "uploadJson.html";
	    }
	 /**
	  * 产品平均分页面
	  * 
	  * @param model
	  * @return String
	  */
	 @RequestMapping(value = "average", method = RequestMethod.GET)
	    public String showAverage(Model model){	 
	     return "average.html";
	    }
	 /**
	  * 正面评价   积极评价页面
	  * 
	  * @param model
	  * @return String
	  */
	 @RequestMapping(value = "positiveComment", method = RequestMethod.GET)
	    public String showPositiveComment(Model model){	 
	     return "positiveComment.html";
	    }
	 /**
	  * 负面评价   消极评价页面
	  * 
	  * @param model
	  * @return String
	  */
	 @RequestMapping(value = "negativeComment", method = RequestMethod.GET)
	    public String showNegativeComment(Model model){	 
	     return "negativeComment.html";
	    }
	 
	 /**
	  * 负面评价   消极评价页面
	  * 
	  * @param model
	  * @return String
	  */
	 @RequestMapping(value = "middleComment", method = RequestMethod.GET)
	    public String showMiddleComment(Model model){	 
	     return "middleComment.html";
	    }
	 /**
	  * 云标签页面
	  * 
	  * @param model
	  * @return String
	  */
	 @RequestMapping(value = "textCloud", method = RequestMethod.GET)
	    public String showTextCloud(Model model){	 
	     return "textCloud.html";
	    }
	 /**
	  * 评论分类统计页面
	  * 
	  * @param model
	  * @return String
	  */
	 @RequestMapping(value = "commentStatistics", method = RequestMethod.GET)
	    public String showcommentStatistics(Model model){	 
	     return "commentStatistics.html";
	    }
}

