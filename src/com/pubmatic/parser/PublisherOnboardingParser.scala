package com.pubmatic.parser

import java.io.FileInputStream
import org.apache.poi.xssf.usermodel.{XSSFSheet, XSSFWorkbook}

class PublisherOnboardingParser {
  private var onboarding: Onboarding = null
  private var platformEngagement: PlatformEngagement = null

  def parse(onboardingExcel:FileInputStream) = {
    val workbook: XSSFWorkbook = new XSSFWorkbook(onboardingExcel)
    this.platformEngagement = new PlatformEngagement(workbook.getSheet("Platform Engagement"))
    this.onboarding = new Onboarding(workbook.getSheet("Onboarding"))

    //TBD
    val yieldAndBrandControl: XSSFSheet = workbook.getSheet("Yield & Brand Control")
    val audiencePmpUIAndUOE: XSSFSheet = workbook.getSheet("Audience, PMP, UI & UOE")
  }

  def getOnboardingDetails: Onboarding = {
    return onboarding
  }

  def getPlatformEngagement: PlatformEngagement = {
    return platformEngagement
  }
}
