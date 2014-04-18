package com.pubmatic.parser;

import org.apache.poi.xssf.usermodel.XSSFSheet;

public class Onboarding {
    public static final String LIST_HIGH_LEVEL_SITE_INFO = "List high-level site info for PubMatic to create a media kit or provide one we can use in market";
    public static final String DESKTOP_HIGH_LEVEL_SITE_INFO = "[Desktop]_" + LIST_HIGH_LEVEL_SITE_INFO;
    public static final String MOBILE_HIGH_LEVEL_SITE_INFO = "[Mobile]_" + LIST_HIGH_LEVEL_SITE_INFO;
    public static final String VIDEO_HIGH_LEVEL_SITE_INFO = "[Video]_" + LIST_HIGH_LEVEL_SITE_INFO;
    DesktopApplications desktopApplications;
    MobileApplications mobileApplications;
    VideoApplications videoApplications;

    public Onboarding(XSSFSheet onboarding) {
        parse(onboarding);
    }

    private void parse(XSSFSheet onboarding) {
        Worksheet worksheet = new Worksheet(onboarding);
        ApplicationDetails desktopApplications = new ApplicationDetails(worksheet.getTable("List full website details"));
        HighLevelSiteInfo mobileHighLevelSiteInfo  = new HighLevelSiteInfo(worksheet.getTable(MOBILE_HIGH_LEVEL_SITE_INFO));
        ApplicationDetails iosApplications = new ApplicationDetails(worksheet.getTable("In-app (iOS)"));
        ApplicationDetails androidApplications = new ApplicationDetails(worksheet.getTable("In-app (Android)"));
        ApplicationDetails mobileWebApplications = new ApplicationDetails(worksheet.getTable("Mobile web"));
        ApplicationDetails tabletWebApplications  = new ApplicationDetails(worksheet.getTable("Tablet  web"));
        ApplicationDetails tabletApplications = new ApplicationDetails(worksheet.getTable("Tablet app"));
        HighLevelSiteInfo videoHighLevelSiteInfo = new HighLevelSiteInfo(worksheet.getTable(VIDEO_HIGH_LEVEL_SITE_INFO));
        VideoDetails videoDetails = new VideoDetails(worksheet.getTable("Video"));

        this.desktopApplications = new DesktopApplications(new HighLevelSiteInfo(worksheet.getTable(DESKTOP_HIGH_LEVEL_SITE_INFO)), desktopApplications);
        this.mobileApplications = new MobileApplications(mobileHighLevelSiteInfo, iosApplications, androidApplications, mobileWebApplications, tabletWebApplications, tabletApplications);
        this.videoApplications = new VideoApplications(videoHighLevelSiteInfo, videoDetails);
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

