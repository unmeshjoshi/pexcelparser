package com.pubmatic.parser;

import org.apache.poi.xssf.usermodel.XSSFSheet;

public class PlatformEngagement {
    private final XSSFSheet platformEngagement;
    private final Contact clientDevBizContact;
    private final Contact clientAdOpsContact;
    private final Contact clientTechContact;
    private final Contact clientBillingContact;
    private final Contact pubmaticSellsContact;
    private final Contact pubmaticAccountManager;
    private final Contact pubmaticTechAccountManager;

    private final String paymentTerms;
    private final String preferredPaymentCurrency;

    // No tables here. Its just rows directly.
    public PlatformEngagement(XSSFSheet platformEngagement) {
        this.platformEngagement = platformEngagement;
        clientDevBizContact = new Contact(platformEngagement.getRow(12));
        clientAdOpsContact = new Contact(platformEngagement.getRow(13));
        clientTechContact = new Contact(platformEngagement.getRow(14));
        clientBillingContact = new Contact(platformEngagement.getRow(15));
        pubmaticSellsContact = new Contact(platformEngagement.getRow(16));
        pubmaticAccountManager = new Contact(platformEngagement.getRow(17));
        pubmaticTechAccountManager = new Contact(platformEngagement.getRow(18));
        paymentTerms = platformEngagement.getRow(34).getCell(1).getStringCellValue();
        preferredPaymentCurrency = platformEngagement.getRow(35).getCell(1).getStringCellValue();
    }

    public XSSFSheet getPlatformEngagement() {
        return platformEngagement;
    }

    public Contact getClientDevBizContact() {
        return clientDevBizContact;
    }

    public Contact getClientAdOpsContact() {
        return clientAdOpsContact;
    }

    public Contact getClientTechContact() {
        return clientTechContact;
    }

    public Contact getClientBillingContact() {
        return clientBillingContact;
    }

    public Contact getPubmaticSellsContact() {
        return pubmaticSellsContact;
    }

    public Contact getPubmaticAccountManager() {
        return pubmaticAccountManager;
    }

    public Contact getPubmaticTechAccountManager() {
        return pubmaticTechAccountManager;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public String getPreferredPaymentCurrency() {
        return preferredPaymentCurrency;
    }
}
