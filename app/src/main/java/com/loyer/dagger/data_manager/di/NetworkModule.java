package com.loyer.dagger.data_manager.di;

import android.content.Context;

import com.loyer.dagger.data_manager.NetworkService;
import com.loyer.dagger.data_manager.service.Service;
import com.loyer.dagger.data_manager.service.ServiceImpl;
import com.loyer.dagger.di.qualifiers.ApplicationContext;
import com.loyer.dagger.rx.interfaces.SchedulerProvider;
import com.loyer.dagger.rx.clazz.SchedulerProviderImpl;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by celikrecep on 7.06.2019.
 */
@Module
public class NetworkModule {
    private static final String BASE_URL = "base_url";
    private static final String TIMEOUT_MILLIS = "timeout_millis";
    private static final String TIMEOUT_UNIT = "timeout_unit";


    @Provides
    @Named(BASE_URL)
    String provideBaseUrl() {
        return "https://api.github.com";
    }

    @Provides
    @Named(TIMEOUT_MILLIS)
    long provideTimeOutMillis() {
        return 30000;
    }

    @Provides
    @Named(TIMEOUT_UNIT)
    TimeUnit provideTimeOutUnit() {
        return TimeUnit.MILLISECONDS;
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    @Singleton
    OkHttpClient provideHttpClient(
            HttpLoggingInterceptor httpInterceptor,
            @ApplicationContext Context context,
            @Named(TIMEOUT_MILLIS) long timeOutMillis,
            @Named(TIMEOUT_UNIT) TimeUnit timeOutUnit) {
        return new OkHttpClient.Builder()
                .addInterceptor(httpInterceptor)
                .readTimeout(timeOutMillis,timeOutUnit)
                .writeTimeout(timeOutMillis,timeOutUnit)
                .connectTimeout(timeOutMillis,timeOutUnit)
                .build();
    }

    @Provides
    @Singleton
    Converter.Factory provideGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    CallAdapter.Factory provideRxJavaAdapterFactory(SchedulerProvider schedulerProvider) {
        return RxJava2CallAdapterFactory.createWithScheduler(schedulerProvider.schedulerIO());
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(@Named(BASE_URL) String baseUrl, Converter.Factory converterFactory,
                             CallAdapter.Factory callAdapterFactory, OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(callAdapterFactory)
                .client(client)
                .build();
    }

    @Provides
    @Singleton
    NetworkService provideNetworkService(Retrofit retrofit) {
        return retrofit.create(NetworkService.class);
    }

    @Provides
    @Singleton
    SchedulerProvider provideSchedulerProvider(SchedulerProviderImpl schedulerProvider){
        return schedulerProvider;
    }


    @Provides
    @Singleton
    Service provideService(ServiceImpl service){
        return service;
    }
}
