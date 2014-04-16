package com.pubmatic.parser;

import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;

import java.util.ArrayList;
import java.util.List;

public class ApplicationDetails {
    List<AdDetails> adDetails = new ArrayList<AdDetails>();

    public ApplicationDetails(XSSFTable table) {
        XSSFSheet onboardingSheet = table.getXSSFSheet();
        CellReference startCellReference = table.getStartCellReference();
        CellReference endCellReference = table.getEndCellReference();
        for (int i = startCellReference.getRow() + 1; i < endCellReference.getRow(); i++) {
            XSSFRow row = onboardingSheet.getRow(i);
            AdDetails e = new AdDetails(row);
            if (!e.isEmpty()) {
                adDetails.add(e);
            }
        }
    }

    public List<AdDetails> getAdDetails() {
        return adDetails;
    }
}
