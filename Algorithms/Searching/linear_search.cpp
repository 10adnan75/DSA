// if element found at last O(n) to O(1)
// if element not found O(n) to O(n/2)

#include <bits/stdc++.h>
using namespace std;

int search(int a[], int n, int x) {
    for (int left=0, right=n-1; left<=right; left++, right--) {
        //cout<<a[left]<<" "<<a[right]<<endl;
        if (a[left] == x) return left;
        if (a[right] == x) return right;
    }
    return -1;
}

int main() {
    int n, x;
    cout<<"Enter size: "; cin>>n;
    int a[n];
    cout<<"Enter keys: "; for (int i=0; i<n; ) cin>>a[i++];
    cout<<"Enter search key: "; cin>>x;
    int key = search(a, n, x);
    if (key == -1) {
        cout<<"Key not found!";   
    } else {
        cout<<"Key found at index: "<<key;
    }
	return 0;
}

/*  OUTPUT:
    Enter size: 7
    Enter keys: -1 0 5 3 1 4 2  
    Enter search key: 2
    Key found at index: 6
*/
