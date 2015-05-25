package com.moier.mvc.service;

public interface IMailService {

	/**
	 * 
	 * <p>Title ：send</p>
	 * Description：		向指定的用户发送邮件
	 * @param to		用户邮箱
	 * @param subject	主题
	 * @param content	内容（纯文本)
	 * @return
	 * Author：Huasong Huang
	 * CreateTime：2014-10-20 上午10:05:46
	 */
	public boolean send(String to,String subject,String content);
}
