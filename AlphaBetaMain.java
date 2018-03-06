package mAlphaBeta;

import java.util.Scanner;

import algorithm.MiniMax;

public class AlphaBetaMain {
	public static final int MAX=-1000000;
	public static final int MIN=+1000000;

	public static void main(String[] args) {

		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter number of node");

        int n=sc.nextInt();

        int arr[]=new int[n];

        System.out.println("enter node");

        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();

        }
//		int arr[]= {3 5 2 9 12 5 23 23};
//      here max value according to minimax is 12
        MiniMax mn= new MiniMax();
        int height=mn.manageHeight(n);
        
        System.out.print("Print: ");
        System.out.println(mn.findValue(0, height, true, arr, 0));

	}

}
