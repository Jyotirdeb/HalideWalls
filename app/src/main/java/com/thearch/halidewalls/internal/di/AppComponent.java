package com.thearch.halidewalls.internal.di;

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;

import com.thearch.halidewalls.base.HubbleApplication;
import com.thearch.halidewalls.base.TinyDB;
import com.thearch.halidewalls.detailspage.DetailsPresenter;
import com.thearch.halidewalls.utils.FavoriteUtils;
import com.thearch.halidewalls.utils.network.NetworkUtil;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

  Context context();

  Resources resources();

  ConnectivityManager provideConnectivityManager();

  NetworkUtil provideNetworkUtil();

  TinyDB provideTinyDB();

  DetailsPresenter provideActDetailsPresenter();

  FavoriteUtils provideFavoriteUtils();

  Gson provideGson();

  void inject(HubbleApplication app);
}
