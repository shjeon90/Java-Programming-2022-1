public class Cashier extends Person {

    private int balance;
    private Calculator calculator;

    public Cashier() {
        this.balance = 10000;
        this.calculator = new Calculator();
    }

    public boolean ringUp(int price) {
        this.balance = this.calculator.calculate(this.balance, price);
        return true;
    }
}


