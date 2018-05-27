package spl1;

import java.util.Queue;

import javax.swing.plaf.synth.SynthStyle;

public class GameTree {
	public boolean team1,team2;
	int[][] path=new int[64][8];
	public int source,destination,index=-10;
	public int currentSource,currentDestination,direction;
	public int controlDoubleployForDestination,controlDoubleployForSource;
	public int callbySource=0,callbyDestination=0;
	public GameTree(int [][] path) {
		this.path=path;
	}
	
	public int minimax(int[][] board, int depth, boolean isMax)
	{
		System.out.println("callbySource: "+callbySource+" callbydestination: "+callbyDestination);	
		int count1=0,count2=0;			
		for(int i=0;i<board.length;i++) {
			if(board[i][2]==1) count1++;
			if(board[i][2]==2) count2++;
		}	
		for(int i=0;i<64;i++) {		
			System.out.print(board[i][2]+" ");
			if((i+1)%8==0)System.out.println();	
		}	
		System.out.println();
		System.out.println(" number of pawn  count1: "+count1+"count2: "+count2);
		if(depth==0) {			
			int evaluate=evaluation(board,path,currentSource,currentDestination,direction);	
			return evaluate;
		}
	    if (isMax)
	    {
	    	int best = -1000;	        
	        System.out.println("teammmmmmmmmmmmmmmmmmmmmmmmmmmmmmm222222222222222222222222222222222222222222222222222222222222222222222");
	        for (int i = 0; i<64; i++)
		    {	
	        	int element=i;
		    	if(board[i][2]==2) {
				   for(int j=0;j<8;j++) {
					   	int s=1,temp=0,tempX1=0,tempX2=0,tempX3;	
					   	tempX1=i;
						temp=path[i][j];
						tempX2=temp;	
						board[i][2]=0;
						FindOptimalPiece bestpawn=new FindOptimalPiece(board,path);	
						if(temp!=-1) {		
							if(board[temp][2]==0) {
						         board[temp][2] = 2;
						         currentSource=i;
						         currentDestination=temp;
						         direction=j;           
						         best = Math.max( best,minimax(board, depth-1, !isMax));
						         board[temp][2]=0;                
							}
						}
						board[i][2]=2;
				    }		                    
	             }
	         }
	        
	        return best;
	    }
	    else {
	    	int best =-1000;   
	    	for (int i = 0; i<64; i++) {
			    int element=i;
			    if(board[i][2]==1) {	
			    	for(int j=0;j<8;j++) {		
						int s=1,temp=0,tempX1=0,tempX2=0,tempX3;			
						tempX1=i;		
						temp=path[i][j];
						tempX2=temp;
						board[i][2]=0;
						FindOptimalPiece bestpawn=new FindOptimalPiece(board,path);
						
						if(temp!=-1) {
							if(board[temp][2]==0) {  
								board[temp][2] = 1;
								currentSource=i;
					            currentDestination=temp;
					            direction=j;		
					            best = Math.max( best, minimax(board, depth-1, !isMax) );
					            System.out.println("best for team 1:  "+best);
					            board[temp][2]=0;
							}																		
						}
						board[i][2]=1;
			    	}
			    }            
		    }
		 return best;
	    }
	}
	
	
	int findBestMove(int[][] arr,int controlDoubleployForSource,int controlDoubleployForDestination)
	{
	   int bestVal = -1000;   
	   int[][] board=new int[64][3];
	   
	   for(int i=0;i<arr.length;i++) {
			for(int j=0;j<3;j++) {
				board[i][j]=arr[i][j];
			}
	   }
	   boolean firstcheck1=false,firstcheck2=false;
	   
	  A:for (int i =0; i<63; i++)
	   {
	    		
	    	int element= i;  //queue.poll();
	    	
	    	if(i==controlDoubleployForDestination) continue A;
	    	
	    	
	    	if(board[element][2]==2) {
	    		
	    			    		
			    	for(int j=7;j>=5;j--) {
						
						int s=1,temp=0,tempX1=0,tempX2=0,tempX3;
						
						tempX1=element;
						
						temp=path[element][j];
						tempX2=temp;
						
						board[element][2]=0;
						FindOptimalPiece bestpawn=new FindOptimalPiece(board,path);
						
						if(temp!=-1) {
							if(board[temp][2]==0&&!bestpawn.checkDangerPosition(temp)&&!bestpawn.checkDangerTomove(element)) {
			            
								
								firstcheck1=true;
			                // Make the move
								board[temp][2] = 2;
								
								
								
								currentSource=i;
			                    currentDestination=temp;
								
			                    callbySource=i;
			                    callbyDestination=temp;
			                    
							System.out.println("callcalllbybbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb by"+element);
			                
			                int moveVal = minimax(board, 1, false);
			                board[temp][2] =0;
			                
			 
			                System.out.println("return valueeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee: "+moveVal);
			              
			                if (moveVal > bestVal)
			                {	
			                	
			                	 System.out.println("checkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk best for move element"+element );
			                	index=element;
			                    bestVal = moveVal;
			                    
			                    source=element;
			                    destination=temp;
			                    		
			                }
			            }
							
					}
				
					board[element][2]=2;			
			    }
	    	}
	    	
	    	//queue.add(element);
	    
	   
	   else if(board[element][2]==3) {
    		
    		
	    	for(int j=7;j>=0;j--) {
				
				int s=1,temp=0,tempX1=0,tempX2=0,tempX3;
				
				tempX1=element;
				
				temp=path[element][j];
				tempX2=temp;
				
				
				
				
				
			
				board[element][2]=0;
				FindOptimalPiece bestpawn=new FindOptimalPiece(board,path);
				
				if(temp!=-1) {
					if(board[temp][2]==0&&!bestpawn.checkDangerPosition(temp)&&!bestpawn.checkDangerTomove(element)) {
	            
						
						firstcheck1=true;
	                // Make the move
						board[temp][2] = 3;
						
						
						
						currentSource=i;
	                    currentDestination=temp;
						
	                    callbySource=i;
	                    callbyDestination=temp;
	                    
					System.out.println("callcalllbybbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb by"+element);
	                
	                int moveVal = minimax(board, 1, false);
	        
	                board[temp][2] =0;
	                
	 
	                System.out.println("return valueeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee: "+moveVal);
	              
	                if (moveVal > bestVal)
	                {	
	                	
	                	 System.out.println("checkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk best for move element"+element );
	                	index=element;
	                    bestVal = moveVal;
	                    
	                    source=element;
	                    destination=temp;
	                    		
	                }
	            }
					
			}
		
			board[element][2]=3;
				
				
				
				
	    }
    	
	}
	
	
}

	    System.out.println("The Optimal Move is   source: "+index+"   desination: "+destination);
	    System.out.println("final max value: "+bestVal); 
	    return index;
	}
	
	
	public int  evaluation(int[][] Altarr,int[][] path,int currentSource,int currentDestination,int direction) {
	
		System.out.println("currentSorce"+currentSource+"dest"+currentDestination);
		int AIscore=0;
		int humanscore=0;
		int[][]  Altarr2=new int[64][3];
		FindOptimalPiece bestpawn=new FindOptimalPiece(Altarr2,path);
		for(int m=0;m<Altarr2.length;m++) {
			for(int n=0;n<Altarr2[0].length;n++) {	
				Altarr2[m][n]=Altarr[m][n];
			}
		}
		
		int count1=0,count2=0,num1=1,num2=1;
		for(int i=0;i<Altarr2.length;i++) {
			if(Altarr2[i][2]==1) count1++;
			if(Altarr2[i][2]==2) count2++;	
		}
		
		MakeFool mk1=new MakeFool(Altarr2,path);
		num1+=mk1.maxForTeam1(Altarr2);
		num2+=mk1.maxForTeam2(Altarr2);
		int AIscore1=0,AIscore2=0,AIscore3=0,AIscore4=0,AIscore5=0,AIscore6=0,humanscore1=0,humanscore2=0,humanscore3=0,humanscore4=0,humanscore5=0;
		for(int i=0;i<64;i++) {
			if(Altarr2[i][2]==2) {	
				if(Altarr2[i][2]==2&&!bestpawn.checkDangerPosition(i)) AIscore5++;
				else {
					humanscore1+=50;	
				}	
			}	
		}
		System.out.println("AI score details: "+" AI1: "+AIscore1+" AI2: "+AIscore2+" AI3: "+AIscore3+" AI4: "+AIscore4+" AI5: "+AIscore5+" AI6 "+AIscore6);
		System.out.println("human score:"+"hum1: "+humanscore1+" hum2: "+humanscore2+" hum3: "+humanscore3+" hum4: "+humanscore4+" hum5: "+humanscore5);
		humanscore=humanscore1+humanscore2+humanscore3+humanscore4+humanscore5;
		AIscore=AIscore1+AIscore2+AIscore3+AIscore4+AIscore5+AIscore6;
		System.out.println("toatal  AI: "+AIscore+" hum: "+humanscore);
		System.out.println("how much gut i can eat team1 "+(num1-1)+"team2 "+(num2-1));
		num1*=5+10;
		num2*=5;
			
		return AIscore*num2-humanscore*(num1);
			
	}

}
