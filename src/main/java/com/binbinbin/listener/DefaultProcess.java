package com.binbinbin.listener;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface DefaultProcess {
    public static final String OUTPUT1 = "repayment_ld01_output"; // 输出通道名称
    public static final String INPUT1= "repayment_ld01_input"; // 输入通道名称
    public static final String OUTPUT2 = "repayment_ld02_output"; // 输出通道名称
    public static final String INPUT2= "repayment_ld02_input"; // 输入通道名称

    @Input(DefaultProcess.INPUT1)
    public SubscribableChannel input1();

    @Output(DefaultProcess.OUTPUT1)
    public MessageChannel output1();

    @Input(DefaultProcess.INPUT2)
    public SubscribableChannel input2();

    @Output(DefaultProcess.OUTPUT2)
    public MessageChannel output2();
}