package com.example.bsapp.dagger.app;

import com.example.bsapp.dagger.NetworkUtils;
import com.example.bsapp.dagger.module.NetworkModule;
import com.example.bsapp.dagger.module.StorageModule;
import com.example.bsapp.dagger.storage.DatabaseHelper;
import com.example.bsapp.ui.fragment.HomeFragment;
import dagger.Component;

@Component(modules = {StorageModule.class, NetworkModule.class})
public interface AppComponent {
    void injectHomeFragment(HomeFragment homeFragment);
}

