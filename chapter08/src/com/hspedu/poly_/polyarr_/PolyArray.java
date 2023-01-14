package com.hspedu.poly_.polyarr_;

public class PolyArray {
    public static void main(String[] args) {
        Person[] persons = new Person[5];
        persons[0] = new Person("jack",12);
        persons[1] = new Student("mark",12,50.0);
        persons[2] = new Student("smith",13,80);
        persons[3] = new Teacher("lisa",30,20000);
        persons[4] = new Teacher("moly",32,25000);
        for (int i = 0; i < persons.length ; i++) {
            System.out.println(persons[i].say());
            if(persons[i] instanceof Student){
                Student student = (Student) persons[i];
                student.student() ;
                //System.out.println( ((Student)persons[i]).say() );
            }else if(persons[i] instanceof  Teacher){
                Teacher teacher = (Teacher) persons [i];
                teacher.teach();//
                // ((Teacher)persons[i]).say() ;
            }else if(persons[i] instanceof  Person){

            }
                else{
                System.out.println("你的类型有误，请重新检查...");
            }

        }

    }

}
