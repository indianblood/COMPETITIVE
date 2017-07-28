//Goodset
//Author:greatindian
#include<iostream>
using namespace std;
int main()
{
  int t,n;
  cin>>t;
  while(t--)
  {
    cin>>n;
    int k=1;
    for(int i=0;i<n;i++)
      {
        cout<<k<<" ";
        k+=2;
      }
    cout<<endl;
  }
  return 0;
}
