package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.model.StudentDO;
import org.modelmapper.AbstractConverter;
import org.modelmapper.AbstractProvider;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class Config {



    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelmapper = new ModelMapper();
        Provider<LocalDate> localDateProvider = new AbstractProvider<LocalDate>() {
            @Override
            public LocalDate get() {
                return LocalDate.now();
            }
        };

        Converter<String, LocalDate> toStringDate = new AbstractConverter<String, LocalDate>() {
            @Override
            protected LocalDate convert(String source) {
                DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                return LocalDate.parse(source, format);
            }
        };

        modelmapper.createTypeMap(String.class, LocalDate.class);
        modelmapper.addConverter(toStringDate);
        modelmapper.getTypeMap(String.class, LocalDate.class).setProvider(localDateProvider);

        return modelmapper;
    }
}
