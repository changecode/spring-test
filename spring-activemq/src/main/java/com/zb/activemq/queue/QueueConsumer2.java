package com.zb.activemq.queue;

import org.apache.activemq.command.ActiveMQObjectMessage;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * 点对点消息消费者2
 */
public class QueueConsumer2 implements MessageListener {

    @Override
    public void onMessage(Message m) {
        try {
            //ActiveMQTextMessage om = (ActiveMQTextMessage) m;
            ActiveMQObjectMessage om = (ActiveMQObjectMessage) m;
            System.out.println("queue消息消费者2: " + om.getObject());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
