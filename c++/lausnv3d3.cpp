#include <iostream>
#include <stdexcept>

using namespace std;

template <class T>
class SinglyLinkedList {
   private:
    class Node {
       public:
        Node* next;
        T data;

        Node(T data, Node* next) {
            this->data = data;
            this->next = next;
        }

        ~Node() {
            if (this->next != nullptr) {
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

    ~SinglyLinkedList() { delete this->head; }

    int size() { return this->length; }

    void display() {
        for (Node* node = this->head; node != nullptr; node = node->next) {
            cout << node->data << " -> ";
        }
        cout << "Ø" << endl;
    }

    void prepend(T c) {
        this->head = new Node(c, this->head);
        this->length += 1;
    }

    T operator[](int n) {
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

    void reverse() {
        Node* previous = nullptr;
        Node* current = this->head;
        Node* next;
        while (current != nullptr) {
            next = current->next;
            current->next = previous;
            previous = current;
            current = next;
        }
        this->head = previous;
    }
};

int main() {
    // Skilgreining lista sem inniheldur tákn
    SinglyLinkedList<char> list;
    list.prepend('G');
    list.prepend('3');
    list.prepend('0');
    list.prepend('2');
    list.prepend('L');
    list.prepend('O');
    list.prepend('T');

    list.display();

    list.reverse();

    list.display();

    return 0;
}