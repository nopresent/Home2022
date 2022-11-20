package Lesson4part2;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        // Employee [] employees = {new Programmer("Ivan"), new Programmer("Oleg"), new TestCode("Serg")};

        // for (int i = 0; i < employees.length; i++) {
        //     System.out.println(employees[i].getEmployeeName()+": "+employees[i].doWork());
        // }

        Programmer ivan = new Programmer("Ivan");
        System.out.println(ivan);

        Programmer ivan2 = new Programmer("Ivan");
        System.out.println(ivan.hashCode());
        System.out.println(ivan2.hashCode());
        System.out.println(ivan == ivan2);
        System.out.println(ivan.equals(ivan2));

        Programmer petro = new Programmer("Petro");
        System.out.println(petro);

    }
}

interface Employee {
    public void doWork();
    public String getEmployeeName();
}

abstract class AbstractEmployee implements Employee {
    protected String name;
    protected int salary;

    @Override
    public String getEmployeeName() {
        return this.name;
    }

    public int getSalary() {
        return salary;
    }

    // template method
    public void printSalary() {
        System.out.print("Employee got " + getSalary() + " for ");
        doWork();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEmployee that = (AbstractEmployee) o;
        return salary == that.salary && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }
}


class Programmer extends AbstractEmployee {
    public Programmer(String name) {
        this.name = name;
        this.salary = 500;
    }

    public Programmer(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void doWork() {
        System.out.println("Write code");
    }

    @Override
    public String toString() {
        return this.getClass() + " {" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }



}

class TestCode extends AbstractEmployee {
    public TestCode(String name) {
        this.name = name;
    }

    @Override
    public void doWork() {
        System.out.println("Test code");
    }
}