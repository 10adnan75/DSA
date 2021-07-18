#include <iostream>
using namespace std;

// left rotation
void rotate_by_one_left(int a[], int n) {
    int temp = a[0];
    for (int i=0; i<n; i++) {
        a[i] = a[i+1];
    }
    a[n-1] = temp;
}

// right rotation
void rotate_by_one_right(int a[], int n) {
    int temp = a[n-1];
    for (int i=n-1; i>=0; i--) {
        a[i] = a[i-1];
    }
    a[0] = temp;
}

void rotate(int left[], int right[], int step, int n) {
    for (int i=0; i<step; i++) {
        rotate_by_one_left(left, n);
        rotate_by_one_right(right, n);
    }
}

int main() {
	int size; 
	cout<<"Enter size: "; cin>>size;
	int a[size], left[size], right[size];
	cout<<"Enter keys: "; for (int i=0; i<size; i++) {
	    cin>>a[i];
	    left[i] = a[i];
	    right[i] = a[i];
	}
	int step;
	cout<<"How many times to rotate?: "; cin>>step;
	rotate(left, right, step, size);
	cout<<step<<" times left rotated array: "; for (int i=0; i<size; i++) cout<<left[i]<<" ";
	cout<<step<<" times right rotated array: "; for (int i=0; i<size; i++) cout<<right[i]<<" ";
	return 0;
}

/*  OUTPUT:
    Enter size: 5
    Enter keys: 1 2 3 4 5
    How many times to rotate?: 2
    5 times left rotated array: 3 4 5 1 2
    5 times right rotated array: 4 5 1 2 3 
*/
