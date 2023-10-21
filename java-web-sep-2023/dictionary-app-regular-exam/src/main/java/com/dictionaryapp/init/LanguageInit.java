package com.dictionaryapp.init;

import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.enums.LanguageNameEnum;
import com.dictionaryapp.repo.LanguageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class LanguageInit implements CommandLineRunner {


    private final LanguageRepository languageRepository;

    private static final String GERMAN_DESCRIPTION = "A West Germanic language, is spoken by over 90 million people worldwide. Known for its complex grammar and compound words, it's the official language of Germany and widely used in Europe.";
    private static final String SPANISH_DESCRIPTION = "A Romance language, is spoken by over 460 million people worldwide. It boasts a rich history, diverse dialects, and is known for its melodious sound, making it a global cultural treasure.";

    private static final String FRENCH_DESCRIPTION = "A Romance language spoken worldwide, known for its elegance and cultural richness. It's the official language of France and numerous nations, famed for its cuisine, art, and literature.";
    private static final String ITALIAN_DESCRIPTION = "A Romance language spoken in Italy and parts of Switzerland, with rich cultural heritage. Known for its melodious sounds, it's a gateway to Italian art, cuisine, and history.";
    public LanguageInit(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        if(languageRepository.count() != 0) {
            return;
        }

        Arrays.stream(LanguageNameEnum.values())
                .forEach(languageNameEnum -> {
                    Language language = new Language();
                    language.setName(languageNameEnum);
                    switch (languageNameEnum) {
                        case GERMAN -> language.setDescription(GERMAN_DESCRIPTION);
                        case SPANISH -> language.setDescription(SPANISH_DESCRIPTION);
                        case FRENCH ->  language.setDescription(FRENCH_DESCRIPTION);
                        case ITALIAN -> language.setDescription(ITALIAN_DESCRIPTION);
                    }

                    languageRepository.save(language);
                });

    }
}
