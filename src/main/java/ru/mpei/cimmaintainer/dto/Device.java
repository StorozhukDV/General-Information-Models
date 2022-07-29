package ru.mpei.cimmaintainer.dto;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.rdf4j.query.algebra.Str;

import java.util.List;

@Getter @Setter
public class Device extends Identifier {
    private String deviceType;

    private Name name;

}
