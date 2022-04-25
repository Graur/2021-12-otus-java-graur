package ru.otus.dataprocessor;

import com.fasterxml.jackson.core.type.TypeReference;
import ru.otus.model.Measurement;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.otus.model.MeasurementMixIn;

import java.io.*;
import java.util.List;

public class ResourcesFileLoader implements Loader {

    private final String filename;
    private final ObjectMapper objectMapper;

    public ResourcesFileLoader(String fileName) {
        this.filename = fileName;
        this.objectMapper = new ObjectMapper().addMixIn(Measurement.class, MeasurementMixIn.class);;
    }

    @Override
    public List<Measurement> load() {
        //читает файл, парсит и возвращает результат
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream(this.filename);
            return objectMapper.readValue(is, new TypeReference<>(){});
        } catch (Exception e) {
            throw new FileProcessException(e);
        }
    }
}
