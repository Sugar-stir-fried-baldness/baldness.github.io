package com.hspedu.encap;

public class Encapsulation01 {
    public static void main(String[] args) {
//        Person person = new Person();
//        person.setName("jack");
//        person.setSalary(3000 , 12345);
//        //设置一个可以重新输入的
//        person.setAge(34,12345);
//        System.out.println(person.info());
        Person lucy = new Person(55, "lucy", 40000);
        System.out.println("====信息为===");
        System.out.println(lucy.info());
    }

}
class Person{
    //年龄，工资，名字,工作
    private int age;
    public String name;
    private double salary;

   //假如想写一个构造器的话
    public Person(int age, String name, double salary) {
        //alt + insert
//        this.age = age;
//        this.name = name;
//        this.salary = salary; //但是这样之前设置的权限就消失了
            setAge(age,123456);
            setName(name);
            setSalary(salary,123456) ;

    }

    public String info(){//返回值的类型为String
        return "这个人的name = "+name+" age = "+age+" salary = "+salary ;
    }
    public void setAge(int age,int password){
        //小tips ，即使这个属性是private 但是get这个方法的时候
        //要设置成public，
        //对设置的年龄进行一个密码认证，假如正确就继续
        if(password == 123456 && age >= 1 && age <= 120 ){
            this.age = age;
        }
       else{

//            for (int i = 0; i < 3; i++) {
//                System.out.println("您输入的密码错误，请重新输入");
//            }
            System.out.println("您输入的次数超过3次，无法重新获得年龄");
        }
    }
    public int getAge(){
        return age;
    }

    public void setName(String name){
        //名字的字符在1-6位内
        if(name.length() >=1 && name.length() <= 6){
            this.name = name;
        }//其实也可以设置名字里面不能包含哪些字符
        else{
            System.out.println("name形式不符合规范，请输入1-6个字符以内的名字");
        }
    }
    public String GetName(){
        return name;
    }

    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary ,int password) {
        if(password == 123456 && age >= 1 && age <= 120 ){
            this.salary  = salary;
        }
        else{
            System.out.println("您输入的密码错误，无法获取薪酬，请重新输入");
        }
    }
}