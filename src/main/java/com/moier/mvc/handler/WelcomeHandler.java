package com.moier.mvc.handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moier.mvc.service.IQuestionService;
import com.moier.mvc.service.ISqliteService;

@Controller
@RequestMapping("welcome")
public class WelcomeHandler {
	@Autowired
	private ISqliteService sqlite ;
	
	@Autowired
	private IQuestionService questionService;
	
	@RequestMapping("question")
	@ResponseBody
	public Map<String,Object> sayHello(String t1,String t2,String t3,String t4,String t5,String t6,String t7,String t8,HttpServletRequest request){
		Map<String, Object> m = new HashMap<String,Object>();
		try {
			String host = request.getRemoteHost();
			StringBuilder sb = new StringBuilder();
			boolean isNeedSend = false;
			if(!StringUtils.isEmpty(t1)){
				sb.append("1. 您需要创新？创业？就业？").append("\r\n").append("回答：").append(t1).append("\r\n");
				isNeedSend = true;
			}
			if(!StringUtils.isEmpty(t2)){
				sb.append("2.您需要的空间位置？面积？").append("\r\n").append("回答：").append(t2).append("\r\n");
				isNeedSend = true;
			}
			if(!StringUtils.isEmpty(t3)){
				sb.append("3.请您上网查询国务院【2015】9号文件，提出您需要的政策扶持申请？").append("\r\n").append("回答：").append(t3).append("\r\n");
				isNeedSend = true;
			}
			if(!StringUtils.isEmpty(t4)){
				sb.append("4.您对空间基础设施建设有哪些要求？").append("\r\n").append("回答：").append(t4).append("\r\n");
				isNeedSend = true;
			}
			if(!StringUtils.isEmpty(t5)){
				sb.append("5.您希望店铺的最佳面积是多少？").append("\r\n").append("回答：").append(t5).append("\r\n");
				isNeedSend = true;
			}
			if(!StringUtils.isEmpty(t6)){
				sb.append("6.您现在开网店，开微店了吗？您经营的商品是什么？年营业额最大是多少？").append("\r\n").append("回答：").append(t6).append("\r\n");
				isNeedSend = true;
			}
			if(!StringUtils.isEmpty(t7)){
				sb.append("7.您还有什么意见？").append("\r\n").append("回答：").append(t7).append("\r\n");
				isNeedSend = true;
			}
			if(!StringUtils.isEmpty(t8)){
				sb.append("8.您还有什么意见？").append("\r\n").append("回答：").append(t8).append("\r\n");
				isNeedSend = true;
			}
			if(isNeedSend){
				this.questionService.sendEmail(sb.toString(),host);
			}else{
				throw new Exception("未发现可用信息");
			}
			
			m.put("success", true);
		} catch (Exception e) {
			m.put("success", false);
			m.put("info", e.getMessage());
		}
		return m;
	}
	
	@RequestMapping("query")
	@ResponseBody
	public String query(){
		try {
			this.sqlite.query();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "hh";
	}

}
