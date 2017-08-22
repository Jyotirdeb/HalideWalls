package com.thearch.halidewalls.nav_drawer.presenters

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.bignerdranch.expandablerecyclerview.Model.ParentListItem
import com.thearch.halidewalls.nav_drawer.adapters.NavDrawerAdapter
import com.thearch.halidewalls.nav_drawer.adapters.NavigationAdapterItem
import com.thearch.halidewalls.nav_drawer.model.SectionChildObject
import com.thearch.halidewalls.nav_drawer.views.NavigationView
import java.util.*

class NavigationPresenter constructor(view: NavigationView, context: Context) :
    NavDrawerAdapter.NavAdapterListener {

  final val TAG = "NavigationPresenter"
  var view: NavigationView
  var context: Context
  var mAdapter: NavDrawerAdapter? = null

  val KEY_SELECTED_QUERY = "selected_query"

  init {
    this.view = view
    this.context = context
  }

  fun restoreState(savedState: Bundle?) {
    if (savedState == null)
      return

    if (savedState.containsKey(KEY_SELECTED_QUERY))
      mAdapter!!.setSelectedQuery(savedState.getString(KEY_SELECTED_QUERY))
  }

  fun getSelectedQuery(): String? {
    return mAdapter!!.getSelectedQuery()
  }

  fun populateAdapter() {
    var drawerItems = ArrayList<ParentListItem>()

    drawerItems.add(NavigationAdapterItem(SectionChildObject("Entire Collection", "entire"),
        NavigationAdapterItem.STANDALONE_SECTION, null))

    drawerItems.add(NavigationAdapterItem(SectionChildObject("Hubble Heritage", "halide-heritage"),
        NavigationAdapterItem.STANDALONE_SECTION, null))

    /**
     * the universe
     */
    var universeItems = ArrayList<SectionChildObject>()
    universeItems.add(createChildObject("Distant Galaxies", "distant-galaxies/distant-galaxies-1"))
    universeItems.add(createChildObject("Intergalactic Gas", "distant-galaxies/intergalactic-gas"))
    universeItems.add(createChildObject("Deep Survey", "distant-galaxies/deep-survey"))

    drawerItems.add(NavigationAdapterItem(SectionChildObject("The Universe", "distant-galaxies"),
        NavigationAdapterItem.GROUP, universeItems))

    /**
     * exotic
     */
    var exoticItems = ArrayList<SectionChildObject>()
    exoticItems.add(createChildObject("Dark Matters", "exotic/dark-matters"))
    exoticItems.add(createChildObject("Beauty", "exotic/beauty"))
    exoticItems.add(createChildObject("Scenery", "exotic/scenery"))

    drawerItems.add(NavigationAdapterItem(SectionChildObject("Exotic", "exotic"),
        NavigationAdapterItem.GROUP, exoticItems))

    /**
     * galaxies
     */
    var galaxyItems = ArrayList<SectionChildObject>()
    galaxyItems.add(createChildObject("Abstract", "vector/abstract"))
    galaxyItems.add(createChildObject("Portraits", "vector/portraits"))

    drawerItems.add(NavigationAdapterItem(SectionChildObject("Vector", "vector"),
        NavigationAdapterItem.GROUP, galaxyItems))

    /**
     * nebulae
     */
    var nebulaItems = ArrayList<SectionChildObject>()
    nebulaItems.add(createChildObject("Portraits", "hd-walls/portraits-1"))
    nebulaItems.add(createChildObject("Landscapes", "hd-walls/landscapes"))

    drawerItems.add(NavigationAdapterItem(SectionChildObject("HD Walls", "hd-walls"),
        NavigationAdapterItem.GROUP, nebulaItems))

    /**
     * solar system
     */
    var solarSystemItems = ArrayList<SectionChildObject>()
    solarSystemItems.add(createChildObject("Exploration", "urban/exploration"))
    solarSystemItems.add(createChildObject("People", "urban/people"))
    solarSystemItems.add(createChildObject("City and architecture", "urban/city-and-architecture"))

    drawerItems.add(NavigationAdapterItem(SectionChildObject("Urban", "urban"),
        NavigationAdapterItem.GROUP, solarSystemItems))

    /**
     * stars
     */
    var starItems = ArrayList<SectionChildObject>()
    starItems.add(createChildObject("Abstract", "exploration-1/abstract-1"))
    starItems.add(createChildObject("Classified", "exploration-1/classified"))

    drawerItems.add(NavigationAdapterItem(SectionChildObject("Exploration", "exploration-1"),
        NavigationAdapterItem.GROUP, starItems))


    mAdapter = NavDrawerAdapter(context, drawerItems, this)

    view.recycler.layoutManager = LinearLayoutManager(context)
    view.recycler.adapter = mAdapter
  }

  private fun createChildObject(title: String, query: String): SectionChildObject {
    return SectionChildObject(title, query)
  }

  override fun onSectionClicked(section: SectionChildObject) {
    view.selectSection(section)
  }

  override fun setSelectedQuery(query: String) {
    mAdapter!!.setSelectedQuery(query)
  }
}
