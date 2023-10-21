package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.dto.word.WordAddBindingModel;
import com.dictionaryapp.model.dto.word.WordViewBindingModel;
import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.model.entity.enums.LanguageNameEnum;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.repo.WordRepository;
import com.dictionaryapp.service.WordService;
import com.dictionaryapp.util.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WordServiceImpl implements WordService {

    private final WordRepository wordRepository;
    private final LanguageRepository languageRepository;
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;

    public WordServiceImpl(WordRepository wordRepository,
                           LanguageRepository languageRepository,
                           UserRepository userRepository,
                           LoggedUser loggedUser) {
        this.wordRepository = wordRepository;
        this.languageRepository = languageRepository;
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }


    @Override
    public void addWord(WordAddBindingModel wordAddBindingModel) {

        User user = userRepository
                .findByUsername(loggedUser.getUsername())
                .orElse(null);

        Language language = languageRepository
                .findByName(wordAddBindingModel.getLanguage())
                .orElse(null);

        if (user != null && language != null) {
            Word word = new Word();
            word.setTerm(wordAddBindingModel.getTerm());
            word.setExample(wordAddBindingModel.getExample());
            word.setTranslation(wordAddBindingModel.getTranslation());
            word.setInputDate(wordAddBindingModel.getInputDate());
            word.setLanguage(language);
            word.setAddedBy(user);

            wordRepository.save(word);
        }
    }

    @Override
    public List<WordViewBindingModel> getGermanPost(LanguageNameEnum german) {
        return wordRepository.findSongByLanguageName(german)
                .stream()
                .map(this::mapWordDTO)
                .collect(Collectors.toList());
    }
    @Override
    public List<WordViewBindingModel> getItalianPost(LanguageNameEnum italian) {
        return wordRepository.findSongByLanguageName(italian)
                .stream()
                .map(this::mapWordDTO)
                .collect(Collectors.toList());
    }
    @Override
    public List<WordViewBindingModel> getSpanishPost(LanguageNameEnum spanish) {
        return wordRepository.findSongByLanguageName(spanish)
                .stream()
                .map(this::mapWordDTO)
                .collect(Collectors.toList());
    }
    @Override
    public List<WordViewBindingModel> getFrenchPost(LanguageNameEnum french) {
        return wordRepository.findSongByLanguageName(french)
                .stream()
                .map(this::mapWordDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<WordViewBindingModel> findAllWords() {
        return wordRepository
                .findAll()
                .stream()
                .map(this::mapWordDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void removeById(Long id) {
        wordRepository.deleteById(id);
    }

    @Override
    public void removeAllWords() {

        wordRepository.deleteAll();
    }

    private WordViewBindingModel mapWordDTO(Word word) {
        WordViewBindingModel wordViewBindingModel = new WordViewBindingModel();
        wordViewBindingModel.setId(word.getId());
        wordViewBindingModel.setUsername(word.getAddedBy().getUsername());
        wordViewBindingModel.setInputDate(word.getInputDate());
        wordViewBindingModel.setTerm(word.getTerm());
        wordViewBindingModel.setTranslation(word.getTranslation());
        wordViewBindingModel.setExample(word.getExample());

        return wordViewBindingModel;
    }
}
