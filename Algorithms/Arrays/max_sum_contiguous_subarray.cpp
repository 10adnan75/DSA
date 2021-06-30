/** Find the contiguous subarray within an array, A of length N which has the largest sum.
 *  e.g.: i. A = [1, 2, 3, 4, -10]
 *           The subarray [1, 2, 3, 4] has the maximum possible sum of 10.
 * 
 *       ii. A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 *           The subarray [4,-1,2,1] has the maximum possible sum of 6.
 */
 
#include <iostream>
#include <vector>
#include <climits>
using namespace std;

int max_sum_array(vector<int> A) {
    int max_so_far = INT_MIN;
    int max_ending_here = 0;
    
    for (int i=0; i<A.size(); i++) {
        if (A[i] <= max_ending_here + A[i]) {
            max_ending_here += A[i];
        } else {
            max_ending_here = A[i];
        }
        
        if (max_ending_here > max_so_far) {
            max_so_far = max_ending_here;
        } 
    }

    return max_so_far;
}

int main() {
    int n;
    cout<<"Enter size: "; cin>>n;
    vector<int> A(n);
    cout<<"Enter keys: ";
    for (int i; cin>>i; ) A.push_back(i);
    cout<<"Maximum possible sum is: "<<max_sum_array(A);
    return 0;
}

/*  OUTPUT:
    Enter size: 9
    Enter keys: -2, 1, -3, 4, -1, 2, 1, -5, 4
    Enter size: Maximum possible sum is: 6
*/
