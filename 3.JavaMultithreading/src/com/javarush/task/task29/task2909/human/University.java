package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students;
    public University(String name, int age) {
        this.name = name;
        this.age = age;
        students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade) {
                return student;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        double averageGrade = 0.0;
        Student resultStudent = null;
        for (Student student : students) {
            if (student.getAverageGrade() > averageGrade) {
                averageGrade = student.getAverageGrade();
                resultStudent = student;
            }
        }
        return resultStudent;
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        Student resultStudent = getStudentWithMaxAverageGrade();
        double minAverage = resultStudent.getAverageGrade();
        for (Student student : students) {
            if (student.getAverageGrade() < minAverage) {
                minAverage = student.getAverageGrade();
                resultStudent = student;
            }
        }
        return resultStudent;
    }

    public void expel(Student student) {
        students.remove(student);
    }
}