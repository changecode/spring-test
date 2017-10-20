package com.zb.activemq.queue;

import org.apache.activemq.command.ActiveMQObjectMessage;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * 点对点消息消费者  1
 */
public class QueueConsumer1 implements MessageListener  {

    @Override
    public void onMessage(Message m) {
        try {
            ActiveMQObjectMessage om = (ActiveMQObjectMessage) m;
            System.out.println("【queue消息消费者1】: " + om.getObject());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
