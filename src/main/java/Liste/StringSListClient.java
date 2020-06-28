package Liste;

/**
 * Class Client to test methods
 */
public class StringSListClient {
    public static void main(String[] args) {

        StringSList li = new StringSList();
        li = new StringSList("build", li);
        li = li.cons("power");
        li = li.cons("string");
        li = li.cons("list");
        li = li.cons("world");
        li = li.cons("Waw");

        StringSList list = new StringSList();
        list = new StringSList("List", list);
        list = list.cons("World");
        list = list.cons("Hello");

        StringSList list_1 = new StringSList();
        list_1 = new StringSList("Display", list_1);
        list_1 = list_1.cons("I am");
        list_1 = list_1.cons("Yes");

        String[] lista = {"Uno", "Due", "Tre"};

        StringSList l = StringSList.fromArray(lista);

        System.out.println(li.isEmpty()); // false
        System.out.println(list.isEmpty()); // false

        System.out.println(li.car()); // Hello
        System.out.println(list.car()); // Hello

        System.out.println(li.cdr()); // (world, list, string, power, build)
        System.out.println(list.cdr()); // (World, List)

        System.out.println(li.length()); // 6
        System.out.println(list.length()); // 3

        System.out.println(li.listRef(1)); // World
        System.out.println(list.listRef(1)); // // World

        System.out.println(li.equals(list)); // false
        System.out.println(list.equals(li)); // false

        System.out.println(li.append(list)); // (Hello, world, list, string, power, build, Hello, World, List)
        System.out.println(li.reverse()); // (build, power, string, list, world, Hello)
        System.out.println(li.toString()); // (Hello, world, list, string, power, build)

        li.display(li); // (Hello, world, list, string, power, build)
        list_1.display(list_1); // (Yes, I am, Display)
    }
}
