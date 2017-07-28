//Triplets
// Author :shubhamsati
#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
typedef long long ll;
#define m 1000000007
ll binsearch(const ll *xorz,ll value,ll l,ll r)
{
  if(r>=l)
  {
  int q=(l+r)/2;
  if(xorz[q]==value)
    {
      if(q<r)
      {
      if(xorz[q+1]>value)
        return q;
      else
        return binsearch(xorz,value,q+1,r);
      }
      else
      return q;
    }
  else if(xorz[q]<value)
  {
    if(xorz[q+1]>value)
      return q;
    else
      return binsearch(xorz,value,q+1,r);
  }
    else
    {
      return binsearch(xorz,value,l,q-1);
    }
  }
  return 0;
}

int main()
{
  ll t;
  cin>>t;
  while(t--)
  {
    ll p,q,r,i,j,k;
    ll res=0;
    //int flagx=0,flagz=0;
    cin>>p>>q>>r;
    ll a[p];
    ll ay[p];
    ll b[q];
    ll c[r];
    ll cy[r];
    for(i=0;i<p;i++)
      cin>>a[i];
    for(j=0;j<q;j++)
      cin>>b[j];
    for(k=0;k<r;k++)
      cin>>c[k];
    sort(a,a+p);
    //sort(b,b+q);
    sort(c,c+r);
    cy[0]=c[0];
    ay[0]=a[0];
    for(i=1;i<r;i++)
      cy[i]=c[i]+cy[i-1];
    for(i=1;i<p;i++)
      ay[i]=a[i]+ay[i-1];
    for(i=0;i<q;i++)
    {

      ll pos1=binsearch(a,b[i],0,p);
      //cout<<pos1<<endl;
      ll pos2=binsearch(c,b[i],0,r);
      //cout<<pos2<<endl;
      /*
      if(pos1==p-1 && a[p-1]<=b[i])
        {
          pos1+=1;
        }
      if(pos2==r-1 && c[r-1]<=b[i])
        {
          pos2+=1;
        }
        */
      //cout<<pos2<<endl;
      //res=(res+( ((ay[pos1]%m)*((pos2+1)%m)*(b[i]%m))%m + ((ay[pos1]%m)*(cy[pos2]%m))%m + (((pos1+1)%m)*((pos2+1)%m)*(b[i]%m)*(b[i]%m))%m + (((pos1+1)%m)*(b[i]%m)*(cy[pos2]%m) )%m ))%m;
      //res=(res%m+(ay[pos1]%m*(pos2+1)%m*b[i]%m)%m+(ay[pos1]%m*cy[pos2]%m)%m+((pos1+1)%m*(pos2+2)%m*b[i]%m*b[i]%m)+((pos1+1)%m*b[i]%m*cy[pos2]%m))%m;

      res=((res + ( ((ay[pos1]%m * (pos2+1)%m)%m *b[i]%m )%m + ( ay[pos1]%m * cy[pos2]%m )%m )%m )%m + ((((pos1+1)%m * (pos2+1)%m)%m *b[i]%m)%m *b[i]%m )%m  + (((pos1+1)%m * b[i]%m)%m *cy[pos2]%m)%m  )%m;
      //cout<<res<<endl;
    }
    cout<<res<<endl;
  }
  return 0;
}













/*
  //Shitty Approach
  for(i=0;i<p;i++)
  {
    flagz=0;
    for(j=0;j<q;j++)
    {
      if(a[i]>b[j])
        {
          flagx=1;
          break;
        }
      for(k=0;k<r,flagz==0;k++)
      {
        if(c[k]>b[j])
        {
          flagz=1;
        }
        if(flagz==0)
        {
          res=(res+funk(a[i],b[j],c[k]))%m;
          cout<<res<<endl;
        }
      }
    }
  }*/
  /* //NAIVE APPROACH
  for(i=0;i<p;i++)
  {
    for(j=0;j<q;j++)
    {
      for(k=0;k<r;k++)
      {
        if(a[i]<=b[j] && c[k]<=b[j])
          res=res+funk(a[i],b[j],c[k]))%m;
      }
    }
  }*/
  /*for(j=0;j<q;j++)
  {
    i=0;
    while(flagx==0 && i<p)
    {
    for(i=0;i<p;i++)
    {
      if(a[i]>b[j])
      {
        flagx=1;
        break;
      }
      for(k=0;k<r;k++)
      {
        if(c[k]>b[j])
          break;
        res=(res+funk(a[i],b[j],c[k]))%m;
      }
      }
    }
  }*/
