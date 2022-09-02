package com.cajero.daniel;

public class Main {

	public static void main(String[] args) {

		Cajero cajero = new Cajero();

		int option = 0;

		do {
			option = cajero.getUserOption();
			cajero.validateUserOption(option);

		} while (option != 4);

	}
}
