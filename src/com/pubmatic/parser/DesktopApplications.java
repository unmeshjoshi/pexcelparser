package com.pubmatic.parser;

public class DesktopApplications {
    HighLevelSiteInfo highLevelSiteInfo;
    ApplicationDetails applicationDetails;

    public DesktopApplications(HighLevelSiteInfo highLevelSiteInfo, ApplicationDetails applicationDetails) {

        this.highLevelSiteInfo = highLevelSiteInfo;
        this.applicationDetails = applicationDetails;
    }

    public HighLevelSiteInfo getHighLevelSiteInfo() {
        return highLevelSiteInfo;
    }

    public ApplicationDetails getApplicationDetails() {
        return applicationDetails;
    }
}
