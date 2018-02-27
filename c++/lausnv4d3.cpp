#include <iostream>

using namespace std;

class Node {
    /*
     * Represents a node for use in a singly linked list
     */
   public:
    int data;
    Node* next;

    Node(int data, Node* next) {
        this->data = data;
        this->next = next;
    }
};

class Stack {
    /*
    Represents a LIFO Stack of arbitrary size
    */
   private:
    Node* head = nullptr;

   public:
    Stack() {}

    ~Stack() {
        // Destructor for cleaning up the trail of nodes
        Node* temp;
        while (!isEmpty()) {
            temp = this->head;
            this->head = this->head->next;
            delete temp;
        }
    }

    void push(int n) {
        // Adds a new integer to the Stack
        this->head = new Node(n, this->head);
    }

    int pop() {
        // Removes and returns the latest integer to be pushed to the stack
        if (this->isEmpty()) {
            throw underflow_error("Attempted to pop from an empty Stack");
        }
        Node* temp = this->head;
        int data = temp->data;
        this->head = this->head->next;
        delete temp;
        return data;
    }

    int peek() {
        if (this->isEmpty()) {
            throw underflow_error("Attempted to peek at an empty Stack");
        }
        return this->head->data;
    }

    bool isEmpty() { return this->head == nullptr; }
};

int main() {
    Stack s;
    cout << "Setjum tölurnar 1, 2 og 4 á hlaðann s." << endl;
    s.push(1);
    s.push(2);
    s.push(4);
    cout << "Stelum efsta stakinu, " << s.pop() << ", af s." << endl;
    cout << "Setjum tölurnar 8, 16 og 32 á s." << endl;
    s.push(8);
    s.push(16);
    s.push(32);

    cout << "Kíkjum á efsta stak s, það er " << s.peek() << "." << endl;

    cout << "Fjarlægjum nú tölurnar af s: " << endl;
    while (!s.isEmpty()) {
        cout << s.pop() << " ";
    }
    cout << endl;

    try {
        s.peek();
    } catch (underflow_error e) {
        cout << "Ekki tókst að kíkja á s, enda tómur" << endl;
    }

    try {
        s.pop();
    } catch (underflow_error e) {
        cout << "Ekki tókst að fjarlægja stak af s, enda tómur" << endl;
    }

    return 0;
}