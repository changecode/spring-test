package com.kode.rocketmq.service.impl;

import com.kode.rocketmq.service.RocketMqMessageListener;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.List;

/**
 * 消息处理实现类
 */
@Service
public class RocketMqMessageListenerImpl implements RocketMqMessageListener {

    private static final Logger logger = LoggerFactory.getLogger(RocketMqMessageListenerImpl.class);

    @Override
    public boolean onMessage(List<MessageExt> messages, ConsumeConcurrentlyContext Context) {
        messages.forEach(messageExt -> logger.info(StringUtils.toEncodedString(messageExt.getBody(), Charset.defaultCharset())));
        return true;
    }
}
