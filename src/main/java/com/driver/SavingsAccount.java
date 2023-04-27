package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;
    int numberOfWithdraw;
    int minBalance = 0;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,0);
        this.rate = rate;
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public int getNumberOfWithdraw() {
        return numberOfWithdraw;
    }

    public void setNumberOfWithdraw(int numberOfWithdraw) {
        this.numberOfWithdraw = numberOfWithdraw;
    }


    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
            if(numberOfWithdraw >= maxWithdrawalLimit ){
                throw  new Exception("Insufficient Balance");
            }
            if(super.getBalance() < amount){
                throw  new Exception("Insufficient Balance");
            }
            super.setBalance(super.getBalance() - amount);
            numberOfWithdraw++;
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        return (super.getBalance()+ (super.getBalance()*rate*years));
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        return super.getBalance()*Math.pow(1+rate/times,times*years);
    }

}
