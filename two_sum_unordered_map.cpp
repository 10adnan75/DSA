#include <bits/stdc++.h>
using namespace std;

vector<int> two_sum(vector<int>& a, int target) {
    unordered_map<int, int> s;
    for (int i=0; i<a.size(); i++) {
        if (s.find(target-a[i]) != s.end()) return {s[target-a[i]], i};
        s[a[i]] = i;
    }
    return {-1, -1};
}

int main() {
    int n, target;
    cout<<"Enter size: "; cin>>n;
    vector<int> a(n);
    cout<<"Enter keys: "; for (auto &i : a) cin>>i;
    cout<<"Enter target: "; cin>>target;
    vector<int> x = two_sum(a, target);
    if (x[0]==-1 and x[1]==-1) {
        cout<<"Sum is not present!";
    } else {
        cout<<"Values: "; 
        for (auto &i : x) cout<<a[i]<<" ";
    }
    return 0;
}
