package com.cristik.common.email;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @Package: com.cristik.framework.email.SimpleEmailManager
 * @ClassName: SimpleEmailManager.java
 * @Description:
 * @Author: zhenghua
 * @CreateDate: 2016/6/6 13:56
 * @Version: v1.0
 */
public class SimpleEmailManager implements EmailManager {

    private JavaMailSender mailSender;

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void placeOrder(final Order order) {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setFrom("cristik@163.com");
            helper.setTo("cristik@qq.com");
            helper.setSubject("密码修改提醒");
            helper.setText("<h1>this is head</h1><br>okok",true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        mailSender.send(message);


    }

    @Override
    public void placeOrder(){
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress("1209311663@qq.com"));//1209311663@qq.com
                mimeMessage.setFrom(new InternetAddress("cristik@163.com"));
                mimeMessage.setSubject("骚扰");
                mimeMessage.setText("dou bi xiang ");
            }
        };
        try {
            this.mailSender.send(preparator);
        }
        catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
