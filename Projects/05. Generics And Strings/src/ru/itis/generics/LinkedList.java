package ru.itis.generics;

public class LinkedList<C> implements List<C> {

    private Node<C> head;

    private static class Node<D> {
        D value;
        Node<D> next;
    }

    @Override
    public void add(C c) {

    }
}
