package br.com.jesse.converter;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IdbrasilApplication {

	public static void main(String[] args) {
		Conversor conversor = new Conversor();
		conversor.iniciodojogo();
	}
}
