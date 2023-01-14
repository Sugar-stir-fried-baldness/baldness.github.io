package com.hspedu.object_;

public class ToString_ {
    public static void main(String[] args) {
        Monster monster = new Monster("怪兽", "打怪兽", 10000);
        System.out.println(monster.toString() );
        System.out.println(monster.hashCode());
        System.out.println("======");
        System.out.println(monster);
        /*
        Object 的 ToString()
        public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
         }
    */
    }
}
class Monster{
    private String name;
    private String job;
    private double sal;
    public Monster (String name,String job ,double sal){
        this.name = name;
        this.job = job;
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", sal=" + sal +
                '}';
    }
    //    public String toString(){
//        return "name = "+this.name +" job = "+this.job+" sal = "+this.sal;
//    }
}