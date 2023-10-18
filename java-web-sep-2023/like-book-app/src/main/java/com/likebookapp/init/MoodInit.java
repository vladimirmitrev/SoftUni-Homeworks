package com.likebookapp.init;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.enums.MoodNameEnum;
import com.likebookapp.repository.MoodRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MoodInit implements CommandLineRunner {

    private final MoodRepository moodRepository;

    public MoodInit(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        if(moodRepository.count() != 0) {
            return;
        }

        Arrays.stream(MoodNameEnum.values())
                .forEach(moodNameEnum -> {
                    Mood mood = new Mood();
                    mood.setName(moodNameEnum);

                    moodRepository.save(mood);
                });

    }
}
