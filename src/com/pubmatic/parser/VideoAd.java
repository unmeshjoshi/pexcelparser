package com.pubmatic.parser;

import org.apache.poi.xssf.usermodel.XSSFRow;

public class VideoAd {
    String videoAdType;
    String videoMaxLength;
    String montlyImpressionsTotal;
    String montlyImpressionsToPubmatic;
    String accompanyingAdSizes;

    public VideoAd(XSSFRow row) {
        videoAdType = row.getCell(1).getStringCellValue();
        videoMaxLength = row.getCell(2).getStringCellValue();
        montlyImpressionsTotal = row.getCell(3).getStringCellValue();
        montlyImpressionsToPubmatic = row.getCell(4).getStringCellValue();
        accompanyingAdSizes = row.getCell(5).getStringCellValue();
    }

    public String getVideoAdType() {
        return videoAdType;
    }

    public String getVideoMaxLength() {
        return videoMaxLength;
    }

    public String getMontlyImpressionsTotal() {
        return montlyImpressionsTotal;
    }

    public String getMontlyImpressionsToPubmatic() {
        return montlyImpressionsToPubmatic;
    }

    public String getAccompanyingAdSizes() {
        return accompanyingAdSizes;
    }

    public boolean isEmpty() {
        return isEmpty(videoAdType) && isEmpty(videoMaxLength) && isEmpty(montlyImpressionsTotal)
                && isEmpty(montlyImpressionsToPubmatic)
                && isEmpty(accompanyingAdSizes);
    }
    private boolean isEmpty(String value) {
        return "".equals(value);
    }

}
