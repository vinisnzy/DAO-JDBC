package application;

import model.entities.Department;

public class Main {
    public static void main(String[] args) {
        Department department = new Department(1, "Computers");
        System.out.println(department);
    }
}