package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.word.WordAddBindingModel;
import com.dictionaryapp.model.dto.word.WordViewBindingModel;
import com.dictionaryapp.model.entity.enums.LanguageNameEnum;

import java.util.List;

public interface WordService {
    void addWord(WordAddBindingModel wordAddBindingModel);

    List<WordViewBindingModel> getGermanPost(LanguageNameEnum languageNameEnum);
    List<WordViewBindingModel> getItalianPost(LanguageNameEnum languageNameEnum);
    List<WordViewBindingModel> getSpanishPost(LanguageNameEnum languageNameEnum);
    List<WordViewBindingModel> getFrenchPost(LanguageNameEnum languageNameEnum);

    List<WordViewBindingModel> findAllWords();

    void removeById(Long id);

    void removeAllWords();
}
