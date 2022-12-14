package io;

import com.google.gson.Gson;
import repository.Repository;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonFileWriter {

    private final String filePath;
    private Repository repository;

    public JsonFileWriter(String filePath, Repository repository) {
        this.filePath = filePath;
        this.repository = repository;
    }

    public void writeData() throws IOException {

        Gson gson = new Gson();

        Writer writer = Files.newBufferedWriter(Paths.get(filePath));

        gson.toJson(repository.getRepository(), writer);

        writer.close();
    }
}
