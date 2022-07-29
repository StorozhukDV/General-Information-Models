package ru.mpei.cimmaintainer.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class SingleLineDiagram {

    private List<Link> links;

    private List<Element> elements;

}
