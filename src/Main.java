public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        queue.put(1);
        queue.put(2);
        queue.put(3);
        queue.put(4);

        System.out.println(queue.get());
        System.out.println(queue.get());
    }
}