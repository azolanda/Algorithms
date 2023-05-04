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

        System.out.println(newTree.getRoot().getValue());
    }
}
