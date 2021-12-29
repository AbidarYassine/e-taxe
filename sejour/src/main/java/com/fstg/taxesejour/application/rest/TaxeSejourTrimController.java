package com.fstg.taxesejour.application.rest;

import com.fstg.taxesejour.application.config.SendMessage;
import com.fstg.taxesejour.application.dto.TaxeSejourTrimDto;
import com.fstg.taxesejour.application.dto.TaxeSejourTrimDtoResponse;
import com.fstg.taxesejour.application.rest.api.TaxeSejourTrimApi;
import com.fstg.taxesejour.domaine.core.Result;
import com.fstg.taxesejour.domaine.pojo.TaxeSejourTrimPojo;
import com.fstg.taxesejour.domaine.process.taxeSejourTrim.create.CreateTaxeTrimProcess;
import com.fstg.taxesejour.infrastructure.dao.facade.TaxeSejourTrimInfra;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TaxeSejourTrimController implements TaxeSejourTrimApi {


    private final CreateTaxeTrimProcess createTaxeTrimProcess;
    private final TaxeSejourTrimInfra taxeSejourTrimInfra;
    private final ModelMapper modelMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final SendMessage sendMessage;


    @Override
    public List<TaxeSejourTrimDtoResponse> findAll() {
        return taxeSejourTrimInfra.findAll().stream().map(e -> modelMapper.map(e, TaxeSejourTrimDtoResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public Result save(TaxeSejourTrimDto taxeSejourTrim) {
        TaxeSejourTrimPojo taxeSejourTrimPojo = modelMapper.map(taxeSejourTrim, TaxeSejourTrimPojo.class);
        log.info("data {}", taxeSejourTrimPojo);
        Result result = createTaxeTrimProcess.execute(taxeSejourTrimPojo);
//        kafkaTemplate.send("myTopic", sendMessage.buildMessage(taxeSejourTrim));
        return result;
    }

}
