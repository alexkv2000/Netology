package day2;

import java.util.PriorityQueue;

public class Main {


        public static void main(String[] args) {

            PriorityQueue<Integer> myPriorityQueue = new PriorityQueue<Integer>();

            myPriorityQueue.add(4);
            myPriorityQueue.add(2);
            myPriorityQueue.add(3);
            myPriorityQueue.remove(4);
            for(int pq : myPriorityQueue) {
                System.out.println(pq);
            }
        }
    }
