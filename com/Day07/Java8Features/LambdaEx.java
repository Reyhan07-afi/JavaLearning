package com.Day07.Java8Features;

public class LambdaEx {
    interface Operation{
        int execute(int a,int b);
    }
    //class Child implements Operation{
//    public int execute(int a,int b){
//        return a+b;
//    }
//}
        public static void main(String[] args) {
            Operation add = (a,b) -> a+b;
            System.out.println(add.execute(10,20));

            Operation sub=(a,b)->a-b;
            System.out.println(sub.execute(45,12));

            Operation mul=(a,b)->a*b;
            System.out.println(mul.execute(12,5));

        }
    }

