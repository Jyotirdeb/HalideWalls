package com.thearch.halidewalls.internal.di;

import com.thearch.halidewalls.base.ActBase;
import com.thearch.halidewalls.base.FragBase;
import com.thearch.halidewalls.detailspage.DetailsActivity;
import com.thearch.halidewalls.home.ActHome;
import com.thearch.halidewalls.imageviewer.ImageViewerActivity;
import com.thearch.halidewalls.ui.activities.ActWelcome;

import dagger.Component;

/**
 * This component injects Activities and Fragments
 */

@ActivityScope
@Component(dependencies = {AppComponent.class})
public interface ActivityComponent {

  void inject(ActBase app);

  void inject(DetailsActivity app);

  void inject(ActHome app);

  void inject(ImageViewerActivity app);

  void inject(ActWelcome app);

  void inject(FragBase app);
}
