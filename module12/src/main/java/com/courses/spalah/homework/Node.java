package com.courses.spalah.homework;

public class Node<E> {
    private E data;
    private Node<E> next;

    Node (E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

    E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    //https://javatalks.ru/topics/32443
    //http://axis.bplaced.net/news/773
    //https://github.com/rxn1d/courses-2-2016/blob/courses/artemuskov/module12/src/main/java/com/courses/spalah/homework/MyCustomList.java
    //https://github.com/rxn1d/courses-2-2016/blob/courses/artemuskov/module12/src/main/java/com/courses/spalah/homework/Node.java
    //http://algmet.simulacrum.me/theory_a4m/spiski/Image128.gif
}
