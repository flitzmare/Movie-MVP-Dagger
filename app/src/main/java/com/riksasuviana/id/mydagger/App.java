package com.riksasuviana.id.mydagger;

import android.app.Application;
import android.widget.Toast;

import com.riksasuviana.id.mydagger.data.component.DaggerNetComponent;
import com.riksasuviana.id.mydagger.data.component.NetComponent;
import com.riksasuviana.id.mydagger.data.module.AppModule;
import com.riksasuviana.id.mydagger.data.module.NetModule;
import com.riksasuviana.id.mydagger.util.MyConstant;

/**
 * Created by riksasuviana on 04/10/17.
 */

public class App extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
//                .netModule(new NetModule("http://jsonplaceholder.typicode.com/"))
                .netModule(new NetModule(MyConstant.BASE_URL))
                .build();

    }

    public NetComponent getNetComponent(){
        return mNetComponent;
    }
}
