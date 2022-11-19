package Lesson4;

public class Main {
    public static void main(String[] args) {

        Employee [] employees = {new Programmer("Ivan"), new Programmer("Oleg"), new TestCode("Serg")};

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getEmployeeName()+": "+employees[i].doWork());
        }

    }
}

interface Employee {               // Вказуються фанкції, які треба реалізувати у класі який його наслідує
    public String doWork();
    public String getEmployeeName();
}

abstract class AbstractEmployee implements Employee {  // Наслідвання від interface за допомогою implements
                                                       // Абстрактний клас не обов'язково реалізовувати функції з interface
    protected String name;
    // private - доступ до зміної тільки у межах класу
    // protected - доступ у класів через super , які наслідуються від нього
    // public -  прямий досутп не рекомендується для змінних

    @Override
    public String getEmployeeName() {
        return this.name;
    }

    public AbstractEmployee(String name) {  // Це конктруктор класу
        this.name = name;
    }
}


class Programmer extends AbstractEmployee { // Наслідвання від abstract за допомогою extends
    public Programmer(String name) {       // Це конктруктор класу Lesson4.Programmer
        // super - звернення до конструктора батьківського класу Lesson4.AbstractEmployee
        super(name);
    }

    @Override
    public String doWork() {
        return "Write code";
    }
}

class TestCode extends AbstractEmployee {
    public TestCode(String name) {       // Це конктруктор класу Lesson4.TestCode
        // super - звернення до конструктора батьківського класу Lesson4.AbstractEmployee
        super(name);
    }

    @Override
    public String doWork() {
        return "Test code";
    }
}