package com.moier.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionService implements IQuestionService {

	
	@Autowired
	private ISqliteService sqlite;
	
	@Autowired
	private IMailService mailService;
	
	@Override
	public void sendEmail(String msg, String host) {
		
		boolean doSended = sqlite.doSended(host);
		if(doSended){
			throw new NullPointerException("不允许重复发送");
		}
		sqlite.saveQuestion(host, msg);
		mailService.send(null, "问卷调查", msg);
	}

}
