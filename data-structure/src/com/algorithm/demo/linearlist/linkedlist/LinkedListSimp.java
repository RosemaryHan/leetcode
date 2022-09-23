package com.algorithm.demo.linearlist.linkedlist;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @Author Rosemary
 * @Date: 2022-09-23-22:52
 * @Description: 手写链表 较为简单的方式——用Node类
 * @Version 1.0
 */
public class LinkedListSimp<E> implements List<E> {
    //固定属性
    transient int size = 0;
    transient Node<E> first;
    transient Node<E> last;

    //简单版——用已有的类
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

        public Node() {
        }
    }

    //头插法
    void linkedFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<E>(null, e, f);
        first = newNode;
        //因为是头插法，所以会把最新的第一个做头
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
            size++;
        }
    }

    //尾插法
    void linkedLast(E e) {
        final Node<E> lastOne = last;
        final Node<E> newNode = new Node<E>(last, e, null);
        last = lastOne;
        //这里是证明还没有赋值的情况下
        if (lastOne == null) {
            first = newNode;
        } else {
            lastOne.next = newNode;
        }
        size++;
    }

    //拆除连接
    E unlinked(Node<E> e) {
        final E element = e.item;
        final Node<E> start = e.prev;
        final Node<E> end = e.prev;

        //为头的话直接删除头连接
        if (start == null) {
            first = null;
        } else {
            //衔接
            start.next = start;
            e.prev = null;
        }

        //处理尾部数据
        if (end == null) {
            last = null;
        } else {
            //衔接
            start.next = end;
            e.next = null;
        }
        e.item = null;
        size--;
        return element;
    }

    @Override
    public boolean remove(Object o) {
        //循环遍历查找
        if(o==null){
            for(Node<E> x = first;x!=null;x=x.next){
                if(x.item==null){
                    unlinked(x);
                    return true;
                }
            }
        }else{
            for(Node<E> x = first;x!=null;x=x.next){
                if(o.equals( x.item)){
                    unlinked(x);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }


}
