package gameSpl;

import java.util.Scanner;

public class Board {

	public static final int SIZE=8;
	public static final int
    			EMPTY = 0,
    			WHITE = 1,
    			WHITE_KING = 2,
    			BLACK = 3,
    			BLACK_KING = 4;

	public int[][] board;
	
	public Board()
	{
		board=new int[SIZE][SIZE];
		
		for(int i=0;i<SIZE;i++)
		{
			for(int j=0;j<SIZE;j++)
			{
				if(i%2==j%2)
				{
					if(i<=2) 
						board[i][j]=WHITE;
					else if(i>=5)
						board[i][j]=BLACK;
					else
						board[i][j]=EMPTY;
				}
				else 
					board[i][j]=EMPTY;
			}
		}
		//board.toString();
		
	}
	
	
	public String toString() {
		
		StringBuilder build = new StringBuilder();
		
		build.append(" Board ");
		
		for (int i = 0; i < SIZE; i++) {
			build.append("	");
		}
		
		build.append("\n");
		
		for (int i = 0; i < SIZE; i++) {
			for (int j = -1; j < SIZE; j++) {
				
				String add = "";
				if (j == -1)
					add = "";
				
				else if (board[i][j] == WHITE)
					add = " w ";
				
				else if (board[i][j] == BLACK)
					add = " b ";
				
				else if (board[i][j] == WHITE_KING)
					add = " W ";
				
				else if (board[i][j] == BLACK_KING)
					add = " B ";
				
				else
					add = " _ ";
				
				build.append(add);
				build.append(" ");
			}
			
			build.append("\n");
		}
		
		return build.toString();
	}
	
	
	
	
	public void move() {
		int turn=1;
		while(turn!=0) {
			
			System.out.println("press 1 for turn Player White");
			System.out.println("press 2 for turn Player Black");
			
			Scanner scr=new Scanner(System.in);
			turn=scr.nextInt();
			
			if(turn==1) {
				
				int temp;
				
				A:for(int i=1;i<board.length-1;i++) {
					
					for(int j=1;j<board[0].length-1;j++) {
						
						//for white right jump
						
						try {
						if(board[i][j]==1 &&board[i+1][j+1]==3&&board[i+2][j+2]==0) {
							
							board[i][j]=0;
							board[i+1][j+1]=0;
							board[i+2][j+2]=1;
							
							System.out.println(toString());
							break A;
						}
						
						//for white left jump
						
						else if(board[i][j]==1 &&board[i+1][j-1]==3&&board[i+2][j-2]==0) {
							
							board[i][j]=0;
							board[i+1][j-1]=0;
							board[i+2][j-2]=1;
							
							System.out.println(toString());
							break A;
						}
						
						
						//for white right move
						
					 	else if(board[i][j]==1 && board[i+1][j+1]==0) {
							
							temp=board[i][j];
							board[i][j]=board[i+1][j+1];
							board[i+1][j-1]=temp;
							
							System.out.println(toString());
							break A;

						}
						
						//for white left move
						
						
						else if(board[i][j]==1 && board[i+1][j-1]==0) {
							
							temp=board[i][j];
							board[i][j]=board[i+1][j-1];
							board[i+1][j-1]=temp;
							
							System.out.println(toString());
							break A;

						}
						}catch(Exception e) {
							
						}
						
						
						
					}
					
					
				}

			}
		
			else if(turn ==2) {
				
				int temp;
				
				A:for(int i=1;i<board.length-1;i++) {
					
					for(int j=1;j<board[0].length-1;j++) {
					 
						try {
						
					 if(board[i][j]==3 &&board[i-1][j+1]==1&&board[i-2][j+2]==0) {
							
							board[i][j]=0;
							board[i-1][j+1]=0;
							board[i-2][j+2]=3;
							
							System.out.println(toString());
							break A;
					}
					 
					 
					 
					 else if(board[i][j]==3 &&board[i-1][j-1]==1&&board[i-2][j-2]==0) {
							
							board[i][j]=0;
							board[i-1][j-1]=0;
							board[i-2][j-2]=3;
							
							System.out.println(toString());
							break A;
					}
						
					 
						
					 else if(board[i][j]==BLACK && board[i-1][j+1]==EMPTY) {
							
							temp=board[i][j];
							board[i][j]=board[i-1][j+1];
							board[i-1][j-1]=temp;
							
							System.out.println(toString());
							break A;

						}
						
						
						
						else if(board[i][j]==3 && board[i-1][j-1]==0) {
							
							temp=board[i][j];
							board[i][j]=board[i-1][j-1];
							board[i-1][j-1]=temp;
							
							System.out.println(toString());
							break A;

						}
						
						}catch(Exception e) {
							
						}
						
					}
					
					
				}

				
			}
		}
	}
		
			
}
