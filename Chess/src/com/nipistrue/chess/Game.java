package com.nipistrue.chess;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = -144290838274381340L;
	
	public static final int WIDTH = 600, HEIGHT = 430;
	private Thread thread;
	private boolean running;
	public Board board;
	public static int turn = 0;
	public static boolean whiteKingInCheck = false;
	public static boolean blackKingInCheck = false;
	private HUD hud;
	
	public static void main(String[] args) {
		new Game();
	}

	public Game() {
		board = new Board();
		hud = new HUD();
		new Window(WIDTH, HEIGHT, "Chess", this);
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				board.checkForClick(e);
			}
		});
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running) {
				render();
				frames++;
			}
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frames = 0;
			}
		}
		
		stop();
	}
	
	public void tick() {
		
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0,  0, WIDTH,  HEIGHT);
		g.setColor(Color.white);
		g.drawRect(0, 0, 400, 400);
		
		board.render(g);
		hud.render(g);
		
		g.dispose();
		bs.show();
	}
	
	public static void printTurn() {
		if (turn == 0) System.out.println("White's turn");
		else System.out.println("Black's turn:");
	}
	
}