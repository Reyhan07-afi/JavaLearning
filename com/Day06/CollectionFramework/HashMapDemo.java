package com.Day06.CollectionFramework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapDemo {
/*
HashMap is a class implementing map interface
Data's are stored in the form of key-value pair
Key should not contains duplicate
Value may contain duplicate

 */


    /*
     * 1. Declaration
     * 2. Adding pairs
     * 3. Finding size of hashmap
     * 4. Remove pairs
     * 5. Accessing value through key
     * 6. Retrieve All keys from HashMap
     * 7. Retrieve All values from HashMap
     * 8. Retrieve All keys along with values from HashMap
     * 9. Reading all data from HashMap
     */


        public static void main(String[] args) {
            Map<Integer,String> hm=new HashMap<>();
            hm.put(101,"Apple");
            hm.put(102,"Strawberry");
            hm.put(103,"Pineapple");
            hm.put(104,"Orange");
            System.out.println(hm.size());
            hm.remove(102);
            System.out.println(hm.get(104));
            System.out.println(hm.keySet());
            System.out.println(hm.values());
            System.out.println(hm.entrySet());
            for(int key:hm.keySet()){
                System.out.println(key+"->"+hm.get(key));
            }
            Iterator<Map.Entry<Integer,String>> it=hm.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry<Integer,String> pair=it.next();
                System.out.println(pair.getKey()+"->"+pair.getValue());
            }
        }
    }

