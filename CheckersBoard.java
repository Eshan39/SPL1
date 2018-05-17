package mySpl1;

import java.awt.BasicStroke;
import java.awt.Color;
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





public class CheckersBoard extends JPanel implements ActionListener,MouseListener{
	
	int[][] arr=new int[64][3];
	
	int width;
	int height;
	
	int eachRoomHeight;
	int eachRoomWidth;
	public Timer timer;
	public int delay=6;
	private int A=-100,B=-100;
	private int totalpawn1=16,totalpawn2=16;
	
	private boolean click=false;
	private boolean mouse,team1Move=true,team2Move=true;
	public int mouseTemp=0;
	
	int[][] path=new int[64][8];
	
	int[][] bestWay=new int[8][2];
	
	public Sound sound;
	
	public Queue<Integer> queue=new LinkedList<Integer>();
	private boolean Atflag=false,drawLine=false,drawLine2=false;;
	public int temp,sourceX,sourceY,destinationX,destinationY,AX,AY,BX,BY;
	ArrayList<ArrayList<Integer> > multiLineDraw=new  ArrayList<ArrayList<Integer>>();
	public boolean ploy1=true,ploy2=true;
	
	private int counter1=0,counter2=0,counter3=0;
	
	public int apprehendSource,apprehendDestination;
	public int tmp1=0,tmp2=0,tmp3=0,tmp4=0;
	
	
	public CheckersBoard(JFrame frame) {
		
		
		
		sound=new Sound();
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		width = gd.getDisplayMode().getWidth();
		height = gd.getDisplayMode().getHeight();
		
		eachRoomHeight=height/10;
		eachRoomWidth=width/14;
		int index=0;
		for(int i=1;i<9;i++) {
			for(int j=3;j<11;j++) {
				
				arr[index][0]=eachRoomWidth*j;
				arr[index][1]=eachRoomHeight*i;
				
				
						
				index++;
				
			}
			
		}
		
		 index=0;
		
		 for(int j=0;j<8;j++) {
				for(int k=0;k<8;k++) {
			
					if(j % 2 == k % 2&&index<24) arr[index][2]=1;
					else if(j % 2 == k % 2&&index>40) arr[index][2]=2;
					else arr[index][2]=0;
					index++;
				}
			
		}
		
		
		 
		 
		 //making graph
		 
		 for(int i=0;i<64;i++) {
				
				for(int j=0;j<8;j++) {
					
					path[i][j]=-1;
					
				}
			}
		 
		 	int temp=0;
			
			//0
			temp=0;
			
			path[temp][4]=1;
			path[temp][5]=9;
			path[temp][6]=8;
			
			
			

			
			
			//1
			temp=1;
			path[temp][0]=0;
			path[temp][4]=2;
			path[temp][5]=10;
			path[temp][6]=9;
			path[temp][7]=8;
			
			
			
			
			
			
			//2
			temp=2;
			path[temp][0]=1;
			path[temp][4]=3;
			path[temp][5]=11;
			path[temp][6]=10;
			path[temp][7]=9;
			
			
			//3
			temp=3;
			path[temp][0]=2;
			path[temp][4]=4;
			path[temp][5]=12;
			path[temp][6]=11;
			path[temp][7]=10;
			
			
			//4
			temp=4;
			path[temp][0]=3;
			path[temp][4]=5;
			path[temp][5]=13;
			path[temp][6]=12;
			path[temp][7]=11;
			
			
			
			
			//5
			temp=5;
			path[temp][0]=4;
			path[temp][4]=6;
			path[temp][5]=14;
			path[temp][6]=13;
			path[temp][7]=12;
			
			
			
			
			
			//6
			temp=6;
			path[temp][0]=5;
			path[temp][4]=7;
			path[temp][5]=15;
			path[temp][6]=14;
			path[temp][7]=13;
			
			
			
			
			//7
			temp=7;
			path[temp][0]=6;
			path[temp][6]=15;
			path[temp][7]=14;
			
			
			
			
			
			//8
			temp=8;
			
			path[temp][2]=0;
			path[temp][3]=1;
			path[temp][4]=9;
			path[temp][5]=17;
			path[temp][6]=16;
		
			
			
			
			//9
			temp=9;
			path[temp][0]=8;
			path[temp][1]=0;
			path[temp][2]=1;
			path[temp][3]=2;
			path[temp][4]=10;
			path[temp][5]=18;
			path[temp][6]=17;
			path[temp][7]=16;
			
			
			
			
			

			//10
			temp=10;
			path[temp][0]=9;
			path[temp][1]=1;
			path[temp][2]=2;
			path[temp][3]=3;
			path[temp][4]=11;
			path[temp][5]=19;
			path[temp][6]=18;
			path[temp][7]=17;
			
		
			
			
			
			//11
			temp=11;
			path[temp][0]=10;
			path[temp][1]=2;
			path[temp][2]=3;
			path[temp][3]=4;
			path[temp][4]=12;
			path[temp][5]=20;
			path[temp][6]=19;
			path[temp][7]=18;
			
			
			
			
			
			
			
			//12
			temp=12;
			path[temp][0]=11;
			path[temp][1]=3;
			path[temp][2]=4;
			path[temp][3]=5;
			path[temp][4]=13;
			path[temp][5]=21;
			path[temp][6]=20;
			path[temp][7]=19;
			
			
			
			
			//complete
			
			
			
			//13
			temp=13;
			path[temp][0]=12;
			path[temp][1]=4;
			path[temp][2]=5;
			path[temp][3]=6;
			path[temp][4]=14;
			path[temp][5]=22;
			path[temp][6]=21;
			path[temp][7]=20;
			
			
			
			//14
			temp=14;
			path[temp][0]=13;
			path[temp][1]=5;
			path[temp][2]=6;
			path[temp][3]=7;
			path[temp][4]=15;
			path[temp][5]=23;
			path[temp][6]=22;
			path[temp][7]=21;
			
			
			
			
			//15
			temp=15;
			path[temp][0]=14;
			path[temp][1]=6;
			path[temp][2]=7;
			path[temp][6]=23;
			path[temp][7]=22;
			
			
			//16
			temp=16;
			path[temp][2]=8;
			path[temp][3]=9;
			path[temp][4]=17;
			path[temp][5]=25;
			path[temp][6]=24;
		
		
			
			
			
			//17
			temp=17;
			path[temp][0]=16;
			path[temp][1]=8;
			path[temp][2]=9;
			path[temp][3]=10;
			path[temp][4]=18;
			path[temp][5]=26;
			path[temp][6]=25;
			path[temp][7]=24;
			
			
			
			//18
			temp=18;
			path[temp][0]=17;
			path[temp][1]=9;
			path[temp][2]=10;
			path[temp][3]=11;
			path[temp][4]=19;
			path[temp][5]=27;
			path[temp][6]=26;
			path[temp][7]=25;
			

			
			
			
			//19
			temp=19;
			path[temp][0]=18;
			path[temp][1]=10;
			path[temp][2]=11;
			path[temp][3]=12;
			path[temp][4]=20;
			path[temp][5]=28;
			path[temp][6]=27;
			path[temp][7]=26;
			
			
			
			
			//20
			temp=20;
			path[temp][0]=19;
			path[temp][1]=11;
			path[temp][2]=12;
			path[temp][3]=13;
			path[temp][4]=21;
			path[temp][5]=29;
			path[temp][6]=28;
			path[temp][7]=27;
		
			
			
		
			
			//21
			temp=21;
			path[temp][0]=20;
			path[temp][1]=12;
			path[temp][2]=13;
			path[temp][3]=14;
			path[temp][4]=22;
			path[temp][5]=30;
			path[temp][6]=29;
			path[temp][7]=28;
		
			
			
			
			
			//22
			temp=22;
			path[temp][0]=21;
			path[temp][1]=13;
			path[temp][2]=14;
			path[temp][3]=15;
			path[temp][4]=23;
			path[temp][5]=31;
			path[temp][6]=30;
			path[temp][7]=29;
			
			
			//23
			temp=23;
			path[temp][0]=22;
			path[temp][1]=14;
			path[temp][2]=15;
			path[temp][6]=31;
			path[temp][7]=30;
			
			
			
			
			
			//24
			temp=24;
			
			path[temp][2]=16;
			path[temp][3]=17;
			path[temp][4]=25;
			path[temp][5]=33;
			path[temp][6]=32;
			
			
			
			//25
			temp=25;
			path[temp][0]=24;
			path[temp][1]=16;
			path[temp][2]=17;
			path[temp][3]=18;
			path[temp][4]=26;
			path[temp][5]=34;
			path[temp][6]=33;
			path[temp][7]=32;

		
			
			
			
			//26
			temp=26;
			path[temp][0]=25;
			path[temp][1]=17;
			path[temp][2]=18;
			path[temp][3]=19;
			path[temp][4]=27;
			path[temp][5]=35;
			path[temp][6]=34;
			path[temp][7]=33;
			
			
			
			//27
			temp=27;
			path[temp][0]=26;
			path[temp][1]=18;
			path[temp][2]=19;
			path[temp][3]=20;
			path[temp][4]=28;
			path[temp][5]=36;
			path[temp][6]=35;
			path[temp][7]=34;
			
			
			
			//28
			temp=28;
			path[temp][0]=27;
			path[temp][1]=19;
			path[temp][2]=20;
			path[temp][3]=21;
			path[temp][4]=29;
			path[temp][5]=37;
			path[temp][6]=36;
			path[temp][7]=35;
			

			
			
			
			//29
			temp=29;
			path[temp][0]=28;
			path[temp][1]=20;
			path[temp][2]=21;
			path[temp][3]=22;
			path[temp][4]=30;
			path[temp][5]=38;
			path[temp][6]=37;
			path[temp][7]=36;
			
			
			
			//30
			temp=30;
			path[temp][0]=29;
			path[temp][1]=21;
			path[temp][2]=22;
			path[temp][3]=23;
			path[temp][4]=31;
			path[temp][5]=39;
			path[temp][6]=38;
			path[temp][7]=37;
			
			
			
			
		
			//31
			temp=31;
			path[temp][0]=30;
			path[temp][1]=22;
			path[temp][2]=23;
			
			path[temp][6]=39;
			path[temp][7]=38;
			
			
			
			
			//32
			temp=32;
			path[temp][2]=24;
			path[temp][3]=25;
			path[temp][4]=33;
			path[temp][5]=41;
			path[temp][6]=40;
			
			
			
			
			//33
			temp=33;
			path[temp][0]=32;
			path[temp][1]=24;
			path[temp][2]=25;
			path[temp][3]=26;
			path[temp][4]=34;
			path[temp][5]=42;
			path[temp][6]=41;
			path[temp][7]=40;
			
			
			
			
			//34
			temp=34;
			path[temp][0]=33;
			path[temp][1]=25;
			path[temp][2]=26;
			path[temp][3]=27;
			path[temp][4]=35;
			path[temp][5]=43;
			path[temp][6]=42;
			path[temp][7]=41;
			
			
			
			
			//35
			temp=35;
			path[temp][0]=34;
			path[temp][1]=26;
			path[temp][2]=27;
			path[temp][3]=28;
			path[temp][4]=36;
			path[temp][5]=44;
			path[temp][6]=43;
			path[temp][7]=42;
			
			
			
			
			//36
			temp=36;
			path[temp][0]=35;
			path[temp][1]=27;
			path[temp][2]=28;
			path[temp][3]=29;
			path[temp][4]=37;
			path[temp][5]=45;
			path[temp][6]=44;
			path[temp][7]=43;
		
		
			
			//37
			temp=37;
			path[temp][0]=36;
			path[temp][1]=28;
			path[temp][2]=29;
			path[temp][3]=30;
			path[temp][4]=38;
			path[temp][5]=46;
			path[temp][6]=45;
			path[temp][7]=44;
			
			
			//38
			temp=38;
			path[temp][0]=37;
			path[temp][1]=29;
			path[temp][2]=30;
			path[temp][3]=31;
			path[temp][4]=39;
			path[temp][5]=47;
			path[temp][6]=46;
			path[temp][7]=45;
			
			
			//39
			temp=39;
			path[temp][0]=38;
			path[temp][1]=30;
			path[temp][2]=31;
			
			path[temp][6]=47;
			path[temp][7]=46;
			
			
			//40
			temp=40;
			path[temp][2]=32;
			path[temp][3]=33;
			path[temp][4]=41;
			path[temp][5]=49;
			path[temp][6]=48;
		 
			//41
			temp=41;
			path[temp][0]=40;
			path[temp][1]=32;
			path[temp][2]=33;
			path[temp][3]=34;
			path[temp][4]=42;
			path[temp][5]=50;
			path[temp][6]=49;
			path[temp][7]=48;
			
			//42
			temp=42;
			path[temp][0]=41;
			path[temp][1]=33;
			path[temp][2]=34;
			path[temp][3]=35;
			path[temp][4]=43;
			path[temp][5]=51;
			path[temp][6]=50;
			path[temp][7]=49;
			

			//43
			temp=43;
			path[temp][0]=42;
			path[temp][1]=34;
			path[temp][2]=35;
			path[temp][3]=36;
			path[temp][4]=44;
			path[temp][5]=52;
			path[temp][6]=51;
			path[temp][7]=50;
			
			//44
			temp=44;
			path[temp][0]=43;
			path[temp][1]=35;
			path[temp][2]=36;
			path[temp][3]=37;
			path[temp][4]=45;
			path[temp][5]=53;
			path[temp][6]=52;
			path[temp][7]=51;
			
			//45
			temp=45;
			path[temp][0]=44;
			path[temp][1]=36;
			path[temp][2]=37;
			path[temp][3]=38;
			path[temp][4]=46;
			path[temp][5]=54;
			path[temp][6]=53;
			path[temp][7]=52;
			
			//46
			temp=46;
			path[temp][0]=45;
			path[temp][1]=37;
			path[temp][2]=38;
			path[temp][3]=39;
			path[temp][4]=47;
			path[temp][5]=55;
			path[temp][6]=56;
			path[temp][7]=53;
			
			//47
			temp=47;
			path[temp][0]=46;
			path[temp][1]=38;
			path[temp][2]=39;
			
			path[temp][6]=55;
			path[temp][7]=54;
			
			
			
			//48
			temp=48;
			path[temp][2]=40;
			path[temp][3]=41;
			path[temp][4]=49;
			path[temp][5]=57;
			path[temp][6]=56;
			
			
			//49
			temp=49;
			path[temp][0]=48;
			path[temp][1]=40;
			path[temp][2]=41;
			path[temp][3]=42;
			path[temp][4]=50;
			path[temp][5]=58;
			path[temp][6]=57;
			path[temp][7]=56;
			
			
			//50
			temp=50;
			path[temp][0]=49;
			path[temp][1]=41;
			path[temp][2]=42;
			path[temp][3]=43;
			path[temp][4]=51;
			path[temp][5]=59;
			path[temp][6]=58;
			path[temp][7]=57;
			
			//51
			temp=51;
			path[temp][0]=50;
			path[temp][1]=42;
			path[temp][2]=43;
			path[temp][3]=44;
			path[temp][4]=52;
			path[temp][5]=60;
			path[temp][6]=59;
			path[temp][7]=58;
			
			//52
			temp=52;
			path[temp][0]=51;
			path[temp][1]=43;
			path[temp][2]=44;
			path[temp][3]=45;
			path[temp][4]=53;
			path[temp][5]=61;
			path[temp][6]=60;
			path[temp][7]=59;
			
			
			
			//53
			temp=53;
			path[temp][0]=52;
			path[temp][1]=44;
			path[temp][2]=45;
			path[temp][3]=46;
			path[temp][4]=54;
			path[temp][5]=62;
			path[temp][6]=61;
			path[temp][7]=60;
			
			
			
			//54
			temp=54;
			path[temp][0]=53;
			path[temp][1]=45;
			path[temp][2]=46;
			path[temp][3]=47;
			path[temp][4]=55;
			path[temp][5]=63;
			path[temp][6]=62;
			path[temp][7]=61;
			
			
			//55
			temp=55;
			path[temp][0]=54;
			path[temp][1]=46;
			path[temp][2]=47;
			
			path[temp][6]=63;
			path[temp][7]=62;
			
			
			
			//56
			temp=56;
			path[temp][2]=48;
			path[temp][3]=49;
			path[temp][4]=57;
			
			
			
			//57
			temp=57;
			path[temp][0]=56;
			path[temp][1]=48;
			path[temp][2]=49;
			
			path[temp][3]=50;
			path[temp][4]=58;
			
			//58
			temp=58;
			path[temp][0]=57;
			path[temp][1]=49;
			path[temp][2]=50;
			
			path[temp][3]=51;
			path[temp][4]=59;
			
			

			//59
			temp=59;
			path[temp][0]=58;
			path[temp][1]=50;
			path[temp][2]=51;
			
			path[temp][3]=52;
			path[temp][4]=60;
			
			
			
			

			//60
			temp=60;
			path[temp][0]=59;
			path[temp][1]=51;
			path[temp][2]=52;
		
			path[temp][3]=53;
			path[temp][4]=61;
			
			
			

			//61
			temp=61;
			path[temp][0]=60;
			path[temp][1]=52;
			path[temp][2]=53;
		
			path[temp][3]=54;
			path[temp][4]=62;
			

			//62
			temp=62;
			path[temp][0]=61;
			path[temp][1]=53;
			path[temp][2]=54;
		
			path[temp][3]=55;
			path[temp][4]=63;
			
			
			//63
			temp=63;
			path[temp][0]=62;
			path[temp][1]=54;
			path[temp][2]=55;
			
			Random rand=new Random();
			
			for(int i=0;i<64;i++) {
				
				queue.add(rand.nextInt(36));
				
			}
			
			for(int i=0;i<64;i++) {
				
				queue.add(i);
				
			}
			
			
			
			for(int i=0;i<64;i++) {
				
				System.out.print("index: "+i+" value: ");
				for(int j=0;j<8;j++) {
					
					System.out.print(path[i][j]+" ");
					
				}
				System.out.println();
				
				
			}
		
			
			
		 
		 //listener
		
		addMouseListener(this);
		
		timer=new Timer(delay,this);
		timer.start();
		
		
		
	}
	
	
	public void paintComponent(Graphics g) {
		
		
		g.setColor(Color.blue);
		g.fillRect(0, 0, width,height);
		
		
			
		int i=0;
		for(int j=0;j<8;j++) {
			for(int k=0;k<8;k++) {
				
				if ( j % 2 == k % 2 ) {
						
					
		               g.setColor(Color.lightGray);
		               g.fillRect(arr[i][0],arr[i][1],eachRoomWidth , eachRoomHeight);
		              /* 
		               if(board[i][2]>0) {
		            	   if(board[i][2]==1) System.out.println("red "+i);
		            	   if(board[i][2]==2) System.out.println("black "+i);
		               }*/
		               
		               if(arr[i][2]==1) {
		            	   
		            	   g.setColor(Color.red);
		            	   g.fillOval(arr[i][0]+25,arr[i][1]+13, 80, 80);
		               }
		               if(arr[i][2]==2) {
		            	   g.setColor(Color.black);
		            	   g.fillOval(arr[i][0]+25,arr[i][1]+13, 80, 80);
		               }
				}
				
		         else {
		        	 
		        	 g.setColor(Color.gray);
		        	 g.fillRect(arr[i][0],arr[i][1],eachRoomWidth , eachRoomHeight);
		        	 
		         }
				
				
				
				i++;
			}
		}
		
		
		if(click==true) {
			
			Graphics2D g2d=(Graphics2D) g;
			g2d.setStroke(new BasicStroke(6));
			g.setColor(Color.blue);
			g.drawOval(A+25,B+16,80,80);
		}
			
			
			
	}
		
		
		
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		click=true;
		
		
		
