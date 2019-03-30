package com.nipistrue.chess;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Piece {
	
	public int x, y;
	public PieceType pieceType;
	public PlayerType playerType;
	
	public Piece(int x, int y, PieceType pieceType, PlayerType playerType) {
		this.x = x;
		this.y = y;
		this.pieceType = pieceType;
		this.playerType = playerType;
	}
	
	public void move(Cell where) {
		this.x = where.x + 10;
		this.y = where.y + 10;
		where.setPiece(this);
	}
	
	public abstract void getValidMoves(Cell cell, Board board);
	
	public abstract void kingInCheck(Cell cell, Board board);
	
	public abstract void render(Graphics g);
	
}
