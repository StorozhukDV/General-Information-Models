package ru.mpei.cimmaintainer.mapper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import ru.mpei.cimmaintainer.dto.SingleLineDiagram;

import java.io.File;

public class JsonMapper {

    private ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @SneakyThrows
    public SingleLineDiagram mapJsonToSld(String filePath) {
        return objectMapper.readValue(
                new File(filePath), SingleLineDiagram.class
        );
    }

}