		//select
		if(SwingUtilities.isLeftMouseButton(e)) {
			
				int check;
				int x1=e.getX();
				int y1=e.getY();
				for(int i=0;i<63;i++) {
					
					if((x1>=(arr[i][0])&&x1<=arr[i][0]+eachRoomWidth)&&((y1>=(arr[i][1])&&y1<=arr[i][1]+eachRoomHeight))&&arr[i][2]==1&&team1Move==true) {
						
						
						mouseTemp=i;
						
						
						
						/*team2Move=true;
						team1Move=false;
						
						for(int j=0;j<8;j++) {
						
								check=path[mouseTemp][j];
								if(check!=-1&&path[check][j]!=-1) {
								
										if((arr[check][2]==2&&arr[mouseTemp][2]==1&&arr[path[check][j]][2]==0)) {
									
											team1Move=true;
										}
								}
						}*/
								
						A=arr[mouseTemp][0];
						B=arr[mouseTemp][1];
						mouse=true;
						
						sound.makeSound();
						
						
					
					}
					if((x1>=(arr[i][0])&&x1<=arr[i][0]+eachRoomWidth)&&((y1>=(arr[i][1])&&y1<=arr[i][1]+eachRoomHeight))&&arr[i][2]==2&&team2Move==true) {
						
						mouseTemp=i;
						
						
						/*team1Move=true;
						team2Move=false;
						
						for(int j=0;j<8;j++) {
								
								check=path[mouseTemp][j];
								if(check!=-1&&path[check][j]!=-1) {
								
										if((arr[check][2]==1&&arr[mouseTemp][2]==2&&arr[path[check][j]][2]==0)) {
										
											team2Move=true;
										}
								}
						}*/
						
						A=arr[mouseTemp][0];
						B=arr[mouseTemp][1];
						mouse=true;
						
						sound.makeSound();
						
						
					}
					
					
					
				}
			
			
			
		}
		
		
		//move
		
