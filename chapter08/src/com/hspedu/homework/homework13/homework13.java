package com.hspedu.homework.homework13;

public class homework13 {
    public static void main(String[] args) {
        Student student = new Student("小明", 15, "男", "00023102");
        student .printInfo() ;
        System.out.println("----------------");
        Teacher teacher = new Teacher("张飞", 30, "男",5);
        teacher.printInfo() ;

        System.out.println("================");
        Person[] person = new Person[4];
        person[0] = new Student("小明", 15, "男", "00023102");
        person[1] = new Student("小明", 16, "男", "00023103");
        person[2] = new Teacher("张飞", 32, "男",5) ;
        person[3] = new Teacher("张宇", 33, "男",4) ;

        homework13 homework13 = new homework13();
        homework13.bubbleSort(person);

        for (int i = 0; i < person.length ; i++) {
            System.out.println(person[i]);
        }
        System.out.println("==========");
        for (int i = 0; i < person.length; i++) {
            homework13.test(person[i]);
        }
    }
    public void test(Person person){
        if( person instanceof Student){
            ((Student) person).study();
        } else if (person instanceof Teacher) {
            ((Teacher) person).study();
        }else {
            System.out.println(" do nothing ...");
        }
    }
    public void bubbleSort(Person[] person){
        Person temp = null;
        for (int i = 0; i < person.length - 1; i++) {
            for (int j = 0; j < person.length -i-1; j++) {
                if(person[j].getAge() < person[j+1].getAge())
                {
                    temp = person[j];
                    person[j] = person[j+1];
                    person[j+1] = temp;
                }
            }
        }
    }
}
