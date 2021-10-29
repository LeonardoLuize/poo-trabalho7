package Errors;

public class ExcecaoSaldoInsuficiente extends Exception{
    private double saldo;
    private double valor;

    public ExcecaoSaldoInsuficiente(double saldo, double valor) {
        super(String.format("R$%.2f. Não é possível sacar o valor: R$%.2f", saldo, valor));
        this.valor = valor;
        this.saldo = saldo;
    }

    public double getValor() {
        return valor;
    }

    public double getSaldo() {
        return saldo;
    }

}
