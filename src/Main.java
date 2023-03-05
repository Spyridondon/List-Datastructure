public class Main {
    public static void main(String[] args) {
        List<Integer> list = new List<>();

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        List<Integer> x = List.copyList(list);

        System.out.println(x.hashCode());
        System.out.println(list.hashCode());

    }
}