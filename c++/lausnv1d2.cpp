#include <iostream>

using namespace std;

class Fraction {
    /*
    Táknar almennt brot með teljara (e. numerator) og nefnara (e. denominator)//
    Represents a fraction with a numerator and denominator
    */
   private:
    int num;
    int den;

    int gcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        } else {
            return gcd(n2, n1 % n2);
        }
    }

   public:
    Fraction(int n, int d) {
        this->num = n;
        this->den = d;
        if (d == 0) {
            cerr << "Warning, zero denominator!" << endl;
        }
    }

    Fraction plus(Fraction f) {
        int n = this->num * f.den + f.num * this->den;
        int d = this->den * f.den;
        return Fraction(n, d);
    }

    void reduce() {
        int n = this->num;
        int d = this->den;
        int divisor = this->gcd(n, d);
        this->num = n / divisor;
        this->den = d / divisor;
    }

    void display() { cout << this->num << "/" << this->den << endl; }
};

int main() {
        cout << "Leggjum saman brotin 1/2 og 1/3 og birtum niðurstöðuna:" << endl;
    Fraction a(1, 2);
    Fraction b(1, 3);
    Fraction c = a.plus(b);
    c.display();
    cout << endl;

    cout << "Búum til og birtum brotið 4/6:" << endl;
    Fraction d(4, 6);
    d.display();
    cout << "Styttum brotið 4/6 og birtum það aftur:" << endl;
    d.reduce();
    d.display();
    cout << endl;

    cout << "Búum til brot með 0 í nefnara:" << endl;
    Fraction e(2, 0);
    return 0;
}