package com.example.test.di

import android.app.Application
import com.example.test.TestApplication
import com.example.test.data.DataModule
import com.example.test.di.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuilder::class,
        DataModule::class
    ]
)
@ApplicationScope
interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(testApplication: TestApplication)

    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}