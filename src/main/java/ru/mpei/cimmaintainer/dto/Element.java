package ru.mpei.cimmaintainer.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Element extends Identifier {

    private String directoryEntryId;
    private String voltageLevel;
    private String operationName;
    private String projectName;
    private String type;
    private List<Port> ports;
    private List<Fields> fields;


}
