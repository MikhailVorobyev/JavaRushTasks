package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;


/*
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing


    public static void main(String[] args) throws IOException {
        String fileNameFrom = "";
        String fileNameTo = "";
        if (args.length > 0) {
            fileNameFrom = args[0];
            fileNameTo = args[1];
            InputStream inputStream = new FileInputStream(fileNameFrom);
            OutputStream outputStream = new FileOutputStream(fileNameTo);
            int count;
            while (inputStream.available() > 0) {
                byte[] buff = new byte[inputStream.available()];
                count = inputStream.read(buff);
                String s = new String(buff, 0, count);
                buff = s.getBytes("Windows-1251");
                outputStream.write(buff);
            }
            inputStream.close();
            outputStream.close();
        }

    }
}
