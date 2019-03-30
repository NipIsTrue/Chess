package com.nipistrue.chess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class King extends Piece {

	public King(int x, int y, PieceType pieceType, PlayerType playerType) {
		super(x, y, pieceType, playerType);
	}
	
	public void render(Graphics g) {
		if (playerType == PlayerType.WHITE) {
			BufferedImage image = null;
			try {
				image = ImageIO.read(getClass().getResource("/resources/White_King.png"));
				g.drawImage(image, x, y, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			BufferedImage image = null;
			try {
				image = ImageIO.read(getClass().getResource("/resources/Black_King.png"));
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
		
		int x = curX - 1;
		int y = curY - 1;
		if (x >= 0 && y >= 0) {
			Cell tempCell = tempBoard[y][x];
			tempCell.highlighted = true;
			if (tempCell.piece != null) {
				 if (tempCell.piece.playerType == this.playerType) tempCell.highlighted = false;
			}
			if (tempCell.piece == null && ((this.playerType == PlayerType.WHITE && Game.whiteKingInCheck) || (this.playerType == PlayerType.BLACK && Game.blackKingInCheck))) {
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
			
		x = curX;
		y = curY - 1;
		if (y >= 0) {
			Cell tempCell = tempBoard[y][x];
			tempCell.highlighted = true;
			if (tempCell.piece != null) {
				 if (tempCell.piece.playerType == this.playerType) tempCell.highlighted = false;
			}
			if (tempCell.piece == null && ((this.playerType == PlayerType.WHITE && Game.whiteKingInCheck) || (this.playerType == PlayerType.BLACK && Game.blackKingInCheck))) {
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
		
		x = curX + 1;
		y = curY - 1;
		if (x <= 7 && y >= 0) {
			Cell tempCell = tempBoard[y][x];
			tempCell.highlighted = true;
			if (tempCell.piece != null) {
				 if (tempCell.piece.playerType == this.playerType) tempCell.highlighted = false;
			}
			if (tempCell.piece == null && ((this.playerType == PlayerType.WHITE && Game.whiteKingInCheck) || (this.playerType == PlayerType.BLACK && Game.blackKingInCheck))) {
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
		
		x = curX + 1;
		y = curY;
		if (x <= 7) {
			Cell tempCell = tempBoard[y][x];
			tempCell.highlighted = true;
			if (tempCell.piece != null) {
				 if (tempCell.piece.playerType == this.playerType) tempCell.highlighted = false;
			}
			if (tempCell.piece == null && ((this.playerType == PlayerType.WHITE && Game.whiteKingInCheck) || (this.playerType == PlayerType.BLACK && Game.blackKingInCheck))) {
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
		
		x = curX + 1;
		y = curY + 1;
		if (x <= 7 && y <= 7) {
			Cell tempCell = tempBoard[y][x];
			tempCell.highlighted = true;
			if (tempCell.piece != null) {
				 if (tempCell.piece.playerType == this.playerType) tempCell.highlighted = false;
			}
			if (tempCell.piece == null && ((this.playerType == PlayerType.WHITE && Game.whiteKingInCheck) || (this.playerType == PlayerType.BLACK && Game.blackKingInCheck))) {
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
		
		x = curX;
		y = curY + 1;
		if (y <= 7) {
			Cell tempCell = tempBoard[y][x];
			tempCell.highlighted = true;
			if (tempCell.piece != null) {
				 if (tempCell.piece.playerType == this.playerType) tempCell.highlighted = false;
			}
			if (tempCell.piece == null && ((this.playerType == PlayerType.WHITE && Game.whiteKingInCheck) || (this.playerType == PlayerType.BLACK && Game.blackKingInCheck))) {
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
		
		x = curX - 1;
		y = curY + 1;
		if (x >= 0 && y <= 7) {
			Cell tempCell = tempBoard[y][x];
			tempCell.highlighted = true;
			if (tempCell.piece != null) {
				 if (tempCell.piece.playerType == this.playerType) tempCell.highlighted = false;
			}
			if (tempCell.piece == null && ((this.playerType == PlayerType.WHITE && Game.whiteKingInCheck) || (this.playerType == PlayerType.BLACK && Game.blackKingInCheck))) {
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
		
		x = curX - 1;
		y = curY;
		if (x >= 0) {
			Cell tempCell = tempBoard[y][x];
			tempCell.highlighted = true;
			if (tempCell.piece != null) {
				 if (tempCell.piece.playerType == this.playerType) tempCell.highlighted = false;
			}
			if (tempCell.piece == null && ((this.playerType == PlayerType.WHITE && Game.whiteKingInCheck) || (this.playerType == PlayerType.BLACK && Game.blackKingInCheck))) {
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
		
		int x = curX - 1;
		int y = curY - 1;
		if (x >= 0 && y >= 0) {
			Cell tempCell = tempBoard[y][x];
			if (tempCell.piece != null) {
				if (tempCell.piece.playerType != this.playerType && tempCell.piece.pieceType == PieceType.KING) {
					if (cell.piece.playerType == PlayerType.WHITE) Game.blackKingInCheck = true;
					else Game.whiteKingInCheck = true;
				}
			}
		}
			
		x = curX;
		y = curY - 1;
		if (y >= 0) {
			Cell tempCell = tempBoard[y][x];
			if (tempCell.piece != null) {
				if (tempCell.piece.playerType != this.playerType && tempCell.piece.pieceType == PieceType.KING) {
					if (cell.piece.playerType == PlayerType.WHITE) Game.blackKingInCheck = true;
					else Game.whiteKingInCheck = true;
				}
			}
		}
		
		x = curX + 1;
		y = curY - 1;
		if (x <= 7 && y >= 0) {
			Cell tempCell = tempBoard[y][x];
			if (tempCell.piece != null) {
				if (tempCell.piece.playerType != this.playerType && tempCell.piece.pieceType == PieceType.KING) {
					if (cell.piece.playerType == PlayerType.WHITE) Game.blackKingInCheck = true;
					else Game.whiteKingInCheck = true;
				}
			}
		}
		
		x = curX + 1;
		y = curY;
		if (x <= 7) {
			Cell tempCell = tempBoard[y][x];
			if (tempCell.piece != null) {
				if (tempCell.piece.playerType != this.playerType && tempCell.piece.pieceType == PieceType.KING) {
					if (cell.piece.playerType == PlayerType.WHITE) Game.blackKingInCheck = true;
					else Game.whiteKingInCheck = true;
				}
			}
		}
		
		x = curX + 1;
		y = curY + 1;
		if (x <= 7 && y <= 7) {
			Cell tempCell = tempBoard[y][x];
			if (tempCell.piece != null) {
				if (tempCell.piece.playerType != this.playerType && tempCell.piece.pieceType == PieceType.KING) {
					if (cell.piece.playerType == PlayerType.WHITE) Game.blackKingInCheck = true;
					else Game.whiteKingInCheck = true;
				}
			}
		}
		
		x = curX;
		y = curY + 1;
		if (y <= 7) {
			Cell tempCell = tempBoard[y][x];
			if (tempCell.piece != null) {
				if (tempCell.piece.playerType != this.playerType && tempCell.piece.pieceType == PieceType.KING) {
					if (cell.piece.playerType == PlayerType.WHITE) Game.blackKingInCheck = true;
					else Game.whiteKingInCheck = true;
				}
			}
		}
		
		x = curX - 1;
		y = curY + 1;
		if (x >= 0 && y <= 7) {
			Cell tempCell = tempBoard[y][x];
			if (tempCell.piece != null) {
				if (tempCell.piece.playerType != this.playerType && tempCell.piece.pieceType == PieceType.KING) {
					if (cell.piece.playerType == PlayerType.WHITE) Game.blackKingInCheck = true;
					else Game.whiteKingInCheck = true;
				}
			}
		}
		
		x = curX - 1;
		y = curY;
		if (x >= 0) {
			Cell tempCell = tempBoard[y][x];
			if (tempCell.piece != null) {
				if (tempCell.piece.playerType != this.playerType && tempCell.piece.pieceType == PieceType.KING) {
					if (cell.piece.playerType == PlayerType.WHITE) Game.blackKingInCheck = true;
					else Game.whiteKingInCheck = true;
				}
			}
		}
	}
}
	
	

