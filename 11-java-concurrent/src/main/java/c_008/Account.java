package c_008;

public class Account {
    String name;
    double balance;

    public synchronized void set(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public synchronized double getBalance() {
        return this.balance;
    }

}
