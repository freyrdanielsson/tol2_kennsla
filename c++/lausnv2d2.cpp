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

        ~Node() {
            if (this->next != nullptr) {
                cout << "eyða node" << endl;
                delete this->next;
            }
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
        delete this->head;
        // Almennt er mikill óþarfi að láta eyði skrifa á staðalúttakið, en hér er það gert til að við sjáum að á hann
        // sé kallað:
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
        Node* node = new Node(c, this->head);
        this->head = node;
        this->length += 1;
    }

    char operator[](int n) {
        Node* node = this->head;
        int i = 0;
        if (n < 0 || this->length <= n) {
            throw out_of_range("Index out of range");
        }
        while (node != nullptr && i < n) {
            node = node->next;
            i++;
        }
        return node->data;
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