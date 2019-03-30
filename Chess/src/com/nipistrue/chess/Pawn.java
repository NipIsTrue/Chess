package com.nipistrue.chess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Pawn extends Piece {

	public Pawn(int x, int y, PieceType pieceType, PlayerType playerType) {
		super(x, y, pieceType, playerType);
	}
	
	public void render(Graphics g) {
		if (playerType == PlayerType.WHITE) {
			BufferedImage image = null;
			try {
				image = ImageIO.read(getClass().getResource("/resources/White_Pawn.png"));
				g.drawImage(image, x, y, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			BufferedImage image = null;
			try {
				image = ImageIO.read(getClass().getResource("/resources/Black_Pawn.png"));
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
		
		if (this.playerType == PlayerType.WHITE) {
			if (curY == 6) {
				Cell tempCell = tempBoard[curY - 2][curX];
				tempCell.highlighted = true;
				if (tempCell.piece != null) tempCell.highlighted = false;
				if (tempCell.piece == null && (this.playerType == PlayerType.WHITE && Game.whiteKingInCheck) || (this.playerType == PlayerType.BLACK && Game.blackKingInCheck)) {
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
			
			Cell tempCell = tempBoard[curY - 1][curX];
			tempCell.highlighted = true;
			if (tempCell.piece != null) tempCell.highlighted = false;
			if (tempCell.piece == null && (this.playerType == PlayerType.WHITE && Game.whiteKingInCheck) || (this.playerType == PlayerType.BLACK && Game.blackKingInCheck)) {
				this.move(tempCell); cell.piece = null;
				board.checkForCheckmate();
				if ((this.playerType == PlayerType.WHITE && Game.whiteKingInCheck) || (this.playerType == PlayerType.BLACK && Game.blackKingInCheck)) {
					tempCell.highlighted = false;
				}
				this.move(cell); tempCell.piece = null;
				if (this.playerType == PlayerType.WHITE) Game.whiteKingInCheck = true;
				else Game.blackKingInCheck = true;
			}
			
			if (curX != 0) { 
				tempCell = tempBoard[curY - 1][curX - 1]; 
				if (tempCell.piece != null) {
					if (tempCell.piece.playerType != this.playerType) tempCell.highlighted = true;
				}
				if (tempCell.piece == null && (this.playerType == PlayerType.WHITE && Game.whiteKingInCheck) || (this.playerType == PlayerType.BLACK && Game.blackKingInCheck)) {
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
			
			if (curX != 7) {
				tempCell = tempBoard[curY - 1][curX + 1]; 
				if (tempCell.piece != null) {
					if (tempCell.piece.playerType != this.playerType) tempCell.highlighted = true;
				}
				if (tempCell.piece == null && (this.playerType == PlayerType.WHITE && Game.whiteKingInCheck) || (this.playerType == PlayerType.BLACK && Game.blackKingInCheck)) {
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
		
		else {
			if (curY == 1) {
				Cell tempCell = tempBoard[curY + 2][curX];
				tempCell.highlighted = true;
				if (tempCell.piece != null) tempCell.highlighted = false;
				if (tempCell.piece == null && (this.playerType == PlayerType.WHITE && Game.whiteKingInCheck) || (this.playerType == PlayerType.BLACK && Game.blackKingInCheck)) {
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
			
			Cell tempCell = tempBoard[curY + 1][curX];
			tempCell.highlighted = true;
			if (tempCell.piece != null) tempCell.highlighted = false;
			if (tempCell.piece == null && (this.playerType == PlayerType.WHITE && Game.whiteKingInCheck) || (this.playerType == PlayerType.BLACK && Game.blackKingInCheck)) {
				this.move(tempCell); cell.piece = null;
				board.checkForCheckmate();
				if ((this.playerType == PlayerType.WHITE && Game.whiteKingInCheck) || (this.playerType == PlayerType.BLACK && Game.blackKingInCheck)) {
					tempCell.highlighted = false;
				}
				this.move(cell); tempCell.piece = null;
				if (this.playerType == PlayerType.WHITE) Game.whiteKingInCheck = true;
				else Game.blackKingInCheck = true;
			}
			
			if (curX != 0) {
				tempCell = tempBoard[curY + 1][curX - 1]; 
				if (tempCell.piece != null) {
					if (tempCell.piece.playerType != this.playerType) tempCell.highlighted = true;
				}
				if (tempCell.piece == null && (this.playerType == PlayerType.WHITE && Game.whiteKingInCheck) || (this.playerType == PlayerType.BLACK && Game.blackKingInCheck)) {
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
			
			if (curX != 7) {
				tempCell = tempBoard[curY + 1][curX + 1]; 
				if (tempCell.piece != null) {
					if (tempCell.piece.playerType != this.playerType) tempCell.highlighted = true;
				}
				if (tempCell.piece == null && (this.playerType == PlayerType.WHITE && Game.whiteKingInCheck) || (this.playerType == PlayerType.BLACK && Game.blackKingInCheck)) {
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
	}
	
	@Override
	public void kingInCheck(Cell cell, Board board) {
		Cell[][] tempBoard = board.pieces;
		
		int curX = cell.x / 50;
		int curY = cell.y / 50;
		
		if (this.playerType == PlayerType.WHITE) {
			Cell tempCell;
			if (curX != 0) { 
				tempCell = tempBoard[curY - 1][curX - 1]; 
				if (tempCell.piece != null) {
					if (tempCell.piece.playerType != this.playerType && tempCell.piece.pieceType == PieceType.KING) {
						if (cell.piece.playerType == PlayerType.WHITE) Game.blackKingInCheck = true;
						else Game.whiteKingInCheck = true;
					}
				}
			}
			
			if (curX != 7) {
				tempCell = tempBoard[curY - 1][curX + 1]; 
				if (tempCell.piece != null) {
					if (tempCell.piece.playerType != this.playerType && tempCell.piece.pieceType == PieceType.KING) {
						if (cell.piece.playerType == PlayerType.WHITE) Game.blackKingInCheck = true;
						else Game.whiteKingInCheck = true;
					}
				}
			}
		}
		
		else {
			Cell tempCell;
			if (curX != 0) {
				tempCell = tempBoard[curY + 1][curX - 1]; 
				if (tempCell.piece != null) {
					if (tempCell.piece.playerType != this.playerType && tempCell.piece.pieceType == PieceType.KING) {
						if (cell.piece.playerType == PlayerType.WHITE) Game.blackKingInCheck = true;
						else Game.whiteKingInCheck = true;
					}
				}
			}
			
			if (curX != 7) {
				tempCell = tempBoard[curY + 1][curX + 1]; 
				if (tempCell.piece != null) {
					if (tempCell.piece.playerType != this.playerType && tempCell.piece.pieceType == PieceType.KING) {
						if (cell.piece.playerType == PlayerType.WHITE) Game.blackKingInCheck = true;
						else Game.whiteKingInCheck = true;
					}
				}
			}
		}
	}
}
