package com.nipistrue.chess;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		if (Game.turn == 0) g.drawString("Turn: White", 450, 200);
		else g.drawString("Turn: Black", 450, 200);
		if (Game.whiteKingInCheck) g.drawString("White king in check", 450, 230);
		if (Game.blackKingInCheck) g.drawString("Black king in check", 450, 230);
	}
	
}
