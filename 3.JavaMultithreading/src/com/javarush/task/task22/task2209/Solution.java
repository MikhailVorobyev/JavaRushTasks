package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) {

        String fileName = "";
        ArrayList<String> listWords = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//...
            fileName = reader.readLine();
            BufferedReader readerFile = new BufferedReader(new FileReader(fileName));
            String line = "";
            while (readerFile.ready()) {
                line = readerFile.readLine();
                String[] stringArray = line.split(" ");
                Collections.addAll(listWords, stringArray);
            }
            reader.close();
            readerFile.close();

        } catch (FileNotFoundException e) {
        } catch (IOException e) {}

        long startTime = System.currentTimeMillis();
        String[] wordsForSort = new String[listWords.size()];
        for (int i = 0; i < wordsForSort.length; i++) {
            wordsForSort[i] = listWords.get(i);
        }

        StringBuilder result = getLine(wordsForSort);
        System.out.println(result.toString());
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    public static StringBuilder getLine(String... words) {
        ArrayList<String> resultWords = null;
        int countWords = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            resultWords = new ArrayList<>();
            sb.append(words[i]);
            countWords++;
            resultWords.add(words[i]);
            char previous = (words[i].toUpperCase()).charAt(words[i].length() - 1);
            for (int j = 0; j < words.length; j++) {
                if (resultWords.contains(words[j])) {
                    continue;
                }
                char next = (words[j].toUpperCase()).charAt(0);

                if (countWords < words.length && previous == next) {
                    sb.append(" ");
                    sb.append(words[j]);
                    countWords++;
                    resultWords.add(words[j]);
                    previous = (words[j].toUpperCase()).charAt(words[j].length() - 1);
                    j = -1;
                }
            }
            if (countWords == words.length) {
                break;
            }
            countWords = 0;
            sb.delete(0, sb.length());
        }
        return sb;
    }
}
