#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void exch(vector<int> &a, int i, int j) {
    int swap = a[i];
    a[i] = a[j];
    a[j] = swap;
}

// partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
// and return the index j.
int partition(vector<int> &a, int lo, int hi) {
    int i = lo;
    int j = hi + 1;
    int v = a[lo];
    while (true) {

        // find item on lo to swap
        while (a[++i] < v)
            if (i == hi) break;

        // find item on hi to swap
        while (v < a[--j])
            if (j == lo) break;      // redundant since a[lo] acts as sentinel

        // check if pointers cross
        if (i >= j) break;

        exch(a, i, j);
    }

    // put partitioning item v at a[j]
    exch(a, lo, j);

    // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
    return j;
}

// quicksort the subarray from a[lo] to a[hi]
void quicksort(vector<int> &a, int lo, int hi) {
    if (hi <= lo) return;
    int j = partition(a, lo, hi);
    quicksort(a, lo, j - 1);
    quicksort(a, j + 1, hi);
}

void quicksort(vector<int> &a) {
    random_shuffle(a.begin(), a.end());
    quicksort(a, 0, a.size() - 1);
}

bool issorted(vector<int>& v) {
    /*
     * Athugar hvort vigurinn v sé í stígandi röð
     */
    cout << endl;
    for (int i = 1; i < v.size(); i++) {
        if (v[i] < v[i - 1]) {
            return false;
        }
    }
    return true;
}

int main() {
    // Prófum sort á vigrum af lengdunum 0, 101, og 1000:
    vector<int> sizes = {0, 10, 20};
    for (int n : sizes) {
        // Upphafstillum v með tölunum 0 upp í n-1 í slembinni röð
        vector<int> v(n);
        for (int i = 0; i < n; i++) {
            v[i] = i;
        }
        random_shuffle(v.begin(), v.end());

        // Röðum v aftur
        quicksort(v);

        // Athugum hvort röðunin tókst
        if (issorted(v)) {
            cout << "Röðun á " << v.size() << " staka vigri tókst" << endl;
        } else {
            cout << "Röðun á " << v.size() << " staka vigri mistókst" << endl;
        }
    }
}