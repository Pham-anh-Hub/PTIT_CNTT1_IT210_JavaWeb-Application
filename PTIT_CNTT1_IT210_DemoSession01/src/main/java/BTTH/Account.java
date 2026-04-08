package BTTH;

public class Account {
    private String fullname;
    private double balance;
    private String area;

    public Account() {
    }

    public Account(String fullname, double balance, String area) {
        this.fullname = fullname;
        this.balance = balance;
        this.area = area;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
