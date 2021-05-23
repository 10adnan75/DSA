#include <bits/stdc++.h>
using namespace std;

int main() {
    cout<<"Enter size: ";
    int i, N; cin>>N;
    int a[N];
    cout<<"Enter elements (0, 1, 2): "; for (i=0; i<N; i++) cin>>a[i];
    int count[3]={0};
    for (i=0; i<N; i++) count[a[i]]++;
    i=0;
    while (count[0]>0) {
        a[i++] = 0; count[0]--;
    }
    while (count[1]>0) {
        a[i++] = 1; count[1]--;
    }
    while (count[2]>0) {
        a[i++] = 2; count[2]--;
    }
    for (i=0; i<N; i++) cout<<a[i]<<" ";
    return 0;
}
