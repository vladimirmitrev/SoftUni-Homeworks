package com.example.cardealer.config;

import com.google.gson.*;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (jsonElement, type, jsonDeserializationContext) ->
                        LocalDateTime
                                .parse(jsonElement.getAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")))
//                .registerTypeAdapter(LocalDateTime.class, (JsonSerializer<String>) (jsonElement, type, jsonSerializationContext) ->
//                        new JsonPrimitive(jsonElement))
                .setPrettyPrinting()
                .create();
    }

//    @Bean
//    public Gson gson(){
//        JsonDeserializer<LocalDateTime> toLocalDate =
//                (json, t, c) -> LocalDateTime.parse(json.getAsString());
//
//        JsonSerializer<String> fromLocalDate =
//                (date, t, c) -> new JsonPrimitive(date);
//
//        return new GsonBuilder()
//                .setPrettyPrinting()
////                .serializeNulls()
//                .registerTypeAdapter(LocalDateTime.class, toLocalDate)
//                .registerTypeAdapter(LocalDateTime.class, fromLocalDate)
//                .create();
//    }
}
