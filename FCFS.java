import java.util.*;
class FCFS
{
    public void sort(int pro[][],int n)
    {
        int temp,temp1;
        for(int i=0;i<n;i++)
        {
            for(int j=1;j<n-i;j++)
            {
                if(pro[j-1][1]>pro[j][1])
                {
                    temp=pro[j-1][1];
                    temp1=pro[j-1][0];
                    pro[j-1][1]=pro[j][1];
                    pro[j-1][0]=pro[j][0];
                    pro[j][1]=temp;
                    pro[j][0]=temp1;
                }
            }
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of processes");
        int n=sc.nextInt();
        int pro[][]=new int[n][2];
        int check[]=new int[n];
        for(int k=0;k<n;k++)
        {
            check[k]=0;
        }
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the burst time of process p"+i);
            pro[i][0]=sc.nextInt();
            System.out.println("Enter the arival time of process p"+i);
            pro[i][1]=sc.nextInt();
        }
        FCFS obj=new FCFS();
        obj.sort(pro,n);
        int st=0;
        int j=0;
        float sum=0,sum1=0;
        int c=0;
        while(j<n)
        {
            int atat=0,awt=0;
            if((pro[j][1]<=st)&&(check[j]==0))
            {
                st=st+pro[j][0];
                atat=st-pro[j][1];
                awt=atat-pro[j][0];
                sum=sum+atat;
                sum1=sum1+awt;
                check[j]=1;
                j=0;c++;
            }
            else
            {
                j++;
                if((j==n)&&(c==0))
                {
                    st=st+1;j=0;
                }
            }
        }
        System.out.println("The value of ATAT is "+(sum/n)+" and the value of AWT is "+(sum1/n));
    }
}
