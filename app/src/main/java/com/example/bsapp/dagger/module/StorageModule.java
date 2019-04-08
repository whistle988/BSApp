package com.example.bsapp.dagger.module;

import com.example.bsapp.dagger.storage.DatabaseHelper;
import dagger.Module;
import dagger.Provides;

@Module
public class StorageModule {
    @Provides
    DatabaseHelper provideDatabaseHelper() {
        return new DatabaseHelper();
    }
}
