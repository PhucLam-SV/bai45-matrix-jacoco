package com.lab;

import java.io.File;
import java.nio.file.Path;

public class ReportStorage {

    public Path reportFile(String directory, String reportName) {
        if (directory == null || directory.isBlank()) {
            throw new IllegalArgumentException("Directory is required");
        }
        if (reportName == null || reportName.isBlank()) {
            throw new IllegalArgumentException("Report name is required");
        }
        String fileName = reportName.endsWith(".csv") ? reportName : reportName + ".csv";
        return Path.of(directory + File.separator + fileName);
    }
}
