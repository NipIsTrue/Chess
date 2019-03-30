package com.nipistrue.chess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Rook extends Piece {

	public Rook(int x, int y, PieceType pieceType, PlayerType playerType) {
		super(x, y, pieceType, playerType);
	}
	
	public void render(Graphics g) {
		if (playerType == PlayerType.WHITE) {
			BufferedImage image = null;
			try {
				image = ImageIO.read(getClass().getResource("/resources/White_Rook.png"));
				g.drawImage(image, x, y, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			BufferedImage image = null;
			try {
				image = ImageIO.read(getClass().getResource("/resources/Black_Rook.png"));
				g.drawImage(image, x, y, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void getValidMoves(Cell cell, Board board) {
		Cell[][] tempBoard = board.pieces;
		int curX = cell.x / 50;
		int curY = cell.y / 50;
		for (int y = curY - 1; y >= 0; y--) {
			Cell tempCell = tempBoard[y][curX];
			tempCell.highlighted = true;
			if (tempCell.piece != null) {
				if (tempCell.piece.playerType == this.playerType) tempCell.highlighted = false;
				break;
			}
			if ((this.playerType == PlayerType.WHITE && Game.whiteKingInCheck) || (this.playerType == PlayerType.BLACK && Game.blackKingInCheck)) {
				this.move(tempCell); cell.piece = null;
				board.checkForCheckmate();
				if ((this.playerType == PlayerType.WHITE && Game.whiteKingInCheck) || (this.playerType == PlayerType.BLACK && Game.blackKingInCheck)) {
					tempCell.highlighted = false;
				}
				this.move(cell); tempCell.piece = null;
				if (this.playerType == PlayerType.WHITE) Game.whiteKingInCheck = true;
				else Game.blackKingInCheck = true;
			} 
		}
		for (int x = curX + 1; x <= 7; x++) {
			Cell tempCell = tempBoard[curY][x];
			tempCell.highlighted = true;
			if (tempCell.piece != null) {
				if (tempCell.piece.playerType == this.playerType) tempCell.highlighted = false;
				break;
			}
			if ((this.playerType == PlayerType.WHITE && Game.whiteKingInCheck) || (this.playerType == PlayerType.BLACK && Game.blackKingInCheck)) {
				this.move(tempCell); cell.piece = null;
				board.checkForCheckmate();
				if ((this.playerType == PlayerType.WHITE && Game.whiteKingInCheck) || (this.playerType == PlayerType.BLACK && Game.blackKingInCheck)) {
					tempCell.highlighted = false;
				}
				this.move(cell); tempCell.piece = null;
				if (this.playerType == PlayerType.WHITE) Game.whiteKingInCheck = true;
				else Game.blackKingInCheck = true;
			}
		}
		for (int y = curY + 1; y <=7; y++) {
			Cell tempCell = tempBoard[y][curX];
			tempCell.highlighted = true;
			if (tempCell.piece != null) {
				if (tempCell.piece.playerType == this.playerType) tempCell.highlighted = false;
				break;
			}
			if ((this.playerType == PlayerType.WHITE && Game.whiteKingInCheck) || (this.playerType == PlayerType.BLACK && Game.blackKingInCheck)) {
				this.move(tempCell); cell.piece = null;
				board.checkForCheckmate();
				if ((this.playerType == PlayerType.WHITE && Game.whiteKingInCheck) || (this.playerType == PlayerType.BLACK && Game.blackKingInCheck)) {
					tempCell.highlighted = false;
				}
				this.move(cell); tempCell.piece = null;
				if (this.playerType == PlayerType.WHITE) Game.whiteKingInCheck = true;
				else Game.blackKingInCheck = true;
			} 
		}
		for (int x = curX - 1; x >= 0; x--) {
			Cell tempCell = tempBoard[curY][x];
			tempCell.highlighted = true;
			if (tempCell.piece != null) {
				if (tempCell.piece.playerType == this.playerType) tempCell.highlighted = false;
				break;
			}
			if ((this.playerType == PlayerType.WHITE && Game.whiteKingInCheck) || (this.playerType == PlayerType.BLACK && Game.blackKingInCheck)) {
				this.move(tempCell); cell.piece = null;
				board.checkForCheckmate();
				if ((this.playerType == PlayerType.WHITE && Game.whiteKingInCheck) || (this.playerType == PlayerType.BLACK && Game.blackKingInCheck)) {
					tempCell.highlighted = false;
				}
				this.move(cell); tempCell.piece = null;
				if (this.playerType == PlayerType.WHITE) Game.whiteKingInCheck = true;
				else Game.blackKingInCheck = true;
			} 
		}
	}
	
	@Override
	public void kingInCheck(Cell cell, Board board) {
		Cell[][] tempBoard = board.pieces;
		int curX = cell.x / 50;
		int curY = cell.y / 50;
		for (int y = curY - 1; y >= 0; y--) {
			Cell tempCell = tempBoard[y][curX];
			if (tempCell.piece != null) {
				if (tempCell.piece.playerType != this.playerType && tempCell.piece.pieceType == PieceType.KING) {
					if (cell.piece.playerType == PlayerType.WHITE) Game.blackKingInCheck = true;
					else Game.whiteKingInCheck = true;
				}
				break;
			}
		}
		for (int x = curX + 1; x <= 7; x++) {
			Cell tempCell = tempBoard[curY][x];
			if (tempCell.piece != null) {
				if (tempCell.piece.playerType != this.playerType && tempCell.piece.pieceType == PieceType.KING) {
					if (cell.piece.playerType == PlayerType.WHITE) Game.blackKingInCheck = true;
					else Game.whiteKingInCheck = true;
				}
				break;
			}
		}
		for (int y = curY + 1; y <=7; y++) {
			Cell tempCell = tempBoard[y][curX];
			if (tempCell.piece != null) {
				if (tempCell.piece.playerType != this.playerType && tempCell.piece.pieceType == PieceType.KING) {
					if (cell.piece.playerType == PlayerType.WHITE) Game.blackKingInCheck = true;
					else Game.whiteKingInCheck = true;
				}
				break;
			}
		}
		for (int x = curX - 1; x >= 0; x--) {
			Cell tempCell = tempBoard[curY][x];
			if (tempCell.piece != null) {
				if (tempCell.piece.playerType != this.playerType && tempCell.piece.pieceType == PieceType.KING) {
					if (cell.piece.playerType == PlayerType.WHITE) Game.blackKingInCheck = true;
					else Game.whiteKingInCheck = true;
				}
				break;
			}
		}
	}
}
