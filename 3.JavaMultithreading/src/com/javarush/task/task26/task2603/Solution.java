package com.javarush.task.task26.task2603;

import java.util.Comparator;



/*
Убежденному убеждать других не трудно
*/
public class Solution {
    public static class CustomizedComparator {
        private Comparator<CustomizedComparator>[] comparators;

        public CustomizedComparator(Comparator<CustomizedComparator>[] vararg) {
            this.comparators = vararg;
        }

        public int compare(CustomizedComparator o1, CustomizedComparator o2) {
            for (int i = 0; i < comparators.length; i++) {

            }
            return 0;
        }


    }
    public static void main(String[] args) {

    }
}
