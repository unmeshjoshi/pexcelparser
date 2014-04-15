package com.pubmatic.parser;

import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;

import java.util.List;

public class Onboarding {
    public static final String LIST_HIGH_LEVEL_SITE_INFO = "List high-level site info for PubMatic to create a media kit or provide one we can use in market";
    public static final String DESKTOP_HIGH_LEVEL_SITE_INFO = "[Desktop]_" + LIST_HIGH_LEVEL_SITE_INFO;
    DesktopApplications desktopApplications;

    public Onboarding(XSSFSheet onboarding) {
        HighLevelSiteInfo highLevelSiteInfo = null;
        WebsiteDetails websiteDetails = null;
        List<XSSFTable> tables = onboarding.getTables();
        for (XSSFTable table : tables) {
            CellReference startCellReference = table.getStartCellReference();
            String tableName = getTableName(onboarding, startCellReference);
            if (DESKTOP_HIGH_LEVEL_SITE_INFO.equals(tableName)) {
                highLevelSiteInfo = new HighLevelSiteInfo(table);
            } else if ("List full website details".equals(tableName)) {
                websiteDetails = new WebsiteDetails(table);
            }
        }
        desktopApplications = new DesktopApplications(highLevelSiteInfo, websiteDetails);
    }


    private String getTableName(XSSFSheet onboarding, CellReference startCellReference) {
        int tableNameRowIndex = (startCellReference.getRow() - 1);
        XSSFRow tableNameRow = onboarding.getRow(tableNameRowIndex);
        String tableName = tableNameRow.getCell(startCellReference.getCol()).getStringCellValue();
        if (tableName.contains(LIST_HIGH_LEVEL_SITE_INFO)) {
            int sectionNameRowIndex = (startCellReference.getRow() - 1) - 4;
            XSSFRow row = onboarding.getRow(sectionNameRowIndex);
            XSSFCell cell = row.getCell(startCellReference.getCol());
            String sectionName = cell.getStringCellValue();
            tableName = sectionName + "_" + tableName;
        }
        return tableName;
    }

    public DesktopApplications getDesktopApplications() {
        return desktopApplications;
    }
}

