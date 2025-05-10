public class SpecialAccount extends CurrentAccount {
    @Override
    protected double calculateFee(double amount) {
        return amount * 0.001; // 0,1% de taxa para clientes especiais
    }
}

