#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

void quickrec(vector<int>& v, int lo, int hi) {
if(hi <= lo) return;
int i = lo, j = hi + 1;
int p = v[lo];
while(true) {
while(v[++i] < p) if(i == hi) break;
while(p < v[--j]) if(j == lo) break;
if(i >= j) break;
swap(v[i], v[j]);
}
swap(v[lo], v[j]);
quickrec(v, lo, j - 1);
quickrec(v, j + 1, hi);
}
void quicksort(vector<int>& v) {
random_shuffle(v.begin(), v.end());
quickrec(v, 0, v.size() - 1);
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