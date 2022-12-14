package com.sivov.test.repository;

import com.sivov.test.entity.Question;

import java.util.ArrayList;
import java.util.Collection;

public class RepositoryImpl implements Repository {

    private final Collection<Question> questions;

    public RepositoryImpl() {
        this.questions = new ArrayList<>();
    }

    @Override
    public void addQuestion(Question question) {
        questions.add(question);
    }

    @Override
    public Collection<Question> getRepository() {
        return this.questions;
    }
}
