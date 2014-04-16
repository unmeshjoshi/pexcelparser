package com.pubmatic.parser;

public class VideoApplications {
    HighLevelSiteInfo videoHighLevelSiteInfo;
    VideoDetails videoDetails;

    public VideoApplications(HighLevelSiteInfo videoHighLevelSiteInfo, VideoDetails videoDetails) {
        this.videoHighLevelSiteInfo = videoHighLevelSiteInfo;
        this.videoDetails = videoDetails;
    }

    public HighLevelSiteInfo getVideoHighLevelSiteInfo() {
        return videoHighLevelSiteInfo;
    }

    public VideoDetails getVideoDetails() {
        return videoDetails;
    }
}
