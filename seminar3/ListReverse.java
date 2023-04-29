package seminar3;

public class ListReverse {
    public static void main(String[] args) {
        NodeList list = new NodeList();
        list.addNode(22);
        list.addNode(90);
        list.addNode(15);

        list.printNodes();

        System.out.println("------------Разворот односвязного списка------------");
        list.NodeListReverse();
        list.printNodes();

        System.out.println("------------Добавляем в список значение------------");
        list.addNode(93);
        list.printNodes();

        System.out.println("-------------Разворот списка-----------");
        list.NodeListReverse();
        list.printNodes();
    }
}

class NodeList {
    Node head = null;
    Node tail = null;

    public void addNode(Integer value) {
        if (head == null) {
            head = new Node(value);
            tail = head;
        } else {
            Node currentNode = head;
            if (currentNode.next == null && !head.equals(tail)) {
                currentNode = tail;
                Node newNode = new Node(value);
                tail = newNode;
                newNode.next = currentNode;
            } else {
                while (currentNode.next != null) {
                    currentNode = currentNode.next;
                }

                currentNode.next = new Node(value);
                tail = currentNode.next;
            }

        }
    }

    public void printNodes() {
        Node current = this.head;
        if (current != null) {
            if (current.next == null) {
                current = this.tail;
            }
            while (current != null) {
                System.out.println(current.value);
                current = current.next;
            }
        }
    }

    public void NodeListReverse() {

        // если список не пустой
        if (this.head != null) {
            Node current = this.head;
            Node previous = null;

            if (current.next == null) {
                current = this.tail;
            }

            // если в списке больше одного элемента
            if (current.next != null) {
                while (current != null) {
                    Node temp = current.next;

                    current.next = previous;

                    previous = current;
                    current = temp;
                }
            }
        }
    }
}

class Node {
    Integer value;
    Node next;

    public Node(Integer val) {
        this.value = val;
        this.next = null;
    }
}