package com.hspedu.homework.homework08;

public class SavingAccount extends BankAccount {
    //老韩没有设置  属性 月份，而是用   earnMonthlyInterest()
    private double interest = 0.01;//利息
    private int count = 3;

    public SavingAccount( double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        if( count <= 3 && count > 0){
            super.deposit(amount);
            count --;
        }else {
            super.deposit(amount-1);
        }

    }

    @Override
    public void withdraw(double amount) {
        if(count < 3){
            super.withdraw(amount);
            count --;
        }else {
            super.withdraw(amount + 1);
        }
    }

    public void earnMonthlyInterest() {
        count = 3;
        super.deposit(getBalance() * interest);
    }
}