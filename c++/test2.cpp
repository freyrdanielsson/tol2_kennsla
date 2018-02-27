#include <iostream>
#include <stdexcept>

using namespace std;

class SinglyLinkedList {
   private:
    class Node {
       public:
        Node* next;
        char data;

        Node(char data, Node* next) {
            this->data = data;
            this->next = next;
        }
    };

    Node* head;
    int length;

   public:
    SinglyLinkedList() {
        this->head = nullptr;
        this->length = 0;
    }

    ~SinglyLinkedList() {
        // Hér þarf að bæta við kóða.
        // Almennt er óþarfi að láta eyði skrifa út, en hér er það gert til að við sjáum að á hann sé kallað:
				// hvenær keyrist þetta?
				// https://www.geeksforgeeks.org/destructors-c/
				// tvær leiðir
				// eyða bendum hér (sem Ernir boss vill að þið gerið til að auka hnúta-mixing skills)
				// setja eyði á Node klasann (sem allur heimurinn mundi frekar gera)
        cout << "Kallað hefur verið á eyðinn fyrir listann" << endl;
    }

    int size() { return this->length; }

    void display() {
        for (Node* node = this->head; node != nullptr; node = node->next) {
            cout << node->data << " -> ";
        }
        cout << "Ø" << endl;
    }

    void prepend(char c) {
        // Hér þarf að bæta við kóða
				// þetta á að bæta við hnút með gildi c fremst í listan
				// nýrHnútur [c | -]--> hvað kemur hér???!!! ¯\_(ツ)_/¯
    }

    char operator[](int n) {
        // Hér þarf að bæta við kóða, fjölbinding á []
				// skilar char tekur inn int.
				// Notkun listi[n]
        
        // Allir listar eru of stuttir þegar engir eru hnútarnir
				// Basilcu hvenær viltu kasta þessari villu..
        throw out_of_range("Index out of range");
    }
};

int main() {
    // Skilgreining lista sem inniheldur tákn
    SinglyLinkedList list;
    list.prepend('G');
    list.prepend('3');
    list.prepend('0');
    list.prepend('2');
    list.prepend('L');
    list.prepend('O');
    list.prepend('T');

    list.display();

    cout << "Stak 0 í listanum er " << list[0] << endl;
    cout << "Stak 3 í listanum er " << list[3] << endl;

    return 0;
}