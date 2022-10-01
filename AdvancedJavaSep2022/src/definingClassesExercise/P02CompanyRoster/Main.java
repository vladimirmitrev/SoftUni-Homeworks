package definingClassesExercise.P02CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfEmployees = Integer.parseInt(scanner.nextLine());

        Map<String,Department> departmentMap = new HashMap<>();
        for (int i = 0; i < countOfEmployees; i++) {
            String[] personInfo = scanner.nextLine().split(" ");
            String name = personInfo[0];
            double salary = Double.parseDouble(personInfo[1]);
            String position = personInfo[2];
            String department = personInfo[3];
            Employee employee = null;

            switch (personInfo.length) {
                case 6:
                    String email = personInfo[4];
                    int age = Integer.parseInt(personInfo[5]);
                    employee = new Employee(name, salary, position, department, email, age);

                    break;
                case 5:
                    if(personInfo[4].matches("\\d+")) {
                    int personAge = Integer.parseInt(personInfo[4]);
                    employee = new Employee(name, salary, position, department, personAge);
                } else {
                        String personEmail = personInfo[4];
                        employee = new Employee(name, salary, position, department, personEmail);
                    }
                    break;
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;
            }
            departmentMap.putIfAbsent(department, new Department(department));
            departmentMap.get(department).getEmployees().add(employee);



        }
        Department highestPaidDepartment = departmentMap.entrySet().stream()
                .max(Comparator.comparingDouble(e -> e.getValue().calculateAverageSalary()))
                .get()
                .getValue();

        System.out.printf("Highest Average Salary: %s%n", highestPaidDepartment.getName());

        highestPaidDepartment.getEmployees().stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);


    }
}
