//Array must be sorted. Binary search approach.

#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int last_occurence(int a[], int lo, int hi, int key) {
    int res=-1;
    while(lo <= hi) {
        int mid = lo + (hi-lo)/2;
        if (a[mid]==key) {
            res = mid;
            lo = mid+1;
        }
        if (a[mid]<key) lo = mid+1;
        if (a[mid]>key) hi = mid-1;
    }
    return res;
}

int main() {
    int n,key;
    cout<<"Enter size: ";
    cin>>n;
    int a[n];
    cout<<"Enter array elements: ";
    for (int i=0; i<n; i++) cin>>a[i];
    cout<<"Enter key: ";
    cin>>key;
    int ub = last_occurence(a, 0, n-1, key);
    if (ub ==- 1) cout<<"The key is not present in the array!"<<endl;
    else cout<<"Upper bound of "<<key<<" is: "<<ub<<endl;
    return 0;
}
