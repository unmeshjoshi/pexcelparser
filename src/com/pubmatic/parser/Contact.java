package com.pubmatic.parser;

import org.apache.poi.xssf.usermodel.XSSFRow;

public class Contact {
    String name;
    String email;
    String phone;
    String fax;
    String skype;
    public Contact(XSSFRow row) {
        name = stringValue(row, 1);
        email = stringValue(row, 2);
        phone = stringValue(row, 3);
        fax = stringValue(row, 4);
        skype = stringValue(row, 5);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

    public String getSkype() {
        return skype;
    }

    private String stringValue(XSSFRow row, int cellnum) {
        return row.getCell(cellnum).getStringCellValue();
    }
}
