package com.irisi.reportingservice.consumer;

import com.google.gson.Gson;
import com.irisi.reportingservice.pojo.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.*;

@Component
@Slf4j
@RequiredArgsConstructor
public class ConsumerMessage {
    private final Gson jsonConverter;
    final Random random = new Random();

    @KafkaListener(topics = "myTopic")
    public void getFromKafka(String data) {
        MessageKafka taxeSejourTrimPojo = jsonConverter.fromJson(data, MessageKafka.class);
        log.info("taxe sejour {} ", taxeSejourTrimPojo);
//         sendEmail
    }

    private List<Employee> getAll() {
        final List<Employee> employees = new ArrayList<>();
        // Creating a list of employees using the "faker" object.
        for (int count = 0; count < 21; count++) {
            employees.add(new Employee(random.nextInt(30 + 1), "yassine",
                    "title", "ing"));
        }
        return employees;
    }

    private void createPdfReport(List<Employee> employees) throws JRException {
        // Fetching the .jrxml file from the resources folder.
        final InputStream stream = this.getClass().getResourceAsStream("/test.jrxml");

        // Compile the Jasper report from .jrxml to .japser
        final JasperReport report = JasperCompileManager.compileReport(stream);

        // Fetching the employees from the data source.
        final JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(employees);

        // Adding the additional parameters to the pdf.
        final Map<String, Object> parameters = new HashMap<>();

        // Filling the report with the employee data and additional parameters information.
        final JasperPrint print = JasperFillManager.fillReport(report, parameters, source);

        // Users can change as per their project requrirements or can take it as request input requirement.
        // For simplicity, this tutorial will automatically place the file under the "c:" drive.
        // If users want to download the pdf file on the browser, then they need to use the "Content-Disposition" technique.
        final String filePath = "\\report";
        // Export the report to a PDF file.
        log.info("last step to generate ...");
        JasperExportManager.exportReportToPdfFile(print, filePath + "Employee_report.pdf");
    }


}
