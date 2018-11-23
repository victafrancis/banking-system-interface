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
public class Bank {
    
    private Account[] accountList;
    private int numAccounts;
    private int maxAccount;

    public Bank() {
        numAccounts = 0;
        maxAccount = 10000;
        accountList = new Account[maxAccount];
    }
    
    public boolean addAccount(long accNum, double bal, String own){
        if(numAccounts>=maxAccount) return false;
        if(bal < 0)return false;
        if(accNum < 0)return false;
        if(findAccount(accNum) != -1)return false;
        accountList[numAccounts] = new Account(accNum, bal, own);
        numAccounts++;
        return true;
    }
    
    public String printAccounts(){
        String output = "********BEGIN REPORT********\n\n[Acc Number] - [Name] - [Balance]\n";
        for (int i = 0; i < numAccounts; i++) {
            output += accountList[i].getAccountNum() + " - " + accountList[i].getOwner() + " - " + accountList[i].getBalance() + "\n";
        }
        return output + "\n********END REPORT********";
    }
    
    public int findAccount(long accNum){
        for (int i = 0; i < numAccounts; i++) {
            if(accountList[i].getAccountNum() == accNum)
                return i;
        }
        return -1;
    }
    
    public void depositAccount(long accNum, double amount){
        int loc = findAccount(accNum);
        if (loc == -1) return; //return if account not found
        accountList[loc].deposit(amount);
    }
    
    public boolean withdrawAccount(long accNum, double amount){
        int loc = findAccount(accNum);
        if (loc == -1) return false; //no account found
        return accountList[loc].withdraw(amount);
    }
    
    public boolean transfer(long accNumFrom, long accNumTo, double amount){
        int locFrom = findAccount(accNumFrom);
        int locTo = findAccount(accNumTo);
        if(locFrom == -1 || locTo == -1) return false;
        return accountList[locFrom].transfer(accountList[locTo], amount);
    }
    
}
