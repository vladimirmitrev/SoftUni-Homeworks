package com.example.spotifyplaylistapp.init;

import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.entity.enums.StyleNameEnum;
import com.example.spotifyplaylistapp.repository.StyleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class StyleInit implements CommandLineRunner {


    private final StyleRepository styleRepository;

    public StyleInit(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if(styleRepository.count() != 0) {
            return;
        }

        Arrays.stream(StyleNameEnum.values())
                .forEach(styleNameEnum -> {
                    Style style = new Style();
                    style.setName(styleNameEnum);

                    styleRepository.save(style);
                });

    }
}
