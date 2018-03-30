package com.test;

import com.util.SmallBallAly;
import com.util.SortUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class demo3 {
    public static void main(String[] args) {
        int[] a_arr = new int[]{1, 3, 5,11};
        int[] b_arr = new int[]{2, 4, 5,6, 8, 11,3};
//        Set<Integer> list = new SmallBallAly().get_same_num(a_arr,b_arr);
//
//        for(int j :list){
//            System.out.println(j);
//        }
        SortUtil su = new SortUtil();
        su.quicksort(b_arr);
        print_arr(b_arr);

//        for(int i :list){
//            System.out.println(i);
//        }
    }
    private static  void print_arr(int[] arr){
        for(int x :arr){
            System.out.println(x);
        }
    }
//    public static int[] sort_double_order()
}
