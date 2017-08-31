import java.util.*;
class RROPZ
{
    public static int top=0,select=0,st=0,c=0;
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
    public void fillqueue(int queue[],int check[],int pro[][],int n)
    {
        int j=0;
        while(j<n)
            if((pro[j][1]<=st)&&(pro[j][0]!=0)&&(check[j]!=1))
            {
                queue[top++]=pro[j][2];
                check[j]=1;
                c++;j++;
            }
            else
            {
                j++;
                if((c==0)&&(j==n))
                {
                st=st+1;j=0;
                }
                if(c==n)
                    return;
            }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of processes");
        int n=sc.nextInt();
        int pro[][]=new int[n][3];
        int proc[][]=new int[n][3];
        int check[]=new int[n];
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the burst time of process p"+i);
            pro[i][0]=sc.nextInt();
            proc[i][0]=pro[i][0];
            System.out.println("Enter the arival time of process p"+i);
            pro[i][1]=sc.nextInt();
            proc[i][1]=pro[i][1];
            pro[i][2]=i;
            proc[i][2]=pro[i][2];
            check[k]=0;
        }
        System.out.println("Enter the time slice");
        int ts = sc.nextInt();
        RROPZ obj=new RROPZ();
        obj.sort(pro,n);
        obj.sort(proc,n);
        int s=0;
        for(int k=0;k<n;k++)
        {
            s=s+pro[k][0];
        }
        System.out.println(s);
        int length=(s/ts)+2;
        System.out.println(length);
        int queue[]=new int[length];
        System.out.println(queue.length);
        for(int l=0;l<length;l++)
        {
            queue[l]=-1;
        }
        int j=0;
        float sum=0,sum1=0;
        int atat=0,awt=0;
        obj.fillqueue(queue,check,pro,n);
        while(st!=s)
        {
            j=queue[select++];
            System.out.println(j);
            if(pro[j][0]<ts)
            {
                    st=st+pro[j][0];
                    pro[j][0]=0;
            }
            else
            {
                    pro[j][0]=pro[j][0]-ts;
                    st=st+ts;
            }
            if(pro[j][0]==0)
            {
            atat=st-proc[j][1];
            awt=atat-proc[j][0];
            sum=sum+atat;
            sum1=sum1+awt;
            check[j]=1;
            atat=0;awt=0;
            }
            obj.fillqueue(queue,check,pro,n);
            if(pro[j][0]!=0)
                queue[top++]=pro[j][2];
        }
            System.out.println("The value of ATAT is "+(sum/n)+" and the value of AWT is "+(sum1/n));
    }
        
}
