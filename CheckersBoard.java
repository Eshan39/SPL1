package finalSpl;

import java.awt.BasicStroke;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class CheckersBoard extends JPanel implements ActionListener, MouseListener {
	
	public JFrame frame;
	
	public Timer timer;
	public Sound sound;
	
	private boolean AImove = false;
	private int counter1 = 0, counter2 = 0, counter3 = 0;
	
	int[][] board = new int[64][3];
	int[][] graph = new int[64][8];
	
	public int temp, sourceX, sourceY, destinationX, destinationY, AX, AY, BX, BY;
	
	public boolean humanTurn = true, computerTurn = true, isContinue = true;

	Button resignButton;
	Button newGame;
	
	int width, height, eachRoomHeight, eachRoomWidth;
	boolean win = false;
	public  int delay = 6;
	private int numRedPieces = 12, numBlackPieces = 12;
	private boolean click = false;
	private boolean mouse, redMove = true, blackMove = true;
	public int mouseTemp = 0,tmp1,tmp2;
	public int repeatedMoveSource, repeatedMoveDestination = 0;	
	public Queue<Integer>  que= new LinkedList<Integer>();
	
	public CheckersBoard(JFrame frame) {
		
		this.frame=frame;
		
		frame.setVisible(true);
		sound = new Sound();
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		width = gd.getDisplayMode().getWidth();

		height = gd.getDisplayMode().getHeight();
		eachRoomHeight = height / 10;
		eachRoomWidth = width / 14;
		int index = 0;
		for (int i = 1; i < 9; i++) {
			for (int j = 3; j < 11; j++) {
				board[index][0] = eachRoomWidth * j;
				board[index][1] = eachRoomHeight * i;
				index++;
			}
		}
		index = 0;
		for (int j = 0; j < 8; j++) {
			for (int k = 0; k < 8; k++) {

				if (j % 2 == k % 2 && index < 24)
					board[index][2] = 2;
				else if (j % 2 == k % 2 && index > 40)
					board[index][2] = 1;
				else
					board[index][2] = 0;
				index++;
			}
		}

		for (int i = 0; i < 64; i++) {
			for (int j = 0; j < 8; j++) {
				graph[i][j] = -1;
			}
		}

		int temp = 0;

		temp = 0;
		graph[temp][5] = 9;

		temp = 1;
		graph[temp][5] = 10;
		graph[temp][7] = 8;

		temp = 2;
		graph[temp][5] = 11;
		graph[temp][7] = 9;

		temp = 3;
		graph[temp][5] = 12;
		graph[temp][7] = 10;

		temp = 4;
		graph[temp][5] = 13;
		graph[temp][7] = 11;

		temp = 5;
		graph[temp][5] = 14;
		graph[temp][7] = 12;

		temp = 6;
		graph[temp][5] = 15;
		graph[temp][7] = 13;

		temp = 7;
		graph[temp][7] = 14;

		temp = 8;
		graph[temp][3] = 1;
		graph[temp][5] = 17;

		temp = 9;
		graph[temp][1] = 0;
		graph[temp][3] = 2;
		graph[temp][5] = 18;
		graph[temp][7] = 16;

		temp = 10;
		graph[temp][1] = 1;
		graph[temp][3] = 3;
		graph[temp][5] = 19;
		graph[temp][7] = 17;

		temp = 11;
		graph[temp][1] = 2;
		graph[temp][3] = 4;
		graph[temp][5] = 20;
		graph[temp][7] = 18;

		temp = 12;
		graph[temp][1] = 3;
		graph[temp][3] = 5;
		graph[temp][5] = 21;
		graph[temp][7] = 19;

		temp = 13;
		graph[temp][1] = 4;
		graph[temp][3] = 6;
		graph[temp][5] = 22;
		graph[temp][7] = 20;

		temp = 14;
		graph[temp][1] = 5;
		graph[temp][3] = 7;
		graph[temp][5] = 23;
		graph[temp][7] = 21;
		
		temp = 15;
		graph[temp][1] = 6;
		graph[temp][7] = 22;
		
		temp = 16;
		graph[temp][3] = 9;
		graph[temp][5] = 25;

		temp = 17;
		graph[temp][1] = 8;
		graph[temp][3] = 10;
		graph[temp][5] = 26;
		graph[temp][7] = 24;
		
		temp = 18;
		graph[temp][1] = 9;
		graph[temp][3] = 11;
		graph[temp][5] = 27;
		graph[temp][7] = 25;

		temp = 19;
		graph[temp][1] = 10;
		graph[temp][3] = 12;
		graph[temp][5] = 28;
		graph[temp][7] = 26;
		
		temp = 20;
		graph[temp][1] = 11;
		graph[temp][3] = 13;
		graph[temp][5] = 29;
		graph[temp][7] = 27;

		temp = 21;
		graph[temp][1] = 12;
		graph[temp][3] = 14;
		graph[temp][5] = 30;
		graph[temp][7] = 28;

		temp = 22;
		graph[temp][1] = 13;
		graph[temp][3] = 15;
		graph[temp][5] = 31;
		graph[temp][7] = 29;

		temp = 23;
		graph[temp][1] = 14;
		graph[temp][7] = 30;
		
		temp = 24;
		graph[temp][3] = 17;
		graph[temp][5] = 33;

		temp = 25;
		graph[temp][1] = 16;
		graph[temp][3] = 18;
		graph[temp][5] = 34;
		graph[temp][7] = 32;

		temp = 26;
		graph[temp][1] = 17;
		graph[temp][3] = 19;
		graph[temp][5] = 35;
		graph[temp][7] = 33;

		temp = 27;
		graph[temp][1] = 18;
		graph[temp][3] = 20;
		graph[temp][5] = 36;
		graph[temp][7] = 34;
		
		temp = 28;
		graph[temp][1] = 19;
		graph[temp][3] = 21;
		graph[temp][5] = 37;
		graph[temp][7] = 35;

		temp = 29;
		graph[temp][1] = 20;
		graph[temp][3] = 22;
		graph[temp][5] = 38;
		graph[temp][7] = 36;

		temp = 30;
		graph[temp][1] = 21;
		graph[temp][3] = 23;
		graph[temp][5] = 39;
		graph[temp][7] = 37;

		temp = 31;
		graph[temp][1] = 22;
		graph[temp][7] = 38;
		
		temp = 32;
		graph[temp][3] = 25;
		graph[temp][5] = 41;

		temp = 33;
		graph[temp][1] = 24;
		graph[temp][3] = 26;
		graph[temp][5] = 42;
		graph[temp][7] = 40;

		temp = 34;
		graph[temp][1] = 25;
		graph[temp][3] = 27;
		graph[temp][5] = 43;
		graph[temp][7] = 41;

		temp = 35;
		graph[temp][1] = 26;
		graph[temp][3] = 28;
		graph[temp][5] = 44;
		graph[temp][7] = 42;

		temp = 36;
		graph[temp][1] = 27;
		graph[temp][3] = 29;
		graph[temp][5] = 45;
		graph[temp][7] = 43;

		temp = 37;
		graph[temp][1] = 28;
		graph[temp][3] = 30;
		graph[temp][5] = 46;
		graph[temp][7] = 44;

		temp = 38;
		graph[temp][1] = 29;
		graph[temp][3] = 31;
		graph[temp][5] = 47;
		graph[temp][7] = 45;
		
		temp = 39;
		graph[temp][1] = 30;
		graph[temp][7] = 46;

		temp = 40;
		graph[temp][3] = 33;
		graph[temp][5] = 49;
		
		temp = 41;
		graph[temp][1] = 32;
		graph[temp][3] = 34;
		graph[temp][5] = 50;
		graph[temp][7] = 48;

		temp = 42;
		graph[temp][1] = 33;
		graph[temp][3] = 35;
		graph[temp][5] = 51;
		graph[temp][7] = 49;

		temp = 43;
		graph[temp][1] = 34;
		graph[temp][3] = 36;
		graph[temp][5] = 52;
		graph[temp][7] = 50;

		temp = 44;
		graph[temp][1] = 35;
		graph[temp][3] = 37;
		graph[temp][5] = 53;
		graph[temp][7] = 51;

		temp = 45;
		graph[temp][1] = 36;
		graph[temp][3] = 38;
		graph[temp][5] = 54;
		graph[temp][7] = 52;

		temp = 46;
		graph[temp][1] = 37;
		graph[temp][3] = 39;
		graph[temp][5] = 55;
		graph[temp][7] = 53;

		temp = 47;
		graph[temp][1] = 38;
		graph[temp][7] = 54;
		
		temp = 48;
		graph[temp][3] = 41;
		graph[temp][5] = 57;

		temp = 49;
		graph[temp][1] = 40;
		graph[temp][3] = 42;
		graph[temp][5] = 58;
		graph[temp][7] = 56;

		temp = 50;
		graph[temp][1] = 41;
		graph[temp][3] = 43;
		graph[temp][5] = 59;
		graph[temp][7] = 57;

		temp = 51;
		graph[temp][1] = 42;
		graph[temp][3] = 44;
		graph[temp][5] = 60;
		graph[temp][7] = 58;

		temp = 52;
		graph[temp][1] = 43;
		graph[temp][3] = 45;
		graph[temp][5] = 61;
		graph[temp][7] = 59;

		temp = 53;
		graph[temp][1] = 44;
		graph[temp][3] = 46;
		graph[temp][5] = 62;
		graph[temp][7] = 60;

		temp = 54;
		graph[temp][1] = 45;
		graph[temp][3] = 47;
		graph[temp][5] = 63;
		graph[temp][7] = 61;

		temp = 55;
		graph[temp][1] = 46;
		graph[temp][7] = 62;

		temp = 56;
		graph[temp][3] = 49;

		temp = 57;
		graph[temp][1] = 48;
		graph[temp][3] = 50;

		temp = 58;
		graph[temp][1] = 49;
		graph[temp][3] = 51;

		temp = 59;
		graph[temp][1] = 50;
		graph[temp][3] = 52;

		temp = 60;
		graph[temp][1] = 51;
		graph[temp][3] = 53;

		temp = 61;
		graph[temp][1] = 52;
		graph[temp][3] = 54;

		temp = 62;
		graph[temp][1] = 53;
		graph[temp][3] = 55;

		temp = 63;
		graph[temp][1] = 54;

		Random rand = new Random();

		for (int i = 0; i < 64; i++) {
			que.add(rand.nextInt(36));
		}

		for (int i = 0; i < 64; i++) {
			que.add(i);
		}

		for (int i = 0; i < 64; i++) {
			System.out.print("index: " + i + " value: ");
			for (int j = 0; j < 8; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
		addMouseListener(this);

		timer = new Timer(delay, this);
		timer.start();
		
	}
	
	public void paintComponent(Graphics g) {
		
		
		g.setColor(Color.blue);
		g.fillRect(0, 0, width, height);

		int i = 0;
		for (int j = 0; j < 8; j++) {
			for (int k = 0; k < 8; k++) {

				if (j % 2 == k % 2) {

					g.setColor(Color.lightGray);
					g.fillRect(board[i][0], board[i][1], eachRoomWidth, eachRoomHeight);
					/*
					 * if(board[i][2]>0) { if(board[i][2]==1) System.out.println("red "+i);
					 * if(board[i][2]==2) System.out.println("black "+i); }
					 */

					if (board[i][2] == 1) {

						g.setColor(Color.red);
						g.fillOval(board[i][0] + 20, board[i][1] + 13, 50, 50);

					}
					if (board[i][2] == 2) {
						g.setColor(Color.black);
						g.fillOval(board[i][0] + 20, board[i][1] + 13, 50, 50);
					}
					if (board[i][2] == 3) {
						g.setColor(Color.black);
						g.fillOval(board[i][0] + 20, board[i][1] + 13, 50, 50);
						g.setColor(Color.white);
						g.setFont(new Font("serif", Font.BOLD, 28));
						g.drawString("K", board[i][0] + 45, board[i][1] + 38);
					}

					if (board[i][2] == 4) {
						g.setColor(Color.red);
						g.fillOval(board[i][0] + 20, board[i][1] + 13, 50, 50);

						g.setColor(Color.white);
						g.setFont(new Font("serif", Font.BOLD, 28));
						g.drawString("K", board[i][0] + 45, board[i][1] + 38);
					}
				}

				else {

					g.setColor(Color.gray);
					g.fillRect(board[i][0], board[i][1], eachRoomWidth, eachRoomHeight);

				}

				i++;
			}
		}

		g.setColor(Color.black);
		g.setFont(new Font("serif", Font.BOLD, 24));
		g.drawString("Player1 Pieces: " + numRedPieces, 20, 100);
		g.setColor(Color.red);
		g.setFont(new Font("serif", Font.BOLD, 24));
		g.drawString("Player2 Pieces: " + numBlackPieces, 1100, 100);

		if (numRedPieces <= 0) {
			ShowWinner message = new ShowWinner(numBlackPieces, frame);
			isContinue = false;
		} else if (numBlackPieces <= 0) {
			ShowWinner message = new ShowWinner(numRedPieces, frame);
			isContinue = false;

		}
		
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		click = true;

		// select
		if (SwingUtilities.isLeftMouseButton(e)) {

			int check;
			int x1 = e.getX();
			int y1 = e.getY();
			for (int i = 0; i < 64; i++) {

				if ((x1 >= (board[i][0]) && x1 <= board[i][0] + eachRoomWidth)
						&& ((y1 >= (board[i][1]) && y1 <= board[i][1] + eachRoomHeight))
						&& (board[i][2] == 1 || board[i][2] == 4) && redMove == true) {

					mouseTemp = i;
					mouse = true;

					sound.makeSound();

				}
				if ((x1 >= (board[i][0]) && x1 <= board[i][0] + eachRoomWidth)
						&& ((y1 >= (board[i][1]) && y1 <= board[i][1] + eachRoomHeight)) && board[i][2] == 2
						&& blackMove == true) {

					mouseTemp = i;

					mouse = true;

					sound.makeSound();

				}

			}

		}

		// move

		if (SwingUtilities.isLeftMouseButton(e) && mouse == true) {

			int x2 = e.getX();
			int y2 = e.getY();

			if (board[mouseTemp][2] == 1) {
				int y;

				for (int i = 0; i < 5; i++) {

					if (graph[mouseTemp][i] != -1) {

						if ((x2 >= (board[graph[mouseTemp][i]][0]) && x2 <= board[graph[mouseTemp][i]][0] + eachRoomWidth)
								&& ((y2 >= (board[graph[mouseTemp][i]][1])
										&& y2 <= board[graph[mouseTemp][i]][1] + eachRoomHeight))
								&& (board[graph[mouseTemp][i]][2] == 0 && board[mouseTemp][2] == 1) && redMove == true) {

							System.out.println("Eshannnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn111");

							if (board[mouseTemp][2] == 1) {

								if (graph[mouseTemp][i] > 7)
									board[graph[mouseTemp][i]][2] = 1;
								else
									board[graph[mouseTemp][i]][2] = 4;
								

								AImove = true;

							}

							board[mouseTemp][2] = 0;

							// mouse1=true;
							redMove = false;
							blackMove = true;

							mouse = false;

							AImove = true;

							sound.makeSound();

						}

						if ((x2 >= (board[graph[mouseTemp][i]][0]) && x2 <= board[graph[mouseTemp][i]][0] + eachRoomWidth)
								&& ((y2 >= (board[graph[mouseTemp][i]][1])
										&& y2 <= board[graph[mouseTemp][i]][1] + eachRoomHeight))
								&& (board[graph[mouseTemp][i]][2] == 0 && board[mouseTemp][2] == 2) && blackMove == true) {

							System.out.println("Eshannnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn222");

							if (board[mouseTemp][2] == 2) {

								board[graph[mouseTemp][i]][2] = 2;
								

								AImove = true;

							}

							board[mouseTemp][2] = 0;

							// mouse1=true;
							redMove = true;
							blackMove = false;
							mouse = false;
							sound.makeSound();
							AImove = true;

						}

						int next = graph[mouseTemp][i];
						if (graph[next][i] != -1) {

							if ((x2 >= (board[graph[next][i]][0]) && x2 <= board[graph[next][i]][0] + eachRoomWidth)
									&& ((y2 >= (board[graph[next][i]][1]) && y2 <= board[graph[next][i]][1] + eachRoomHeight))
									&& (((board[next][2] == 2 || board[next][2] == 3) && (board[mouseTemp][2] == 1)
											&& board[graph[next][i]][2] == 0))) {
								if (board[mouseTemp][2] == 1) {
									numBlackPieces--;
									if (graph[next][i] > 7)
										board[graph[next][i]][2] = 1;
									else
										board[graph[next][i]][2] = 4;
									
								}

								board[mouseTemp][2] = 0;
								board[next][2] = 0;

								redMove = false;
								blackMove = true;
								mouse = false;
								AImove = true;

								int tmp = graph[next][i];

								for (int t = 0; t < 5; t++) {

									if (graph[tmp][t] != -1) {
										int tmp2 = graph[tmp][t];
										if (graph[tmp2][t] != -1) {
											if ((board[graph[tmp][t]][2] == 2 || board[graph[tmp][t]][2] == 3)
													&& board[tmp][2] == 1 && board[graph[tmp2][t]][2] == 0) {

												redMove = true;
												blackMove = true;
												AImove = false;

											}
										}
									}

								}

								sound.makeSound();

							}

							if ((x2 >= (board[graph[next][i]][0]) && x2 <= board[graph[next][i]][0] + eachRoomWidth)
									&& ((y2 >= (board[graph[next][i]][1]) && y2 <= board[graph[next][i]][1] + eachRoomHeight))
									&& ((board[next][2] == 1 && board[mouseTemp][2] == 2 && board[graph[next][i]][2] == 0))) {

								if (board[mouseTemp][2] == 2) {
									numRedPieces--;
									board[graph[next][i]][2] = 2;

									
								}
								board[mouseTemp][2] = 0;
								board[next][2] = 0;

								blackMove = false;
								redMove = true;

								mouse = false;

								int tmp = graph[next][i];

								for (int t = 0; t < 8; t++) {

									if (graph[tmp][t] != -1) {
										int tmp2 = graph[tmp][t];
										if (graph[tmp2][t] != -1) {
											if (board[graph[tmp][t]][2] == 1 && board[tmp][2] == 2
													&& board[graph[tmp2][t]][2] == 0) {

												redMove = true;
												blackMove = true;

											}
										}
									}

								}

								sound.makeSound();

							}

						}

					}
				}

			} else if (board[mouseTemp][2] == 4) {

				for (int i = 0; i < 8; i++) {

					if (graph[mouseTemp][i] != -1) {

						if ((x2 >= (board[graph[mouseTemp][i]][0]) && x2 <= board[graph[mouseTemp][i]][0] + eachRoomWidth)
								&& ((y2 >= (board[graph[mouseTemp][i]][1])
										&& y2 <= board[graph[mouseTemp][i]][1] + eachRoomHeight))
								&& (board[graph[mouseTemp][i]][2] == 0 && board[mouseTemp][2] == 4) && redMove == true) {

							System.out.println("Eshan111");

							if (board[mouseTemp][2] == 4) {

								board[graph[mouseTemp][i]][2] = 4;
								
								AImove = true;

							}

							board[mouseTemp][2] = 0;
							redMove = false;
							blackMove = true;
							mouse = false;
							AImove = true;
							sound.makeSound();

						}

						if ((x2 >= (board[graph[mouseTemp][i]][0]) && x2 <= board[graph[mouseTemp][i]][0] + eachRoomWidth)
								&& ((y2 >= (board[graph[mouseTemp][i]][1])
										&& y2 <= board[graph[mouseTemp][i]][1] + eachRoomHeight))
								&& (board[graph[mouseTemp][i]][2] == 0 && board[mouseTemp][2] == 2) && blackMove == true) {

							System.out.println("Eshan222");

							if (board[mouseTemp][2] == 2) {

								board[graph[mouseTemp][i]][2] = 2;
								
								AImove = true;

							}

							board[mouseTemp][2] = 0;

							// mouse1=true;
							redMove = true;
							blackMove = false;
							mouse = false;

							sound.makeSound();

							AImove = true;

						}

						int next = graph[mouseTemp][i];
						if (graph[next][i] != -1) {

							if ((x2 >= (board[graph[next][i]][0]) && x2 <= board[graph[next][i]][0] + eachRoomWidth)
									&& ((y2 >= (board[graph[next][i]][1]) && y2 <= board[graph[next][i]][1] + eachRoomHeight))
									&& (((board[next][2] == 2 || board[next][2] == 3) && (board[mouseTemp][2] == 4)
											&& board[graph[next][i]][2] == 0))) {

								// System.out.println("mouseTemp:"+mouseTemp+" "+"next:"+next+"
								// "+"next2:"+graph[next][i]);
								if (board[mouseTemp][2] == 4) {
									numBlackPieces--;

									board[graph[next][i]][2] = 4;
									
								}

								board[mouseTemp][2] = 0;
								board[next][2] = 0;

								redMove = false;
								blackMove = true;
								mouse = false;
								AImove = true;

								int tmp = graph[next][i];

								for (int t = 0; t < 5; t++) {

									if (graph[tmp][t] != -1) {
										int tmp2 = graph[tmp][t];
										if (graph[tmp2][t] != -1) {
											if ((board[graph[tmp][t]][2] == 2 || board[graph[tmp][t]][2] == 3)
													&& board[tmp][2] == 4 && board[graph[tmp2][t]][2] == 0) {

												redMove = true;
												blackMove = true;
												AImove = false;

											}
										}
									}

								}

								sound.makeSound();

							}

							if ((x2 >= (board[graph[next][i]][0]) && x2 <= board[graph[next][i]][0] + eachRoomWidth)
									&& ((y2 >= (board[graph[next][i]][1]) && y2 <= board[graph[next][i]][1] + eachRoomHeight))
									&& ((board[next][2] == 1 && board[mouseTemp][2] == 2 && board[graph[next][i]][2] == 0))) {

								// System.out.println("mouseTemp:"+mouseTemp+" "+"next:"+next+"
								// "+"next2:"+graph[next][i]);

								if (board[mouseTemp][2] == 2) {
									numRedPieces--;
									board[graph[next][i]][2] = 2;

									
								}
								board[mouseTemp][2] = 0;
								board[next][2] = 0;

								blackMove = false;
								redMove = true;

								mouse = false;

								int tmp = graph[next][i];

								for (int t = 0; t < 8; t++) {

									if (graph[tmp][t] != -1) {
										int tmp2 = graph[tmp][t];
										if (graph[tmp2][t] != -1) {
											if (board[graph[tmp][t]][2] == 1 && board[tmp][2] == 2
													&& board[graph[tmp2][t]][2] == 0) {

												redMove = true;
												blackMove = true;

											}
										}
									}

								}

								sound.makeSound();

							}

						}

					}
				}

			}

		}
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		
		
		if (AImove ==true) {

			humanTurn = true;
			computerTurn = true;

			int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0, count7 = 0, count8 = 0;

			ArrayList<Integer> bestWay[] = new ArrayList[64];
			int[] counter = new int[64];

			int[] checkCounter = new int[64];

			for (int t = 0; t < 64; t++) {

				bestWay[t] = new ArrayList<Integer>();

			}

			if (humanTurn == true) {
				for (int i = 0; i < 64; i++) {

					if (board[i][2] == 3) {

						for (int l = 0; l < 64; l++) {

							System.out.print(board[l][2] + " ");
							if ((l + 1) % 8 == 0)
								System.out.println();

						}

						for (int j = 0; j < 8; j++) {

							int[][] Altboard = new int[64][3];

							int s = 1, temp = 0, tempX1 = 0, tempX2 = 0, tempX3, lastPosition = -1;

							for (int m = 0; m < Altboard.length; m++) {

								for (int n = 0; n < Altboard[0].length; n++) {

									Altboard[m][n] = board[m][n];

								}

							}

							tempX1 = i;

							temp = graph[i][j];
							tempX2 = temp;

							if (temp != -1 && graph[temp][j] != -1) {
								if (graph[i][j] != -1 && (Altboard[graph[i][j]][2] == 1 || Altboard[graph[i][j]][2] == 4)
										&& Altboard[graph[temp][j]][2] == 0) {

									BlackKingJumpMove bestway = new BlackKingJumpMove(tempX1, counter, bestWay,
											checkCounter);

									bestway.findBestWay(tempX1, Altboard, graph);

									break;

								}

							}

						}

						// new add

						for (int t = 0; t < 64; t++) {

							System.out.print(checkCounter[t]);
						}

						System.out.println(" eat up counter in AI:");

						int max = -100, index = 0;
						for (int t = 0; t < 64; t++) {

							System.out.print(counter[t]);

							if (checkCounter[t] >= max && board[t][2] == 3) {

								max = checkCounter[t];
								index = t;
							}

						}

						System.out.println();

						if (max >= 0) {

							max = counter[index];

							if (counter1 <= 250) {

								counter1++;
								System.out.println("eat for king only ");

								for (int l = 0; l < 64; l++) {

									System.out.print(board[l][2] + " ");
									if ((l + 1) % 8 == 0)
										System.out.println();

								}

								// System.out.println("best way boarday size:"+bestWay[index].size());
								for (int t = 0; t < bestWay[index].size(); t += 3) {

									ArrayList<Integer> multiLineXY = new ArrayList<Integer>();
									int sour = bestWay[index].get(t);
									int dest = bestWay[index].get(t + 2);

									multiLineXY.add(board[sour][0]);
									multiLineXY.add(board[sour][1]);

									multiLineXY.add(board[dest][0]);
									multiLineXY.add(board[dest][1]);

									humanTurn = true;
									computerTurn = false;

								}

							}

							if (counter1 > 250) {

								counter1 = 0;

								for (int t = 0; t < bestWay[index].size(); t += 3) {

									int sour = bestWay[index].get(t);
									int mid = bestWay[index].get(t + 1);
									int dest = bestWay[index].get(t + 2);

									board[sour][2] = 0;
									board[mid][2] = 0;
									board[dest][2] = 3;

									redMove = true;
									blackMove = false;
									mouse = false;
									AImove = false;
									computerTurn = false;

									numRedPieces--;

									sound.makeSound();

								}

								System.out.println("bestWay for king" + bestWay[index]);

							}
						}

					}

					else if (board[i][2] == 2) {
						for (int j = 5; j < 8; j++) {
							int s = 1, temp = 0, tempX1 = 0, tempX2 = 0, tempX3, lastPosition = -1;
							int[][] Altboard = new int[64][3];

							for (int m = 0; m < Altboard.length; m++) {
								for (int n = 0; n < Altboard[0].length; n++) {
									Altboard[m][n] = board[m][n];
								}
							}

							tempX1 = i;

							temp = graph[i][j];
							tempX2 = temp;

							if (temp != -1 && graph[temp][j] != -1) {
								if (graph[i][j] != -1 && (Altboard[graph[i][j]][2] == 1 || Altboard[graph[i][j]][2] == 4)
										&& Altboard[graph[temp][j]][2] == 0) {
									
									BlackJumpMove bestway = new BlackJumpMove(tempX1, counter, bestWay, checkCounter);
									bestway.findBestWay(tempX1, Altboard, graph);
									break;
								}
							}
						}

						for (int t = 0; t < 64; t++) {
							System.out.print(checkCounter[t]);
						}
						System.out.println(" eat up counter in AI:");
						int max = -100, index = 0;
						for (int t = 0; t < 64; t++) {
							System.out.print(counter[t]);
							if (checkCounter[t] >= max && board[t][2] == 2) {
								max = checkCounter[t];
								index = t;
							}
						}
						System.out.println();

						if (max >= 0) {

							System.out.println("eat for normal only ");

							for (int m = 0; m < 64; m++) {

								System.out.print(board[m][2] + " ");
								if ((m + 1) % 8 == 0)
									System.out.println();

							}

							max = counter[index];

							if (counter1 <= 250) {

								counter1++;

								// System.out.println("best way boarday size:"+bestWay[index].size());
								for (int t = 0; t < bestWay[index].size(); t += 3) {

									ArrayList<Integer> multiLineXY = new ArrayList<Integer>();
									int sour = bestWay[index].get(t);
									int dest = bestWay[index].get(t + 2);

									multiLineXY.add(board[sour][0]);
									multiLineXY.add(board[sour][1]);

									multiLineXY.add(board[dest][0]);
									multiLineXY.add(board[dest][1]);

									humanTurn = true;
									computerTurn = false;

								}

							}

							if (counter1 > 250) {

								counter1 = 0;

								for (int t = 0; t < bestWay[index].size(); t += 3) {

									int sour = bestWay[index].get(t);
									int mid = bestWay[index].get(t + 1);
									int dest = bestWay[index].get(t + 2);

									board[sour][2] = 0;
									board[mid][2] = 0;
									if (dest >= 56)
										board[dest][2] = 3;
									else
										board[dest][2] = 2;

									redMove = true;
									blackMove = false;
									mouse = false;

									AImove = false;

									computerTurn = false;

									numRedPieces--;

									sound.makeSound();

								}

								System.out.println("bestWay normal" + bestWay[index]);

							}
						}

					}

				}
				
				System.out.println("hellooooooooooooooooooooooooooooooo");

			}

			if (computerTurn == true) {
				boolean saveflag = true, safePlaceFlag = true, hotspotPointflag = true, otherflag = true;

				FindOptimalPiece bestpawn = new FindOptimalPiece(board, graph);
				
				GameTree m = new GameTree(graph);
				if (bestpawn.saveGuti(counter2)) {
					counter2++;
					if (counter2 < 150) {
						AX = bestpawn.AX;
						AY = bestpawn.AY;
						BX = bestpawn.BX;
						BY = bestpawn.BY;
					}

					if (counter2 > 151) {
						counter2 = 0;
						AImove = false;
						humanTurn = false;
						redMove = true;
						blackMove = false;
						mouse = false;

						System.out.println("helloooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooAZAZ");
					}
				}

				else if (numBlackPieces > 0&& m.findBestMove(board, repeatedMoveSource, repeatedMoveDestination) > -1) {

					counter2++;

					AX = board[m.source][0];
					AY = board[m.source][1];
					BX = board[m.destination][0];
					BY = board[m.destination][1];

					counter2 = 0;

					repeatedMoveSource = m.source;
					repeatedMoveDestination = m.destination;

					if (board[m.source][2] == 3)
						board[m.destination][2] = board[m.source][2];
					else if (m.destination > 55 && m.destination <= 63)
						board[m.destination][2] = 3;
					else
						board[m.destination][2] = 2;

					board[m.source][2] = 0;

					AImove = false;
					humanTurn = false;

					redMove = true;
					blackMove = false;
					mouse = false;

					System.out.println("helloooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooAZAZ");

				}
				else if (numBlackPieces > 0) {

					System.out.println("othersssss");

					boolean flagForNextCheck = true, flagForNextCheck2 = true, flagForNextCheck3 = true;

					B: for (int i = 0; i < 64; i++) {
						int element = i;
						if (board[element][2] == 2) {

							for (int j = 5; j < 8; j++) {
								int s = 1, temp = 0, tempX1 = 0, tempX2 = 0, tempX3;
				
								tempX1 = element;

								temp = graph[element][j];
								tempX2 = temp;

								if (temp != -1 && graph[temp][j] != -1) {
									if (graph[element][j] != -1 && board[graph[element][j]][2] ==0) {

											counter2++;

											if (counter2 == 1) {
												AX = board[tempX1][0];
												AY = board[tempX1][1];
												BX = board[tempX2][0];
												BY = board[tempX2][1];

												tmp1 = tempX1;
												tmp2 = tempX2;

												System.out.println(tmp1 +"value "+board[tmp1][2]+ " " + tmp2+" value "+board[tmp2][2]
														+ "wowwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww1");

											}
											if (counter2 > 150) {

												counter2 = 0;
												AImove = false;
												humanTurn = false;
												redMove = true;
												blackMove = false;
												mouse = false;

												board[tmp1][2] = 0;

												if (board[tmp1][2] == 3) {

													System.out.println("source 3");
													board[tmp2][2] = board[tmp1][2];

												} else if (tmp2 > 55 && tmp2 < 64) {
													board[tmp2][2] = 3;
													System.out.println("destination 55 and 63");

												} else {
													board[tmp2][2] = 2;
													System.out.println("normal");
												}

												System.out.println(tmp1 + " " + tmp2 + "wowwwwwwwwwwwwwwwwwwwwwww2");

												sound.makeSound();

											}

											flagForNextCheck = false;

											System.out.println("2222222");

											break B;

										}

									}
								
							}
						}
					
					else if (board[element][2] == 3) {

						for (int j = 0; j < 8; j++) {

							int s = 1, temp = 0, tempX1 = 0, tempX2 = 0, tempX3;

							tempX1 = element;

							temp = graph[element][j];
							tempX2 = temp;

							if (temp != -1 && graph[temp][j] != -1) {
								if (graph[element][j] != -1 && board[graph[element][j]][2] == 0
										&& (board[graph[temp][j]][2] != 1 || board[graph[temp][j]][2] != 4)) {

									if (!bestpawn.checkDangerPosition(temp)
											&& !bestpawn.checkDangerTomove(tempX1)) {

										counter2++;

										if (counter2 == 1) {

											AX = board[tempX1][0];
											AY = board[tempX1][1];
											BX = board[tempX2][0];
											BY = board[tempX2][1];

											tmp1 = tempX1;
											tmp2 = tempX2;

											System.out.println(tmp1 + " " + tmp2
													+ "wowwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww1");

										}
										if (counter2 > 150) {

											counter2 = 0;

											AImove = false;
											humanTurn = false;
											redMove = true;
											blackMove = false;
											mouse = false;

											board[tmp1][2] = 0;
											board[tmp2][2] = 3;

											System.out.println(tmp1 + " " + tmp2 + "wowwwwwwwwwwwwwwwwwwwwwww2");

											sound.makeSound();

										}

										flagForNextCheck = false;

										System.out.println("2222222");

										

										break B;

									}

								}
							}

						}

					}
				

				}
				/*if(flagForNextCheck = true) {
					
					ShowWinner message = new ShowWinner(numBlackPieces, frame);
					isContinue = false;
						
						
				}*/
				}
			}
		}
		
		if(isContinue==true) repaint();
				
	}
}
