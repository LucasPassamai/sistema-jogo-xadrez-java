package aplicacao;

import xadrez.PartidadeXadrez;

public class Programa {

	public static void main(String[] args) {
		
		PartidadeXadrez partida = new PartidadeXadrez();
		UI.imprimeTabuleiro(partida.pecas());
		
	}

}
