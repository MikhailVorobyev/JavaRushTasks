package com.javarush.task.task22.task2208;



import java.util.LinkedHashMap;
import java.util.Map;

/*
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put(null, "185");
        map.put("name", "Boris");
        map.put("city", null);
        map.put(null, null);
        String queryString = getQuery(map);
        System.out.println(map);

        System.out.println(queryString);
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;

        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (pair.getValue() != null) {
                if (!isFirst) {
                    sb.append(" and ");
                }
                sb.append(pair.getKey());
                sb.append(" = ");
                sb.append("'");
                sb.append(pair.getValue());
                sb.append("'");
                isFirst = false;
            }
        }
        return sb.toString();
    }
}
