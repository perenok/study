package com.perenok.study.datastructure;

public class Tree<T> {

    private int count;

    public Tree() {
        count = 0;
    }

    Node addNode(T data) {
        Node<T> node = new Node<>(data);
        return node;
    }

    void preOrder(Node node) {

    }

    void inOrder(Node node) {

    }

    void postOrder(Node node) {

    }

    public class Node<T> {

        private T item;
        private Node<T> left;
        private Node<T> right;

        public Node(T item) {
            this.item = item;
            left = null;
            right = null;
        }

        public void addLeft(Node node) {
            left = node;
            count++;
        }

        public void addRight(Node node) {
            right = node;
            count++;
        }

        public void deleteLeft() {
            left = null;
            count--;
        }

        public void deleteRight() {
            right = null;
            count--;
        }
    }

}
