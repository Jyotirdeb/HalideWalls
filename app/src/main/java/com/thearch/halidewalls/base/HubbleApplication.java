package com.thearch.halidewalls.base;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.thearch.halidewalls.internal.di.AppComponent;
import com.thearch.halidewalls.internal.di.AppModule;
import com.thearch.halidewalls.internal.di.DaggerAppComponent;

import io.fabric.sdk.android.Fabric;

public class HubbleApplication extends Application {

  private AppComponent appComponent;

  @Override
  public void onCreate() {
    super.onCreate();
    Fabric.with(this, new Crashlytics());
    this.initializeInjector();
  }

  private void initializeInjector() {
    this.appComponent = DaggerAppComponent
        .builder()
        .appModule(new AppModule(this))
        .build();

    this.appComponent.inject(this);
  }

  public AppComponent getAppComponent() {
    return appComponent;
  }
}
