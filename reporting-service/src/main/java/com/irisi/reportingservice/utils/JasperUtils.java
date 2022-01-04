package com.irisi.reportingservice.utils;

import com.irisi.reportingservice.config.SimpleReportExporter;
import com.irisi.reportingservice.config.SimpleReportFiller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class JasperUtils {

    private final SimpleReportFiller simpleReportFiller;
    private final SimpleReportExporter simpleReportExporter;

    public void generate() {
        simpleReportFiller.setReportFileName("test.jrxml");
        simpleReportFiller.compileReport();
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("title", "Employee Report Example");
        parameters.put("minSalary", 15000.0);
        parameters.put("condition", " LAST_NAME ='Smith' ORDER BY FIRST_NAME");

        simpleReportFiller.setParameters(parameters);
//        simpleReportFiller.fillReport();

//        simpleReportExporter.exportToPdf("test.pdf", "baeldung");
//        simpleReportExporter.exportToXlsx("employeeReport.xlsx", "Employee Data");
//        simpleReportExporter.exportToCsv("employeeReport.csv");
        simpleReportExporter.exportToHtml("employeeReport.html");
    }

}
