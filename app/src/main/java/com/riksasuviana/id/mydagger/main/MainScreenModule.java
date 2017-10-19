package com.riksasuviana.id.mydagger.main;

import com.riksasuviana.id.mydagger.util.CustomScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by riksasuviana on 04/10/17.
 */
@Module
public class MainScreenModule {
    private final MainScreenContract.View mView;

    public MainScreenModule(MainScreenContract.View mView){
        this.mView = mView;
    }

    @Provides
    @CustomScope
    MainScreenContract.View providesMainScreenContractView(){
        return mView;
    }
}
