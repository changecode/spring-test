package com.zb.activemq.topic;

import com.zb.activemq.PersonInfo;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Topic;

/**
 * PUB-SUB消息生产者
 */
@Component
public class TopicMessageProducer {

    /**
     * spring消息发送模版
     */
    @Resource(name="topicJmsTemplate")
    private JmsTemplate jmsTemplate;

    /**
     * 消息目的地
     */
    @Resource(name = "topicDestination")
    private Topic defaultDestination;

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public Topic getDefaultDestination() {
        return defaultDestination;
    }

    public void setDefaultDestination(Topic defaultDestination) {
        this.defaultDestination = defaultDestination;
    }

    public void sendTopicMessage(PersonInfo personInfo) {
        // getJmsTemplate().convertAndSend(personInfo);//如果配置文件中指定了目的地，可以使用这句话发送消息。
        System.out.println("topic product messsages...");
        getJmsTemplate().convertAndSend(this.defaultDestination, personInfo);
    }

}
