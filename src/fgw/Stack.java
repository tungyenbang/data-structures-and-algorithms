package fgw;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<E> implements AbstractStack<E>{

    private class Node<E>{
        private E element;

        private Node<E> next;

        private Node<E> previous;

        public Node(E element) {
            this.element = element;
        }
    }


    private Node<E> top;

    private int size;

    public Stack(){
        top = null;
        size = 0;

    }

    @Override
    public void push(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.next = top;
        top = newNode;
        size++;
    }

    @Override
    public E pop() {
        if(top == null){
            throw new NoSuchElementException();
        }
        E element = top.element;
        top = top.next;
        size--;
        return element;
    }

    @Override
    public E peek() {
        if(top == null){
            throw new NoSuchElementException();
        }

        return top.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public String toString(){
        Node<E> current = top;
        StringBuilder result = new StringBuilder();
        result.append("[");
//        result.append("");
        System.out.println();
        while (current != null){
            result.append(current.element);
            if(current.next != null) {
                result.append(", ");

            }
            current = current.next;
        }
//        result.append("");
        result.append("]");
        return result.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> current = top;
            @Override
            public boolean hasNext() {
                if(current != null){
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public E next() {
                if(current == null){
                    throw new NoSuchElementException();
                }
                E element = current.element;
                current = current.previous;
                return element;
            }
        };
    }



}
