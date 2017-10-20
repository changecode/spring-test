package activemq;

import com.zb.activemq.PersonInfo;
import com.zb.activemq.queue.QueueMessageProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.JMSException;
/**
 * 点对点模式(1-1)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/applicationContext.xml")
public class QueueMessageTest {

    @Autowired
    private QueueMessageProducer queueMessageProducer;

    /**
     * 发送queue消息
     * 
     *  queue消费者可以有多个，但是最终只能有一个消费者接收到消息并进行处理，可以说是一次性，接收到之后消息就不存在了。
     *  PTP消息，可以保证消息一定会到达消费者的手中。
     *  消息接收成功后，会通知容器进行下一步处理。
     * @throws JMSException
     */
    @Test
    public void testQueueMQ() throws JMSException {
        PersonInfo personInfo = new PersonInfo();
        personInfo.setAddress("queue_10086");
        personInfo.setPwd("queue_10086");
        personInfo.setUserName("queue_10086");
        queueMessageProducer.sendQueueMessage(personInfo);
    }
}
