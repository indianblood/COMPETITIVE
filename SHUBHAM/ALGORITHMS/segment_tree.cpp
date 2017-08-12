/* Following is a simple implementation of Segment Tree*/

#include<iostream>
#include<cmath>
#include<climits>
static int n;
int data[1000];
using namespace std;
/* Updation function begins from  here*/

void update(int index,int value){
    index=index+n;
    data[index]=value;
    while(index>=1)
    {
        index=index/2;
        data[index]=min(data[2*index],data[2*index+1]);
    }
}

/*Updation function ends here*/


/*Function to find the minimum value within a range*/
int minimum(int left,int right){
    left=left+n;
    right=right+n;
    int mini=INT_MAX;
    while(left<right){
    if(left%2!=0){
        mini=min(mini,data[left]);
        left+=1;
    }
    if(right%2!=0){
        right-=1;
        mini=min(mini,data[right]);
    }
        right/=2;
        left/=2;
    }
    return mini;
}
int main(){
    cin>>n;
    //int data[2*n];

    /* Construction Phase*/

    for(int i=n;i<2*n;i++)
        cin>>data[i];
    for(int i=n-1;i>=1;i--)
        data[i]=min(data[2*i],data[2*i+1]);

    /*Construction phase end here */

    //cout<<minimum(3,7)<<endl; //Tester to check the minimum between left index and not including right index
    return 0;
}
