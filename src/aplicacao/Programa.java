package aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.PartidadeXadrez;
import xadrez.PecadeXadrez;
import xadrez.PoscaodeXadrez;
import xadrez.XadrezException;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PartidadeXadrez partida = new PartidadeXadrez();
		
				
		while(true) {
			try {
			UI.clearScreen();
			UI.imprimeTabuleiro(partida.pecas());
			System.out.println();
			System.out.print("Inicial: ");
			PoscaodeXadrez inicial = UI.leiaUmaPosicao(sc);
			
			boolean[][] possiveisMovimentos = partida.possiveisMovimentos(inicial);
			UI.clearScreen();
			UI.imprimeTabuleiro(partida.pecas(), possiveisMovimentos);
			
			System.out.println();
			System.out.print("Destino: ");
			PoscaodeXadrez destino = UI.leiaUmaPosicao(sc);
			
			PecadeXadrez pecaCapturada = partida.realizarMovimento(inicial, destino);
			}
			catch(XadrezException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		
	}

}
