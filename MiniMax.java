package algorithm;

public class MiniMax {
	
	public MiniMax()
	{
		
	}
	
	public int findValue(int depth,int height,boolean max,int arr[],int index)
	{
		if(depth== height)
			return arr[index];
		
		if(max==true) {
			
			return Math.max(findValue(depth+1,height,false,arr,index*2), findValue(depth+1,height,false,arr,index*2+1));
		}
		
		else if(max==false) {
			
			return Math.min(findValue(depth+1,height,true,arr,index*2), findValue(depth+1,height,true,arr,index*2+1));
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
