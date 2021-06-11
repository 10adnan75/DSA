#include <iostream>
using namespace std;

void reverse(int* p, int N) {
    for (int i=0; i<N/2; i++) {
        int temp = *(p+i);
        *(p+i) = *(p+N-i-1);
        *(p+N-i-1) = temp;
    }
}

int main() {
    int N;
    cout<<"Enter size: "; cin>>N;
    int* p, a[N];
    p = a;
    cout<<"Enter keys: "; for (int i=0; i<N; i++) cin>>*(p+i);
    reverse(p, N);
    cout<<"Reversed array: "; for (int i=0; i<N; i++) cout<<*(p+i)<<" ";
    return 0;
}

/*  OUTPUT:
    Enter size: 5
    Enter keys: 1 2 3 -1 5
    Reversed array: 5 -1 3 2 1 
*/
