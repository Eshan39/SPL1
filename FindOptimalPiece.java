package spl1;

public class FindOptimalPiece {
	
	int[][] arr=new int[64][3];
	int[][] path=new int[64][8];
	public int AX,AY,BX,BY;
	
	public FindOptimalPiece(int[][] arr,int[][] path) {
		this.arr=arr;
		this.path=path;
	}
	
	public boolean saveGuti(int counter2) {
		for(int i=0;i<64;i++) {
			if(arr[i][2]==3) {	
				for(int j=0;j<8;j++) {
					if(j<4) {
					boolean flag1=true;
						if(path[i][j]!=-1&&path[i][j+4]!=-1) {
							if(arr[path[i][j]][2]==0&&arr[path[i][j+4]][2]==1||arr[path[i][j+4]][2]==0&&arr[path[i][j]][2]==1) {
								if(arr[path[i][j]][2]==0) {
									if(checkDangerPosition(path[i][j],j)) {
									}
									else {
										int temp=path[i][j];
										for(int t=0;t<8;t++) {
											if(path[temp][t]!=-1) {
												if(arr[path[temp][t]][2]==3) {
													if(checkDangerTomove(path[temp][t])) {
													}
													else{
														int[][] Altarr=new int[64][3];
														for(int m=0;m<Altarr.length;m++) {
															for(int n=0;n<Altarr[0].length;n++){
																Altarr[m][n]=arr[m][n];
															}
														}
														MakeFool mf=new MakeFool(Altarr,path);
														
														
														int num1=mf.maxForTeam1(Altarr);
														
														
														for(int m=0;m<Altarr.length;m++) {
															
															for(int n=0;n<Altarr[0].length;n++) {
																
																Altarr[m][n]=arr[m][n];
																
																
															}
															
														}
														
														Altarr[path[i][j]][2]=3;
														Altarr[path[temp][t]][2]=0;
														
														int num2=mf.maxForTeam1(Altarr);
														
														System.out.println("method  save guti  num1"+num1+"num2"+num2);
														if(num2<num1) {
														
														
														
														
														
																flag1=false;
																if(counter2<150) {
																	
																	AX=arr[path[i][j]][0];
																	AY=arr[path[i][j]][1];
																	BX=arr[path[temp][t]][0];
																	BY=arr[path[temp][t]][1];
																	
																	System.out.println("azaz 1");
																	
																}
																if(counter2>150) {
																arr[path[i][j]][2]=3;
																
																arr[path[temp][t]][2]=0;
																	
																	System.out.println("azaz 2");
																	
																}
																
																return true;
														}
													}
													
												}
												
												
											}
											
										}
										
									}
									
									if(flag1==true) {
										
										for(int t=0;t<8;t++) {
											
											if(path[i][t]!=-1) {
											if(arr[path[i][t]][2]==0) {
												if(!checkDangerPosition(path[i][t],t)) {
													
													
													//new add
													
													int[][] Altarr=new int[64][3];
													
													
													
													for(int m=0;m<Altarr.length;m++) {
														
														for(int n=0;n<Altarr[0].length;n++) {
															
															Altarr[m][n]=arr[m][n];
															
															
														}
														
													}
													
													MakeFool mf=new MakeFool(Altarr,path);
													
													int num1=mf.maxForTeam1(Altarr);
													
													for(int m=0;m<Altarr.length;m++) {
														
														for(int n=0;n<Altarr[0].length;n++) {
															
															Altarr[m][n]=arr[m][n];
															
															
														}
														
													}

													
													Altarr[i][2]=0;
													Altarr[path[i][t]][2]=3;
													
													int num2=mf.maxForTeam1(Altarr);
													
													if(num2<num1) {
													

													
													
														if(counter2<150) {
															
															AX=arr[i][0];
															AY=arr[i][1];
															BX=arr[path[i][t]][0];
															BY=arr[path[i][t]][1];
															
															System.out.println("azaz 3");
															
														}
														if(counter2>150) {
															arr[i][2]=0;
															arr[path[i][t]][2]=3;
															
															
															System.out.println("azaz 4");
														}
														
														return true;
													}
														
												}
											}
											}
											
										}
										
									}
									
									
							}
								
								
								
							if(arr[path[i][j+4]][2]==0) {
									
									if(checkDangerPosition(path[i][j+4],j+4)) {
										
									}
									else {
										
										int temp=path[i][j+4];
										
										for(int t=0;t<8;t++) {
											
											if(path[temp][t]!=-1) {
												
												if(arr[path[temp][t]][2]==3) {
													
													if(checkDangerTomove(path[temp][t])) {
														
													}
													else {
														
														
														//new add
														
														int[][] Altarr=new int[64][3];
														
														
														
														for(int m=0;m<Altarr.length;m++) {
															
															for(int n=0;n<Altarr[0].length;n++) {
																
																Altarr[m][n]=arr[m][n];
																
																
															}
															
														}
														
														MakeFool mf=new MakeFool(Altarr,path);
														
														int num1=mf.maxForTeam1(Altarr);
														
														
														for(int m=0;m<Altarr.length;m++) {
															
															for(int n=0;n<Altarr[0].length;n++) {
																
																Altarr[m][n]=arr[m][n];
																
																
															}
															
														}
														
														Altarr[path[i][j+4]][2]=3;
														Altarr[path[temp][t]][2]=0;														
														int num2=mf.maxForTeam1(Altarr);
														
														if(num2<num1) {

														
												
														
																if(counter2<150) {
																	
																	AX=arr[path[i][j+4]][0];
																	AY=arr[path[i][j+4]][1];
																	BX=arr[path[temp][t]][0];
																	BY=arr[path[temp][t]][1];
																	
																	System.out.println("azaz 5");
																	
																}
																if(counter2>150) {
																	 arr[path[i][j+4]][2]=3;
																	
																	arr[path[temp][t]][2]=0;
																	
																	System.out.println("azaz 6");
																}
																
																flag1=false;
																
																
																return true;
														}
														
													}
													
												}
												
												
											}
											
										}
										
										
									}
									
									if(flag1==true) {
										
										for(int t=0;t<8;t++) {
											
											if(path[i][t]!=-1) {
											if(arr[path[i][t]][2]==3) {
												if(!checkDangerPosition(path[i][t],t)) {
													
													//new add
													
													int[][] Altarr=new int[64][3];
													
													
													
													for(int m=0;m<Altarr.length;m++) {
														
														for(int n=0;n<Altarr[0].length;n++) {
															
															Altarr[m][n]=arr[m][n];
															
															
														}
														
													}
													
													MakeFool mf=new MakeFool(Altarr,path);
													
													int num1=mf.maxForTeam1(Altarr);
													
													
													for(int m=0;m<Altarr.length;m++) {
														
														for(int n=0;n<Altarr[0].length;n++) {
															
															Altarr[m][n]=arr[m][n];
															
															
														}
														
													}
													
													Altarr[i][2]=0;
													Altarr[path[i][t]][2]=3;													
													int num2=mf.maxForTeam1(Altarr);
													
													if(num2<num1) {


													
													
													
													
													
														if(counter2<150) {
															
															AX=arr[i][0];
															AY=arr[i][1];
															BX=arr[path[i][t]][0];
															BY=arr[path[i][t]][1];
															
															System.out.println("azaz 7");
															
														}
														if(counter2>150) {
															arr[i][2]=0;
															arr[path[i][t]][2]=3;
															
															
															System.out.println("azaz 8");
														}
														
														
														
														
														return true;
														
													}
												}
											}
											}
										}
										
									}
									
									
								}
								
								
								
								
								
								
								
							}
							
						}
				
					
				}
				
				
				
				
				
				if(j>=4) {
					
					boolean flag1=true;
					
						if(path[i][j]!=-1&&path[i][j-4]!=-1) {
							
							if(arr[path[i][j]][2]==0&&arr[path[i][j-4]][2]==1||arr[path[i][j-4]][2]==0&&arr[path[i][j]][2]==1) {
								
								if(arr[path[i][j]][2]==0) {
									
									
									if(checkDangerPosition(path[i][j],j)) {
										
									}
									else {
										
										
										int temp=path[i][j];
										
										for(int t=0;t<8;t++) {
											
											if(path[temp][t]!=-1) {
												
												if(arr[path[temp][t]][2]==3) {
													
													if(checkDangerTomove(path[temp][t])) {
														
													}
													else {
														
														
														
														
														
														//new add
														
														int[][] Altarr=new int[64][3];
														
														
														
														for(int m=0;m<Altarr.length;m++) {
															
															for(int n=0;n<Altarr[0].length;n++) {
																
																Altarr[m][n]=arr[m][n];
																
																
															}
															
														}
														
														MakeFool mf=new MakeFool(Altarr,path);
														
														int num1=mf.maxForTeam1(Altarr);
														
														for(int m=0;m<Altarr.length;m++) {
															
															for(int n=0;n<Altarr[0].length;n++) {
																
																Altarr[m][n]=arr[m][n];
																
																
															}
															
														}
														
														Altarr[path[i][j]][2]=0;
														Altarr[path[temp][t]][2]=3;
											
														int num2=mf.maxForTeam1(Altarr);
														
														if(num2<num1) {


														
																flag1=false;
																
																
																
																if(counter2<150) {
																	
																	AX=arr[path[i][j]][0];
																	AY=arr[path[i][j]][1];
																	BX=arr[path[temp][t]][0];
																	BY=arr[path[temp][t]][1];
																	
																}
																if(counter2>150) {
																	arr[path[i][j]][2]=0;
																	arr[path[temp][t]][2]=3;
																}
																
																
																return true;
														}
														
													}
													
												}
												
												
											}
											
										}
										
									}
									
									if(flag1==true) {
										
										for(int t=0;t<8;t++) {
											
											if(path[i][t]!=-1) {
											if(arr[path[i][t]][2]==0) {
												if(!checkDangerPosition(path[i][t],t)) {
													
													
													
													//new add
													
													int[][] Altarr=new int[64][3];
													
													
													
													for(int m=0;m<Altarr.length;m++) {
														
														for(int n=0;n<Altarr[0].length;n++) {
															
															Altarr[m][n]=arr[m][n];
															
															
														}
														
													}
													
													MakeFool mf=new MakeFool(Altarr,path);
													
													int num1=mf.maxForTeam1(Altarr);
													
													
													for(int m=0;m<Altarr.length;m++) {
														
														for(int n=0;n<Altarr[0].length;n++) {
															
															Altarr[m][n]=arr[m][n];
															
															
														}
														
													}
													
													Altarr[i][2]=0;
													Altarr[path[i][t]][2]=3;
										
													int num2=mf.maxForTeam1(Altarr);
													
													if(num2<num1) {


													
															if(counter2<150) {
																
																AX=arr[i][0];
																AY=arr[i][1];
																BX=arr[path[i][t]][0];
																BY=arr[path[i][t]][1];
																
															}
															if(counter2>150) {
																arr[i][2]=0;
																arr[path[i][t]][2]=3;
															}
															
															
															
															return true;
													}
													
												}
											}
											}
										}
										
									}
									
									
							}
								
								
								
								
							if(arr[path[i][j-4]][2]==0) {
									
									if(checkDangerPosition(path[i][j-4],j-4)) {
										
									}
									else {
										
										int temp=path[i][j-4];
										
										for(int t=0;t<8;t++) {
											
											if(path[temp][t]!=-1) {
												
												if(arr[path[temp][t]][2]==3) {
													
													if(checkDangerTomove(path[temp][t])) {
														
													}
													else {
														
														
														
														//new add
														
														int[][] Altarr=new int[64][3];
														
														
														
														for(int m=0;m<Altarr.length;m++) {
															
															for(int n=0;n<Altarr[0].length;n++) {
																
																Altarr[m][n]=arr[m][n];
																
																
															}
															
														}
														
														MakeFool mf=new MakeFool(Altarr,path);
														
														int num1=mf.maxForTeam1(Altarr);
														
														
														for(int m=0;m<Altarr.length;m++) {
															
															for(int n=0;n<Altarr[0].length;n++) {
																
																Altarr[m][n]=arr[m][n];
																
																
															}
															
														}
														
														Altarr[path[i][j-4]][2]=0;
														Altarr[path[temp][t]][2]=3;											
														int num2=mf.maxForTeam1(Altarr);
														
														if(num2<num1) {


														
																flag1=false;
																
																if(counter2<150) {
																	
																	AX=arr[path[i][j-4]][0];
																	AY=arr[path[i][j-4]][1];
																	BX=arr[path[temp][t]][0];
																	BY=arr[path[temp][t]][1];
																	
																}
																if(counter2>150) {
																	arr[path[i][j-4]][2]=0;
																	 arr[path[temp][t]][2]=3;
																	
																}
																
																
																
																return true;
														}
														
													}
													
												}
												
												
											}
											
										}
										
										
									}
									
									if(flag1==true) {
										
										for(int t=0;t<8;t++) {
											
											if(path[i][t]!=-1) {
											if(arr[path[i][t]][2]==0) {
												if(!checkDangerPosition(path[i][t],t)) {
													
													
													
													//new add
													
													int[][] Altarr=new int[64][3];
													
													
													
													for(int m=0;m<Altarr.length;m++) {
														
														for(int n=0;n<Altarr[0].length;n++) {
															
															Altarr[m][n]=arr[m][n];
															
															
														}
														
													}
													
													MakeFool mf=new MakeFool(Altarr,path);
													
													int num1=mf.maxForTeam1(Altarr);
													
													
													
													for(int m=0;m<Altarr.length;m++) {
														
														for(int n=0;n<Altarr[0].length;n++) {
															
															Altarr[m][n]=arr[m][n];
															
															
														}
														
													}
													
													
													Altarr[i][2]=0;
													Altarr[path[i][t]][2]=3;
									
													int num2=mf.maxForTeam1(Altarr);
													
													if(num2<num1) {



													
															if(counter2<150) {
																
																AX=arr[i][0];
																AY=arr[i][1];
																BX=arr[path[i][t]][0];
																BY=arr[path[i][t]][1];
																
															}
															if(counter2>150) {
																arr[i][2]=0;
																arr[path[i][t]][2]=3;
																
															}
															
															
															
															return true;
															
													}
													
													
													
													
												}
											}
										}
									}
										
									}
									
									
								}
								
								
								
								
								
								
								
							}
							
						}
				
					
				}				
				
				
				
				
			}
			
			
		}
		else if(arr[i][2]==2) {	
			
			for(int j=5;j<8;j++) {
				
				if(j<4) {
						
					boolean flag1=true;
					
						if(path[i][j]!=-1&&path[i][j+4]!=-1) {
							
							if(arr[path[i][j]][2]==0&&arr[path[i][j+4]][2]==1||arr[path[i][j+4]][2]==0&&arr[path[i][j]][2]==1) {
								
								if(arr[path[i][j]][2]==0) {
									
									
									if(checkDangerPosition(path[i][j],j)) {
										
									}
									else {
										
										
										int temp=path[i][j];
										
										for(int t=5;t<8;t++) {
											
											if(path[temp][t]!=-1) {
												
												if(arr[path[temp][t]][2]==2) {
													
													if(checkDangerTomove(path[temp][t])) {
														
													}
													else {
														
														
														//new add
														
														int[][] Altarr=new int[64][3];
														
														
														
														for(int m=0;m<Altarr.length;m++) {
															
															for(int n=0;n<Altarr[0].length;n++) {
																
																Altarr[m][n]=arr[m][n];
																
																
															}
															
														}
														
														MakeFool2 mf=new MakeFool2(Altarr,path);
														
														
														int num1=mf.maxForTeam1(Altarr);
														
														
														for(int m=0;m<Altarr.length;m++) {
															
															for(int n=0;n<Altarr[0].length;n++) {
																
																Altarr[m][n]=arr[m][n];
																
																
															}
															
														}
														
														Altarr[path[i][j]][2]=2;
														Altarr[path[temp][t]][2]=0;
														
														int num2=mf.maxForTeam1(Altarr);
														
														System.out.println("method  save guti  num1"+num1+"num2"+num2);
														if(num2<num1) {
														
														
														
														
														
																flag1=false;
																if(counter2<150) {
																	
																	AX=arr[path[i][j]][0];
																	AY=arr[path[i][j]][1];
																	BX=arr[path[temp][t]][0];
																	BY=arr[path[temp][t]][1];
																	
																	System.out.println("azaz 1");
																	
																}
																if(counter2>150) {
																if(path[i][j]>=56)arr[path[i][j]][2]=3;
																else arr[path[i][j]][2]=2;
																arr[path[temp][t]][2]=0;
																	
																	System.out.println("azaz 2");
																	
																}
																
																return true;
														}
													}
													
												}
												
												
											}
											
										}
										
									}
									
									if(flag1==true) {
										
										for(int t=0;t<8;t++) {
											
											if(path[i][t]!=-1) {
											if(arr[path[i][t]][2]==0) {
												if(!checkDangerPosition(path[i][t],t)) {
													
													
												
													
													int[][] Altarr=new int[64][3];
													
													
													
													for(int m=0;m<Altarr.length;m++) {
														
														for(int n=0;n<Altarr[0].length;n++) {
															
															Altarr[m][n]=arr[m][n];
															
															
														}
														
													}
													
													MakeFool2 mf=new MakeFool2(Altarr,path);
													
													int num1=mf.maxForTeam1(Altarr);
													
													for(int m=0;m<Altarr.length;m++) {
														
														for(int n=0;n<Altarr[0].length;n++) {
															
															Altarr[m][n]=arr[m][n];
															
															
														}
														
													}

													
													Altarr[i][2]=0;
													Altarr[path[i][t]][2]=2;
													
													int num2=mf.maxForTeam1(Altarr);
													
													if(num2<num1) {
													

													
													
														if(counter2<150) {
															
															AX=arr[i][0];
															AY=arr[i][1];
															BX=arr[path[i][t]][0];
															BY=arr[path[i][t]][1];
															
															System.out.println("azaz 3");
															
														}
														if(counter2>150) {
															arr[i][2]=0;
															if(path[i][t]>=56)arr[path[i][t]][2]=3;
															else arr[path[i][t]][2]=2;
															
															System.out.println("azaz 4");
														}
														
														return true;
													}
														
												}
											}
											}
											
										}
										
									}
									
									
							}
								
								
								
							if(arr[path[i][j+4]][2]==0) {
									
									if(checkDangerPosition(path[i][j+4],j+4)) {
										
									}
									else {
										
										int temp=path[i][j+4];
										
										for(int t=0;t<8;t++) {
											
											if(path[temp][t]!=-1) {
												
												if(arr[path[temp][t]][2]==2) {
													
													if(checkDangerTomove(path[temp][t])) {
														
													}
													else {
														
														
														//new add
														
														int[][] Altarr=new int[64][3];
														
														
														
														for(int m=0;m<Altarr.length;m++) {
															
															for(int n=0;n<Altarr[0].length;n++) {
																
																Altarr[m][n]=arr[m][n];
																
																
															}
															
														}
														
														MakeFool mf=new MakeFool(Altarr,path);
														
														int num1=mf.maxForTeam1(Altarr);
														
														
														for(int m=0;m<Altarr.length;m++) {
															
															for(int n=0;n<Altarr[0].length;n++) {
																
																Altarr[m][n]=arr[m][n];
																
																
															}
															
														}
														
														Altarr[path[i][j+4]][2]=2;
														Altarr[path[temp][t]][2]=0;														
														int num2=mf.maxForTeam1(Altarr);
														
														if(num2<num1) {

														
												
														
																if(counter2<150) {
																	
																	AX=arr[path[i][j+4]][0];
																	AY=arr[path[i][j+4]][1];
																	BX=arr[path[temp][t]][0];
																	BY=arr[path[temp][t]][1];
																	
																	System.out.println("azaz 5");
																	
																}
																if(counter2>150) {
																	if(path[i][j+4]>=56) arr[path[i][j+4]][2]=3;
																	else arr[path[i][j+4]][2]=2;
																	arr[path[temp][t]][2]=0;
																	
																	System.out.println("azaz 6");
																}
																
																flag1=false;
																
																
																return true;
														}
														
													}
													
												}
												
												
											}
											
										}
										
										
									}
									
									if(flag1==true) {
										
										for(int t=0;t<8;t++) {
											
											if(path[i][t]!=-1) {
											if(arr[path[i][t]][2]==0) {
												if(!checkDangerPosition(path[i][t],t)) {
													
													//new add
													
													int[][] Altarr=new int[64][3];
													
													
													
													for(int m=0;m<Altarr.length;m++) {
														
														for(int n=0;n<Altarr[0].length;n++) {
															
															Altarr[m][n]=arr[m][n];
															
															
														}
														
													}
													
													MakeFool mf=new MakeFool(Altarr,path);
													
													int num1=mf.maxForTeam1(Altarr);
													
													
													for(int m=0;m<Altarr.length;m++) {
														
														for(int n=0;n<Altarr[0].length;n++) {
															
															Altarr[m][n]=arr[m][n];
															
															
														}
														
													}
													
													Altarr[i][2]=0;
													Altarr[path[i][t]][2]=2;													
													int num2=mf.maxForTeam1(Altarr);
													
													if(num2<num1) {


													
													
													
													
													
														if(counter2<150) {
															
															AX=arr[i][0];
															AY=arr[i][1];
															BX=arr[path[i][t]][0];
															BY=arr[path[i][t]][1];
															
															System.out.println("azaz 7");
															
														}
														if(counter2>150) {
															arr[i][2]=0;
															if(path[i][t]>=56)arr[path[i][t]][2]=3;
															else arr[path[i][t]][2]=2;
															
															System.out.println("azaz 8");
														}
														
														
														
														
														return true;
														
													}
												}
											}
											}
										}
										
									}
									
									
								}
								
								
								
								
								
								
								
							}
							
						}
				
					
				}
				
				
				
				
				
		
				
				
				
			}
			
			
			
			
			
			
			
			
			
			
		
		}
			
			
		}	
		
		return false;
		
	}
	
	
	public boolean checkDangerPosition(int source) {		
		for(int j=0;j<8;j++) {	
			if(j<4) {				
				if(path[source][j]!=-1&&path[source][j+4]!=-1) {				
					if(arr[path[source][j]][2]==0&&arr[path[source][j+4]][2]==1||arr[path[source][j+4]][2]==0&&arr[path[source][j]][2]==1) {				
						return true;
					}			
				}			
			}
			if(j>=4) {			
				if(path[source][j]!=-1&&path[source][j-4]!=-1) {			
					if(arr[path[source][j]][2]==0&&arr[path[source][j-4]][2]==1||arr[path[source][j-4]][2]==0&&arr[path[source][j]][2]==1) {			
						return true;		
					}		
				}	
			}
		}
		return false;

	}
	
	
	
