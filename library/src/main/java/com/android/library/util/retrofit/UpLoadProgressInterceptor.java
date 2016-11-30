package com.android.library.util.retrofit;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Author:  ljo_h
 * Date:    2016/7/16
 * Description:
 */
public class UpLoadProgressInterceptor implements Interceptor {
    private CountingRequestBody.Listener progressListener;

    public UpLoadProgressInterceptor(CountingRequestBody.Listener progressListener) {
        this.progressListener = progressListener;
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request originalRequest = chain.request();

        if (originalRequest.body() == null) {
            return chain.proceed(originalRequest);
        }

        Request progressRequest = originalRequest.newBuilder()
                .method(originalRequest.method(),
                        new CountingRequestBody(originalRequest.body(), progressListener))
                .build();

        return chain.proceed(progressRequest);
    }
}
