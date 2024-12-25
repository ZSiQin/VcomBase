package com.vcom.base.utils;

import android.text.TextUtils;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkhttpUtil {
    private static OkhttpUtil util;

    private OkhttpUtil() {
    }

    public OkhttpUtil getInstance() {
        if (util == null) {
            synchronized (OkhttpUtil.class) {
                if (util == null) {
                    util = new OkhttpUtil();
                }
            }
        }
        return util;
    }

    private static OkHttpClient okHttpClient;

    private static OkHttpClient getOkHttpClient() {

        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request request = chain.request();
                            Request builder = request.newBuilder().addHeader("source", "android").build();
                            Response response = chain.proceed(builder);
                            return response;
                        }
                    })
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .build();
        }
        return okHttpClient;
    }

    /**
     * get请求
     * 参数1 url
     * 参数2 回调Callback
     */

    public static void doGet(String url, Callback callback) {

        OkHttpClient okHttpClient = getOkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }

    /**
     * post请求
     * 参数1 url
     * 参数2 回调Callback
     */

    public static void doPost(String url, Map<String, String> params, Callback callback) {

        OkHttpClient okHttpClient = getOkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : params.keySet()) {
            builder.add(key, params.get(key));
        }
        Request request = new Request.Builder().url(url).post(builder.build()).build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);

    }

    public static String getMD5String(String source) {
        if (TextUtils.isEmpty(source)) {
            return "";
        }
        byte[] bytes = source.getBytes();
        MessageDigest messagedigest = null;
        try {
            messagedigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            // ignore
        }
        if (messagedigest == null) {
            return "";
        }
        messagedigest.update(bytes);
        String result = "";
        try {
            byte[] digest = messagedigest.digest();
            for (int i = 0; i < digest.length; i++) {
                result = result + byteHex(digest[i]);
            }
        } catch (Exception e) {
            return "";
        }
        return result;
    }

    public static String byteHex(byte ib) {
        char[] digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        char[] ob = new char[2];
        ob[0] = digit[(ib >>> 4) & 0X0F];
        ob[1] = digit[ib & 0X0F];
        return new String(ob);
    }

}
