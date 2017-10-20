package com.springbatch.demo;

import org.springframework.batch.item.file.transform.LineAggregator;

/**
 * (处理完之后)实现写接口方法
 */
public class HelloLineAggregator implements LineAggregator<DeviceCommand> {

    @Override
    public String aggregate(DeviceCommand deviceCommand) {

        StringBuffer sb = new StringBuffer();
        sb.append(deviceCommand.getId());
        sb.append(",");
        sb.append(deviceCommand.getStatus());
        return sb.toString();

    }

}
