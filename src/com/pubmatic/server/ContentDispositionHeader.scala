package com.pubmatic.server

class ContentDispositionHeader(val value: String) {

  def getFileName = {
    val contentDispositionValues = value.split(";")
    val filteredValues = contentDispositionValues.filter(content => content.trim.startsWith("file")).map(content => content.substring(content.indexOf('=') + 1).replace("\"", ""))
    if (filteredValues.isEmpty) value else filteredValues(0)
  }
}