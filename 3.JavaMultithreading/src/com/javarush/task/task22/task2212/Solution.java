package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) {
            return false;
        }
        String onlyDigits = removeUnnecessarySymbols(telNumber);

        if (telNumber.startsWith("+") && onlyDigits.length() == 12) {
            return telNumber.matches("\\+\\d*(\\(\\d{3}\\))?\\d*-?\\d*-?\\d+");
        } else if (onlyDigits.length() == 10) {
            return telNumber.matches("(\\(\\d{3}\\))?\\d*-?\\d+-?\\d+");
        }
        return false;
    }

    public static String removeUnnecessarySymbols(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : string.toCharArray()) {
            if (Character.isDigit(ch)) {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        /*System.out.println(checkTelNumber("+380501234567"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("050123-4567"));
        System.out.println(checkTelNumber("+38)050(1234567"));
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println(checkTelNumber("050ххх4567"));
        System.out.println(checkTelNumber("050123456"));
        System.out.println(checkTelNumber("(0)501234567"));*/

        System.out.println(checkTelNumber("380-50123-45"));
        System.out.println(checkTelNumber("+38051202(345)7"));
        System.out.println(checkTelNumber("1-23456789-0"));
        System.out.println(checkTelNumber("0-50123-4567"));
        System.out.println(checkTelNumber("+38(050)12-34567"));
        System.out.println(checkTelNumber("+38050123425-1"));
        System.out.println(checkTelNumber("+38(050)12-34-567"));
        System.out.println(checkTelNumber("+38050123(456)7"));




    }
}
