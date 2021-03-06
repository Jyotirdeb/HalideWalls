package com.thearch.halidewalls.base;

import android.os.Environment;

public class Constants {

  public static final String MODE_KEY = "current_mode";
  public static final String PARAM_TILE_KEY = "tile_param";
  public static final String PARAM_DETAILS_KEY = "details_param";
  public static final String ONBOARDING_SHOWN = "onboarding_shown";
  public static final int LOADED_MODE = 0;
  public static final int FAVORITES_MODE = 1;
  public static final int SEARCH_MODE = 2;

  public static String imageDirectory() {
    return Environment.getExternalStorageDirectory() + "/Pictures/Halide";
  }

}
