package com.example.test.di

import android.app.Application
import android.content.Context
import com.example.test.TestApplication
import com.example.test.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    @ApplicationScope()
    internal fun provideApplication(application: Application): TestApplication = application as TestApplication

    @Provides
    @ApplicationScope
    internal fun provideContext(application: Application): Context = application


}