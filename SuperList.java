import java.util.EmptyStackException;

public class SuperList<E> implements SL<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SuperList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void add(E value) {
        Node<E> node = new Node<>(value);

        if (head == null) {
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }

        tail = node;
        size++;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer("[");
        Node<E> current = head;

        while (current != null) {
            result.append(current.value);
            if (current.hasNext()) {
                result.append(", ");
            }
            current = current.next;
        }

        result.append(']');
        return result.toString();
    }

    public E get(int index) {
        checkIndex(index);
        return getNode(index).value;
    }

    public E set(int index, E val) {
        checkIndex(index);
        Node<E> current = getNode(index);
        E oldValue = current.value;
        current.value = val;
        return oldValue;
    }

    private Node<E> getNode(int index) {
        Node<E> current;

        if (index <= size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        return current;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void add(int index, E value) {
        checkAddIndex(index);

        if (index == size) {
            add(value);
            return;
        }

        Node<E> current = getNode(index);
        Node<E> node = new Node<>(value);

        if (index == 0) {
            node.next = head;
            head.prev = node;
            head = node;
        } else {
            node.next = current;
            node.prev = current.prev;

            current.prev.next = node;
            current.prev = node;
        }

        size++;
    }

    private void checkAddIndex(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public E remove(int index) {
        checkIndex(index);

        Node<E> current = getNode(index);
        E removedValue = current.value;

        if (current.prev == null) {
            head = current.next;
        } else {
            current.prev.next = current.next;
        }

        if (current.next == null) {
            tail = current.prev;
        } else {
            current.next.prev = current.prev;
        }

        current.next = null;
        current.prev = null;
        size--;
        return removedValue;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean contains(E value) {
        Node<E> current = head;

        while (current != null) {
            if (value == null) {
                if (current.value == null) {
                    return true;
                }
            } else if (value.equals(current.value)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public E push(E value) {
        add(value);
        return value;
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return remove(size - 1);
    }

    public E stackPeek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return tail.value;
    }

    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return remove(0);
    }

    public E queuePeek() {
        if (isEmpty()) {
            return null;
        }
        return head.value;
    }

    @Override
    public String getAuthor() {
        return "Samuel Asefa";
    }

    @Override
    public void insertList(int index, SL<E> other) {
        checkAddIndex(index);
        if (other == this) {
            throw new IllegalArgumentException();
        }

        int count = other.size();
        if (count == 0) {
            return;
        }

        Node<E> first = new Node<>(other.get(0));
        Node<E> last = first;
        for (int i = 1; i < count; i++) {
            Node<E> node = new Node<>(other.get(i));
            last.next = node;
            node.prev = last;
            last = node;
        }

        Node<E> next = null;
        Node<E> prev = tail;
        if (index < size) {
            next = getNode(index);
            prev = next.prev;
        }

        first.prev = prev;
        last.next = next;
        if (prev == null) {
            head = first;
        } else {
            prev.next = first;
        }
        if (next == null) {
            tail = last;
        } else {
            next.prev = last;
        }
        size += count;
    }

    private static class Node<E> {
        private E value;
        private Node<E> next;
        private Node<E> prev;

        public Node(E value) {
            this.value = value;
            next = null;
            prev = null;
        }

        public boolean hasNext() {
            return next != null;
        }

        public boolean hasPrev() {
            return prev != null;
        }
    }
}