package com.zb.activemq.topic;

import com.zb.activemq.PersonInfo;

import javax.jms.JMSException;

/**
 * topic消息消费者B
 */
public class TopicConsumerB {
    public void receiveB(PersonInfo personInfo) throws JMSException {
        System.out.println("TOPIC_B 收到的消息: " + personInfo.getUserName());
    }
}
