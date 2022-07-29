package ru.mpei.cimmaintainer.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Link extends Identifier {
    private String sourceId;
    private String targetId;
    private String sourcePortId;
    private String targetPortId;
    private Port sourceport;
    private Port targetport;
    private Element source;
    private Element target;


}
