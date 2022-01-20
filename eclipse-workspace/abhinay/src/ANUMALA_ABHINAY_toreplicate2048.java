import java.util.*;

public class ANUMALA_ABHINAY_toreplicate2048 {

	public static void upmove(int a[][])
	{
		int i,j,li,ri;
		for(j=0;j<4;j++)
		{
			li=0;
			ri=j;
			for(i=1;i<4;i++)
			{
				if(a[i][j]!=0)
				{
					if(a[i-1][j]==0 || a[i-1][j]==a[i][j])
					{
						if(a[li][ri]==a[i][j])
						{
							a[li][ri]*=2;
							a[i][j]=0;
						}
						else
						{
							if(a[li][ri]==0)
							{
								a[li][ri]=a[i][j];
								a[i][j]=0;
							}
							else
							{
								a[++li][ri]=a[i][j];
								a[i][j]=0;
							}
						}
					}
					else li++;
				}
			}
		}
	}
	
	public static void downmove(int a[][])
	{
		int i,j,li,ri;
		for(j=0;j<4;j++)
		{
			li=3;
			ri=j;
			for(i=2;i>=0;i--)
			{
				if(a[i][j]!=0)
				{
					if(a[i+1][j]==0 || a[i+1][j]==a[i][j])
					{
						if(a[li][ri]==a[i][j])
						{
							a[li][ri]*=2;
							a[i][j]=0;
						}
						else
						{
							if(a[li][ri]==0)
							{
								a[li][ri]=a[i][j];
								a[i][j]=0;
							}
							else
							{
								a[--li][ri]=a[i][j];
								a[i][j]=0;
							}
						}
					}
					else li--;
				}
			}
		}
	}
	
	public static void leftmove(int a[][])
	{
		int i,j,li,ri;
		for(i=0;i<4;i++)
		{
			li=i;
			ri=0;
			for(j=1;j<4;j++)
			{
				if(a[i][j]!=0)
				{
					if(a[i][j-1]==0 || a[i][j-1]==a[i][j])
					{
						if(a[li][ri]==a[i][j])
						{
							a[li][ri]*=2;
							a[i][j]=0;
						}
						else
						{
							if(a[li][ri]==0)
							{
								a[li][ri]=a[i][j];
								a[i][j]=0;
							}
							else
							{
								a[li][++ri]=a[i][j];
								a[i][j]=0;
							}
						}
					}
					else ri++;
				}
			}
		}
	}

	public static void rightmove(int a[][])
	{
		int i,j,li,ri;
		for(i=0;i<4;i++)
		{
			li=i;
			ri=3;
			for(j=2;j>=0;j--)
			{
				if(a[i][j]!=0)
				{
					if(a[i][j+1]==0 || a[i][j+1]==a[i][j])
					{
						if(a[li][ri]==a[i][j])
						{
							a[li][ri]*=2;
							a[i][j]=0;
						}
						else
						{
							if(a[li][ri]==0)
							{
								a[li][ri]=a[i][j];
								a[i][j]=0;
							}
							else
							{
								a[li][--ri]=a[i][j];
								a[i][j]=0;
							}
						}
					}
					else ri--;
				}
			}
		}
	}

	public static void addblock(int a[][])
	{
		int li,ri;
		while(true)
		{
			li=(int) (Math.random()*4);
			ri=(int) (Math.random()*4);
			if(a[li][ri]==0)
			{
				a[li][ri]=(int) Math.pow(2,li%2 + 1);
				break;
			}
		}

	}

	public static void disp(int a[][])
	{
		System.out.println("\n\n\n");
		int i,j;
		for(i=0;i<4;i++)
		{
			System.out.print("\t\t\t\t-----------------\n\t\t\t\t");
			for(j=0;j<4;j++)
			{
				if(a[i][j]==0) System.out.print("|   ");
				else
					System.out.print("| "+a[i][j] + " ");
				
			}
			System.out.println("|");
		}
		System.out.print("\t\t\t\t-----------------\n");
	}

	public static boolean check(int tmp[][],int a[][])
	{
		boolean fl=true;
		int i,j;
		for(i=0;i<4;i++)
	    	for(j=0;j<4;j++)
	    		if(tmp[i][j]!=a[i][j])
	    		{
	    			fl=false;
	    			break;
				}
		return fl;
	}

	public static boolean checkover(int a[][])
	{
		boolean fl=false,gl=false;
		int i,j;
		for(i=0;i<4;i++)
	    	for(j=0;j<4;j++)
	    		if(a[i][j]==0)
	    		{
	    			fl=true;
					break;	
				}
				
		for(i=0;i<3;i++)
	    	for(j=0;j<3;j++)
	    		if(a[i+1][j]==a[i][j] || a[i][j+1]==a[i][j])
	    		{
	    			gl=true;
	    			break;
				}
				
		if((fl || gl)) return true;
		else return false;
	}
	
	public static void main(String[] args) {
		System.out.println("\n\n\n\n\t\t\t2048 GAME\n\n\n\t\tPress any key to continue");
		int i1,i2,i3,i4,i,j;
		int[][] a = new int[4][4];
		int[][] tmp = new int[4][4];
		i1=(int) (Math.random()*4);
		i2=(int) (Math.random()*4);
		while(true)
		{
			i3=(int) (Math.random()*4);
			i4=(int) (Math.random()*4);
			if(i3!=i1 && i4!=i2) break;
		}
		a[i1][i2]=2;
		a[i3][i4]=4;
		disp(a);
		Scanner in = new Scanner(System.in);
		String ch;
		while (true)
	    {
	    	for(i=0;i<4;i++)
	    		for(j=0;j<4;j++)
	    			tmp[i][j]=a[i][j];
	    	ch=in.nextLine();
	    	if(ch=="1") upmove(a);
	    	if(ch=="2") downmove(a);
	    	if(ch=="3") leftmove(a);
	    	if(ch=="4") rightmove(a);
			if(ch=="0") break;
			
			if(!check(tmp,a))
				addblock(a);
			disp(a);
				
			if(!checkover(a))
			{
				System.out.print("\n\n\t\t\tGAME OVER!!\n\n\n");
				break;
			}
		}		
		return ;
	}

}
