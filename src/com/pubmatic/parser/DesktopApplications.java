package com.pubmatic.parser;

public class DesktopApplications {
    HighLevelSiteInfo highLevelSiteInfo;
    WebsiteDetails websiteDetails;

    public DesktopApplications(HighLevelSiteInfo highLevelSiteInfo, WebsiteDetails websiteDetails) {

        this.highLevelSiteInfo = highLevelSiteInfo;
        this.websiteDetails = websiteDetails;
    }

    public HighLevelSiteInfo getHighLevelSiteInfo() {
        return highLevelSiteInfo;
    }

    public WebsiteDetails getWebsiteDetails() {
        return websiteDetails;
    }
}
