/** Given an integer array A of size N. You need to check that whether there exist a element which is strictly 
 *  greater than all the elements on left of it and strictly smaller than all the elements on right of it.
 *  If it exists return its index else -1.
 *  NOTE: Do not consider the corner elements i.e A[0] and A[N-1] as the answer.
 *  for e.g: i. A = [5, 1, 4, 3, 6, 8, 10, 7, 9], return 4.
 *              A[4] = 6 is the element we are looking for.
 *              All elements on left of A[4] are smaller than it and all elements on right are greater.
 *           
 *          ii. A = [5, 1, 4, 4], return -1.
 *              No such element exits.
 */

#include <bits/stdc++.h>
using namespace std;

int perfect_peak(vector<int> &A) {
    int n = A.size();
    vector<int> prefix(n);
    vector<int> suffix(n);
    
    prefix[0] = A[0];
    for (int i=1; i<n; i++) {
        prefix[i] = max(prefix[i-1], A[i]);
    }
    
    suffix[n-1] = A[n-1];
    for (int i=n-2; i>=0; i--) {
        suffix[i] = min(suffix[i+1], A[i]);
    }
    
    for (int i=1; i<=n-2; i++) {
        if (prefix[i-1]<A[i] and suffix[i+1]>A[i]) {
            return i;
        }
    }
    return -1;
}

int main() {
    std::vector<int> A;
    int n;
	cout<<"Enter size: "; cin>>n;
	cout<<"Enter keys: ";
	for (int i=0; i<n; i++) {
	    int x; cin>>x;
	    A.push_back(x);
	}
	int index = perfect_peak(A);
	if (index == -1) cout<<"No such element exists.\n";
	else cout<<"Element present at A["<<index<<"].\n";
	return 0;
}

/*  OUTPUT:
    Enter size: 9
    Enter keys: 5 1 4 3 6 8 10 7 9
    Element present at A[4].
*/
