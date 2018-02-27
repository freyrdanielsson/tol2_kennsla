#include <iostream>
#include <stdexcept>

using namespace std;

class Fraction {
    /*
    Táknar almennt brot með teljara (e. numerator) og nefnara (e. denominator)
    */
   protected:
    int num;
    int den;

    int gcd(int n1, int n2) {
        /*
        Finnur stærsta samdeili heiltalnanna n1 og n2
        */
        if (n2 == 0) {
            return n1;
        } else {
            return gcd(n2, n1 % n2);
        }
    }

    void reduce() {
        /*
        Styttir brotið svo að teljarinn og nefnarinn séu af lágmarksstærð
        */
        int n = this->num;
        int d = this->den;
        int divisor = this->gcd(n, d);
        this->num = n / divisor;
        this->den = d / divisor;
    }

   public:
    Fraction(int n, int d) {
        this->num = n;
        this->den = d;
        if (d == 0) {
            throw logic_error("Error, zero denominator!");
        }
        this->reduce();
    }

    Fraction operator+(Fraction f) {
        int n = this->num * f.den + f.num * this->den;
        int d = this->den * f.den;
        return Fraction(n, d);
    }

    // Hingað skal bæta við aðferðum til að láta * virkjann virka

    // ostream veittur aðgangur að protected eiginleikum klasans
    friend ostream& operator<<(std::ostream& os, Fraction f);
};

ostream& operator<<(ostream& os, Fraction f) {
    /*
    Útskýrt hvernig ostream skal hegða sér þegar hann rekst á tilvik af Fraction
    */
    os << f.num << "/" << f.den;
    return os;
};

class MixedFraction : public Fraction {
   public:
    MixedFraction(int num, int den) : Fraction(num, den) {}

    // Hér þarf að bæta við öðrum smið (Fyrir MixedFraction(int whole, int num, int den))

    friend ostream& operator<<(std::ostream& os, MixedFraction f);
};

ostream& operator<<(ostream& os, MixedFraction f) {
    // Hingað vantar kóða
		// Hvað eru mörg tilvik sem geta komið upp?
		// þarf að stytta brot?....... ¯\_(ツ)_/¯
    os << Fraction(f.num, f.den); // Þessari línu þarf að henda 
    return os;
};

int main() {
    cout << "Búum til og birtum brotið 4/3 sem Fraction: ";
    cout << Fraction(4, 3) << endl;

    cout << "Margföldum saman Fraction-in 1/2 og 2/3: ";
    // Afkommentið næstu línu fyrir skil
    //cout << Fraction(1, 2) * Fraction(2, 3) << endl;

    cout << "Búum til og birtum brotið 1/4 sem MixedFraction: ";
    cout << MixedFraction(1, 4) << endl;

    cout << "Búum til og birtum brotið 4/1 sem MixedFraction: ";
    cout << MixedFraction(4, 1) << endl;

    cout << "Búum til og birtum brotið 0/2 sem MixedFraction: ";
    cout << MixedFraction(0, 2) << endl;

    cout << "Búum til og birtum brotið 7/6 sem MixedFraction: ";
    cout << MixedFraction(7, 6) << endl;

    cout << "Búum til og birtum brotið 1 1/3 sem MixedFraction: ";
    // Afkommentið næstu línu fyrir skil
    //cout << MixedFraction(1, 1, 3) << endl;

    return 0;
}