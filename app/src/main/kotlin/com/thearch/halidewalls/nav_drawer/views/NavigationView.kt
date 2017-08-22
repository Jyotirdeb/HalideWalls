package com.thearch.halidewalls.nav_drawer.views

import android.support.v7.widget.RecyclerView
import com.thearch.halidewalls.nav_drawer.model.SectionChildObject

interface NavigationView {
  val recycler: RecyclerView
    get

  fun selectSection(section: SectionChildObject) {
  }

  fun deselectFavorites() {
  }
}