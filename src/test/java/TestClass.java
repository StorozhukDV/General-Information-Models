import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.junit.jupiter.api.Test;
import ru.mpei.cimmaintainer.JO.Terminal;
import ru.mpei.cimmaintainer.binder.ElementsBinder;
import ru.mpei.cimmaintainer.converter.CimToFileSaver;
import ru.mpei.cimmaintainer.converter.RdfMaintainer;
import ru.mpei.cimmaintainer.converter.SldFromCimBuilder;
import ru.mpei.cimmaintainer.converter.SldToCimConverter;
import ru.mpei.cimmaintainer.dto.SingleLineDiagram;
import ru.mpei.cimmaintainer.mapper.JsonMapper;
import ru.mpei.cimmaintainer.mapper.MapperDev;
import ru.mpei.cimmaintainer.mapper.VoltageMap;

import java.io.IOException;
import java.util.Map;

public class TestClass {

    @Test
    public void test() throws IOException {
        JsonMapper jsonMapper = new JsonMapper();
        SingleLineDiagram sld = jsonMapper.mapJsonToSld("src/test/resources/Viezdnoe.json");

        ElementsBinder.bind(sld);

        MapperDev mapperDev = new MapperDev();
        Map<String, String> devices = mapperDev.mapJsonToType("src/test/resources/DeviceDirectory.json");

        VoltageMap voltagemap = new VoltageMap();
        Map<String, String> voltages = voltagemap.mapJsonToType("src/test/resources/VoltageLevelDirectory.json");

        SldToCimConverter converter = new SldToCimConverter();
        converter.convert(sld, devices, voltages);
        String cimModel = converter.getResult(RDFFormat.RDFXML);
        CimToFileSaver.writeXML(cimModel);
        Model model = RdfMaintainer.rdfMaintainer();
        SldFromCimBuilder.sparQL(model);
        System.out.println();
    }

}
