import java.util.*;
class SRTN
{
    public void sort(int pro[][],int n)
    {
        int temp,temp1;
        for(int i=0;i<n;i++)
        {
            for(int j=1;j<n-i;j++)
            {
                if(pro[j-1][0]>pro[j][0])
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
        int proc[][]=new int[n][2];
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
        }
        SRTN obj=new SRTN();
        obj.sort(pro,n);
        obj.sort(proc,n);
        int st=0;
        int j=0,sum=0,sum1=0;
        int c=0;
        int atat=0,awt=0;
        while(j<n)
        {
            if((pro[j][1]<=st)&&(pro[j][0]!=0)&&(check[j]==0))
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
                obj.sort(pro,n);
                obj.sort(proc,n);
                j=0;c++;
            }
            else
            {
                j++;
                if((j==n)&&(c==0))
                {
                    st++;j=0;
                }
            }
        }
        System.out.println(sum+" "+sum1);
    }
}
