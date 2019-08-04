package aplicacao;

import java.util.Scanner;

import xadrez.PartidadeXadrez;
import xadrez.PecadeXadrez;
import xadrez.PoscaodeXadrez;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PartidadeXadrez partida = new PartidadeXadrez();
		
		while(true) {		
			UI.imprimeTabuleiro(partida.pecas());
			System.out.println();
			System.out.print("Inicial: ");
			PoscaodeXadrez inicial = UI.leiaUmaPosicao(sc);
			
			System.out.println();
			System.out.print("Destino: ");
			PoscaodeXadrez destino = UI.leiaUmaPosicao(sc);
			
			PecadeXadrez pecaCapturada = partida.realizarMovimento(inicial, destino);
		}
		
	}

}
