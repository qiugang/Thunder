package me.originqiu.library;

import android.support.annotation.NonNull;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by OriginQiu on 16/8/18.
 */
public class CallBuilder {
    private String url;
    
    private String params;
    
    /*
     * Must. 必须。
     */
    public CallBuilder url(@NonNull String url) {
        this.url = url;
        return this;
    }
    
    /*
     * Optional. 可选。
     */
    public CallBuilder params(@NonNull String params) {
        this.params = params;
        return this;
    }
    
    public Call buildPost() {
        RequestBody body = RequestBody.create(MediaType.parse("application/json"),
                                              params);
        Request.Builder builder = new Request.Builder().url(url).post(body);
        Request request = builder.build();
        return new OkHttpClient().newCall(request);
    }
    
    public Call buildGet() {
        Request.Builder builder = new Request.Builder().url(url).get();
        Request request = builder.build();
        return new OkHttpClient().newCall(request);
    }
}
