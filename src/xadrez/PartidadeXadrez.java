package xadrez;

import tabuleiro.Peca;
import tabuleiro.Posicao;
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
	
	public boolean[][] possiveisMovimentos(PoscaodeXadrez posicaoInicial){
		Posicao posicao = posicaoInicial.posicionar();
		validarPosicaoInicial(posicao);
		return tabuleiro.peca(posicao).possiveisMovimentos();
	}
	
	public PecadeXadrez realizarMovimento(PoscaodeXadrez posicaoInicial, PoscaodeXadrez posicaoDestino) {
		Posicao inicial = posicaoInicial.posicionar();
		Posicao destino = posicaoDestino.posicionar();
		validarPosicaoInicial(inicial);
		validarPosicaoDestino(inicial, destino);
		Peca pecaCapturada = movimento(inicial, destino);
		return (PecadeXadrez)pecaCapturada;
	}
	
	private Peca movimento(Posicao inicial, Posicao destino) {
		Peca p = tabuleiro.removePeca(inicial);
		Peca capturada = tabuleiro.removePeca(destino);
		tabuleiro.colocarPeca(p, destino);
		return capturada;
	}
	
	private void validarPosicaoInicial(Posicao posicao) {
		if(!tabuleiro.pecaNaPosicao(posicao)) {
			throw new XadrezException("Nao existe peca na posicao de origem");
		}
		if(!tabuleiro.peca(posicao).existePeloMenosUmMovimento()) {
			throw new XadrezException("Nao existe movimentos possiveis para a peca escolhida");
		}
	}
	
	private void validarPosicaoDestino(Posicao inicial, Posicao destino) {
		if(!tabuleiro.peca(inicial).possivelMovimento(destino)) {
		throw new XadrezException("A peca escolhida nao pode se mover para a posicao de destino");
		}
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
