package seminar4;

public class MainCreateTree {
    public static void main(String[] args) {
        RedBlackTree newTree = new RedBlackTree();

        newTree.add(10);
        newTree.add(5);
        newTree.add(2);
        newTree.add(12);
        newTree.add(42);
        newTree.add(15);
        newTree.add(37);
        newTree.add(29);
        newTree.add(7);
        newTree.add(87);
        newTree.add(55);
        newTree.add(67);
        newTree.add(99);
        newTree.add(121);
        newTree.add(94);

        newTree.printTree(newTree.getRoot());
    }
}
