package com.thearch.halidewalls.detailspage;

import android.content.Intent;
import android.widget.ImageView;

import com.thearch.halidewalls._shared.model.DetailsObject;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;

public interface DetailsContract {

  void showLoadingAnimation(boolean show, int type);

  void populateDetails(DetailsObject detailsObject);

  void showZeroState(boolean show);

  void generatePalette();

  void openActivityIntent(Intent intent);

  void openImageViewer();

  ImageView getIvDisplay();

  ObservableScrollView getScrollView();

  void updateMenu();
}
