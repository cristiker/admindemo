package com.cristik.activemq;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;


/**
 * Created by zhenghua on 2016/5/17.
 */



public class QueueTest {

    public static void main(String[] args) throws Exception {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("vm://localhost");

        Connection connection = factory.createConnection();
        connection.start();

        //创建一个Queue
        /*Queue queue = new ActiveMQQueue("testQueue");*/
        Topic queue = new ActiveMQTopic("testtopic");
        //创建一个Session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //注册消费者1
        MessageConsumer comsumer1 = session.createConsumer(queue);
        comsumer1.setMessageListener(new MessageListener(){
            public void onMessage(Message m) {
                try {
                    System.out.println("Consumer1 get " + ((TextMessage)m).getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

        //注册消费者2
        MessageConsumer comsumer2 = session.createConsumer(queue);
        comsumer2.setMessageListener(new MessageListener(){
            public void onMessage(Message m) {
                try {
                    System.out.println("Consumer2 get " + ((TextMessage)m).getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }

        });

        //创建一个生产者，然后发送多个消息。
        MessageProducer producer = session.createProducer(queue);
        for(int i=0; i<10; i++){
            producer.send(session.createTextMessage("Message:" + i*1000));
        }
    }

}
