package fgw;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<E> implements AbstractQueue<E>{

    private class Node<E>{
        private E element;

        private Node<E> next;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }
    }

    private Node<E> head;

    private Node<E> tail;

    private int size;

    public Queue(){
        head = tail = null;
        size = 0;
    }


    @Override
    public void offer(E element) {
        Node<E> newNode = new Node<>(element);
        if(head == null ){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E poll() {
        if(head == null){
            throw new NoSuchElementException();
        }
        if(size == 0){
            tail = null;
        }
        E element = head.element;
        head = head.next;
        size--;
        return element;
    }

    @Override
    public E peek() {
        if(head == null){
            throw new NoSuchElementException();
        }
        return head.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size == 0 & head == null){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        Node<E> current = head;
        StringBuilder result = new StringBuilder();
        result.append("[");
        while (current != null) {
            result.append(current.element);
            if (current.next != null) {
                result.append(", ");
            }
            current = current.next;
        }
        result.append("]");
        return result.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>( ) {
            private Node<E> current = head;
            public boolean hasNext( ) {
                return current != null;
            }
            public E next( ) {
                if ( !hasNext( ) ) {
                    throw new NoSuchElementException( );
                }
                E element = current.element;
                current = current.next;
                return element;
            }
        };
    }
}
