package com.pubmatic.parser;

import com.pubmatic.server.ContentDispositionHeader;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContentDispositionHeaderTest {
    @Test
    public void shouldGetFileName() {
        ContentDispositionHeader header = new ContentDispositionHeader("form-data; name=\"file\"; filename=\"test.xlsx\"");
        assertEquals("test.xlsx", header.getFileName());
    }
}
