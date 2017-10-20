package com.zb.activemq.queue;

import com.zb.activemq.PersonInfo;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Queue;

/**
 * 点对点消息生产者
 */
@Component
public class QueueMessageProducer {
    
    /**
     * spring消息发送模版
     */
    @Resource(name="queueJmsTemplate")
    private JmsTemplate jmsTemplate;

    /**
     * 消息目的地
     */
    @Resource(name = "queueDestination")
    private Queue defaultDestination;

    /**
     * 发送消息
     * @param personInfo
     */
    public void sendQueueMessage(PersonInfo personInfo) {
        // getJmsTemplate().convertAndSend(personInfo);//如果配置文件中指定了目的地，可以使用这句话发送消息。
        System.out.println("QUEUE SEND MESSAGE...");
        getJmsTemplate().convertAndSend(this.defaultDestination, personInfo);
    }

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public Queue getDefaultDestination() {
        return defaultDestination;
    }

    public void setDefaultDestination(Queue defaultDestination) {
        this.defaultDestination = defaultDestination;
    }

}
