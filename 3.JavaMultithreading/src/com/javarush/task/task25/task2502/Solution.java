package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws Exception {
            wheels = new ArrayList<>();//init wheels here
            String[] wheelsDB = loadWheelNamesFromDB();
            if (wheelsDB.length != 4) {
                throw new Exception();
            }
            boolean b = false;
            for (String s : wheelsDB) {
                for (Wheel wheel : Wheel.values()) {
                    if (wheel.toString().equals(s)) {
                        b = true;
                        wheels.add(Wheel.valueOf(s));
                    }
                }
                if (!b) {
                    throw new Exception();
                }
                b = false;
            }
            System.out.println(wheels);
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
    }
}
