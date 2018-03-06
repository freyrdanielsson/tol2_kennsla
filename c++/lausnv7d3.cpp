#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Node {
    /*
    Táknar hnút í tvíleitartré sem inniheldur strengi
    */
   public:
    string data;
    Node* left;
    Node* right;

    Node(string data) {
        /*
        Býr til nýjan barnlausan hnút sem inniheldur strenginn <data>
        */
        this->data = data;
        this->left = nullptr;
        this->right = nullptr;
    }

    ~Node() {
        /*
        Passar endurkvæmt upp á að engin börn séu skilin eftir í reiðileysi
        */
        delete this->left;
        delete this->right;
    }

    void showchildren() {
        /*
        Hnútar skrifaðir út í miðröð
        */
        if (this->left != nullptr) {
            this->left->showchildren();
        }
        cout << this->data << " ";
        if (this->right != nullptr) {
            this->right->showchildren();
        }
    }
};

class StringSearchTree {
    /*
    Táknar tvíleitartré sem inniheldur strengi.
    Samanburðir fara fram á strengjunum sjálfum.
    Einu aðgerðirnar sem eru studdar eru innsetning (put) og uppfletting (contains)
    */
   public:
    StringSearchTree() {
        /*
        Upphafsstillir tómt (hnútalaust) tvíleitartré.
        */
        this->root = nullptr;
    };

    ~StringSearchTree() {
        /*
        Eyðingu úthlutað til klasans Node.
         */
        delete this->root;
    }

    void put(string data) {
        /*
        Býr til hnút utan um strenginn <data> og setur hann á réttan stað í tvíleitartréð.
        Sé hnútur með sömu gögn þegar í trénu er þeim ekki bætt við aftur.
        Strengurinn <data> þarf að vera skilgreindur, ekki þarf að meðhöndla nullptr.
        */
        this->root = put(this->root, data);
    }

    bool contains(string data) {
        /*
        Skilar sönnu sé <data> í trénu, annars ósönnu.
         */
        return contains(this->root, data);
    }

   private:
    Node* root;

    Node* put(Node* node, string data) {
        /*
        Kemur gögnunum <data> fyrir í nýjum hnúti í stað <node> sé <node> tómur, að öðrum kosti á réttan stað meðal
        barna hans. Sjá put(string data).
        */
        if (node == nullptr) {
            return new Node(data);
        }
        if (data < node->data) {
            node->left = put(node->left, data);
        } else if (node->data < data) {
            node->right = put(node->right, data);
        } else {
            node->data = data;
        }
        return node;
    }

    bool contains(Node* node, string data) {
        /*
        Athugar hvort <data> sé í hnútnum <node> eða meðal barna hans. Sjá contains(string data)
        */
        return node != nullptr && (node->data == data || contains(node->left, data) || contains(node->right, data));
    }

    friend ostream& operator<<(std::ostream& os, StringSearchTree& tree);
};

ostream& operator<<(ostream& os, StringSearchTree& tree) {
    tree.root->showchildren();
    return os;
};

int main() {
    /*
    Tvíleitartréð prófað með því að setja í það ávexti.
    */

    StringSearchTree tree;

    // Skilgreinum ávextina okkar
    vector<string> fruits = {"Ananas", "Banani", "Epli", "Greip", "Mandarína",
                             "Mangó", "Melóna", "Sítróna", "Stjörnuávöxtur", "Súraldin"};
    // Innsetningin á að virka óháð innsetningarröð
    random_shuffle(fruits.begin(), fruits.end());
    cout << "Setjum ávexti í tréð í eftirfarandi röð:" << endl;
    for (string fruit : fruits) {
        cout << fruit << " ";
        tree.put(fruit);
    }
    cout << endl << endl;

    // Athugum hvort tréð innihaldi ávextina
    int missing = 0;
    for (string fruit : fruits) {
        if (!tree.contains(fruit)) {
            missing++;
        }
    }
    if (0 < missing) {
        cout << missing << " ávextir skiluðu sér ekki í tréð.";
    } else {
        cout << "Allir ávextirnir lentu í trénu." << endl;
    }
    if (tree.contains("Ferskja")) {
        cout << "Ferskja fannst í trénu sem ekki var sett þangað. Þetta er villa." << endl << endl;
    } else {
        cout << "Engin ferskja er í trénu, sem er eðlilegt." << endl << endl;
    }

    cout << "Skrifum út ávextina í trénu í réttri röð:" << endl;
    cout << tree << endl;
}