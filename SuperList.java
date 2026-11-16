public class SuperList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SuperList() {
        head = null;
        tail = null;
        size = 0;
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
