package com.pubmatic.parser;

public class MobileApplications {
    HighLevelSiteInfo mobileHighLevelSiteInfo;
    ApplicationDetails iosApplications;
    ApplicationDetails androidApplications;
    ApplicationDetails mobileWebApplications;
    ApplicationDetails tabletWebApplications;
    ApplicationDetails tabletApplications;

    public MobileApplications(HighLevelSiteInfo mobileHighLevelSiteInfo, ApplicationDetails iosApplications, ApplicationDetails androidApplications, ApplicationDetails mobileWebApplications, ApplicationDetails tabletWebApplications, ApplicationDetails tabletApplications) {
        this.mobileHighLevelSiteInfo = mobileHighLevelSiteInfo;
        this.iosApplications = iosApplications;
        this.androidApplications = androidApplications;
        this.mobileWebApplications = mobileWebApplications;
        this.tabletWebApplications = tabletWebApplications;
        this.tabletApplications = tabletApplications;
    }

    public HighLevelSiteInfo getMobileHighLevelSiteInfo() {
        return mobileHighLevelSiteInfo;
    }

    public ApplicationDetails getIosApplications() {
        return iosApplications;
    }

    public ApplicationDetails getAndroidApplications() {
        return androidApplications;
    }

    public ApplicationDetails getMobileWebApplications() {
        return mobileWebApplications;
    }

    public ApplicationDetails getTabletWebApplications() {
        return tabletWebApplications;
    }

    public ApplicationDetails getTabletApplications() {
        return tabletApplications;
    }
}
