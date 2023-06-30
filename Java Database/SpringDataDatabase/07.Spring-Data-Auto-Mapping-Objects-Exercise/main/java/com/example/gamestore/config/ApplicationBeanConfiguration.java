package com.example.gamestore.config;

import com.example.gamestore.model.dto.GameAddDTO;
import com.example.gamestore.model.entities.Game;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();

        modelMapper
                .typeMap(GameAddDTO.class, Game.class)
                .addMappings(mapper ->
                        mapper.map(GameAddDTO::getThumbnailURL,
                                Game::setImageThumbnail));

        return new ModelMapper();
    }
}
