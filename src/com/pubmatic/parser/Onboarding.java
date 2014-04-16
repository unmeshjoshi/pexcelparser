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
    public static final String MOBILE_HIGH_LEVEL_SITE_INFO = "[Mobile]_" + LIST_HIGH_LEVEL_SITE_INFO;
    public static final String VIDEO_HIGH_LEVEL_SITE_INFO = "[Video]_" + LIST_HIGH_LEVEL_SITE_INFO;
    DesktopApplications desktopApplications;
    MobileApplications mobileApplications;
    VideoApplications videoApplications;

    public Onboarding(XSSFSheet onboarding) {
        HighLevelSiteInfo deskTopHighLevelSiteInfo = null;
        ApplicationDetails desktopApplications = null;

        HighLevelSiteInfo mobileHighLevelSiteInfo = null;
        ApplicationDetails iosApplications = null;
        ApplicationDetails androidApplications = null;
        ApplicationDetails mobileWebApplications = null;
        ApplicationDetails tabletWebApplications = null;
        ApplicationDetails tabletApplications = null;

        HighLevelSiteInfo videoHighLevelSiteInfo = null;
        VideoDetails videoDetails = null;

        List<XSSFTable> tables = onboarding.getTables();
        for (XSSFTable table : tables) {
            CellReference startCellReference = table.getStartCellReference();
            String tableName = getTableName(onboarding, startCellReference);
            switch(tableName) {
                case DESKTOP_HIGH_LEVEL_SITE_INFO:
                    deskTopHighLevelSiteInfo = new HighLevelSiteInfo(table);
                    break;
                case "List full website details":
                    desktopApplications = new ApplicationDetails(table);
                    break;
                case MOBILE_HIGH_LEVEL_SITE_INFO:
                    mobileHighLevelSiteInfo = new HighLevelSiteInfo(table);
                    break;
                case "In-app (iOS)":
                    iosApplications = new ApplicationDetails(table);
                    break;
                case "In-app (Android)":
                    androidApplications = new ApplicationDetails(table);
                    break;
                case "Mobile web":
                    mobileWebApplications = new ApplicationDetails(table);
                    break;
                case "Tablet  web":
                    tabletWebApplications = new ApplicationDetails(table);
                    break;
                case "Tablet app":
                    tabletApplications = new ApplicationDetails(table);
                    break;
                case  VIDEO_HIGH_LEVEL_SITE_INFO:
                    videoHighLevelSiteInfo = new HighLevelSiteInfo(table);
                    break;
                case "Video":
                    videoDetails = new VideoDetails(table);
                    break;

            }

        }
        this.desktopApplications = new DesktopApplications(deskTopHighLevelSiteInfo, desktopApplications);
        this.mobileApplications = new MobileApplications(mobileHighLevelSiteInfo, iosApplications, androidApplications, mobileWebApplications, tabletWebApplications, tabletApplications);
        this.videoApplications = new VideoApplications(videoHighLevelSiteInfo, videoDetails);
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

    public MobileApplications getMobileApplications() {
        return mobileApplications;
    }

    public VideoApplications getVideoApplications() {
        return videoApplications;
    }
}

