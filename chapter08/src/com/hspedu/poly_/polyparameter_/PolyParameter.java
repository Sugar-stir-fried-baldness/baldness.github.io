package com.hspedu.poly_.polyparameter_;
//多态参数
public class PolyParameter {
    public static void main(String[] args) {
//        Employee[] employees = new Employee[3];
//        employees[0] = new Manger("jack" ,30000,20000);
//        employees[1] = new Worker("lisa",10000);
//        employees[2] = new Worker("july",10000);
        Manger jack = new Manger("jack" ,3000, 50000);
        Worker lisa = new Worker("lisa", 2500);
        PolyParameter polyParameter = new PolyParameter();
       // System.out.println( polyParameter.showEmpAnnal("employee") );
        polyParameter.showEmpAnnal(jack);
        polyParameter.showEmpAnnal(lisa);
        polyParameter.testWork(jack);//子类对象是可以传给父类的
        polyParameter.testWork(lisa);
    }

    public void showEmpAnnal(Employee e){
        //实现获取任何员工对象的年工资
        System.out.println(e.getAnnal() );
    }
    public void testWork(Employee e){
        if(e instanceof Worker){
            ( (Worker)e).work() ;//向下转型
        } else if (e instanceof  Manger) {
            ( (Manger) e).manage() ;
        }else {
            System.out.println("您的输入错误...");
        }
    }
}
