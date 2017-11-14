package com.telit.springboot.util;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JpushUtil {

    private static int timeToLive =  60 * 60 * 24;
    public static void sendAllsetNotification(String message,String appKey,String masterSecret,
                                              List<String> alias,Map<String, String> extras) {
        JPushClient jpushClient = new JPushClient(masterSecret, appKey,timeToLive);
        // 添加附加信息
        if(BeanUtil.isEmpty(extras)){
            extras = new HashMap<String,String>();
        }
        PushPayload payload = buildPush(message, extras,alias);
        try {
            PushResult result = jpushClient.sendPush(payload);
            System.out.println("消息发送成功 : "+result);
        } catch (APIConnectionException e) {
            System.out.println(e);
        } catch (APIRequestException e) {
            System.out.println("Error response from JPush server. Should review and fix it. " + e);
            System.out.println("HTTP Status: " + e.getStatus());
            System.out.println("Error Code: " + e.getErrorCode());
            System.out.println("Error Message: " + e.getErrorMessage());
            System.out.println("Msg ID: " + e.getMsgId());
        }
    }
    private static PushPayload buildPush(String message, Map<String, String> extras,List<String> alias) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                // 设置平台
                .setAudience(Audience.alias(alias))
                // 按什么发送 tag alia
                .setNotification(
                        Notification
                                .newBuilder()
                                .setAlert(message)
                                .addPlatformNotification(
                                        AndroidNotification.newBuilder().addExtras(extras).build())
                                .addPlatformNotification(
                                        IosNotification.newBuilder().addExtras(extras).build())
                                .build())
                // 发送消息
                .setOptions(Options.newBuilder().setApnsProduction(true).build()).build();
        //设置ios平台环境  True 表示推送生产环境，False 表示要推送开发环境   默认是开发
    }

}
