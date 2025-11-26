package com.MiniProject03;

public class collectionUtil {
    /**
     * Generic Stack and Queue implementation.
     */
    public class CollectionUtil {

        // ---------------- STACK ----------------
        public static class Stack<T> {

            private Node<T> top;
            private int size = 0;

            private static class Node<T> {
                T value;
                Node<T> next;
                Node(T val, Node<T> next) { this.value = val; this.next = next; }
            }
            public void push(T v) {
                top = new Node<>(v, top);
                size++;
            }
            public T pop() {
                if (top == null) throw new RuntimeException("Stack empty");
                T v = top.value;
                top = top.next;
                size--;
                return v;
            }
            public T peek() {
                if (top == null) throw new RuntimeException("Stack empty");
                return top.value;
            }

            public boolean isEmpty() { return top == null; }
            public int size() { return size; }
        }

        // ---------------- QUEUE ----------------
        public static class Queue<T> {

            private Node<T> head, tail;
            private int size = 0;

            private static class Node<T> {
                T value;
                Node<T> next;
                Node(T val) { this.value = val; }
            }
            public void enqueue(T v) {
                Node<T> node = new Node<>(v);
                if (tail != null) tail.next = node;
                tail = node;
                if (head == null) head = node;
                size++;
            }
            public T dequeue() {
                if (head == null) throw new RuntimeException("Queue empty");
                T v = head.value;
                head = head.next;
                if (head == null) tail = null;
                size--;
                return v;
            }
            public T peek() {
                if (head == null) throw new RuntimeException("Queue empty");
                return head.value;
            }
            public boolean isEmpty() { return head == null; }

            public int size() { return size; }
        }
    }

}
