package com.fstg.taxesejour;


import com.google.gson.Gson;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableFeignClients
@EnableEurekaClient
@OpenAPIDefinition(info =
@Info(title = "Taxe sejour API", version = "1.0", description = "E-Taxe sejour API v1.0")
)
public class TaxeSejourApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxeSejourApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	@Bean
	public Gson jsonConverter() {
		return new Gson();
	}

}
