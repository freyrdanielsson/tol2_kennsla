#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

double median(vector<double> v) {
    sort(v.begin(), v.end());
    int n = v.size();
    if (n % 2 == 0) {
        // cout << "even. " << n / 2 -1 << " " << n / 2 << endl;
        return (v[n / 2 - 1] + v[n / 2]) / 2;
    } else {
        // cout << "odd. " << n / 2 << endl;
        return (v[n / 2]);
    }
}

double mean(vector<double> v) {
    double sum = 0;
    for (double d : v) {
        sum += d;
    }
    return sum / v.size();
}

double variance(vector<double> v) {
    double var = 0;
    double m = mean(v);
    for (double d : v) {
        var += (d - m) * (d - m);
    }
    return var / v.size();
}

int main() {
    vector<double> v;
    double i;
    while (cin >> i) {
        v.push_back(i);
    }
    cout << "Miðgildi talnanna er " << median(v) << endl;
    cout << "Dreifni talnanna er  " << variance(v) << endl;
    return 0;
}
