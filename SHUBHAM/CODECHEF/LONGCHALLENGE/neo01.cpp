//Problem Code:https://www.codechef.com/JUNE17/problems/NEO01
//Maximize the happiness you get from eating i-th dish
#include<algorithm>
#include<functional>
#include<iostream>
using namespace std;
typedef long long ll;
int main()
{
  int t;
  cin>>t;
  while(t--)
  {
    ll n;
    cin>>n;
    ll a[n];
    for(ll i=0;i<n;i++)
      cin>>a[i];
    sort(a,a+n,greater<ll>());
    ll ctr=0;
    ll sum=0;
    ll temp=0;
    for(ll i=0;i<n;i++)
    {
      ctr+=1;
      if(a[i]>=0)
        temp+=a[i];
      else
      {
        if((temp+a[i])*ctr>=(temp*(ctr-1))+a[i])
          temp+=a[i];
        else
          {
            sum+=temp*(ctr-1);
            ctr=1;
            while(i<n)
            {
              sum+=a[i];
              i++;
            }
            if(i==n)
              i-=1;
            temp=0;
          }
        }
      if(i==n-1)
      {
        sum+=temp*ctr;
        cout<<sum<<endl;
      }
    }
  }
  return 0;
}
