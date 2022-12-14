package com.sivov.test.io;

import com.sivov.test.entity.Question;
import com.sivov.test.repository.Repository;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FileReader {

    private String filePath;
    private Repository repository;

    public FileReader(String filePath, Repository repository) {
        this.filePath = filePath;
        this.repository = repository;
    }

    public void readData() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(filePath);
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);

        while (true) {
            try {
                Question question = (Question) inputStream.readObject();
                repository.addQuestion(question);
            } catch (EOFException | ClassNotFoundException e) {
                break;
            }
        }
        fileInputStream.close();
        inputStream.close();
    }
}
