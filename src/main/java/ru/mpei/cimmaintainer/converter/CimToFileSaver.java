package ru.mpei.cimmaintainer.converter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CimToFileSaver {
    public static void writeXML(String cimModel){
        try (FileOutputStream fos = new FileOutputStream(
                "E:\\Idea\\Онтологии ЛР№1\\Материалы\\Общие информационные модели и онтология РЗА энергосистем\\ЛР\\1 ЛР\\src\\main\\resources\\cimmodel.xml")){
            byte[] buffer = cimModel.getBytes();
            fos.write(buffer, 0, buffer.length);
            System.out.println("Файл записан");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
