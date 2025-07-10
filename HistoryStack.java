package com.example.calendar.data;

import java.util.LinkedList;

public class HistoryStack<T> {
    private LinkedList<T> stack = new LinkedList<>();

    public void push(T item) {
        stack.addFirst(item);
    }

    public T pop() {
        return stack.isEmpty() ? null : stack.removeFirst();
    }

    public T peek() {
        return stack.isEmpty() ? null : stack.getFirst();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}