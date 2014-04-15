package com.pubmatic.parser;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PublisherOnboardingExcelParser {
    private Onboarding onboarding;
    private PlatformEngagement platformEngagement;

    public void parse(FileInputStream onboardingExcel) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(onboardingExcel);
        this.platformEngagement = new PlatformEngagement(workbook.getSheet("Platform Engagement"));
        this.onboarding = new Onboarding(workbook.getSheet("Onboarding"));

        //TBD
        XSSFSheet yieldAndBrandControl = workbook.getSheet("Yield & Brand Control");
        XSSFSheet audiencePmpUIAndUOE = workbook.getSheet("Audience, PMP, UI & UOE");

    }
    public Onboarding getOnboardingDetails() {
        return onboarding;
    }

    public PlatformEngagement getPlatformEngagement() {
        return platformEngagement;
    }
}
