package com.pubmatic.parser;

import com.google.gson.Gson;
import org.apache.poi.hssf.eventmodel.ERFListener;
import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
import org.apache.poi.hssf.record.ObjRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.SubRecord;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PublisherOnboardingFormPOIBasedParserTest {

    private static PublisherOnboardingParser parser;

    @BeforeClass
    public static void readPubmaticExcel() throws Exception {
        parser = new PublisherOnboardingParser();
        parser.parse(new FileInputStream("./test.xlsx"));
    }

    @Test
    public void shouldParseOnboardingTablesForDesktop() throws IOException {
        Onboarding onboarding = parser.getOnboardingDetails();
        DesktopApplications desktopApplications = onboarding.getDesktopApplications();
        assertNotNull(desktopApplications);
        assertNotNull(desktopApplications.getHighLevelSiteInfo());
        assertEquals(1, desktopApplications.getHighLevelSiteInfo().getSites().size());
        assertNotNull(desktopApplications.getApplicationDetails());
    }

    @Test
    public void shouldParseOnboardingTablesForMobile() throws IOException {
        Onboarding onboarding = parser.getOnboardingDetails();
        MobileApplications mobileApplications = onboarding.getMobileApplications();
        assertNotNull(mobileApplications);
        assertNotNull(mobileApplications.getMobileHighLevelSiteInfo());
        assertEquals(1, mobileApplications.getMobileHighLevelSiteInfo().getSites().size());
        assertNotNull(mobileApplications.getAndroidApplications());
        assertNotNull(mobileApplications.getIosApplications());
        assertNotNull(mobileApplications.getMobileWebApplications());
        assertNotNull(mobileApplications.getTabletApplications());
        assertNotNull(mobileApplications.getTabletWebApplications());
    }

    @Test
    public void shouldParseOnboardingTablesForVideo() throws IOException {
        Onboarding onboarding = parser.getOnboardingDetails();
        VideoApplications videoApplications = onboarding.getVideoApplications();
        assertNotNull(videoApplications);
        assertNotNull(videoApplications.getVideoHighLevelSiteInfo());
        assertEquals(1, videoApplications.getVideoHighLevelSiteInfo().getSites().size());
        assertNotNull(videoApplications.getVideoDetails());
    }

    @Test
    public void shouldParsePlatformEngagement() throws Exception {
        PlatformEngagement engagement = parser.getPlatformEngagement();
        assertNotNull(engagement.getClientAdOpsContact());
    }


    @Test
    @Ignore //XSSF doesnt support this. HSSF probably does, but its not useful.
    public void shouldParseFormControlsFromXlsx() throws Exception {
        FileInputStream is = new FileInputStream("/home/unmesh/work/pubmatic/test/com/pubmatic/parser/PubMatic Publisher OnBoarding Form.xlsx");
        POIFSFileSystem poifs = new POIFSFileSystem(is);
    }

}

class EventListener implements ERFListener {

    @Override
    public boolean processRecord(Record record) {
        switch (record.getSid()) {
            case ObjRecord.sid:
                ObjRecord objRecord = (ObjRecord) record;
                List<SubRecord> subRecords = objRecord.getSubRecords();
                for (SubRecord subRecord : subRecords) {
                    if (subRecord instanceof CommonObjectDataSubRecord) {
                        CommonObjectDataSubRecord objectDataSubRecord = (CommonObjectDataSubRecord) subRecord;
                        if (objectDataSubRecord.getObjectType() == CommonObjectDataSubRecord.OBJECT_TYPE_OPTION_BUTTON) {
                            System.out.println("objectDataSubRecord = " + objectDataSubRecord);
                        }
                    }
                }
                break;
        }
        return false;
    }
}