package com.riksasuviana.id.mydagger.data.component;

import com.riksasuviana.id.mydagger.data.module.AppModule;
import com.riksasuviana.id.mydagger.data.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by riksasuviana on 04/10/17.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    Retrofit retrofit();
}
