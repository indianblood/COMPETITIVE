//Simple use of DFS to loop over the connected components and caculate the  minimum of the solution.
//Problem Page:https://www.hackerrank.com/challenges/torque-and-development
#include<iostream>
#include<algorithm>
#include<cstdio>
#include<cmath>
#include<vector>
using namespace std;
int c_lib,c_road,n,m;
vector<int>adj[100001];
bool edge[100001];
int c=0;
void dfs(int s){
  edge[s]=true;
  c+=1;
  for(int i=0;i<adj[s].size();i++){
    int edge_s=adj[s][i];
    if(!edge[edge_s]) dfs(edge_s);
  }
}
int main()
{
  int t;
  cin>>t;
  while(t--){
    cin>>n>>m>>c_lib>>c_road;
    for(int i=0;i<=n;i++){
      edge[i]=false;
      adj[i].clear();
    }
    for(int i=0;i<m;i++){
      int x,y;
      cin>>x>>y;
      adj[x].push_back(y);
      adj[y].push_back(x);
    }
    long long ans=0;
    for(int i=1;i<=n;i++)
    {
      if(!edge[i]){
        c=0;
        dfs(i);
        ans+=c_lib;
        ans+=(c-1)*c_road;
      }
    }
    cout<<min(ans,(long long)c_lib*n)<<endl;
  }
  return 0;
}
