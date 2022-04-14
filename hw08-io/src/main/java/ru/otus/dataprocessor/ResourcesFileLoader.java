package ru.otus.dataprocessor;

import ru.otus.model.Measurement;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.otus.model.MeasurementMixIn;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
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
        return parse(read());
    }

    private File read() {
        URL resource = getClass().getClassLoader().getResource(this.filename);
        if (resource == null) {
            throw new FileProcessException("File not found by name: " + this.filename);
        } else {
            try {
                return new File(resource.toURI());
            } catch (URISyntaxException e) {
                throw new FileProcessException(e.getMessage());
            }
        }
    }

    private List<Measurement> parse(File file) {
        List<Measurement> measurements;
        try {
            measurements = objectMapper.readerForListOf(Measurement.class).readValue(file);
        } catch (IOException e) {
            throw new FileProcessException(e.getMessage());
        }
        return measurements;
    }
}
