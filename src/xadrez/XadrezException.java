package xadrez;

import tabuleiro.BoardException;

public class XadrezException extends BoardException {
	private static final long serialVersionUID = 1L;

	public XadrezException(String msg) {
		super(msg);
	}
}
