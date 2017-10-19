package com.riksasuviana.id.mydagger.main;

import com.riksasuviana.id.mydagger.data.component.NetComponent;
import com.riksasuviana.id.mydagger.util.CustomScope;

import dagger.Component;

/**
 * Created by riksasuviana on 04/10/17.
 */
@CustomScope
@Component(dependencies = NetComponent.class, modules = MainScreenModule.class)
public interface MainScreenComponent {
    void inject(MainActivity activity);
}