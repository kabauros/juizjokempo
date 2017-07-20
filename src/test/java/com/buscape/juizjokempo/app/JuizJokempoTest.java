package com.buscape.juizjokempo.app;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.buscape.juizjokempo.app.JuizJokempo;

@RunWith(MockitoJUnitRunner.class)
public class JuizJokempoTest {

	@InjectMocks
	private JuizJokempo juizJokempo;

	@Test
	public void juizJokempoTesteValido() {
		// GIVEN
		String player1 = "PEDRA";
		String player2 = "TESOURA";
		String saidaEsperada = "Jogador 1 ganhou";

		// WHEN
		String retorno = juizJokempo.verificarJogada(player1, player2);

		// THEN
		assertThat(retorno, notNullValue());
		assertThat(retorno, Matchers.is(Matchers.equalToIgnoringCase(saidaEsperada)));
	}

	@Test
	public void juizJokempoTesteValido1() {
		// GIVEN
		String player1 = "PEDRA";
		String player2 = "TESOURA";
		String saidaEsperada = "Jogador 1 ganhou";

		// WHEN
		String retorno = juizJokempo.verificarJogada(player1, player2);

		// THEN
		assertThat(retorno, notNullValue());
		assertThat(retorno, Matchers.is(Matchers.equalToIgnoringCase(saidaEsperada)));
	}

	@Test
	public void juizJokempoTesteValido2() {
		// GIVEN
		String player1 = "PEDRA";
		String player2 = "PAPEL";
		String saidaEsperada = "Jogador 2 ganhou";

		// WHEN
		String retorno = juizJokempo.verificarJogada(player1, player2);

		// THEN
		assertThat(retorno, notNullValue());
		assertThat(retorno, Matchers.is(Matchers.equalToIgnoringCase(saidaEsperada)));
	}

	@Test
	public void juizJokempoTesteValido3() {
		// GIVEN
		String player1 = "PAPEL";
		String player2 = "tesoura";
		String saidaEsperada = "Jogador 2 ganhou";

		// WHEN
		String retorno = juizJokempo.verificarJogada(player1, player2);

		// THEN
		assertThat(retorno, notNullValue());
		assertThat(retorno, Matchers.is(Matchers.equalToIgnoringCase(saidaEsperada)));
	}
	
	@Test(expected = RuntimeException.class)
	public void juizJokempoTesteInvalido() {
		// GIVEN
				String player1 = "00000";
				String player2 = "TESOURA";
		
		// WHEN
		juizJokempo.verificarJogada(player1, player2);
	}
	
	@Test(expected = RuntimeException.class)
	public void juizJokempoTesteInvalido2() {
		// GIVEN
				String player1 = "PAPEL";
				String player2 = "abcd";
		
		// WHEN
		juizJokempo.verificarJogada(player1, player2);
	}
	
	@Test(expected = RuntimeException.class)
	public void juizJokempoTesteInvalido3() {
		// GIVEN
				String player1 = null;
				String player2 = "abcd";
		
		// WHEN
		juizJokempo.verificarJogada(player1, player2);
	}

	@Test(expected = RuntimeException.class)
	public void juizJokempoTesteInvalido4() {
		// GIVEN
				String player1 = "abc";
				String player2 = null;
		
		// WHEN
		juizJokempo.verificarJogada(player1, player2);
	}
	
	@Test(expected = RuntimeException.class)
	public void juizJokempoTesteInvalido5() {
		// GIVEN
				String player1 = "";
				String player2 = null;
		
		// WHEN
		juizJokempo.verificarJogada(player1, player2);
	}

}
