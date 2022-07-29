package ru.mpei.cimmaintainer.binder;

import ru.mpei.cimmaintainer.dto.Link;
import ru.mpei.cimmaintainer.dto.SingleLineDiagram;

import java.util.HashMap;
import java.util.Map;

public class ElementsBinder {

    public static void bind(SingleLineDiagram sld){

        Map<String, Link> linkidToLinkMap = new HashMap<>();
        sld.getLinks().forEach(link -> linkidToLinkMap.put(link.getId(), link));

        sld.getElements().forEach(element -> element.getPorts().forEach(port -> {
            port.setElement(element);
            if (port.getLinks().isEmpty()) return;
            String linkId = port.getLinks().get(0);
            if (linkId == null) return;

            Link link = linkidToLinkMap.get(linkId);
            port.setLink(link);

            if (link.getSourcePortId().equals(port.getId())){
                link.setSourceport(port);
                link.setSource(element);
            }
            else {
                link.setTargetport(port);
                link.setTarget(element);
            }
        }));
    }
}
