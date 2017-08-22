package com.thearch.halidewalls.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.thearch.halidewalls.internal.di.ActivityComponent;
import com.thearch.halidewalls.internal.di.DaggerActivityComponent;

public abstract class ActBase extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedState) {
    super.onCreate(savedState);

    injectComponent(DaggerActivityComponent.builder()
        .appComponent(((HubbleApplication) getApplication()).getAppComponent())
        .build());
  }

  /**
   * <p>
   * This method must be implemented
   * </p>
   * <code>component.inject(this)</code>
   *
   * @param component
   */
  protected abstract void injectComponent(ActivityComponent component);
}
