package quiz.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import quiz.repository.Repository;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonFileWriter {

    private Repository repository;

    public JsonFileWriter(Repository repository) {
        this.repository = repository;
    }

    public void writeData() throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String filePath = "src/main/java/quiz/io/quizData.json";

        Writer writer = Files.newBufferedWriter(Paths.get(filePath));

        gson.toJson(repository.getRepository(), writer);

        writer.close();
    }
}
