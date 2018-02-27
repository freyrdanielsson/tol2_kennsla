#include <algorithm> // ef við viljum nota innbyggt sort t.d.
#include <iostream>
#include <vector>

using namespace std;

double median(vector<double> v) {
   //miðgildi
}

double mean(vector<double> v) {
   //meðaltal
}

double variance(vector<double> v) {
    //deifni
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