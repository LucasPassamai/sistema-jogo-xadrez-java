package xadrez;

import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public abstract class PecadeXadrez extends Peca {
	
	private Cor cor;

	public PecadeXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}
	public Cor getCor() {
		return cor;
	}
	
	protected boolean exsteUmaPecaAdversaria(Posicao posicao) {
		PecadeXadrez p = (PecadeXadrez)getTabuleiro().peca(posicao);
		return p != null && p.getCor() != cor;
	}
	
}
