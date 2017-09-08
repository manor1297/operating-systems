import java.util.*;
class Diningthread implements Runnable
{
	
		public void release()
	{	
		int pn=(int)Thread.currentThread().getId();
		pn=pn-8;
		if(pn!=0)
		{
			if((Diner.P[pn]==0)&&(Diner.P[pn-1]==1))
			{
				Diner.P[pn]=1;
				Diner.P[pn-1]=1;
				Thread.currentThread().interrupt();
			}
			else
			{return;}
		}
		else
		{
			if((Diner.P[pn]==0)&&(Diner.P[pn+(Diner.n-1)]==0))
			{
				Diner.P[pn]=1;
				Diner.P[pn+(Diner.n-1)]=1;
				Thread.currentThread().interrupt();
				
			}
			else
			{
				return;
			}
		}
	}
		public void run()
	{
		try
		{
			Diner obj1=new Diner();
			
			obj1.request();
			obj1.exec();
			release();
		}
		catch(Exception i)
		{
			System.out.println("Error");
		}
		
	}
}
class Diner
{
	public static int P[];
	public static int n;
	public void request()
	{
		int pn=(int)Thread.currentThread().getId();
		pn=pn-8;
		if(pn!=0)
		{
			if((P[pn]==1)&&(P[pn-1]==1))
			{
				P[pn]=0;
				P[pn-1]=0;
			}
			else
			{return;}
		}
		else
		{
			if((P[pn]==1)&&(P[pn+(n-1)]==1))
			{
				P[pn]=0;
				P[pn+(n-1)]=0;
			}
			else
			{
				return;
			}
		}
		System.out.println(pn);
	}
	public void exec()
	{
		int pn=(int)Thread.currentThread().getId();
		pn=pn-8;
		if((P[pn]==0)&&(P[pn-1]==0))
		{
			System.out.println("Process is done");
		}
		else
		{
			request();
		}
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of processes");
		n=sc.nextInt();
		P=new int[n];
		for(int i=0;i<n;i++)
		{
			P[i]=1;
			Thread obj=new Thread(new Diningthread());
			obj.start();
		}
	}
}