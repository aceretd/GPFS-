package com.gpfs;

import static org.dozer.loader.api.FieldsMappingOptions.copyByReference;

import java.text.SimpleDateFormat;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.gpfs.company.model.Company;
import com.gpfs.core.dto.CompanyInfo;
import com.gpfs.core.util.DateUtil;

@Configuration
public class MappingConfig {

    @Bean
    public Mapper mapper() {
        DozerBeanMapper mapper = new DozerBeanMapper();

        mapper.addMapping(new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(Company.class, CompanyInfo.class)
                        .fields("incorporationDate", "incorporationDate", copyByReference());
            }
        });

        return mapper;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JodaModule());
        mapper.setDateFormat(new SimpleDateFormat(DateUtil.DATE_TIME_FORMAT));
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }

}
