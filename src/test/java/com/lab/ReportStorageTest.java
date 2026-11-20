package com.lab;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReportStorageTest {

    private final ReportStorage storage = new ReportStorage();

    @Test
    void hardcodedWindowsSeparator() {
        Path path = storage.reportFile("reports", "monthly");
        assertEquals("reports\\monthly.csv", path.toString());
    }

    @Test
    void keepsExistingCsvExtension() {
        Path path = storage.reportFile("reports", "monthly.csv");
        assertEquals("reports\\monthly.csv", path.toString());
    }

    @Test
    void rejectsBlankDirectory() {
        assertThrows(IllegalArgumentException.class, () -> storage.reportFile("  ", "monthly"));
    }

    @Test
    void rejectsNullDirectory() {
        assertThrows(IllegalArgumentException.class, () -> storage.reportFile(null, "monthly"));
    }

    @Test
    void rejectsBlankReportName() {
        assertThrows(IllegalArgumentException.class, () -> storage.reportFile("reports", ""));
    }

    @Test
    void rejectsNullReportName() {
        assertThrows(IllegalArgumentException.class, () -> storage.reportFile("reports", null));
    }
}
