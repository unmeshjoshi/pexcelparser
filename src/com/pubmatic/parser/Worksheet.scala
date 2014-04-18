package com.pubmatic.parser

import org.apache.poi.xssf.usermodel.{XSSFTable, XSSFSheet}
import scala.collection.JavaConversions._

class Worksheet(xssfWorkSheet: XSSFSheet, tables:List[XSSFTable]) {
  final val LIST_HIGH_LEVEL_SITE_INFO: String = "List high-level site info for PubMatic to create a media kit or provide one we can use in market"

  def this(xssfWorkSheet: XSSFSheet) = this(xssfWorkSheet, xssfWorkSheet.getTables().toList)

  def getTable(tableName: String): XSSFTable = {
    val table = tables.filter(getTableName(_).equals(tableName))
    if (!table.isEmpty()) table(0) else throw new IllegalArgumentException(tableName);
  }


  private def getTableName(table: XSSFTable): String = {
    val startCellReference = table.getStartCellReference();
    val tableNameRowIndex = (startCellReference.getRow() - 1);
    val tableNameRow = xssfWorkSheet.getRow(tableNameRowIndex);
    var tableName = tableNameRow.getCell(startCellReference.getCol()).getStringCellValue();
    if (tableName.contains(LIST_HIGH_LEVEL_SITE_INFO)) {
      val sectionNameRowIndex = (startCellReference.getRow() - 1) - 4;
      val row = xssfWorkSheet.getRow(sectionNameRowIndex);
      val cell = row.getCell(startCellReference.getCol());
      val sectionName = cell.getStringCellValue();
      tableName = sectionName + "_" + tableName;
    }
    tableName;
  }
}
