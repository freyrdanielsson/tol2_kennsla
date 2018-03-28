#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

void exch_shifted(vector<int>& v, int i, int j) {
    int swap = v[i - 1];
    v[i - 1] = v[j - 1];
    v[j - 1] = swap;
}

bool less_shifted(vector<int>& v, int i, int j) {
    return v[i - 1] < v[j - 1];
}

void sink(vector<int>& v, int k, int n) {
    while (2 * k <= n) {
        int j = 2 * k;
        if (j < n && less_shifted(v, j, j + 1))
            j++;
        if (!less_shifted(v, k, j))
            break;
        exch_shifted(v, k, j);
        k = j;
    }
}

void heapsort(vector<int>& v) {
    int n = v.size();
    for (int k = n / 2; k >= 1; k--)
        sink(v, k, n);
    while (n > 1) {
        exch_shifted(v, 1, n--);
        sink(v, 1, n);
    }
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
    vector<int> sizes = {0, 101, 1000}; // nota c++11
    for (int n : sizes) {
        // Upphafstillum v með tölunum 0 upp í n-1 í slembinni röð
        vector<int> v(n);
        for (int i = 0; i < n; i++) {
            v[i] = i;
        }
        random_shuffle(v.begin(), v.end());

        // Röðum v aftur
        heapsort(v);

        // Athugum hvort röðunin tókst
        if (issorted(v)) {
            cout << "Röðun á " << v.size() << " staka vigri tókst" << endl;
        } else {
            cout << "Röðun á " << v.size() << " staka vigri mistókst" << endl;
        }
    }
}