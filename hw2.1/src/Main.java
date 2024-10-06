public class Main {
    public static void main(String[] args) {
        BackAccount account = new BackAccount();
        account.deposit(15000);

        while(true) {
            try {
                account.withDraw(6000);
                System.out.println("Вы успешно сняли 6000 сом, \n У вас осталось: " + account.getAmount());
                System.out.println("-------------------------------------------");
            } catch (LimitException e) {
                System.out.println("Ошибка!" + e.getMessage());
                System.out.println("Осталось на счету: " + e.getRemainingAmount());
                try {
                    account.withDraw((int) e.getRemainingAmount());
                    System.out.println("Мы сняли ваш остаток на счету: " + e.getRemainingAmount());
                } catch (LimitException ex) {
                    System.out.println("Ошибка при снятии оставшейся суммы: " + ex.getMessage());
                }
                break;
            }
        }
    }
}