	public boolean checkDangerTomove(int source) {
		
		for(int i=0;i<8;i++) {
			
			if(source!=-1) {
				int tempX1=path[source][i];
				
				if(tempX1!=-1) {
					int tempX2=path[tempX1][i];
				
						if(tempX2!=-1) {
					
							if(arr[tempX1][2]==2&&arr[tempX2][2]==1) {
						
								return true;
							}
							
						}
					}
					
				}
		}
		return false;
	}
	
	public boolean checkDangerPosition(int source,int index) {	
		int temp=0,tempX1=0;
		tempX1=source;	
		temp=path[source][index];
		if(temp!=-1&&source!=-1) {
			if(path[source][index]!=-1&&arr[source][2]==0&&arr[path[source][index]][2]==1) {		
				return true;
			}	
		}
		for(int j=0;j<8;j++) {
			if(j<4) {			
				if(path[source][j]!=-1&&path[source][j+4]!=-1) {			
					if(arr[path[source][j]][2]==0&&arr[path[source][j+4]][2]==1||arr[path[source][j+4]][2]==0&&arr[path[source][j]][2]==1) {			
						return true;
					}		
				}	
			}
			if(j>=4) {		
				if(path[source][j]!=-1&&path[source][j-4]!=-1) {	
					if(arr[path[source][j]][2]==0&&arr[path[source][j-4]][2]==1||arr[path[source][j-4]][2]==0&&arr[path[source][j]][2]==1) {
						return true;	
					}	
				}
			}
		}
		return false;
	}
	
}
