package com.zb.activemq.queue;

import com.zb.activemq.PersonInfo;

import javax.jms.JMSException;

/**
 * 点对点消息消费者3
 * 未实现MessageListener接口，
 * 通过在spring-activemq-ptp.xml文件中配置进行相应的处理
 */
public class QueueConsumer3 {

    /**
     * receive方法的参数类型是PersonInfo，为何呢？
     * @param personInfo
     * @throws JMSException
     */
    public void receive(PersonInfo personInfo) throws JMSException {
        System.out.println("【消费者Queue3】"  + personInfo.getUserName());
    }

}
