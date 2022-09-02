package com.cajero.daniel;

import java.util.Scanner;

public class Cajero {

	Scanner in = new Scanner(System.in);
	Usuario user = new Usuario();

	public int getUserOption() {

		System.out.println("Digite la opción correspondiente: \n" + "1. Consultar saldo.\n" + "2. Retirar dinero.\n"
				+ "3. Depositar dinero.\n" + "4. Salir.");
		return in.nextInt();
	}

	// Obtener balance.
	protected int checkBalance(boolean printMessage) {

		int balance = user.getBalance();

		if (printMessage == true)
			System.out.println("Su saldo actual es: " + balance);

		return balance;
	}

	// Transacción realizada.
	protected void transactionMade(String transactionType) {
		System.out.println(transactionType + " realizado, su nuevo saldo es: $" + checkBalance(false)
				+ ". Transacción finalizada.");
	}

	// Retirar dinero del cajero.
	protected void withdrawMoneyAtm() {

		System.out.println("Digite cantidad de dinero a retirar: ");
		int withdrawal = in.nextInt();

		if (withdrawal <= checkBalance(false)) {

			user.setBalance(user.getBalance() - withdrawal);
			transactionMade("Retiro");
		} else {
			System.out.println("Retiro $" + withdrawal + " supera el saldo actual $" + checkBalance(false)
					+ ", no es posible realizar la transacción.");
		}
	}

	// Depositar dinero en el banco.
	protected void depositMoneyBank() {

		System.out.print("Digite cantidad de dinero a depositar: ");
		int deposit = in.nextInt();
		user.setBalance(checkBalance(false) + deposit);
		transactionMade("Depósito");
	}

	protected void exit() {
		// System.exit(0);
		System.out.println("Saliendo del cajero, por favor retire su tarjeta.");
	}

	// Validar opciones del usuario.
	protected void validateUserOption(int option) {

		switch (option) {
		case 1:
			checkBalance(true);
			break;
		case 2:
			withdrawMoneyAtm();
			break;
		case 3:
			depositMoneyBank();
			break;
		case 4:
			exit();
			break;
		default:
			throw new IllegalArgumentException("Unexpected value " + option + ", debe elegir un opción entre1 y 4: ");
		}

	}
}
