package com.mousbah.algorithms.bst;

public class App {

    public static void main(String[] args) {

        Tree<Integer> bst1 = new BinarySearchTree<>();

        bst1.insert(2);
        bst1.insert(55);
        bst1.insert(67);
        bst1.insert(12);
        bst1.insert(11);

        Tree<Integer> bst2 = new BinarySearchTree<>();

        bst2.insert(2);
        bst2.insert(5);
        bst2.insert(67);
        bst2.insert(12);
        bst2.insert(11);

        System.out.println(bst2.equals(bst1));
    }
}
