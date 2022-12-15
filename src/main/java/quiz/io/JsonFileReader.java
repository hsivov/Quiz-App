package quiz.io;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import quiz.entity.Question;
import quiz.repository.QuestionRepository;
import quiz.repository.Repository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class JsonFileReader {

    private Repository repository;

    public JsonFileReader() {
        this.repository = new QuestionRepository();
    }

    public Repository readData() throws IOException {
        Gson gson = new Gson();
        String filePath = "src/main/java/quiz/io/quizData.json";

        Reader reader = Files.newBufferedReader(Paths.get(filePath));

        TypeToken<Map<Integer, Question>> mapType = new TypeToken<>() {};

        Map<Integer, Question> questionMap = gson.fromJson(reader, mapType);

        if (questionMap != null) {
            for (Map.Entry<Integer, Question> entry : questionMap.entrySet()) {
                repository.addQuestion(entry.getKey(), entry.getValue());
            }
        }

        reader.close();
        return repository;
    }
}
