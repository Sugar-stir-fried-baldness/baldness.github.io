package com.hspedu.homework.homework08;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Homework08 {
    public static void main(String[] args) {

//        CheckingAccount checkingAccount = new CheckingAccount( 400);
//        checkingAccount.deposit(100) ;
//        checkingAccount.withdraw(100);
//        System.out.println( checkingAccount.getBalance());
        SavingAccount savingAccount = new SavingAccount(1000);
        savingAccount.deposit(100);
        savingAccount.deposit(100);
        savingAccount.deposit(100);
        System.out.println( savingAccount.getBalance() );
        savingAccount.deposit(100);
        System.out.println( savingAccount.getBalance() );
    }
}
