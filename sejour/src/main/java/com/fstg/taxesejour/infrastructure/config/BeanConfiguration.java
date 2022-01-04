package com.fstg.taxesejour.infrastructure.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fstg.taxesejour.domaine.process.tauxTaxe.create.CreateTauxTaxeProcess;
import com.fstg.taxesejour.domaine.process.tauxTaxe.create.CreateTauxTaxeProcessImpl;
import com.fstg.taxesejour.domaine.process.taxeSejourAnnuel.create.CreateTaxeAnnuelProcess;
import com.fstg.taxesejour.domaine.process.taxeSejourAnnuel.create.CreateTaxeAnnuelProcessImpl;
import com.fstg.taxesejour.domaine.process.taxeSejourTrim.create.CreateTaxeTrimProcess;
import com.fstg.taxesejour.domaine.process.taxeSejourTrim.create.CreateTaxeTrimProcessImpl;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxRetardTaxeSejourTrimInfra;
import com.fstg.taxesejour.infrastructure.dao.facade.TauxTaxeSejourInfra;
import com.fstg.taxesejour.infrastructure.dao.facade.TaxeSejourAnnuelInfra;
import com.fstg.taxesejour.infrastructure.dao.facade.TaxeSejourTrimInfra;
import com.fstg.taxesejour.infrastructure.messaging.LocalMessageReader;
import com.fstg.taxesejour.infrastructure.required.LocalService;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class BeanConfiguration {
    @Bean
    public CreateTaxeAnnuelProcess createTaxeAnnuelProcess(
            TaxeSejourAnnuelInfra taxeSejourAnnuelInfra,
            TauxTaxeSejourInfra tauxTaxeSejourInfra,
            LocalService localService,
            LocalMessageReader localMessageReader
    ) {
        return new CreateTaxeAnnuelProcessImpl(taxeSejourAnnuelInfra, localService, localMessageReader);
    }

    @Bean
    public CreateTaxeTrimProcess createTaxeTrimProcess(
            TaxeSejourTrimInfra taxeSejourTrimInfra,
            TauxTaxeSejourInfra tauxTaxeSejourInfra,
            TauxRetardTaxeSejourTrimInfra tauxRetardTaxeSejourTrimInfra,
            LocalService localService,
            LocalMessageReader localMessageReader
    ) {
        return new CreateTaxeTrimProcessImpl(taxeSejourTrimInfra, tauxTaxeSejourInfra, tauxRetardTaxeSejourTrimInfra, localService, localMessageReader);
    }

    @Bean
    public CreateTauxTaxeProcess createTauxTaxeProcess(
            TauxTaxeSejourInfra tauxTaxeSejourInfra,
            LocalMessageReader localMessageReader
    ) {
        return new CreateTauxTaxeProcessImpl(tauxTaxeSejourInfra, localMessageReader);
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }


}
