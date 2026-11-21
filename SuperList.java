public class SuperList<E> {
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

    public boolean add(E value) {
        Node<E> node = new Node<>(value);

        if (head == null) {
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }

        tail = node;
        size++;
        return true;
    }

    @Override
    public String toString() {
        String result = "[";
        Node<E> current = head;

        while (current != null) {
            result += current.value;
            if (current.hasNext()) {
                result += ", ";
            }
            current = current.next;
        }

        return result + "]";
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