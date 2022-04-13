package ru.otus.dataprocessor;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

public class FileSerializer implements Serializer {

    private final String filename;
    private final ObjectMapper objectMapper;

    public FileSerializer(String fileName) {
        this.filename = fileName;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public void serialize(Map<String, Double> data) {
        //формирует результирующий json и сохраняет его в файл
        try {
            objectMapper.writeValue(Paths.get(this.filename).toFile(), data);
        } catch (IOException e) {
            throw new FileProcessException(e);
        }
    }
}
