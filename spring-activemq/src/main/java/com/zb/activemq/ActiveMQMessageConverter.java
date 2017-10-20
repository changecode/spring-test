package com.zb.activemq;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

/**
 * 消息转换器
 */
@Component("activeMQMessageConverter")
public class ActiveMQMessageConverter implements MessageConverter {
    
    /**
     * 将发送的实体bean对象封装为Message消息
     *  对已经实现MessageListener接口的消费者产生作用
     * @param obj
     * @param session
     * @return
     * @throws JMSException
     */
    public Message toMessage(Object obj, Session session) throws JMSException {
        if (obj instanceof PersonInfo) {
            ActiveMQObjectMessage msg = (ActiveMQObjectMessage) session.createObjectMessage();
            msg.setObject((PersonInfo) obj);
            return msg;
        } else {
            throw new JMSException("Object:[" + obj + "] is not a instance of PersonInfo.");
        }
    }
    
    /**
     * 将消息对象转换为对应的实体bean并返回
     *  只对未实现MessageListener接口的消息消费者产生作用，其他的已经实现MessageListener接口的，不会执行该方法
     * @param message
     * @return
     * @throws JMSException
     */
    public Object fromMessage(Message message) throws JMSException {
        if (message instanceof ObjectMessage) {
            ObjectMessage oMsg = (ObjectMessage) message;
            if (oMsg instanceof ActiveMQObjectMessage) {
                ActiveMQObjectMessage aMsg = (ActiveMQObjectMessage) oMsg;
                try {
                    PersonInfo personInfo = (PersonInfo) aMsg.getObject();
                    personInfo.setUserName(personInfo.getUserName());
                    return personInfo;
                } catch (Exception e) {
                    throw new JMSException("Message:[" + message + "] is not a instance of personInfo.");
                }
            } else {
                throw new JMSException("Message:[" + message + "] is not " + "a instance of ActiveMQObjectMessage[personInfo].");
            }
        } else {
            throw new JMSException("Message:[" + message + "] is not a instance of ObjectMessage.");
        }
    }

}
