package com.buscape.juizjokempo.app;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class JuizJokempo implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		String param1 = null;
		if (args != null && args.length != 0) {
			param1 = args[0];
		}

		if ("start".equalsIgnoreCase(param1)) {
			Scanner sc = null;

			try {
				sc = new Scanner(System.in);

				String player1;
				String player2;

				System.out.println("Escolha uma das armas:");
				System.out.println("PEDRA");
				System.out.println("PAPEL");
				System.out.println("TESOURA");

				System.out.println("Jogador 1:");
				player1 = sc.next();

				System.out.println("Jogador 2:");
				player2 = sc.next();

				String retorno = verificarJogada(player1, player2);
				System.out.println(retorno);

			} catch (Exception e) {
				System.out.println("Erro:" + e.getMessage());
			} finally {
				if (sc != null) {
					sc.close();
				}
			}
		}
	}

	public String verificarJogada(String player1, String player2) {
		
		if(player1 == null){
			throw new RuntimeException("O jogador 1 deve escolheu uma das armas: PEDRA, PAPEL e TESOURA");
		}
		
		if(player2 == null){
			throw new RuntimeException("O jogador 2 deve escolheu uma das armas: PEDRA, PAPEL e TESOURA");
		}

		switch (player1.toUpperCase()) {
		case "PEDRA":
			switch (player2.toUpperCase()) {
			case "PEDRA":
				return ("Empate");

			case "PAPEL":
				return ("Jogador 2 ganhou");

			case "TESOURA":
				return ("Jogador 1 ganhou");

			default:
				throw new RuntimeException("O jogador 2 escolheu uma arma diferente de PEDRA, PAPEL e TESOURA");
			}

		case "PAPEL":
			switch (player2.toUpperCase()) {
			case "PEDRA":
				return ("Jogador 1 ganhou");

			case "PAPEL":
				return ("Empatou");

			case "TESOURA":
				return ("Jogador 2 ganhou");

			default:
				throw new RuntimeException("O jogador 2 escolheu uma arma diferente de PEDRA, PAPEL e TESOURA");
			}

		case "TESOURA":
			switch (player2.toUpperCase()) {
			case "PEDRA":
				return ("Jogador 2 ganhou");

			case "PAPEL":
				return ("Jogador 1 ganhou");

			case "TESOURA":
				return ("Empate");

			default:
				throw new RuntimeException("O jogador 2 escolheu uma arma diferente de PEDRA, PAPEL e TESOURA");
			}

		default:
			throw new RuntimeException("O jogador 1 escolheu uma arma diferente de PEDRA, PAPEL e TESOURA");
		}
	}
}
