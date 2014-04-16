package com.pubmatic.parser;

import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;

import java.util.ArrayList;
import java.util.List;

public class VideoDetails {
    List<VideoAd> videoAds = new ArrayList<>();

    public VideoDetails(XSSFTable table) {
        XSSFSheet onboardingSheet = table.getXSSFSheet();
        CellReference startCellReference = table.getStartCellReference();
        CellReference endCellReference = table.getEndCellReference();
        for (int i = startCellReference.getRow() + 1; i < endCellReference.getRow(); i++) {
            XSSFRow row = onboardingSheet.getRow(i);
            VideoAd e = new VideoAd(row);
            if (!e.isEmpty()) {
                videoAds.add(e);
            }
        }
    }
}
