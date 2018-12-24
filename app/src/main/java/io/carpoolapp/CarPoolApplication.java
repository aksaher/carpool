package io.carpoolapp;

import android.app.Application;
import android.content.Context;

import io.carpoolapp.network.APIClient;
import io.carpoolapp.network.WebServices;

/**
 * Created by akshay on 11-12-2018.
 */

public class CarPoolApplication extends Application {
    private static CarPoolApplication carPoolApplication;
    public static WebServices webServices;

    public static CarPoolApplication get() {
        return carPoolApplication;
    }

    public static void  initializeCarPoolApplication()
    {

    }

    public static Context getCarPoolApplication() {
        if (carPoolApplication == null) {
            carPoolApplication = new CarPoolApplication();
        }
        return carPoolApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        carPoolApplication = this;
        webServices = APIClient.getRetrofitClient().create(WebServices.class);
    }
}
