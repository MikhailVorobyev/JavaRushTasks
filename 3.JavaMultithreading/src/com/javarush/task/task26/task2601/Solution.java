package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{13, 8, 15, 5, 17};
        System.out.println(Arrays.toString(array));
        Integer[] resultArray = sort(array);
        System.out.println(Arrays.toString(resultArray));

    }

    public static Integer[] sort(Integer[] array) {
        Integer[] sortArray = array.clone();
        Arrays.sort(sortArray);
        //implement logic here
        int median;

        if ((sortArray.length % 2) != 0) {
            median = sortArray[sortArray.length / 2];
        } else {
            int a = sortArray.length / 2;
            int b = (sortArray.length /2) + 1;
            median = (a + b) / 2;
        }

        Arrays.sort(sortArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 == median || o2 == median? Integer.MAX_VALUE : o2.compareTo(o1);
            }
        });


        return sortArray;
    }
}
