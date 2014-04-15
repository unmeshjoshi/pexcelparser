package com.pubmatic.parser;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class SiteInfo {

    private final String siteName;
    private final String category;
    private final String description;
    private final String typeOfInventory;
    private final String transperancy;
    private final double uniqUsers;
    private final double clickThroughRate;
    private final String usTraffic;
    private final String caTraffic;
    private final String ukTraffic;
    private final String auTraffic;

    public SiteInfo(XSSFRow row) {
        siteName = row.getCell(1).getStringCellValue();
        category = row.getCell(2).getStringCellValue();
        description = row.getCell(3).getStringCellValue();
        typeOfInventory = row.getCell(4).getStringCellValue();
        transperancy = row.getCell(5).getStringCellValue();
        uniqUsers = numericValue(row.getCell(6));
        clickThroughRate = numericValue(row.getCell(7));
        usTraffic = row.getCell(8).getStringCellValue();
        caTraffic = row.getCell(9).getStringCellValue();
        ukTraffic = row.getCell(10).getStringCellValue();
        auTraffic = row.getCell(11).getStringCellValue();
    }

    private double numericValue(XSSFCell cell) {
        return cell.getCellType() == XSSFCell.CELL_TYPE_BLANK ? 0:cell.getNumericCellValue();
    }

    public boolean isEmpty() {
        return isEmpty(siteName) && isEmpty(this.category) && isEmpty(this.auTraffic)
                && isEmpty(description) && isEmpty(typeOfInventory) && uniqUsers == 0 && clickThroughRate == 0
                && isEmpty(usTraffic) && isEmpty(caTraffic) && isEmpty(ukTraffic) && isEmpty(auTraffic);

    }

    private boolean isEmpty(String value) {
        return "".equals(value);
    }

    public String getSiteName() {
        return siteName;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getTypeOfInventory() {
        return typeOfInventory;
    }

    public String getTransperancy() {
        return transperancy;
    }

    public double getUniqUsers() {
        return uniqUsers;
    }

    public double getClickThroughRate() {
        return clickThroughRate;
    }

    public String getUsTraffic() {
        return usTraffic;
    }

    public String getCaTraffic() {
        return caTraffic;
    }

    public String getUkTraffic() {
        return ukTraffic;
    }

    public String getAuTraffic() {
        return auTraffic;
    }
}
