package com.courses.spalah.homework;

import java.util.Iterator;

public class MyListElements<E> implements MyList<E> {
    private Node<E> firstElement;
    private Node<E> lastElement;
    private int sizeOfList = 0;

    @Override
    public int size() {
        return sizeOfList;
    }

    @Override
    public boolean isEmpty() {
        if (firstElement == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean add(E element) {
        Node<E> newNode = new Node<>(element, null);

        if (isEmpty()) {
            firstElement = newNode;
            lastElement = firstElement;
        } else {
            lastElement.setNext(newNode);
            lastElement = newNode;
        }

        sizeOfList++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        Node<E> newElement = new Node<>(element, null);

        if (isEmpty()) {
            sizeOfList = 0;
            return;
        }

        if (index == 0) {
            newElement.setNext(firstElement);
            firstElement = newElement;

            sizeOfList++;
            return;
        }

        Node<E> nodeIterator = firstElement;
        Node<E> oldNode = new Node<>(null, null);
        int indexCounter = 0;

        while (nodeIterator != null) {
            if ((index >= sizeOfList) && (nodeIterator.getNext() == null)) {
                nodeIterator.setNext(newElement);
                lastElement = newElement;

                sizeOfList++;
                return;
            }

            if (indexCounter == index) {
                oldNode.setData(nodeIterator.getData());
                oldNode.setNext(nodeIterator.getNext());

                nodeIterator.setData(newElement.getData());
                nodeIterator.setNext(oldNode);

                sizeOfList++;
                return;
            }

            nodeIterator = nodeIterator.getNext();
            indexCounter++;
        }
    }

    @Override
    public void remove(int index) {
        if (isEmpty()) {
            sizeOfList = 0;
            return;
        }

        if (firstElement.equals(lastElement)) {
            firstElement = null;
            lastElement = null;
            sizeOfList = 0;
            return;
        }

        if (index == 0) {
            firstElement = firstElement.getNext();
            sizeOfList--;
            return;
        }

        Node<E> removeElement = firstElement;
        Node<E> oldNode;
        int indexCounter = 0;

        while (removeElement != null) {
            if ((indexCounter == index) && (removeElement.getNext() != null)) {
                oldNode = removeElement.getNext();
                removeElement.setNext(removeElement.getNext().getNext());
                removeElement.setData(oldNode.getData());

                sizeOfList--;
                return;
            }

            if (removeElement.getNext().getNext() == null) {
                removeElement.setNext(null);
                lastElement = removeElement;

                sizeOfList--;
                return;
            } else {
                removeElement = removeElement.getNext();
            }

            indexCounter++;
        }
    }

    @Override
    public E get(int index) {
        Node<E> getElement = firstElement;

        for (int i = 0; i <= index; i++) {
            if (i == index) {
                return getElement.getData();
            } else {
                getElement = getElement.getNext();
            }
        }
        return null;
    }

    @Override
    public E set(int index, E element) {
        Node<E> setElement = firstElement;

        for (int i = 0; i <= index; i++) {
            if (i == index) {
                setElement.setData(element);
                return setElement.getData();
            } else {
                setElement = setElement.getNext();
            }
        }
        return null;
    }

    @Override
    public boolean contains(E element) {
        Node<E> containsElement = firstElement;

        while (containsElement != null) {
            if (containsElement.getData().equals(element)) {
                return true;
            } else {
                containsElement = containsElement.getNext();
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {
            int currentIndex = sizeOfList - 1;

            @Override
            public boolean hasNext() {
                return currentIndex >= 0;
            }

            @Override
            public E next() {
                E node = (E) get(currentIndex);
                currentIndex--;
                return node;
            }

            @Override
            public void remove() {
                MyListElements.this.remove(sizeOfList);
                sizeOfList--;
            }
        };
        return iterator;
    }
}
