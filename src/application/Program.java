package application;

import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Digite sua conta");
			System.out.print("Numero: ");
			Integer number = sc.nextInt();
			System.out.print("Titular: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Deposito inicial: ");
			Double initialDeposit = sc.nextDouble();
			System.out.print("Limite de saque: ");
			Double withDrawLimit = sc.nextDouble();
			
			Account account = new Account(number, holder, initialDeposit, withDrawLimit);
			
			System.out.print("\nDigite quanto deseja sacar: ");
			Double amount = sc.nextDouble();
			account.withDraw(amount);
			System.out.print("Novo saldo: " + account.getBalance());
		}
		catch(DomainException e){ // Catch da exceção personalizada criada no metodo withDraw
			System.out.println("Erro no saque: " + e.getMessage());
		}
		catch(RuntimeException e){ // Catch caso tenha algum erro de digitação
			System.out.println("Erro no saque");
			
		}
		sc.close();
	}
}