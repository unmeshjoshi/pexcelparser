package com.pubmatic.parser;

import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;

import java.util.ArrayList;
import java.util.List;

public class HighLevelSiteInfo {
    List<SiteInfo> siteInfos = new ArrayList<SiteInfo>();

    public HighLevelSiteInfo(XSSFTable table) {
        XSSFSheet onboardingSheet = table.getXSSFSheet();
        CellReference startCellReference = table.getStartCellReference();
        CellReference endCellReference = table.getEndCellReference();
        for (int i = startCellReference.getRow() + 1; i < endCellReference.getRow(); i++) {
            XSSFRow row = onboardingSheet.getRow(i);
            SiteInfo e = new SiteInfo(row);
            if (!e.isEmpty()) {
                siteInfos.add(e);
            }
        }
    }

    public List<SiteInfo> getSites() {
        return siteInfos;
    }
}
