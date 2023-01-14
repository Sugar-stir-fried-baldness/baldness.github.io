package com.hspedu.encap;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account();
        account.setName("smit");
        account.setBalance(13);
        account.setPassword("123456");
        System.out.println(account.info());
    }
}
