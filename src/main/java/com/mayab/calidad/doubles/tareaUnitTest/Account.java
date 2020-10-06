package com.mayab.calidad.doubles.tareaUnitTest;

public class Account {

	int balance;
    String holder;
    AlertListener alerts;
    int zone;
    public Account(String holder, int initialBalance, AlertListener alerts){
        this.holder = holder;
        this.balance = initialBalance;
        this.alerts = alerts;
    }
    
    public Account(String holder, int initialBalance,int zone, AlertListener alerts){
        this.holder = holder;
        this.balance = initialBalance;
        this.zone = zone;
        this.alerts = alerts;
    }
    
    public Account(String holder, int initialBalance,int zone){
        this.holder = holder;
        this.balance = initialBalance;
        this.zone = zone;
        
    }
    
    public int getBalance() {
        return this.balance;
    }
    
    public String getHolder(){
        return this.holder;
    }
    public int getZone() {
    	return this.zone;
    }
    public float getCommision() {
    	switch(zone) {
    	case 1:
    		return 0.01f;
		case 2:
    		return 0.02f;
    	case 3:
    		return 0.03f;
    	default:
    		return 0;	
    	}
    }
    void debit(int balance) {
        this.balance -= balance;
        if(this.balance < 100){
            this.alerts.sendAlert(this.holder+", your account balance is below 100");
        }
    }

    void credit(int balance) {
        this.balance += balance;
    }
    float abono(int balance) {
        this.balance += balance;
        return balance;
    }
    float calcularComm() {
    	
    	return 0;
    }
    void setAlertListener(AlertListener listener){
        this.alerts = listener;
    }
	
}
