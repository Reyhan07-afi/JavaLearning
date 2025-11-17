package com.Day01;

public class TwoSum{
        public static void main(String[] args) {

            // Check if exactly two arguments are passed
            if (args.length != 2) {
                System.out.println("Please provide exactly two command line arguments.");
                return;
            }

            String str1 = args[0];
            String str2 = args[1];

            System.out.println("First String  : " + str1);
            System.out.println("Second String : " + str2);
            System.out.println("Combined      : " + str1 + " " + str2);
        }
    }


