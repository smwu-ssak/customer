package com.example.seed.Network;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.example.seed.KakaoSDKAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kakao.auth.KakaoSDK;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Customized by SY

public class ApplicationController extends Application {

    private String baseUrl = "http://52.79.193.54:3000/";
    private static ApplicationController instance;
    private static ApplicationController getInstance() { return instance; }
    private NetworkService networkService;

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationController.instance = this;
        KakaoSDK.init(new KakaoSDKAdapter());
        buildNetworkService();
    }

    public NetworkService buildNetworkService() {
        synchronized (ApplicationController.class) {
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                    .create();
            GsonConverterFactory factory = GsonConverterFactory.create(gson);
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        networkService = retrofit.create(NetworkService.class);
        Log.d("networkService", String.valueOf(networkService));
        return networkService;
    }

    public NetworkService getNetworkService() { return networkService; }

    public static ApplicationController getApplicationController() {
        if(instance == null)
            throw new IllegalStateException("this application does not inherit com.kakao.ApplicationController");
        return instance;
    }
}
