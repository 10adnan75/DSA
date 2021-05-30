#include <bits/stdc++.h>
using namespace std;

int* two_sum(int a[], int lo, int hi, int target) {
    static int sum[] = {-1, -1};
    while (lo < hi) {
        int s = a[lo] + a[hi];
        if (s == target) {
            sum[0] = a[lo]; 
            sum[1] = a[hi];
            break;
        } else if (s < target) {
            lo++;
        } else {
            hi--;
        }
    }
    return sum;
}

int main() {
    int n, target;
    cout<<"Enter size: "; cin>>n;
    int a[n];
    cout<<"Enter keys: "; for (int i=0; i<n; i++) cin>>a[i];
    sort(a, a+n);
    cout<<"Enter target: "; cin>>target;
    int* x;
    x = two_sum(a, 0, n-1, target);
    if (x[0]==-1 and x[1]==-1) {
        cout<<"Sum is not present!\n";   
    } else {
	cout<<"Values: "<<*(x+0)<<" "<<*(x+1)<<"\n";
    }
    return 0;
}

/*  OUTPUT:
    Enter size: 5
    Enter keys: 4 2 1 5 3
    Enter target: 7
    Values: 2 5
*/    
