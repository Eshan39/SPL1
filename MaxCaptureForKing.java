package finalSpl;

import java.util.ArrayList;

public class MaxCaptureForKing {
	
	int[][] board=new int[64][3];
	int[][] graph=new int[64][8];
	
	public int source,destination;
	
	public MaxCaptureForKing(int[][] board,int[][] graph) {
		
		this.board=board;
		this.graph=graph;
		
	}
	
	public boolean makeFool() {
		
		System.out.println("start foolllllllllllllllllllllllllllll");
		
		FindOptimalPiece bestpawn=new FindOptimalPiece(board,graph);
		
		B:for(int i=0;i<64;i++) {
			
			
			
			
			int element=i;
			if(board[element][2]==2) {
			
			for(int j=5;j<8;j++) {
				
				
				
				int [][] Altboard=new int [64][3];
				for(int m=0;m<Altboard.length;m++) {
					
					for(int n=0;n<Altboard[0].length;n++) {
						
						Altboard[m][n]=board[m][n];
						
						
					}
					
				}
			
				
				int s=1,temp=0,tempX1=0,tempX2=0,tempX3;
				
				tempX1=element;
				
				temp=graph[element][j];
				tempX2=temp;
				
				
				
				if(temp!=-1&&graph[temp][j]!=-1) {
					if((graph[element][j]!=-1&&Altboard[graph[element][j]][2]==0&&Altboard[graph[temp][j]][2]==1)||(Altboard[graph[element][j]][2]==0&&bestpawn.checkDangerPosition(temp)&&bestpawn.checkDangerTomove(tempX1))) {
					
					
						
						System.out.println("tempX1"+tempX1+"  tempX2"+tempX2+" MAKE FOOLLLLLLLLLLLLLLLLLLLLLLLLLLLLLFOOLLLLLLLLLLLLLLLLL");
						
						Altboard[tempX1][2]=0;
						Altboard[tempX2][2]=2;
						
						if(maxForTeam1Alt(Altboard)==-100) {
							
							return false;
						
						}
						else {
								
								for(int m=0;m<Altboard.length;m++) {
									
									for(int n=0;n<Altboard[0].length;n++) {
										
										Altboard[m][n]=board[m][n];
										
										
									}
									
								}
								
								Altboard[tempX1][2]=0;
								Altboard[tempX2][2]=2;
									
						
								if(maxForTeam1(Altboard)<(maxForTeam2(Altboard)-maxForTeam1(Altboard))) {
									
									source=tempX1;
									destination=tempX2;
									
									System.out.println("end  fool with return true  foolllllllllllllllllllllllllllll");
									
									return true;
									
								}
						}
								
						
						
						
					
					}
				}
			}
			}
			
		}
		
		System.out.println("end with false foolllllllllllllllllllllllllllll");
		
		return false;
		
	}
	
	
	public int maxForTeam1(int [][] Altboard) {
		
		System.out.println("start team1");
		ArrayList<Integer> bestWay2[]=new ArrayList[64];
		int[] counter2=new int[64];
		
		
		for(int t=0;t<64;t++) {
			
			bestWay2[t]=new ArrayList<Integer>();
			
		}
		
		
		
		for(int i=0;i<64;i++) {
			
			
			
			int[][] Altboard2=new int[64][3];
			if(Altboard[i][2]==1) {
			
			for(int j=5;j<8;j++) {
				
				
				int s=1,temp=0,tempX1=0,tempX2=0,tempX3,lastPosition=-1;
				
				for(int m=0;m<Altboard.length;m++) {
					
					for(int n=0;n<Altboard[0].length;n++) {
						
						Altboard2[m][n]=Altboard[m][n];
						
						
					}
					
				}
				
				tempX1=i;
				
				temp=graph[i][j];
				tempX2=temp;
				
				
				if(temp!=-1&&graph[temp][j]!=-1) {
				if(graph[i][j]!=-1&&Altboard2[graph[i][j]][2]==2&&Altboard2[graph[temp][j]][2]==0) {
						 
					HumanJumpMove bestway=new HumanJumpMove(tempX1,counter2,bestWay2);
					bestway.findBestWay(tempX1,Altboard2,graph); 
					break;
				}
				
				}
				
			}
			}
			
			
		}
		
		
		
		System.out.println("newwwww team 1 counter in AI:");
	

		int max1=0,index=0;
		
		 for(int t=0;t<64;t++) {
		
			 
			 
			 if(counter2[t]>=max1) {
				 
				 max1=counter2[t];
				 index=t;
			 }
		
		}
		 
		 
		 for(int t=0;t<bestWay2[index].size();t+=3) {
				
				
				int sour=bestWay2[index].get(t);
				int mid=bestWay2[index].get(t+1);
				int dest=bestWay2[index].get(t+2);
				
				System.out.println("sour"+sour+" mid"+mid+"dest"+dest);
				
				Altboard[sour][2]=0;
				Altboard[mid][2]=0;
				Altboard[dest][2]=1;
		 }
		 
		 
		
		 
		
		 System.out.println("Fool max1: "+max1);
		 
		 System.out.println("end team1");
		 return max1;
		
	}
	