		if(SwingUtilities.isLeftMouseButton(e)&&mouse==true) {
			
				int x2=e.getX();
				int y2=e.getY();
				
				for(int i=0;i<8;i++) {
					
					
					if(path[mouseTemp][i]!=-1) {
						
						
							if((x2>=(arr[path[mouseTemp][i]][0])&&x2<=arr[path[mouseTemp][i]][0]+eachRoomWidth)&&((y2>=(arr[path[mouseTemp][i]][1])&&y2<=arr[path[mouseTemp][i]][1]+eachRoomHeight))
								&&(arr[path[mouseTemp][i]][2]==0&&arr[mouseTemp][2]==1)&&team1Move==true) {
								
								System.out.println("Eshannnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn111");
								
									if(arr[mouseTemp][2]==1) {
										
										arr[path[mouseTemp][i]][2]=1;
										A=arr[path[mouseTemp][i]][0];
										B=arr[path[mouseTemp][i]][1];
										
										Atflag=true;
										
										
									
									}
									
	
									
									
									
									
									
									arr[mouseTemp][2]=0;
									
									//mouse1=true;
									team1Move=false;
									team2Move=true;
									
									mouse=false;
									
									Atflag=true;
									
									sound.makeSound();
									
									
							}
							
							
							if((x2>=(arr[path[mouseTemp][i]][0])&&x2<=arr[path[mouseTemp][i]][0]+eachRoomWidth)&&((y2>=(arr[path[mouseTemp][i]][1])&&y2<=arr[path[mouseTemp][i]][1]+eachRoomHeight))
								&&(arr[path[mouseTemp][i]][2]==0&&arr[mouseTemp][2]==2)&&team2Move==true) {
								
								System.out.println("Eshannnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn222");
									
									if(arr[mouseTemp][2]==2) {
									
										arr[path[mouseTemp][i]][2]=2;
										A=arr[path[mouseTemp][i]][0];
										B=arr[path[mouseTemp][i]][1];
										
										Atflag=true;
										
								
									}
									
									arr[mouseTemp][2]=0;
									
									//mouse1=true;
									team1Move=true;
									team2Move=false;
									mouse=false;
									
									sound.makeSound();
									
									Atflag=true;
									
							}
							
							
							
							
							
							
							int next=path[mouseTemp][i];
							if(path[next][i]!=-1) {
									
									if((x2>=(arr[path[next][i]][0])&&x2<=arr[path[next][i]][0]+eachRoomWidth)&&((y2>=(arr[path[next][i]][1])&&y2<=arr[path[next][i]][1]+eachRoomHeight))
										&&((arr[next][2]==2&&arr[mouseTemp][2]==1&&arr[path[next][i]][2]==0))) {
										
										//System.out.println("mouseTemp:"+mouseTemp+"  "+"next:"+next+" "+"next2:"+path[next][i]);
										if(arr[mouseTemp][2]==1) {
											totalpawn2--;
											arr[path[next][i]][2]=1;
											A=arr[path[next][i]][0];
											B=arr[path[next][i]][1];
											
										}
										
										arr[mouseTemp][2]=0;
										arr[next][2]=0;
										
										team1Move=false;
										team2Move=true;
										mouse=false;
										Atflag=true;
										
										
										int tmp=path[next][i];



			                            for(int t=0;t<8;t++) {

			                                if(path[tmp][t]!=-1) {
			                                    int tmp2=path[tmp][t];
			                                    if(path[tmp2][t]!=-1) {
			                                        if(arr[path[tmp][t]][2]==2&&arr[tmp][2]==1&&arr[path[tmp2][t]][2]==0) {

			                                            team1Move=true;
			                                            team2Move=true;
			                                            Atflag=false;

			                                        }
			                                    }
			                                }


			                            }
			                            
			                            
			                            
			                            sound.makeSound();



										
										
										
									}
									
									
									
									 if((x2>=(arr[path[next][i]][0])&&x2<=arr[path[next][i]][0]+eachRoomWidth)&&((y2>=(arr[path[next][i]][1])&&y2<=arr[path[next][i]][1]+eachRoomHeight))
										&&((arr[next][2]==1&&arr[mouseTemp][2]==2&&arr[path[next][i]][2]==0))) {
											
											//System.out.println("mouseTemp:"+mouseTemp+"  "+"next:"+next+" "+"next2:"+path[next][i]);
											
											if(arr[mouseTemp][2]==2) {
												totalpawn1--;
												arr[path[next][i]][2]=2;
												
												A=arr[path[next][i]][0];
												B=arr[path[next][i]][1];
										
											}
											arr[mouseTemp][2]=0;
											arr[next][2]=0;
											
											team2Move=false;
											team1Move=true;
										
											mouse=false;
											
											
											
											int tmp=path[next][i];



				                            for(int t=0;t<8;t++) {

				                                if(path[tmp][t]!=-1) {
				                                    int tmp2=path[tmp][t];
				                                    if(path[tmp2][t]!=-1) {
				                                        if(arr[path[tmp][t]][2]==1&&arr[tmp][2]==2&&arr[path[tmp2][t]][2]==0) {

				                                            team1Move=true;
				                                            team2Move=true;

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

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		if(Atflag==true) {
			
			ploy1=true;
			ploy2=true;
			
			
			
			
			int count1=0,count2=0,count3=0,count4=0,count5=0,count6=0,count7=0,count8=0;
			
			
			ArrayList<Integer> bestWay[]=new ArrayList[64];
			int[] counter=new int[64];
			
			int[] checkCounter=new int[64];
			
			
			
			
			
			for(int t=0;t<64;t++) {
				
				bestWay[t]=new ArrayList<Integer>();
				
			}
			
			
			if(ploy1==true) {
					for(int i=0;i<64;i++) {
						
						
						if(arr[i][2]==2) {
						
							
						for(int j=0;j<8;j++) {
							
							int[][] Altarr=new int[64][3];
							
							int s=1,temp=0,tempX1=0,tempX2=0,tempX3,lastPosition=-1;
							
							for(int m=0;m<Altarr.length;m++) {
								
								for(int n=0;n<Altarr[0].length;n++) {
									
									Altarr[m][n]=arr[m][n];
									
									
								}
								
							}
							
							tempX1=i;
							
							temp=path[i][j];
							tempX2=temp;
							
							
							if(temp!=-1&&path[temp][j]!=-1) {
							if(path[i][j]!=-1&&Altarr[path[i][j]][2]==1&&Altarr[path[temp][j]][2]==0) {
								
								
								
								 
								 BestWay bestway=new BestWay(tempX1,counter,bestWay,checkCounter);
								
								 bestway.findBestWay(tempX1,Altarr,path); 
								 
								 break;
								 
								 
							}
							
							}
							
						}
								 
								 
						}
					}
					
						
						for(int t=0;t<64;t++) {
					
							System.out.print(checkCounter[t]);
						}
						
						
						 System.out.println(" eat up counter in AI:");
						
								int max=-100,index=0;
								 for(int t=0;t<64;t++) {
								
									 System.out.print(counter[t]);
									 
									
									 
									 if(checkCounter[t]>=max) {
										 
										 max=checkCounter[t];
										 index=t;
									 }
								
								 }
								
								 
								 System.out.println();
								 
								 if(max>=0) {
									 	
									 
									 	max=counter[index];
										 drawLine=true;
										 if(counter1<=250) {
											 
											 counter1++;
											 
											 //System.out.println("best way array size:"+bestWay[index].size());
											 for(int t=0;t<bestWay[index].size();t+=3) {
											
												
												ArrayList<Integer> multiLineXY=new  ArrayList<Integer>();
												int sour=bestWay[index].get(t);
												int dest=bestWay[index].get(t+2);
												
												multiLineXY.add(arr[sour][0]);
												multiLineXY.add(arr[sour][1]);
												
												
												multiLineXY.add(arr[dest][0]);
												multiLineXY.add(arr[dest][1]);
												
												
												multiLineDraw.add(multiLineXY);
												
												ploy1=true;
												ploy2=false;
												
												
												
											}
											
											
										}
										 
										if(counter1>250) {
											
											counter1=0;
												
											 for(int t=0;t<bestWay[index].size();t+=3) {
													
													
												int sour=bestWay[index].get(t);
												int mid=bestWay[index].get(t+1);
												int dest=bestWay[index].get(t+2);
												
												arr[sour][2]=0;
												arr[mid][2]=0;
												arr[dest][2]=2;
												
												
			
												
												team1Move=true;
												team2Move=false;
												mouse=false;
												
												
												
												Atflag=false;
												drawLine=false;
												
												
												ploy2=false;
												
												A=-100;
												B=-100;
												
												
												
												
												totalpawn1--;
												
												multiLineDraw.removeAll(multiLineDraw);
												
												
												  sound.makeSound();
												
												
											 }		
											 
											 System.out.println("bestWay"+bestWay[index]);
											
												
											
									}
								 }
								 else {
									 
									 if(!multiLineDraw.isEmpty()) {
										 multiLineDraw.removeAll(multiLineDraw);
										 
										 
										 	team1Move=true;
											team2Move=false;
											mouse=false;
											
											
											
											ploy1=false;
											ploy2=true;
											drawLine=false;
											
										 
									 }
									 
								 }
						}
								 
								 
						if(ploy2==true) {	
										
										
										System.out.println(counter2+" end sour"+apprehendSource+"dest"+apprehendDestination);
										
										
										
									
										boolean saveflag=true,safePlaceFlag=true,hotspotPointflag=true,otherflag=true;
										
										
										//making object
										BestPawn bestpawn=new BestPawn(arr,path);
										
										MakeFool mf=new MakeFool(arr,path);
										
										Apprehend aprrehend=new Apprehend(arr,path);
										
										
										//SafePosition safeposition=new SafePosition(arr,path);
										
										
										if(bestpawn.saveGuti(counter2)) {
											
											
											counter2++;
											
											drawLine2=true;
											if(counter2<150) {
												
												AX=bestpawn.AX;
												AY=bestpawn.AY;
												BX=bestpawn.BX;
												BY=bestpawn.BY;
											}
											
											if(counter2>151) {
												
												counter2=0;
												
												Atflag=false;
												ploy1=false;
												
												team1Move=true;
												team2Move=false;
												mouse=false;
												
												drawLine2=false;
												
									
												
												System.out.println("helloooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooAZAZ");
											}
											
											
											
											
											
										}
										else if((totalpawn2-totalpawn1)>=2&&aprrehend.toCatch(counter3)) {
											
											
											drawLine2=true;
											
											counter3++;
											
											System.out.println(counter2 +"       AI sour"+apprehendSource+"AI dest"+apprehendDestination);
											
											if(counter3==1) {
												
												AX=arr[aprrehend.source][0];
												AY=arr[aprrehend.source][1];
												BX=arr[aprrehend.destination][0];
												BY=arr[aprrehend.destination][1];
												
												apprehendSource=aprrehend.source;
												apprehendDestination=aprrehend.destination;
												
												
												
												
											}
											
											if(counter3>150) {
												
												
												
												System.out.println(" end sour"+apprehendSource+"dest"+apprehendDestination);
												
												arr[apprehendSource][2]=0;
												arr[apprehendDestination][2]=2;
												
												
												
												counter3=0;
												
												Atflag=false;
												ploy1=false;
												
												team1Move=true;
												team2Move=false;
												mouse=false;
												
												drawLine2=false;
												
											
												
												System.out.println("ApprehendAZAZ");
												
												  sound.makeSound();
												
											}
											
											
										}
										
										else {
											
											
											System.out.println("othersssss");
											
											int o;
											
											boolean flagForNextCheck=true,flagForNextCheck2=true,flagForNextCheck3=true;
											
											B:for(int i=0;i<128;i++) {
												
												
											
											
											
													int element=queue.poll();
													if(arr[element][2]==2) {
														
														/*if((element==16&&(arr[12][2]==1||arr[22][2]==1))||(element==20&&(arr[14][2]==1||arr[24][2]==1))||(element==6&&(arr[7][2]==1||arr[11][2]==1||arr[12][2]==1))||(element==26&&(arr[21][2]==1||arr[27][2]==1||arr[22][2]==1))
																||(element==30&&(arr[29][2]==1||arr[25][2]==1||arr[24][2]==1))||(element==10&&(arr[9][2]==1||arr[14][2]==1||arr[15][2]==1))||((element==10||element==30)&&(arr[20][2]==1))||((element==6||element==26)&&(arr[16][2]==1))
																||(element==8&&(arr[6][2]==1||arr[10][2]==1))||(element==18&&(arr[26][2]==1||arr[30][2]==1))||(element==16&&(arr[10][2]==1||arr[30][2]==1))||(element==20&&(arr[6][2]==1||arr[26][2]==1))) {
															
															
															System.out.println("azzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzd1111111111111111111111111");
															queue.add(element);
															continue;
														}*/
														
															
														
													
													for(int j=0;j<8;j++) {
														
														int s=1,temp=0,tempX1=0,tempX2=0,tempX3;
														
														tempX1=element;
														
														temp=path[element][j];
														tempX2=temp;
														
														
														if(temp!=-1&&path[temp][j]!=-1) {
														if(path[element][j]!=-1&&arr[path[element][j]][2]==0&&arr[path[temp][j]][2]!=-1) {
															
															if(!bestpawn.checkDangerPosition(temp)&&!bestpawn.checkDangerTomove(tempX1)) {
																	
																	
																	counter2++;
																	
																	drawLine2=true;
																	if(counter2==1) {
																		
																		AX=arr[tempX1][0];
																		AY=arr[tempX1][1];
																		BX=arr[tempX2][0];
																		BY=arr[tempX2][1];
																		
																		tmp1=tempX1;
																		tmp2=tempX2;
																		
																		
																		System.out.println(tmp1+" "+tmp2+"wowwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww1");
																		
																	}
																	if(counter2>150) {
																		
																		
																		counter2=0;
																		
																		Atflag=false;
																		ploy1=false;
																	
																		team1Move=true;
																		team2Move=false;
																		mouse=false;
																		
																		drawLine2=false;
																	
																		arr[tmp1][2]=0;
																		arr[tmp2][2]=2;
																		
																	
																	
																		System.out.println(tmp1+" "+tmp2+"wowwwwwwwwwwwwwwwwwwwwwww2");
																		
																		  sound.makeSound();
																		
																	}
																	
																	flagForNextCheck=false;
																	
																	System.out.println("2222222");
																	
																	
																	queue.add(element);
																	
																	break B;
																	
															}
															
															
															
														}
														}
														
													}
													
												}
												queue.add(element);
													
													
												
													
											}
												
										
										
									System.out.println("counter"+counter2+"  "+flagForNextCheck);
									
									
									
										
									if(flagForNextCheck==true) {
										
								
										
										B:for(int i=0;i<126;i++) {
											
												
											
											
											int element=queue.poll();
											if(arr[element][2]==2) {
												
												if((element==16&&(arr[12][2]==1||arr[22][2]==1))||(element==20&&(arr[14][2]==1||arr[24][2]==1))||(element==6&&(arr[7][2]==1||arr[11][2]==1||arr[12][2]==1))||(element==26&&(arr[21][2]==1||arr[27][2]==1||arr[22][2]==1))
														||(element==30&&(arr[29][2]==1||arr[25][2]==1||arr[24][2]==1))||(element==10&&(arr[9][2]==1||arr[14][2]==1||arr[15][2]==1))||((element==10||element==30)&&(arr[20][2]==1))||((element==6||element==26)&&(arr[16][2]==1))
														||(element==8&&(arr[6][2]==1||arr[10][2]==1))||(element==18&&(arr[26][2]==1||arr[30][2]==1))||(element==16&&(arr[10][2]==1||arr[30][2]==1))||(element==20&&(arr[6][2]==1||arr[26][2]==1))) {
													
													
													System.out.println("azzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzd222222222222222222222");
													queue.add(element);
													continue;
												}
											
											for(int j=0;j<8;j++) {
												
												int s=1,temp=0,tempX1=0,tempX2=0,tempX3;
												
												tempX1=element;
												
												temp=path[element][j];
												tempX2=temp;
												
												if(temp!=-1&&path[temp][j]==-1) {
													if(path[element][j]!=-1&&arr[path[element][j]][2]==0) {
														
														if(!bestpawn.checkDangerPosition(temp)&&!bestpawn.checkDangerTomove(tempX1)) {
														
												
												
												
												
															System.out.println("444444");
																	
																	counter2++;
																	
																	drawLine2=true;
																	
																	if(counter2==1) {
																		
																		AX=arr[tempX1][0];
																		AY=arr[tempX1][1];
																		BX=arr[tempX2][0];
																		BY=arr[tempX2][1];
																		
																		tmp1=tempX1;
																		tmp2=tempX2;
																		
																		
																		
																		System.out.println(tmp1+" "+tmp2+"wowwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3");
																		
																	}
																	if(counter2>150) {
																		
																		
																		counter2=0;
																		
																		Atflag=false;
																		ploy1=false;
																	
																		team1Move=true;
																		team2Move=false;
																		mouse=false;
																	
																		
																		drawLine2=false;
																	
																		arr[tmp1][2]=0;
																		arr[tmp2][2]=2;
																		
																		
																	
																		System.out.println(tmp1+" "+tmp2+"wowwwwwwwwwwwwwwwwwwwwwww4");
																		  sound.makeSound();
																		
																	}
																	
															
															
																	queue.add(element);
																	
																	flagForNextCheck2=false;
															
															
																	break B;
													}
													
												}
												}
												
											}
											
											}
											queue.add(element);
											
											
											
										
											
										}
									
										
												
									}
									
									
									if(flagForNextCheck2==true&&flagForNextCheck==true) {
										
									
										
										
										B:for(int i=0;i<126;i++) {
											
												
											
											
											int element=queue.poll();
											if(arr[element][2]==2) {
												
												if((element==16&&(arr[12][2]==1||arr[22][2]==1))||(element==20&&(arr[14][2]==1||arr[24][2]==1))||(element==6&&(arr[7][2]==1||arr[11][2]==1||arr[12][2]==1))||(element==26&&(arr[21][2]==1||arr[27][2]==1||arr[22][2]==1))
														||(element==30&&(arr[29][2]==1||arr[25][2]==1||arr[24][2]==1))||(element==10&&(arr[9][2]==1||arr[14][2]==1||arr[15][2]==1))||((element==10||element==30)&&(arr[20][2]==1))||((element==6||element==26)&&(arr[16][2]==1))
														||(element==8&&(arr[6][2]==1||arr[10][2]==1))||(element==18&&(arr[26][2]==1||arr[30][2]==1))||(element==16&&(arr[10][2]==1||arr[30][2]==1))||(element==20&&(arr[6][2]==1||arr[26][2]==1))) {
													
													
													System.out.println("azzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzd33333333333");
													queue.add(element);
													continue;
												}
											
											for(int j=0;j<8;j++) {
												
												int s=1,temp=0,tempX1=0,tempX2=0,tempX3;
												
												tempX1=element;
												
												temp=path[element][j];
												tempX2=temp;
												
												
												if(temp!=-1&&path[temp][j]!=-1) {
													if(path[element][j]!=-1&&arr[path[element][j]][2]==0&&arr[path[temp][j]][2]!=1) {
														
														if(!bestpawn.checkDangerTomove(element)) {
														
													
															System.out.println("666666");
															
															counter2++;
															
															drawLine2=true;
															
															if(counter2==1) {
																
																AX=arr[tempX1][0];
																AY=arr[tempX1][1];
																BX=arr[tempX2][0];
																BY=arr[tempX2][1];
																
																tmp1=tempX1;
																tmp2=tempX2;
																
																
																
																System.out.println(tmp1+" "+tmp2+"wowwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5");
																
															}
															if(counter2>150) {
																
																
																counter2=0;
																
																Atflag=false;
																ploy1=false;
															
																team1Move=true;
																team2Move=false;
																mouse=false;
																
																drawLine2=false;
															
																arr[tmp1][2]=0;
																arr[tmp2][2]=2;
																
															
															
																System.out.println(tmp1+" "+tmp2+"wowwwwwwwwwwwwwwwwwwwwwww6");
																
																  sound.makeSound();
																
															}
															
													
													
															queue.add(element);
															
															flagForNextCheck3=false;
													
													
															break B;
													}
													
												}
												}
												
											}
											
											}
											queue.add(element);
											
											
											
										
											
										}
									
										
												
									}
											
									
									
									if(flagForNextCheck2==true&&flagForNextCheck==true&&flagForNextCheck3==true) {
										
										
										
										B:for(int i=0;i<126;i++) {
											
												
											
											
											int element=queue.poll();
											if(arr[element][2]==2) {
											
											for(int j=0;j<8;j++) {
												
												int s=1,temp=0,tempX1=0,tempX2=0,tempX3;
												
												tempX1=element;
												
												temp=path[element][j];
												tempX2=temp;
												
												
												if(temp!=-1&&path[temp][j]!=-1) {
												if(path[element][j]!=-1&&arr[path[element][j]][2]==0) {
													
													
													System.out.println("other"+"88888");
															
															counter2++;
															
															drawLine2=true;
															
															if(counter2==1) {
																
																AX=arr[tempX1][0];
																AY=arr[tempX1][1];
																BX=arr[tempX2][0];
																BY=arr[tempX2][1];
																
																tmp1=tempX1;
																tmp2=tempX2;
																
																
																
																System.out.println(tmp1+" "+tmp2+"wowwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7");
																
															}
															if(counter2>150) {
																
																
																counter2=0;
																
																Atflag=false;
																ploy1=false;
															
																team1Move=true;
																team2Move=false;
																mouse=false;
																
																drawLine2=false;
															
																arr[tmp1][2]=0;
																arr[tmp2][2]=2;
																
															
																System.out.println(tmp1+" "+tmp2+"wowwwwwwwwwwwwwwwwwwwwwww8");
																
																
																  sound.makeSound();
																
															}
															
													
													
															queue.add(element);
															
															
													
													
															break B;
													
												}
												}
												
											}
											
											}
											queue.add(element);
											
											
											
										
											
										}
									
										
												
									}
											
									
									
									
									
									
									
									
									
									
									
									
											
											
											
									
										
										
										
									}	
										
									
										
										
										
										
										
										
									}	
									
										
									
									
								
								}
								
									
		
		
		
		repaint();
	}

}
