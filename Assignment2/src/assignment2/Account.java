/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * @author franc
 */
public class Account {
    
    //Members:
    //Maria Lilian Yang - 101151657
    //Francis Victa - 101159185
    
    private long accountNum;
    private double balance;
    private String owner;

    public Account(long accountNum, double balance, String owner) {
        this.accountNum = accountNum;
        this.balance = balance;
        this.owner = owner;
    }

    public long getAccountNum() {
        return accountNum;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }
    
    public boolean withdraw(double amount){
        if(amount<0 || amount>balance) 
            return false;
        balance -= amount;
        return true;
    }
    
    public void deposit(double amount){
        if (amount<0) //if negative amount
            return;
        balance += amount;
    }
    
    public boolean transfer(Account acct, double amount){
        if(withdraw(amount)){
            acct.deposit(amount);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Account{" + "accountNum=" + accountNum + ", balance=" + balance + ", owner=" + owner + '}';
    }

}
