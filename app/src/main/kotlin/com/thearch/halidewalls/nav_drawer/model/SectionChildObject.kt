package com.thearch.halidewalls.nav_drawer.model;

open class SectionChildObject {

  constructor() {
  }

  constructor(title: String, query: String) {
    this.sectionTitle = title
    this.query = query
  }

  var sectionTitle: String = ""
  var query: String = ""
}

