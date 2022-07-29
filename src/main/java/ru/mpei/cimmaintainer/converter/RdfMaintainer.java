package ru.mpei.cimmaintainer.converter;

import org.eclipse.rdf4j.model.*;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.RDFParseException;
import org.eclipse.rdf4j.rio.Rio;
import java.io.FileInputStream;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;


public class RdfMaintainer {
    public static Model rdfMaintainer(){
        try (
                FileReader fileReader = new FileReader(
                        "E:\\Idea\\Онтологии ЛР№1\\Материалы\\Общие информационные модели и онтология РЗА энергосистем\\ЛР\\1 ЛР\\src\\main\\resources\\cimmodel.xml")) {
            return Rio.parse(fileReader, "http://iec.ch/TC57/2013/CIM-schema-cim16#", RDFFormat.RDFXML);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
