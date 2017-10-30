package com.kode.rocketmq.service;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * Created by WIN on 2017/10/20.
 */
public interface RocketMqMessageListener {
    boolean onMessage(List<MessageExt> messages, ConsumeConcurrentlyContext Context);
}
