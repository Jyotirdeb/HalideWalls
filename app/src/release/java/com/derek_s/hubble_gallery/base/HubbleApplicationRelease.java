package com.thearch.halidewalls.base;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

public class HubbleApplicationRelease extends HubbleApplication {

  @Override
  public void onCreate() {
    super.onCreate();
    Fabric.with(this, new Crashlytics());
  }

}
