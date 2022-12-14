package io;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entity.Question;
import repository.Repository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class JsonFileReader {

    private final String filePath;
    private Repository repository;

    public JsonFileReader(String filePath, Repository repository) {
        this.filePath = filePath;
        this.repository = repository;
    }

    public void readData() throws IOException {
        Gson gson = new Gson();

        Reader reader = Files.newBufferedReader(Paths.get(filePath));

        TypeToken<Map<Integer, Question>> mapType = new TypeToken<>() {};

        Map<Integer, Question> questionMap = gson.fromJson(reader, mapType);

        if (questionMap != null) {
            for (Map.Entry<Integer, Question> entry : questionMap.entrySet()) {
                repository.addQuestion(entry.getKey(), entry.getValue());
            }
        }

        reader.close();
    }
}
