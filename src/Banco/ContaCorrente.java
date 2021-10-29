package Banco;

import Errors.*;

public class ContaCorrente {

    private int numero;
    private int numeroDeContas;
    private String senha;
    private double saldo;

    public ContaCorrente(int numero, String senha, double saldo){
        this.numero = numero;
        this.senha = senha;
        this.saldo = saldo;
    }

    public ContaCorrente() {

    }

    @Override
    public String toString(){
        return "Número: " + numero + " Senha: " + senha + " Saldo: " + saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public String getSenha() {
        return senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void retirar(int numero, String senha, double valor, int horas, int numeroDeContas)
    throws ExcecaoContaInvalida, ExcecaoSenhaInvalida, ExcecaoHorarioInvalido, ExcecaoSaldoInsuficiente
    {
        if(horas < 8 || horas > 22){
            throw new ExcecaoHorarioInvalido("No momento não é possivel fazer transações, veja mais em https://itau.com.br");
        }
        if(saldo - valor < 0){
            throw new ExcecaoSaldoInsuficiente(saldo, valor);
        }
        if(!this.senha.equals(senha)){
            throw new ExcecaoSenhaInvalida("Conta ou senha inválida!");
        }
        if(numeroDeContas < numero){
            throw new ExcecaoContaInvalida("Conta ou senha inválida!");
        }

        this.saldo -= valor;
    }

}
