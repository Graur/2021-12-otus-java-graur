package ru.otus.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MeasurementMixIn {
    @JsonCreator
    MeasurementMixIn(
            @JsonProperty("name") String name,
            @JsonProperty("value") double value)
    { }

}
