package com.Day06.CollectionFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

    /*
    Arraylist is a class implementing list interface
    Insertion order preserved
    Duplicates are allowed
    Null also allowed
    Heterogenous Data are allowed
     */
    /*
     * 1. Declaration
     * 2. How to Add Data to ArrayList
     * 3. How to find the size of the ArrayList
     * 4. How to print ArrayList
     * 5. How to remove element in an ArrayList
     * 6. How to insert element at particular index
     * 7. How to modify/update element in the ArrayList
     * 8. How to access elements from ArrayList
     * 9. How to clear ArrayList
     * 10. How to check whether the ArrayList contains an element
     * 11. How to convert array to ArrayList and ArrayList to array
     */
    public class ArrayListDemo {
        public static void main(String[] args) {
            ArrayList list = new ArrayList<>();
            list.add("Reyhan");
            list.add(20);
            list.add('M');
            list.add(6.03);
            list.add(true);
            list.add(null);
            System.out.println(list);
            list.set(4, false);
            list.add(3, "JN");
            System.out.println(list);
            System.out.println(list.get(5));
            list.clear();
            System.out.println(list);
            System.out.println(list.isEmpty());
            Integer[] array = new Integer[]{1, 2, 3, 4, 5};
            List<Integer> list1 = new ArrayList<>(Arrays.asList(array));
            System.out.println(list1);

            for (int i = 0; i < list1.size(); i++) {
                System.out.println(list1.get(i));
            }
            for (Integer temp : list1) {
                System.out.println(temp);
            }
            Iterator<Integer> it = list1.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        }
    }


