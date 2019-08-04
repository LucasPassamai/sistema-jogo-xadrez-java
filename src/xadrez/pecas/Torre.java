package xadrez.pecas;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecadeXadrez;

public class Torre extends PecadeXadrez {

	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public String toString() {
		return "T";
	}

	@Override
	public boolean[][] possiveisMovimentos() {
		boolean[][] matriz = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao p = new Posicao(0, 0);
		// acima
		p.setValues(posicao.getLinha() - 1, posicao.getColuna());
		while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().pecaNaPosicao(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() - 1);
		}
		if (getTabuleiro().posicaoExiste(p) && exsteUmaPecaAdversaria(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		// esquerda
		p.setValues(posicao.getLinha(), posicao.getColuna() - 1);
		while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().pecaNaPosicao(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() - 1);
			;
		}
		if (getTabuleiro().posicaoExiste(p) && exsteUmaPecaAdversaria(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		// direita
		p.setValues(posicao.getLinha(), posicao.getColuna() + 1);
		while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().pecaNaPosicao(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() + 1);
			;
		}
		if (getTabuleiro().posicaoExiste(p) && exsteUmaPecaAdversaria(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		// abaixo
		p.setValues(posicao.getLinha() + 1, posicao.getColuna());
		while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().pecaNaPosicao(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() + 1);
		}
		if (getTabuleiro().posicaoExiste(p) && exsteUmaPecaAdversaria(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}

		return matriz;
	}
}
