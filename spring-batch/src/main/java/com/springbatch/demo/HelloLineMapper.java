package com.springbatch.demo;

import org.springframework.batch.item.file.LineMapper;

/**
 * 映射成对应的实体
 */
public class HelloLineMapper implements LineMapper<DeviceCommand> {

    @Override
    public DeviceCommand mapLine(String line, int lineNumber) throws Exception {

        String[] args = line.split(",");
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setId(args[0]);
        deviceCommand.setStatus(args[1]);
        return deviceCommand;

    }

}
