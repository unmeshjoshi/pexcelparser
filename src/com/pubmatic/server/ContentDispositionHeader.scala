package com.pubmatic.server

class ContentDispositionHeader(val contentDisposition:String) {

  def getFileName = {
      val partHeader = contentDisposition
      System.out.println("content-disposition = " + partHeader)

    val contentDispositionValues = contentDisposition.split(";")
    val filteredValues = contentDispositionValues.filter(content => content.trim.startsWith("file")).map(content=>content.substring(content.indexOf('=') + 1).replace("\"", ""))
    if (filteredValues.isEmpty) partHeader else filteredValues(0)
  }
}
