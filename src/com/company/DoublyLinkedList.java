package com.company;

public class DoublyLinkedList<T> {
    private class DoublyLinkedListNode {
        public T value;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode previous;

        public DoublyLinkedListNode(T value, DoublyLinkedListNode next, DoublyLinkedListNode previous) {
            this.value = value;
            this.next = next;
        }

        public DoublyLinkedListNode(T value) {
            this(value, null, null);
        }
    }

    private DoublyLinkedListNode first = null;  // first, top
    private DoublyLinkedListNode last = null;  // last
    private int size = 0;

    private void checkEmptyError() throws Exception {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
    }

    public void add(T value, int index) throws Exception{
        checkEmptyError();
        if (index < 0 || index >= size) {
            throw new IllegalStateException("Incorrect index");
        } else {
            addPrevious(value, index);
        }
    }

    public void add(T value){
        addLast(value);
    }

    public void addFirst(T value) {
        first = new DoublyLinkedListNode(value, first, null);
        if (size == 0) {
            last = first;
        } else {

        }
        size++;
    }
    public void addLast(T value) {
        if (size == 0) {
            first = last = new DoublyLinkedListNode(value);
        } else {
            DoublyLinkedListNode temp = last;
            last.next = new DoublyLinkedListNode(value);
            last = last.next;
            last.previous = temp;
        }
        size++;
    }

    public void addNext(T value, int index) throws Exception{
        checkEmptyError();
        if (index < 0 || index >= size) {
            throw new IllegalStateException("Incorrect index");
        } else {
            DoublyLinkedListNode temp = getNode(index);
            DoublyLinkedListNode newnode = new DoublyLinkedListNode(value);
            if (temp.next != null){
                newnode.next = temp.next;
                newnode.next.previous = newnode;
            }
            temp.next = newnode;
            newnode.previous = temp;
            if(temp == last){
                last = newnode;
            }
            size++;
        }
    }

    public void addPrevious(T value, int index) throws Exception {
        checkEmptyError();
        if (index < 0 || index >= size) {
            throw new IllegalStateException("Incorrect index");
        } else {
            DoublyLinkedListNode temp = getNode(index);
            DoublyLinkedListNode newnode = new DoublyLinkedListNode(value);
            if (temp.previous != null){
                newnode.previous = temp.previous;
                newnode.previous.next = newnode;
            }
            temp.previous = newnode;
            newnode.next = temp;
            if (temp == first){
                first = newnode;
            }
            size++;
        }
    }

    public DoublyLinkedListNode getNode(int index) {
        DoublyLinkedListNode curr = first;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public T get(int index) throws Exception {
        checkEmptyError();
        return getNode(index).value;
    }

    public T getFirst() throws Exception {
        checkEmptyError();
        return first.value;
    }

    public T getLast() throws Exception {
        checkEmptyError();
        return last.value;
    }

    public void removeFirst() throws Exception {
        checkEmptyError();
        first = first.next;
        if (size == 1) {
            last = null;
        }
        size--;
    }

    public void removeLast() throws Exception {
        checkEmptyError();
        if (size == 1) {
            first = last = null;
        } else {
            last = last.previous;
            last.next = null;
        }
        size--;
    }

    public void remove(int index) throws Exception{
        checkEmptyError();
        if (index < 0 || index >= size) {
            throw new IllegalStateException("Incorrect index");
        } else if (index == 0) {
            removeFirst();
        } else {
            DoublyLinkedListNode temp = getNode(index);
            if (temp != first){
                temp.previous.next = temp.next;
            }
            if (temp != last){
                temp.next.previous = temp.previous;
            }
            size--;
        }
    }

    public int size() {
        return size;
    }

}
