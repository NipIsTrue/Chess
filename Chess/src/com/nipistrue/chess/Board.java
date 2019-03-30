package com.nipistrue.chess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Board {
	
	public Cell[][] pieces;
	private Cell lastCellSelected = null;
	public boolean clicked = false;
	
	public Board() {
		pieces = new Cell[8][8];
		for (int i = 0; i < 400; i += 50) {
			for (int x = 0; x < 400; x += 50) {
				if (i % 100 == 0) {
					if (x % 100 == 0) pieces[i / 50][x / 50] = new Cell(Color.lightGray, x, i);
					else pieces[i / 50][x / 50] = new Cell(Color.white, x, i);
				}
				else {
					if (x % 100 == 0) pieces[i / 50][x / 50] = new Cell(Color.white, x, i);
					else pieces[i / 50][x / 50] = new Cell(Color.lightGray, x, i);
				}
			}
		}
		setPieces();
	}
	
	private void setPieces() {
		for (int x = 0; x < 8; x++) {
			if (x == 0) {
				for (int i = 0; i < 8; i++) {
					Cell tempCell = pieces[x][i];
					switch (i) {
					case 0:
						tempCell.setPiece(new Rook(tempCell.x + 10, tempCell.y + 10, PieceType.ROOK, PlayerType.BLACK));
						break;
					case 1:
						tempCell.setPiece(new Knight(tempCell.x + 10, tempCell.y + 10, PieceType.KNIGHT, PlayerType.BLACK));
						break;
					case 2:
						tempCell.setPiece(new Bishop(tempCell.x + 10, tempCell.y + 10, PieceType.BISHOP, PlayerType.BLACK));
						break; 
					case 3:
						tempCell.setPiece(new Queen(tempCell.x + 10, tempCell.y + 10, PieceType.QUEEN, PlayerType.BLACK));
						break;
					case 4:
						tempCell.setPiece(new King(tempCell.x + 10, tempCell.y + 10, PieceType.KING, PlayerType.BLACK));
						break;
					case 5:
						tempCell.setPiece(new Bishop(tempCell.x + 10, tempCell.y + 10, PieceType.BISHOP, PlayerType.BLACK));
						break;
					case 6:
						tempCell.setPiece(new Knight(tempCell.x + 10, tempCell.y + 10, PieceType.KNIGHT, PlayerType.BLACK));
						break;
					case 7:
						tempCell.setPiece(new Rook(tempCell.x + 10, tempCell.y + 10, PieceType.ROOK, PlayerType.BLACK));
						break;
					}
				}
			}
			else if (x == 1) {
				for (int i = 0; i < 8; i++) {
					Cell tempCell = pieces[x][i];
					tempCell.setPiece(new Pawn(tempCell.x + 10, tempCell.y + 10, PieceType.PAWN, PlayerType.BLACK));
				}
			}
			else if (x == 6) {
				for (int i = 0; i < 8; i++) {
					Cell tempCell = pieces[x][i];
					tempCell.setPiece(new Pawn(tempCell.x + 10, tempCell.y + 10, PieceType.PAWN, PlayerType.WHITE));
				}
			}
			else if (x == 7) {
				for (int i = 0; i < 8; i++) {
					Cell tempCell = pieces[x][i];
					switch (i) {
					case 0:
						tempCell.setPiece(new Rook(tempCell.x + 10, tempCell.y + 10, PieceType.ROOK, PlayerType.WHITE));
						break;
					case 1:
						tempCell.setPiece(new Knight(tempCell.x + 10, tempCell.y + 10, PieceType.KNIGHT, PlayerType.WHITE));
						break;
					case 2:
						tempCell.setPiece(new Bishop(tempCell.x + 10, tempCell.y + 10, PieceType.BISHOP, PlayerType.WHITE));
						break; 
					case 3:
						tempCell.setPiece(new King(tempCell.x + 10, tempCell.y + 10, PieceType.KING, PlayerType.WHITE));
						break;
					case 4:
						tempCell.setPiece(new Queen(tempCell.x + 10, tempCell.y + 10, PieceType.QUEEN, PlayerType.WHITE));
						break;
					case 5:
						tempCell.setPiece(new Bishop(tempCell.x + 10, tempCell.y + 10, PieceType.BISHOP, PlayerType.WHITE));
						break;
					case 6:
						tempCell.setPiece(new Knight(tempCell.x + 10, tempCell.y + 10, PieceType.KNIGHT, PlayerType.WHITE));
						break;
					case 7:
						tempCell.setPiece(new Rook(tempCell.x + 10, tempCell.y + 10, PieceType.ROOK, PlayerType.WHITE));
						break;
					}
				}
			}
		}
	}
	
	public void render(Graphics g) {
		for (int i = 0; i < 8; i++) {
			for (int x = 0; x < 8; x++) {
				pieces[i][x].render(g);
			}
		}
	}
	
	private void clearHighlights() {
		for (int i = 0; i < 8; i++) {
			for (int x = 0; x < 8; x++) {
				pieces[i][x].highlighted = false;
			}
		}
	}
	
	public void checkForClick(MouseEvent e) {
		if (clicked) {
			int x = e.getX();
			int y = e.getY();
			for (int i = 0; i < 8; i++) {
				for (int z = 0; z < 8; z++) {
					Cell tempCell = pieces[i][z];
					if ((x >= tempCell.x && x <= tempCell.x + 50) && (y >= tempCell.y && y <= tempCell.y + 50)) {
						if (tempCell.highlighted) {
							lastCellSelected.piece.move(tempCell);
							if (Game.turn == 0) Game.turn = 1;
							else Game.turn = 0;
							lastCellSelected.piece = null;
							checkForCheckmate();
							Game.printTurn();
						}
					}
				}
			}
			clicked = false;
			lastCellSelected.selected = false;
			lastCellSelected = null;
			clearHighlights();
		}
		else {
			int x = e.getX();
			int y = e.getY();
			for (int i = 0; i < 8; i++) {
				for (int z = 0; z < 8; z++) {
					Cell tempCell = pieces[i][z];
					if ((x >= tempCell.x && x <= tempCell.x + 50) && (y >= tempCell.y && y <= tempCell.y + 50) && tempCell.piece != null) {
						if (Game.turn == 0) {
							if (tempCell.piece.playerType == PlayerType.WHITE) {
								tempCell.selected = true;
								clicked = true;
								lastCellSelected = tempCell;
								lastCellSelected.piece.getValidMoves(tempCell, this);
							}
						}
						else {
							if (tempCell.piece.playerType == PlayerType.BLACK) {
								tempCell.selected = true;
								clicked = true;
								lastCellSelected = tempCell;
								lastCellSelected.piece.getValidMoves(tempCell, this);
							}
						}
					}
				}
			}
		}
	}
	
	public void checkForCheckmate() {
		Game.whiteKingInCheck = false;
		Game.blackKingInCheck = false;
		for (int i = 0; i < 8; i++) {
			for (int x = 0; x < 8; x++) {
				Cell tempCell = pieces[i][x];
				if (tempCell.piece != null) {
					tempCell.piece.kingInCheck(tempCell, this);
				}
			}
		}
	}
}
