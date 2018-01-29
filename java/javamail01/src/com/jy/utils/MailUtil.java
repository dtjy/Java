/*
 *******************************************************************************
 * @FileName	MailUtil.java
 * @package		com.jy.utils
 * @author		jy·DT
 * @Date		2018年1月30日 上午2:38:40
 * @description 
 *******************************************************************************
 */
package com.jy.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.search.RecipientStringTerm;

import sun.nio.cs.MS1250;

/**
 * 邮箱工具
 ******************************************
 * @author jy·DT  [2018年1月30日 上午2:38:40]
 ******************************************
 */
public class MailUtil {
	
	public static void sendMail(String to,String code) throws Exception{
		// 1.创建连接对象
		Session session = Session.getDefaultInstance(new Properties(), new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("service@dt.com", "123456");
			}
		});
		// 2.创建邮件对象
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("service@dt.com"));
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		//主题
		message.setSubject("来自dt的激活邮件");
		//正文
		message.setContent("<h1>来自dt的激活邮件，点击链接激活账号：</h1><h3><a href='http://localhost:8081/javamail01/active?code="+code+"'>http://localhost:8081/javamail01/active?code="+code+"</a></h3>", "text/html;charset=utf-8");
		// 3.发送激活邮件
		Transport.send(message);
	}
}
