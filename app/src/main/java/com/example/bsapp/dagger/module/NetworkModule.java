package com.example.bsapp.dagger.module;

import com.example.bsapp.dagger.NetworkUtils;
import dagger.Module;
import dagger.Provides;


@Module
public class NetworkModule {

    @Provides
    NetworkUtils provideNetworkUtils() {

        return new NetworkUtils();
    }

}
