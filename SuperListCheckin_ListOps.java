// tests core list operations.. not everything in the interface
public class SuperListCheckin_ListOps {
    public static void main(String[] args) {
        SuperList<String> list = new SuperList<>();

        System.out.println(list); // []
        System.out.println(list.size()); // 0

        list.add("A");
        list.add("C");
        list.add("E");
        System.out.println(list); // [A, C, E]
        System.out.println(list.size()); // 3

        list.add(1, "B");
        list.add(3, "D");
        System.out.println(list); // [A, B, C, D, E]

        list.add(0, "START");
        list.add(list.size(), "END");
        System.out.println(list); // [START, A, B, C, D, E, END]

        System.out.println(list.get(0)); // START
        System.out.println(list.get(3)); // C
        System.out.println(list.set(3, "X")); // C
        System.out.println(list); // [START, A, B, X, D, E, END]

        System.out.println(list.remove(0)); // START
        System.out.println(list.remove(2)); // X
        System.out.println(list.remove(list.size() - 1)); // END
        System.out.println(list); // [A, B, D, E]
        System.out.println(list.size()); // 4

        list.remove(0);
        list.remove(0);
        list.remove(0);
        list.remove(0);
        System.out.println(list); // []

        list.add("Z");
        System.out.println(list); // [Z]
    }
}