// Binary search approach, ~ O(log N)

#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int first_occurence(int a[], int lo, int hi, int key) {
    int res=-1;
    while(lo <= hi) {
        int mid = lo + (hi-lo)/2;
        if (a[mid]==key) {
            res = mid;
            hi = mid-1;
        }
        if (a[mid]<key) lo = mid+1;
        if (a[mid]>key) hi = mid-1;
    }
    return res;
}

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

int count(int a[], int lo, int hi, int key) {
    int first = first_occurence(a, lo, hi, key);
    int last = last_occurence(a, lo, hi, key);
    if(first==-1 || last==-1) return 0;
    return last - first + 1;
}

int main() {
    int n,key;
    cout<<"Enter size: ";
    cin>>n;
    int a[n];
    cout<<"Enter array elements: ";
    for (int i=0; i<n; i++) cin>>a[i];
    sort(a, a+n);
    cout<<"Enter key: ";
    cin>>key;
    cout<<"Count of "<<key<<" is: "<<count(a, 0, n-1, key)<<endl;
    return 0;
}
