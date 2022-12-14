package com.sivov.test.io;

import com.sivov.test.entity.Question;
import com.sivov.test.repository.Repository;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileWriter {

    private String filePath;
    private Repository repository;

    public FileWriter(String filePath, Repository repository) {
        this.filePath = filePath;
        this.repository = repository;
    }

    public void writeData() throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

        for (Question question : repository.getRepository()) {

            outputStream.writeObject(question);
        }
        outputStream.close();
    }
}
