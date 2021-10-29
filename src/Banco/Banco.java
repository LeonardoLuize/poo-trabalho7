package Banco;

import java.util.ArrayList;
import Errors.*;

public class Banco extends ContaCorrente{

    private String nome;
    private ArrayList<ContaCorrente> contas;

    public Banco(String nome){
        super();
        this.nome = nome;
        contas = new ArrayList<ContaCorrente>();
    }

    public ArrayList<ContaCorrente> getContas() {
        return contas;
    }

    public void addConta(ContaCorrente novaConta){
        contas.add(novaConta);
    }

    public void operacoes() {
        int cont = 1;
        System.out.println("Operações no banco" + this.nome);
        for(ContaCorrente conta : contas){
            System.out.println("-------------------");
            System.out.println("Antes da operação: ");
            imprimeConta(conta);

            try{
                conta.retirar(cont, "POO", 100, 18 + cont, contas.size());
                System.out.println("saque OK");
            }catch(ExcecaoContaInvalida e){
                System.out.println("*** Erro de conta inválida: " + e);
            }catch(ExcecaoSenhaInvalida e){
                System.out.println("*** Erro de autenticação: " + e);
            }catch(ExcecaoHorarioInvalido e){
                System.out.println("*** Erro de execução: " + e);
            }catch(ExcecaoSaldoInsuficiente e){
                System.out.println("*** Erro na conta corrente: " + e);
            }finally{
                System.out.println("\nApós a operação");
                imprimeConta(conta);
                cont ++;
            }
        }
    }

    public void imprimeConta(ContaCorrente c){
        System.out.println(c.toString());
    }

    public static void main (String[] args){



        Banco banco = new Banco("Itau");


        banco.addConta(new ContaCorrente(1, "POO", 500.0));
        banco.addConta(new ContaCorrente(20, "POO", 400.0));
        banco.addConta(new ContaCorrente(3, "OOP", 300.0));
        banco.addConta(new ContaCorrente(4, "POO", 10.0));
        banco.addConta(new ContaCorrente(5, "POO", 200.0));
        banco.operacoes();


    }

}
