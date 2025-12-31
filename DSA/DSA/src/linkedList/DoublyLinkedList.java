package linkedList;

class DoublyLinkedList {

    // Node definition
    class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;
    int size = 0;

    // Insert at beginning
    void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // Insert at end
    void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // Insert at position (1-based index)
    void insertAtPosition(int data, int pos) {
        if (pos < 1 || pos > size + 1) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 1) {
            insertAtBeginning(data);
            return;
        }

        if (pos == size + 1) {
            insertAtEnd(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 1; i < pos - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;

        size++;
    }

    // Delete from beginning
    void deleteFromBeginning() {
        if (head == null) return;

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    // Delete from end
    void deleteFromEnd() {
        if (tail == null) return;

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    // Delete by value
    void deleteByValue(int key) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == key) {

                if (temp == head) {
                    deleteFromBeginning();
                } else if (temp == tail) {
                    deleteFromEnd();
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                    size--;
                }
                return;
            }
            temp = temp.next;
        }

        System.out.println("Value not found");
    }

    // Forward traversal
    void displayForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Backward traversal
    void displayBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("NULL");
    }

    // Search element
    boolean search(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key)
                return true;
            temp = temp.next;
        }
        return false;
    }

    // Get size
    int getSize() {
        return size;
    }

    // Main method for testing
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertAtBeginning(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        dll.insertAtPosition(15, 2);

        dll.displayForward();
        dll.displayBackward();

        dll.deleteByValue(20);
        dll.displayForward();
       

        System.out.println("Search 15: " + dll.search(8));
        System.out.println("Size: " + dll.getSize());
    }
}
