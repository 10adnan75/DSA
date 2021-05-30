#include <bits/stdc++.h>
using namespace std;

int* three_sum(vector<int>& a, int target) {
    bool found = false;
    int one = 0, two = 0, three = 0;
    static int sum[] = {-1, -1, -1};
    for (int i=0; i<a.size(); i++) {
        if (found) break;
        int lo = i + 1;
        int hi = a.size() - 1;
        while (lo < hi) {
            int curr = a[i] + a[lo] + a[hi];
            if (curr == target) {
                found = true;
                one = i;
                two = lo;
                three = hi;
                break;
            } else if (curr < target) {
                lo++;
            } else {
                hi--;
            }
        }
    }
    if (found) {
        sum[0] = a[one]; 
        sum[1] = a[two];
        sum[2] = a[three];
    }
    return sum;
}

int main() {
    int n, target;
    cout<<"Enter size: "; cin>>n;
    vector<int> a(n);
    cout<<"Enter keys: "; for (auto &i : a) cin>>i;
    sort(a.begin(), a.end());
    cout<<"Enter target: "; cin>>target;
    int* x;
    x = three_sum(a, target);
    if (x[0]==-1 and x[1]==-1 and x[2]==-1) {
        cout<<"Sum is not present!\n";   
    } else {
        cout<<"Values: "<<*(x+0)<<" "<<*(x+1)<<" "<<*(x+2)<<"\n";
    }
    return 0;
}

/*  OUTPUT:
    Enter size: 6
    Enter keys: 0 -1 -2 -3 -4 4
    Enter target: 0
    Values: -4 0 4
*/ 
