
package set;

import java.util.*;

public class MyCustomClass<T> implements Set<T> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyCustomClass() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public boolean add(T element) {
        if (contains(element)) {
            return false;
        }

        if (size == elements.length) {
            int newCapacity = (size * 3) / 2 + 1;
            elements = Arrays.copyOf(elements, newCapacity);
        }

        elements[size++] = element;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, elements[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (T) elements[currentIndex++];
        }
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return a;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, elements[i])) {
                elements[i] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object elements : c) {
            if (!contains(elements)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean temp = false;
        for (T elements : c) {
            temp |= add(elements);
        }
        return temp;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object element : c) {
            modified |= remove(element);
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (int i = size - 1; i >= 0; i--) {
            if (!c.contains(elements[i])) {
                elements[i] = null;
                size--;
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(elements[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyCustomClass<Integer> set = new MyCustomClass<>();
        set.add(20);
        set.add(15);
        set.add(40);
        set.add(40);

        System.out.println(set);

        MyCustomClass<Integer> num = new MyCustomClass<>();
        num.add(13);
        num.add(25);
        num.add(15);
        num.add(20);
        num.add(15);

        System.out.println(num);

        MyCustomClass<Integer> union = new MyCustomClass<>();
        union.addAll(set);
        union.addAll(num);
        System.out.println("Union: " + union);

        MyCustomClass<Integer> intersection = new MyCustomClass<>();
        intersection.addAll(set);
        intersection.retainAll(set);
        System.out.println("Intersection: " + intersection);

        MyCustomClass<Integer> difference = new MyCustomClass<>();
        difference.addAll(num);
        difference.removeAll(set);
        System.out.println("Difference: " + difference);
    }
}
