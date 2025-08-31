package com.hr.hackerrankproblems;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Student {

    String name;
    double cgpa;
    int id;

    Student(String name, double cgpa, int id) {
        this.name = name;
        this.cgpa = cgpa;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    @Override
    public String toString() {
        return name;
    }

}

public class JavaPriorityQueue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        PriorityQueue<Student> pq = new PriorityQueue<>(
            Comparator.comparing(Student::getCgpa).reversed()
                      .thenComparing(Student::getName)
                      .thenComparing(Student::getId)
        );

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String[] s = str.trim().split("\\s+");
            String ops = s[0];

            switch (ops) {
                case "ENTER" -> {
                    String name = s[1];
                    double cgpa = Double.parseDouble(s[2]);
                    int id = Integer.parseInt(s[3]);
                    pq.add(new Student(name, cgpa, id));
                }
                case "SERVED" -> pq.poll();
            }
        }

        if (pq.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            while (!pq.isEmpty()) {
                System.out.println(pq.poll().getName());
            }
        }
    }
}

