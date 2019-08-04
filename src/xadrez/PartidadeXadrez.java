package xadrez;

import tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidadeXadrez {
	
	private Tabuleiro tabuleiro;
	
	public PartidadeXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		iniciarPartida();
	}
	
	public PecadeXadrez[][] pecas(){
		PecadeXadrez[][] mat = new PecadeXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for(int i = 0; i < tabuleiro.getLinhas(); i++) {
			for(int j = 0; j < tabuleiro.getColunas(); j++) {
				mat[i][j] = (PecadeXadrez)tabuleiro.peca(i, j);
			}
		}
		return mat;
	}
	
	private void coloqueNovaPeca(char coluna, int linha, PecadeXadrez peca) {
		tabuleiro.colocarPeca(peca, new PoscaodeXadrez(coluna, linha).posicionar());
	}
	
	private void iniciarPartida() {
		coloqueNovaPeca('c', 1, new Torre(tabuleiro, Cor.WHITE));
		coloqueNovaPeca('c', 2, new Torre(tabuleiro, Cor.WHITE));
		coloqueNovaPeca('d', 2, new Torre(tabuleiro, Cor.WHITE));
		coloqueNovaPeca('e', 2, new Torre(tabuleiro, Cor.WHITE));
		coloqueNovaPeca('e', 1, new Torre(tabuleiro, Cor.WHITE));
		coloqueNovaPeca('d', 1, new Rei(tabuleiro, Cor.WHITE));

		coloqueNovaPeca('c', 7, new Torre(tabuleiro, Cor.BLACK));
		coloqueNovaPeca('c', 8, new Torre(tabuleiro, Cor.BLACK));
		coloqueNovaPeca('d', 7, new Torre(tabuleiro, Cor.BLACK));
		coloqueNovaPeca('e', 7, new Torre(tabuleiro, Cor.BLACK));
		coloqueNovaPeca('e', 8, new Torre(tabuleiro, Cor.BLACK));
		coloqueNovaPeca('d', 8, new Rei(tabuleiro, Cor.BLACK));
	}

	
}
