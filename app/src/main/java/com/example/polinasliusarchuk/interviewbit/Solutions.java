package com.example.polinasliusarchuk.interviewbit;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solutions {

    //
//Print concentric rectangular pattern in a 2d matrix.
//        Let us show you some examples to clarify what we mean.
//
//
//
//        Input: A = 4.
//        Output:
//
//        4 4 4 4 4 4 4

//        4 3 3 3 3 3 4
//        4 3 2 2 2 3 4
//        4 3 2 1 2 3 4
//        4 3 2 2 2 3 4
//        4 3 3 3 3 3 4
//        4 4 4 4 4 4 4

    // 00 01 02 03 04 05 06
// 10 11 12 13 14 15 16
//
// 50 51 52 53 54 55 56    5 6  = 1+2 6-4 +2
// 60 61 62 63 64 65 66
    public static ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(A<=0) return res;
        for (int i = 0; i < A * 2 - 1; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j < A * 2 - 1; j++) {
                int k = i;
                int h = j;
                if (k >= A) k += 2;
                if (h >= A) h += 2;
                int val = Math.max(Math.abs(k - A), Math.abs(h - A));
                arr.add(val);
            }
            res.add(arr);
        }


return res;
    }


//    Kth Smallest Element in the Array
//    Find the kth smallest element in an unsorted array of non-negative integers.
//
//    Definition of kth smallest element
//
//    kth smallest element is the minimum possible n such that there are at least k elements in the array <= n.
//    In other words, if the array A was sorted, then A[k - 1] ( k is 1 based, while the arrays are 0 based )
//    NOTE
//    You are not allowed to modify the array ( The array is read only ).
//    Try to do it using constant extra space.
//
//            Example:
//
//    A : [2 1 4 3 2]
//    k : 3
//
//    answer : 2

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int kthsmallest(final List<Integer> A, int B) {
        ArrayList<Integer> sort = new ArrayList<>(A);
        Collections.sort(sort);
        return sort.get(B-1);
    }

//    NEXTGREATER
//    Given an array, find the next greater element G[i] for every element A[i] in the array. The Next greater Element for an element A[i] is the first greater element on the right side of A[i] in array.
//    More formally,
//
//    G[i] for an element A[i] = an element A[j] such that
//    j is minimum possible AND
//    j > i AND
//    A[j] > A[i]
//    Elements for which no greater element exist, consider next greater element as -1.
//
//    Example:
//
//    Input : A : [4, 5, 2, 10]
//    Output : [5, 10, 10, -1]

    public ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
        for(int i = 0 ; i<A.size(); i++){
            for(int j = i; j<A.size();j++){
                if(A.get(i)<A.get(j)){
                    A.set(i, A.get(j));
                    break;
                }
                if(j==A.size()-1) A.set(i, -1);

            }

        }
        return A;
    }

//    Longest Consecutive Sequence
//    Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
//    Example:
//    Given [100, 4, 200, 1, 3, 2],
//    The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
//
//    Your algorithm should run in O(n) complexity.
//

    public int longestConsecutive(final List<Integer> A) {
        Collections.sort(A);
        int res =1;
        int size= 1;
        for(int i = 0; i<A.size()-1; i++){
            if(A.get(i)==A.get(i+1)) continue;
            if(A.get(i)+1==A.get(i+1)){
                size++;
                if(size>res)res=size;
            } else {
                size=1;
            }
        }
        return res;
    }



}

