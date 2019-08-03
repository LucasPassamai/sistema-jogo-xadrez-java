package xadrez;

import tabuleiro.Posicao;

public class PoscaodeXadrez {
	
	private char coluna;
	private int linha;
	
	public PoscaodeXadrez(char coluna, int linha) {
		if(coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
			throw new XadrezException("Erro instanciando posição de xadrez: valores válidos de a1 até h8.");
		}
		this.coluna = coluna;
		this.linha = linha;
	}

	public char getColuna() {
		return coluna;
	}

	public int getLinha() {
		return linha;
	}

	protected Posicao posicionar() {
		return new Posicao(8 - linha, coluna - 'a');
	}
	
	protected static PoscaodeXadrez posicao(Posicao posicao) {
		return new PoscaodeXadrez((char)('a' - posicao.getColuna()), 8 - posicao.getLinha());
	}
	
	@Override
	public String toString() {
		return "" + coluna + linha;
	}
}
