#include <map>
#include <unordered_map>
#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int main() {
    /*
     * Upphafsstillum vigra með strengjum lesnum inn af staðalinntaki
     */
    vector<string> words;
    vector<string> shuffledwords;
    string s;
    while (getline(cin, s)) {
        words.push_back(s);
    }
    shuffledwords = words;
    random_shuffle(shuffledwords.begin(), shuffledwords.end());

    clock_t c;


    /*
     * Strengir, röðuð nafnatafla
     */
    cout << "Tímamæling á strengjum í raðaðri vörpun:" << endl;
    map<string, int> om;
    c = clock();
    for (int i = 0; i < shuffledwords.size(); i++) {
        om[shuffledwords[i]]=i;
    }
    cout << "Innsetningu lokið á: " << (clock() - c) << " klukkupúlsum" << endl;
    c = clock();
    for (int i = 0; i < words.size(); i++) {
        om.find(words[i]);
    }
    cout << "Uppflettingu lokið á: " << (clock() - c) << " klukkupúlsum" << endl << endl;

    /*
     * Strengir, óröðuð nafnatafla
     */

    unordered_map<string, int> uom;
    cout << "Tímamæling á strengjum í óraðaðri vörpun:" << endl;
    c = clock();
    for (int i = 0; i < shuffledwords.size(); i++) {
        uom[shuffledwords[i]]=i;
    }
    cout << "Innsetningu lokið á: " << (clock() - c) << " klukkupúlsum" << endl;
    c = clock();
    for (int i = 0; i < words.size(); i++) {
        uom.find(words[i]);
    }
    cout << "Uppflettingu lokið á: " << (clock() - c) << " klukkupúlsum" << endl << endl;

    return 0;
}