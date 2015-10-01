package com.app.coolweather.util;

/**
 * Created by wen on 2015/10/1.
 */
public interface HttpcallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
