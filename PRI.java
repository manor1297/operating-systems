import java.util.*;
class PRI
{
    public void sort(int pro[][],int n)
    {
        int temp,temp1,temp2;
        for(int i=0;i<n;i++)
        {
            for(int j=1;j<n-i;j++)
            {
                if(pro[j-1][1]>pro[j][1])
                {
                    temp=pro[j-1][1];
                    temp1=pro[j-1][0];
                    temp2=pro[j-1][2];
                    pro[j-1][1]=pro[j][1];
                    pro[j-1][0]=pro[j][0];
                    pro[j-1][2]=pro[j][2];
                    pro[j][1]=temp;
                    pro[j][0]=temp1;
                    pro[j][2]=temp2;
                }
            }
        }
    }
    public int findmin(int pro[][],int st,int n,int s)
    {
        int min=100;
        int j=0;
        while(j<n)
        {
            if((pro[j][2]<min)&&(pro[j][0]!=0)&&(pro[j][1]<=st))
            {
                min=pro[j][2];
            }
           j++;
        }
        return min;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of processes");
        int n=sc.nextInt();
        int pro[][]=new int[n][3];
        int proc[][]=new int[n][3];
        int check[]=new int[n];
        for(int k=0;k<n;k++)
        {
            check[k]=0;
        }
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the burst time of process p"+i);
            pro[i][0]=sc.nextInt();
            proc[i][0]=pro[i][0];
            System.out.println("Enter the arival time of process p"+i);
            pro[i][1]=sc.nextInt();
            proc[i][1]=pro[i][1];
            System.out.println("Enter the priority of process p"+i);
            pro[i][2]=sc.nextInt();
            proc[i][2]=pro[i][2];
        }
        PRI obj=new PRI();
        obj.sort(pro,n);
        obj.sort(proc,n);
        int s=0;
        for(int k=0;k<n;k++)
        {
            s=s+pro[k][0];
        }
        int st=0;
        int j=0;
        float sum=0,sum1=0;
        int c=0;
        int atat=0,awt=0;
        while(j<n)
        {
            int min=obj.findmin(pro,st,n,s);
            if((pro[j][1]<=st)&&(pro[j][0]!=0)&&(check[j]==0)&&(pro[j][2]<=min))
            {
                pro[j][0]--;
                st++;
                if(pro[j][0]==0)
                {
                    atat=st-proc[j][1];
                    awt=atat-proc[j][0];
                    sum=sum+atat;
                    sum1=sum1+awt;
                    check[j]=1;
                    atat=0;awt=0;
                }
                c++;j++;
            }
            else
            {
                j++;
                if((j==n)&&(c==0))
                {
                    st++;
                }
            } 
            if((j==n)&&(st!=s))
                {
                    j=0;
                }
        }
        System.out.println("The value of ATAT is "+(sum/n)+" and the value of AWT is "+(sum1/n));
    }
}
