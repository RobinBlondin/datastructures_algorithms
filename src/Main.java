public class Main {
    public static void main(String[] args) {
        HashTable table = new HashTable();
        table.set("nails", 1000);
        table.set("nails", 1000);
        table.set("nails", 1000);
        table.set("nails", 1000);
        table.set("screws", 10000);
        table.set("tape", 20);

        table.set("screwdriver", 100);
        table.set("screwdriver", 100);
        table.set("screwdriver", 100);
        table.set("tape", 20);
        table.set("nails", 1000);

        System.out.println(table.get("nails"));
        table.printTable();
        table.keys().forEach(System.out::println);
    }
}