	public int maxForTeam2(int [][] Altboard) {
		
		System.out.println("start team2");
				ArrayList<Integer> bestWay[]=new ArrayList[64];
				int[] counter=new int[64];
				
				int[] checkCounter=new int[64];
				
				for(int t=0;t<64;t++) {
					
					bestWay[t]=new ArrayList<Integer>();
					
				}
				
				
				for(int i=0;i<64;i++) {
					
					
					if(Altboard[i][2]==2) {
					
					for(int j=5;j<8;j++) {
						
						int[][] Altboard2=new int[64][3];
						
						int s=1,temp=0,tempX1=0,tempX2=0,tempX3,lastPosition=-1;
						
						for(int m=0;m<Altboard2.length;m++) {
							
							for(int n=0;n<Altboard2[0].length;n++) {
								
								Altboard2[m][n]=Altboard[m][n];
								
								
							}
							
						}
						
						tempX1=i;
						
						temp=graph[i][j];
						tempX2=temp;
						
						
						if(temp!=-1&&graph[temp][j]!=-1) {
						if(graph[i][j]!=-1&&Altboard[graph[i][j]][2]==1&&Altboard[graph[temp][j]][2]==0) {
							
							
							
							 
							 BlackKingJumpMove bestway=new BlackKingJumpMove(tempX1,counter,bestWay,checkCounter);
							
							 bestway.findBestWay(tempX1,Altboard,graph); 
						}
						
						}
						
					}
					}
				}
				
				System.out.println("newwwww team 2 counter in AI:");
				
				System.out.println();
					
				
					
				int max2=0,index=0;
				for(int t=0;t<64;t++) {
							
					 
								 
								
								 
					 if(counter[t]>=max2) {
									 
							max2=counter[t];
							index=t;
					}
							
				}
				
				
				
				 for(int t=0;t<bestWay[index].size();t+=3) {
						
						
						int sour=bestWay[index].get(t);
						int mid=bestWay[index].get(t+1);
						int dest=bestWay[index].get(t+2);
						
						System.out.println("sour"+sour+" mid"+mid+"dest"+dest);
						
						Altboard[sour][2]=0;
						Altboard[mid][2]=0;
						Altboard[dest][2]=2;
				 }
				 
				
				
				 System.out.println("Fool max2: "+max2);
				 
				 System.out.println("end team2");
				 
				 return max2;
				
				
				
				
				
}
	
	
public int maxForTeam1Alt(int [][] Altboard) {
		
		System.out.println("start team1");
		ArrayList<Integer> bestWay2[]=new ArrayList[64];
		int[] counter2=new int[64];
		
		
		for(int t=0;t<64;t++) {
			bestWay2[t]=new ArrayList<Integer>();
			
		}
		
		
		
		for(int i=0;i<64;i++) {
			
			
			
			int[][] Altboard2=new int[64][3];
			if(Altboard[i][2]==1) {
			
			for(int j=5;j<8;j++) {
				
				
				int s=1,temp=0,tempX1=0,tempX2=0,tempX3,lastPosition=-1;
				
				for(int m=0;m<Altboard.length;m++) {
					for(int n=0;n<Altboard[0].length;n++) {
						Altboard2[m][n]=Altboard[m][n];
					}
					
				}
				
				tempX1=i;
				temp=graph[i][j];
				tempX2=temp;
				
				if(temp!=-1&&graph[temp][j]!=-1) {
					if(graph[i][j]!=-1&&Altboard2[graph[i][j]][2]==2&&Altboard2[graph[temp][j]][2]==0) {			
						
						HumanJumpMove bestway=new HumanJumpMove(tempX1,counter2,bestWay2);
						bestway.findBestWay(tempX1,Altboard2,graph);  
						break;
					}
				
				}
				
			}
			}
			
			
			
			if(counter2[i]>maxForTeam2(Altboard2)) {
				System.out.println("team1Alt return -100");
				return -100;
			}
			
		}
		
		
		
		System.out.println("newwwww team 1 counter in AI:");
		
		int max1=0,index=0;
		
		 for(int t=0;t<64;t++) {	 
			 if(counter2[t]>=max1) {
				 
				 max1=counter2[t];
				 index=t;
			 }
		
		}
		 
		 
		 for(int t=0;t<bestWay2[index].size();t+=3) {
				
				
				int sour=bestWay2[index].get(t);
				int mid=bestWay2[index].get(t+1);
				int dest=bestWay2[index].get(t+2);
				
				System.out.println("sour"+sour+" mid"+mid+"dest"+dest);
				
				Altboard[sour][2]=0;
				Altboard[mid][2]=0;
				Altboard[dest][2]=1;
		 }
		 
		 System.out.println("Fool max1: "+max1);
		
		 return max1;
		
	}
	
}

