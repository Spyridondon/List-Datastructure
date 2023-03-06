public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.put(1);
        stack.put(2);
        stack.put(3);

        System.out.println(stack.get());
        System.out.println(stack.get());
    }
}