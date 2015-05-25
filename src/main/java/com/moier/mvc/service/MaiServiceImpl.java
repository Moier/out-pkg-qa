package com.moier.mvc.service;

import org.apache.log4j.Logger;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.util.StringUtils;

/**
 * 
 * <p>Title: MaiServiceImpl</p>
 * Description:		邮件服务类
 *
 * @author Huasong Huang
 * CreateTime: 2014-10-20 上午10:16:42
 */
public class MaiServiceImpl implements IMailService {

	private JavaMailSenderImpl sender;
	
	private String to;
	
	private static Logger LOGGER = Logger.getLogger(MaiServiceImpl.class);
	
	
	@Override
	public boolean send(String to, String subject, String content) {
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setFrom(sender.getUsername());
		smm.setSubject(subject);
		smm.setText(content);
		if(StringUtils.isEmpty(to)){
			smm.setTo(this.to);
		}else{
			smm.setTo(to);
		}
		boolean isSendSuccess = false;
		try{
			this.sender.send(smm);
			isSendSuccess = true;
		}catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return isSendSuccess;
	}

	public JavaMailSenderImpl getSender() {
		return sender;
	}

	public void setSender(JavaMailSenderImpl sender) {
		this.sender = sender;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
	
	
	
}
