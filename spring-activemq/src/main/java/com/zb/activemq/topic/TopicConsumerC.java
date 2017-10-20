package com.zb.activemq.topic;

import org.apache.activemq.command.ActiveMQObjectMessage;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * topic消息消费者C
 */
public class TopicConsumerC implements MessageListener{

    @Override
    public void onMessage(Message m) {
        try {
            ActiveMQObjectMessage om = (ActiveMQObjectMessage) m;
            System.out.println("TOPIC_C 接受到的消息: " + om.getObject());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
