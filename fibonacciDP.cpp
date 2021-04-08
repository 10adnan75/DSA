// bottom-up approach in O(n) time

#include <iostream>

using namespace std;

int main() {
    int n;
    cout << "Enter number: ";
    cin >> n;
    long long bottom_up[n + 1];
    bottom_up[1] = 1;
    bottom_up[2] = 1;
    for (int i=3; i<n+1; i++) bottom_up[i] = bottom_up[i-1] + bottom_up[i-2];
    cout << bottom_up[n] << endl;
}