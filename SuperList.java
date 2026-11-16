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