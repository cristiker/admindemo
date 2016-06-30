package com.cristik.common.email;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * @Package: com.cristik.email.SimpleOrderManager
 * @ClassName: SimpleOrderManager.java
 * @Description:
 * @Author: zhenghua
 * @CreateDate: 2016/6/6 10:53
 * @Version: v1.0
 */
public class SimpleOrderManager implements OrderManager{

    private MailSender mailSender;

    private SimpleMailMessage templateMessage;

    public void setMailSender(MailSender mailSender){
        this.mailSender = mailSender;
    }

    public void setTemplateMessage(SimpleMailMessage templateMessage){
        this.templateMessage = templateMessage;
    }

    @Override
    public void placeOrder(Order order) {
        SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
        msg.setTo("370814386@qq.com");
        msg.setText("this is my first email");
        try {
            this.mailSender.send(msg);
        } catch (MailException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("邮件发送成功");
    }

}
