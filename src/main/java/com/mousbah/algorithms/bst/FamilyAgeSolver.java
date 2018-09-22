package com.mousbah.algorithms.bst;

public class FamilyAgeSolver {

    private BinarySearchTree<Person> binarySearchTree;

    public FamilyAgeSolver(BinarySearchTree<Person> binarySearchTree) {
        this.binarySearchTree = binarySearchTree;
    }

    public int calculateSum() {
        return visitNode(binarySearchTree.getRoot());
    }

    private int visitNode(Node<Person> node) {
        if (node == null) {
            return 0;
        }
        return node.getData().getAge() + visitNode(node.getLeftChild()) + visitNode(node.getRightChild());
    }

    public static void main(String[] args) {
        BinarySearchTree<Person> bst = new BinarySearchTree<>();
        Person root = new Person("Mo", 28);
        Person p1 = new Person("A", 2);
        Person p2 = new Person("B", 10);
        Person p3 = new Person("C", 20);
        Person p4 = new Person("D", 40);
        bst.insert(root);
        bst.insert(p1);
        bst.insert(p2);
        bst.insert(p3);
        bst.insert(p4);

        FamilyAgeSolver familyAgeSolver = new FamilyAgeSolver(bst);
        System.out.println(familyAgeSolver.calculateSum());
    }
}
