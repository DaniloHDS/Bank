public class CurrentAccount {
    private double balance;
    private boolean isSpecial;

    public CurrentAccount() {
        this.balance = 0.0;
        this.isSpecial = false;
    }

    public void deposit(double amount) {
        if (amount > 0.0) {
            balance += amount;
            System.out.println("Deposit of $ " + amount + " completed. Current balance: $ " + balance);
            checkUpgradeToSpecial();
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0.0) {
            System.out.println("Withdrawl amount must be positive.");
            return;
        }

        double fee = calculateFee(amount);
        if (amount + fee <= balance) {
            balance -= (amount + fee);
            System.out.println("Withdrawl of $ " + amount + " completed. Fee: $ " + fee + ". Current balance: $ " + balance);
        } else {
            System.out.println("Insufficient funds for withdrawl.");
        }
    }

    public double getBalance() {
        return balance;
    }

    private void checkUpgradeToSpecial() {
        if (balance >= 1000.0 && !isSpecial) {
            isSpecial = true; // Upgrade status to special
            System.out.println("Congratularion! You are now special account holder.");
        }
    }

    protected double calculateFee(double amount) {
        return isSpecial ? amount * 0.001 : amount * 0.005; // Special fee for special clients.
    }
}