#include <bits/stdc++.h>

using namespace std;

long long int fact(long long int num) {
    if (num <= 1) return 1;
    return num * fact(num-1);
}

int main() {
    long long int num;
    cout<<"Enter number: ";
    cin>>num;
    cout<<"Factorial of "<<num<<" is: "<<fact(num)<<endl;
}

/*  OUTPUT:
    Enter number: 20
    Factorial of 20 is: 2432902008176640000
*/
