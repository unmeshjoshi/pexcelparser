package com.pubmatic.parser;

import org.apache.poi.xssf.usermodel.XSSFRow;

public class AdDetails {

    private final String siteName;
    private final String atfAdSize;
    private final String atfMonthlyImpressionTotal;
    private final String atfMonthlyImpressionsToPubmatic;
    private final String btfAdSize;
    private final String btfMontlyImpressionsTotal;
    private final String btfMontlyIMpressionsToPubmatic;

    public AdDetails(XSSFRow row) {
        siteName = row.getCell(1).getStringCellValue();
        atfAdSize = row.getCell(2).getStringCellValue();
        atfMonthlyImpressionTotal = row.getCell(3).getStringCellValue();
        atfMonthlyImpressionsToPubmatic = row.getCell(4).getStringCellValue();
        btfAdSize = row.getCell(5).getStringCellValue();
        btfMontlyImpressionsTotal = row.getCell(6).getStringCellValue();
        btfMontlyIMpressionsToPubmatic = row.getCell(7).getStringCellValue();
    }

    public boolean isEmpty() {
        return isEmpty(siteName) && isEmpty(atfAdSize) && isEmpty(atfMonthlyImpressionTotal)
                && isEmpty(atfMonthlyImpressionsToPubmatic) && isEmpty(btfAdSize)
                && isEmpty(btfMontlyImpressionsTotal) && isEmpty(btfMontlyIMpressionsToPubmatic);
    }

    private boolean isEmpty(String value) {
        return "".equals(value);
    }

    public String getSiteName() {
        return siteName;
    }

    public String getAtfAdSize() {
        return atfAdSize;
    }

    public String getAtfMonthlyImpressionTotal() {
        return atfMonthlyImpressionTotal;
    }

    public String getAtfMonthlyImpressionsToPubmatic() {
        return atfMonthlyImpressionsToPubmatic;
    }

    public String getBtfAdSize() {
        return btfAdSize;
    }

    public String getBtfMontlyImpressionsTotal() {
        return btfMontlyImpressionsTotal;
    }

    public String getBtfMontlyIMpressionsToPubmatic() {
        return btfMontlyIMpressionsToPubmatic;
    }
}
