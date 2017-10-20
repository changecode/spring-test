package com.zb.activemq.topic;

import com.zb.activemq.PersonInfo;

import javax.jms.JMSException;

/**
 * topic消息消费者A
 */
public class TopicConsumerA {

    public void receiveA(PersonInfo personInfo) throws JMSException {
        System.out.println("TOPIC_A 收到的消息: "  + personInfo.getUserName());
    }

}
