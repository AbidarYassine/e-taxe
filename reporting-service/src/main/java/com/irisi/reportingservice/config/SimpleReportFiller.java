package com.irisi.reportingservice.config;

import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRSaver;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class SimpleReportFiller {
    private String reportFileName;

    private JasperReport jasperReport;

    private JasperPrint jasperPrint;


    private Map<String, Object> parameters;

    public SimpleReportFiller() {
        parameters = new HashMap<>();
    }

    public void prepareReport() {
        compileReport();
    }

    public void compileReport() {
        try {
            InputStream reportStream = getClass().getResourceAsStream("/".concat(reportFileName));
            jasperReport = JasperCompileManager.compileReport(reportStream);
            JRSaver.saveObject(jasperReport, reportFileName.replace(".jrxml", ".jasper"));
        } catch (JRException ex) {
            log.info("error {}", ex);
        }
    }


    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public String getReportFileName() {
        return reportFileName;
    }

    public void setReportFileName(String reportFileName) {
        this.reportFileName = reportFileName;
    }

    public JasperPrint getJasperPrint() {
        return jasperPrint;
    }
}
