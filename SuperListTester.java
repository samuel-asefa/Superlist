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
        numbers.add(4);
        System.out.println("Numbers: " + numbers);
        System.out.println("Size: " + numbers.size());

        SuperList<String> words = new SuperList<>();
        words.add("red");
        words.add("blue");
        System.out.println("Words: " + words);
        System.out.println("Size: " + words.size());
    }
}