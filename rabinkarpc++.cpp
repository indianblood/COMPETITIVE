#include<iostream>
#include<cmath>
#include<cstring>
using namespace std;
typedef long long ll;
static int prime=101;
ll createhash(string ,int );
ll recalculatehash(string ,ll,char,char,int);
bool checkequality(string ,string ,int ,int );
int PatternSearch(string text,string pattern)
{
  //Main function which finds the pattern in the text
  int m=pattern.length();
  int n=text.length();
  ll hashpat=createhash(pattern,m);
  ll hashtxt=createhash(text,m);
  for(int i=0;i<n-m+1;i++)
  {
    if(hashpat==hashtxt && checkequality(pattern,text,i,i+m-1))
      return i+1;
    if(i!=n-m)
      hashtxt=recalculatehash(text,hashtxt,text[i],text[i+m],m);
  }
  return -1;

}
ll createhash(string pattern,int length)
{
  //Used for determining the  hash value of pattern and the first chunk of text
  ll hash=int(pattern[0]);
    for(int i=1;i<length;i++)
      hash+=pow(prime,i)*int(pattern[i]);
  return hash;
}
ll recalculatehash(string text,ll hash,char prev,char newi,int length)
{
  //Used Rolling Hash For Calculation of new Hash Value in O(1)
  ll newhash=hash-prev;
  newhash=newhash/prime;
  newhash=newhash+ int(newi)*pow(prime,length-1);
  return newhash;
}
bool checkequality(string pattern,string text,int start,int end)
{
  bool flag=true;
  int k=0;
  for(int i=start;i<=end;i++)
  {
    if(pattern[k]!=text[i])
      {
        flag=false;
        break;
      }
    k++;
  }
  return flag;
}
int main()
{
  string text;
  string pattern;
  cout<<"Enter the text:\n";
  cin>>text;
  cout<<"Enter the pattern to be searched:\n";
  cin>>pattern;
  int pos=PatternSearch(text,pattern);
  if(pos!=-1)
    cout<<"Pattern found at position "<<pos<<" !"<<endl;
  else
    cout<<"Pattern Not Found"<<endl;
  return 0;
}
