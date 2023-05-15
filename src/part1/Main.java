package part1;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        //Part1 LinkedList
        System.out.println("Part1 part1.LinkedList");
        LinkedList<Integer> list = new LinkedList<>();
        // add elements to the list
        list.add(60);
        list.add(2);
        list.add(10);
        list.add(20);
        list.add(5);
        list.add(7);
        list.add(88);
        list.add(15);

        System.out.println("all elements of the list after using method add: \n" + list
                + " with size: " + list.getSize());
        System.out.println("------------------");

        System.out.println("element at index 3: " + list.get(3));
        System.out.println("------------------");

        list.add(5, 20);
        System.out.println("after adding element with value 20 with index 5: \n" + list);
        System.out.println("------------------");

        list.remove(7);
        System.out.println("after removing element with index 7: \n" + list);
        System.out.println("------------------");

        list.remove(Integer.valueOf(2));
        System.out.println("after removing element with value 2: \n" + list);
        System.out.println("------------------");

        list.removeAll(20);
        System.out.println("after removing all elements with value 20: \n" + list.toString());
        System.out.println("------------------");

        list.addFirst(6);
        System.out.println("after adding element with value 6 at the beginning of the list: \n" + list);
        System.out.println("------------------");

        System.out.println("current size of my list is: " + list.getSize()); //??? size doesn't work correct
        System.out.println("------------------");

        String stringOfList = list.toString();
        System.out.println("printing list with method toString: " + stringOfList);
        System.out.println("------------------");

        System.out.println("showing the usage of iterator:");
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("banana");
        list2.add("apple");
        list2.add("peach");
        list2.add("pineapple");
        list2.add("watermelon");
        Iterator<String> iterator = list2.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println("\n------------------");






    }
}