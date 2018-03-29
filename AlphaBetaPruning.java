package mAlphaBeta;

public class AlphaBetaPruning {
	
	public static final int MAX=-1000000;
	public static final int MIN=+1000000;
		
		public AlphaBetaPruning()
		{
			//default constructor
			
		}
		
		public int findValue(int depth,int height,boolean max,int arr[],int index,int alpha ,int beta)
		{
			
			if(depth== height)
				return arr[index];
			
			if(max==true) {
				
				int bestValue = MIN;
				
				for (int i=0; i<2; i++)
		        {
					
					int value=findValue(depth+1,height,false,arr,index*2,alpha,beta);
					bestValue=Math.max(value, bestValue);
					alpha=Math.max(alpha, bestValue);
					
					if(alpha>=beta)
						break;
			
		        }
				return bestValue;
			}	
			
			else if(max==false) {
				
				int bestValue = MAX;
				
				for (int i=0; i<2; i++)
		        {
					
					int value=findValue(depth+1,height,true,arr,index*2,alpha,beta);
					bestValue=Math.min(value, bestValue);
					beta=Math.min(alpha, bestValue);
					
					if(alpha>=beta)
						break;
			
		        }
				return bestValue;
			}
			
			return 0;
		}
		
		public int manageHeight(int n) {
			if(n==1)
				return 0;
			else
				return 1+manageHeight(n/2);
		}
		
		

}
