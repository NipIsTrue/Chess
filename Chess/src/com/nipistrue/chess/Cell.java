package com.nipistrue.chess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cell {
	
	public Piece piece;
	public int x;
	public int y;
	public Color color;
	public boolean selected, highlighted;
	
	public Cell(Color color, int x, int y) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect(x,  y,  50,  50);
		if (piece != null) {
			if (piece.playerType == PlayerType.WHITE && Game.whiteKingInCheck && piece.pieceType == PieceType.KING) specialRender(g);
			else if (piece.playerType == PlayerType.BLACK && Game.blackKingInCheck && piece.pieceType == PieceType.KING) specialRender(g);
		}
		if (highlighted) {
			g.setColor(color);
			g.fillRect(x,  y,  50,  50);
			border(g, Color.green);
		}
		else if (selected) {
			g.setColor(color);
			g.fillRect(x,  y,  50,  50);
			border(g, Color.blue);
		}
		if (piece != null) {
			piece.render(g);
		}
	}
	
	private void border(Graphics g, Color color) {
		g.setColor(color);
		g.fillRect(x, y, 5, 50);
		g.fillRect(x, y + 45, 50, 5);
		g.fillRect(x + 45, y, 5, 50);
		g.fillRect(x, y, 50, 5);
	}
	
	public Piece getPiece() {
		return piece;
	}
	
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	public void specialRender(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x,  y,  50,  50);
		if (piece != null) {
			piece.render(g);
		}
	}
	
}
