package com.sivov.test.repository;

import com.sivov.test.entity.Question;

import java.util.Collection;

public interface Repository {

    void addQuestion(Question question);

    Collection<Question> getRepository();
}
