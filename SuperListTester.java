public class SuperListTester {
    public static void main(String[] args) {
        SuperList<Integer> numbers = new SuperList<>();

        System.out.println("Empty: " + numbers);
        System.out.println("Size: " + numbers.size());

        numbers.add(1);
        System.out.println("One value: " + numbers);
        System.out.println("Size: " + numbers.size());

        numbers.add(2);
        numbers.add(3);
        numbers.add(1, 4);
        numbers.remove(2);
        System.out.println("Numbers: " + numbers);
        System.out.println("Size: " + numbers.size());

        SuperList<String> words = new SuperList<>();
        words.add("red");
        words.add("blue");
        System.out.println("Words: " + words);
        System.out.println("Size: " + words.size());

        testInsertList();
        testEmptyOperations();
        System.out.println("All SuperList checks passed.");
    }

    private static void testInsertList() {
        SuperList<String> list = new SuperList<>();
        list.add("A");
        list.add("D");
        list.add("E");

        SuperList<String> other = new SuperList<>();
        other.add("B");
        other.add("C");

        list.insertList(1, other);
        check(list.toString().equals("[A, B, C, D, E]") && list.size() == 5,
                "middle insert");
        check(other.toString().equals("[B, C]") && other.size() == 2,
                "source after insert");

        other.set(0, "X");
        list.set(2, "Y");
        check(list.get(1).equals("B") && other.get(1).equals("C"),
                "independent nodes");

        SuperList<String> ends = new SuperList<>();
        ends.insertList(0, other);
        ends.insertList(0, other);
        ends.insertList(ends.size(), other);
        ends.insertList(1, new SuperList<>());

        check(ends.toString().equals("[X, C, X, C, X, C]") && ends.size() == 6,
                "endpoints and empty source");

        for (int i = 0; i < 3; i++) {
            check("C".equals(ends.pop()) && "X".equals(ends.pop()),
                    "backward links");
        }
        check(ends.isEmpty(), "size after draining");

        try {
            list.insertList(-1, other);
            throw new AssertionError("negative insert index");
        } catch (ArrayIndexOutOfBoundsException expected) {
            // Expected for an index below zero.
        }

        try {
            list.insertList(list.size() + 1, new SuperList<>());
            throw new AssertionError("insert past end");
        } catch (ArrayIndexOutOfBoundsException expected) {
            // An empty source still requires a valid index.
        }

        try {
            list.insertList(0, list);
            throw new AssertionError("self-insertion");
        } catch (IllegalArgumentException expected) {
            // The source and destination must be different lists.
        }
    }

    private static void testEmptyOperations() {
        SuperList<Integer> list = new SuperList<>();
        list.push(10);
        list.push(20);

        check(list.stackPeek() == 20 && list.queuePeek() == 10 && list.size() == 2,
                "peek at both ends");
        check(list.pop() == 20 && list.poll() == 10, "stack and queue order");
        check(list.queuePeek() == null && list.poll() == null, "empty queue");

        try {
            list.pop();
            throw new AssertionError("empty pop");
        } catch (java.util.EmptyStackException expected) {
            // Expected for an empty stack.
        }

        try {
            list.stackPeek();
            throw new AssertionError("empty stackPeek");
        } catch (java.util.EmptyStackException expected) {
            // Expected for an empty stack.
        }
    }

    private static void check(boolean passed, String name) {
        if (!passed) {
            throw new AssertionError(name);
        }
    }
}