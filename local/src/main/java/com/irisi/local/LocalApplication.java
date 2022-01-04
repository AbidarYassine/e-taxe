package com.irisi.local;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.irisi.local.dao.*;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableEurekaClient
@OpenAPIDefinition(info =
@Info(title = "Local Service API", version = "1.0", description = "Local Service api v1.0")
)
public class LocalApplication {

    public static void main(String[] args) {

        SpringApplication.run(LocalApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dye0ygkxm",
                "api_key", "126716589298932",
                "api_secret", "y644M0lSkNXvJaJUfkCnJykpWuA"));
    }

    @Bean
    public CommandLineRunner demo(ActiviteDao activiteDao,
                                  CommuneDao communeDao,
                                  DeclarationDao declarationDao,
                                  VilleDao villeDao,
                                  QuartierDao quartierDao,
                                  RueDao rueDao,
                                  RedevableDao redevableDao,
                                  LocalDao localDao,
                                  AnnexAdministrativeDao annexAdministrativeDao) {
        return (args) -> {
//            Activite activite = new Activite();
//            activite.setNom("acitiviter-1");
//            Activite activiteSaved = activiteDao.save(activite);
//            AnnexAdministrative annexAdministrative = new AnnexAdministrative();
//            annexAdministrative.setNom("annexAdministrative");
//            annexAdministrative.setNumero("12478");
//            annexAdministrativeDao.save(annexAdministrative);
//
//            Ville ville = new Ville();
//            ville.setNom("Marrakech");
//
//            Commune commune = new Commune();
//            commune.setNom("Commune");
//            commune.setVille(villeDao.save(ville));
//
//            Declaration declaration = new Declaration();
//            declaration.setRef("ref-declaration");
//            Declaration declarationSaved = declarationDao.save(declaration);
//
//
//            Quartier quartier = new Quartier();
//            quartier.setNumero("12445");
//            quartier.setNom("MASSIRA");
//            Quartier quartierSaved = quartierDao.save(quartier);
//
//            Redevable redevable = new Redevable();
//            redevable.setRef("ref-1");
//            redevable.setNom("abidar");
//            redevable.setAdresse("Marrakech ");
//            redevable.setAdresse("Marrakech ");
//            redevable.setEmail("yassine.abidar@edu.uca.ma");
//            redevable.setPrenom("yassine");
//            Redevable redevableSaved = redevableDao.save(redevable);
//
//
//            Rue rue = new Rue();
//            rue.setNumero("124455");
//            rue.setNom("RUE 1");
//            rue.setQuartier(quartierSaved);
//            Rue rueSaved = rueDao.save(rue);
//
//            Local local = new Local();
//            local.setRef("local-ref-1");
//            local.setRedevable(redevableSaved);
//            local.setNom("Cristal");
//            local.setNomCommercial("CRISTAL");
//            local.setActivite(activiteSaved);
//            local.setDeclaration(declarationSaved);
//            local.setNumeroCaissier("124578");
//            local.setRue(rueSaved);
//            localDao.save(local);

        };
    }
}
