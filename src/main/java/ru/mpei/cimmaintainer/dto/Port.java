package ru.mpei.cimmaintainer.dto;

import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter @Setter
public class Port extends Identifier {

    private String name;
    private List<String> links = new LinkedList<>();
    private List<Fields> fields;
    private Link link;
    private Element element;




}
