#include <iostream>

using namespace std;

void swap(int* a, int* b) {
    int temp = *a;
    *a = *b;
    *b = temp;
    return;
}

int main() {
    int a = 2;
    int b = 3;
    int* pointsToA = &a;
    int* pointsToB = &b;
    cout << "*pointsToA = " << *pointsToA << endl;
    cout << "*pointsToB = " << *pointsToB << endl;
    cout << "Skiptum á gildum" << endl;
    swap(pointsToA, pointsToB);
    cout << "*pointsToA = " << *pointsToA << endl;
    cout << "*pointsToB = " << *pointsToB << endl;
    return 0;
}
