public class BackAccount {
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void deposit(double sum) {
        amount+=sum;
    }

    public void withDraw(int sum) throws LimitException {
        if (sum > amount){
            throw new LimitException("Не достаточно средтсв для вывода", amount);
        }
        amount-=sum;
    }
}
