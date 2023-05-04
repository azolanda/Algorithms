package seminar4;

public class RedBlackTree {
    private Node root;
    private int n = 0;

    public Node getRoot() {
        return this.root;
    }

    private boolean isRoot(Node node) {
        if (this.root.equals(node)) {
            return true;
        }
        return false;
    }

    public void printTree(Node node) {
        String isRoot = "";

        if (node != null) {
            if (isRoot(node)) {
                isRoot = ", ROOT";
            }
            System.out.println(n++ + ": Node {" + node.toString() + isRoot + "}");
        }

        if (node.leftChild != null) {
            printTree(node.leftChild);
            if (node.rightChild != null) {
                printTree(node.rightChild);
            }
        }
    }

    public boolean add(int value) {
        if (root != null) {
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        } else {
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }
    }

    private boolean addNode(Node node, int value) {
        if (node.value == value) {
            return false;
        } else {
            if (node.value > value) {
                if (node.leftChild != null) {
                    boolean result = addNode(node.leftChild, value);
                    node.leftChild = rebalance(node.leftChild);
                    return result;
                } else {
                    node.leftChild = new Node();
                    node.leftChild.color = Color.RED;
                    node.leftChild.value = value;
                    return true;
                }
            } else {
                if (node.rightChild != null) {
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild = rebalance(node.rightChild);
                    return result;
                } else {
                    node.rightChild = new Node();
                    node.rightChild.color = Color.RED;
                    node.rightChild.value = value;
                    return true;
                }
            }
        }
    }

    private Node rebalance(Node node) {
        Node result = node;
        boolean needRebalance;

        do {
            needRebalance = false;

            if (result.rightChild != null && result.rightChild.color == Color.RED &&
                    (result.leftChild == null || result.leftChild.color == Color.BLACK)) {
                needRebalance = true;
                result = rightSwap(result);
            }

            if (result.leftChild != null && result.leftChild.color == Color.RED &&
                    result.leftChild.leftChild != null && result.leftChild.leftChild.color == Color.RED) {
                needRebalance = true;
                result = leftSwap(result);
            }

            if (result.leftChild != null && result.leftChild.color == Color.RED &&
                    result.rightChild != null && result.rightChild.color == Color.RED) {
                needRebalance = true;
                colorSwap(result);
            }
        } while (needRebalance);

        return result;
    }

    private Node leftSwap(Node node) {
        Node leftChild = node.leftChild;
        Node betweenChild = node.rightChild;

        leftChild.rightChild = node;
        node.leftChild = betweenChild;
        leftChild.color = node.color;
        node.color = Color.RED;

        return leftChild;
    }

    private Node rightSwap(Node node) {
        Node rightChild = node.rightChild;
        Node betweenChild = rightChild.leftChild;

        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;

        return rightChild;
    }

    private void colorSwap(Node node) {
        node.rightChild.color = Color.BLACK;
        node.leftChild.color = Color.BLACK;
        node.color = Color.RED;
    }

    class Node {
        private int value;
        private Color color;
        private Node leftChild;
        private Node rightChild;

        public int getValue() {
            return this.value;
        }

        public Color getColor() {
            return this.color;
        }

        @Override
        public String toString() {
            return "value: " + getValue() + ", color: " + getColor();
        }
    }

    private enum Color {
        RED, BLACK;
    }
}
