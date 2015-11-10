/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author mazenbadr
 */
public class Knapsack1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        InputStream stream = ClassLoader.getSystemResourceAsStream("knapsack.txt");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(stream));

        int numOfItems = 0;
        int capacity = 0;
        ArrayList<Item> items = new ArrayList<>();
        try {
            String[] line1 = buffer.readLine().split("\\s+");
            String line = "";
            capacity = Integer.valueOf(line1[0]);
            numOfItems = Integer.valueOf(line1[1]);
            while ((line = buffer.readLine()) != null) {
                String[] vals = line.split("\\s+");
                Item tempItem = new Item(Integer.valueOf(vals[0]), Integer.valueOf(vals[1]));
                items.add(tempItem);
            }
        } catch (Exception e) {

        }
        int[][] values = new int[numOfItems][capacity];
        for (int x = 0; x < capacity; x++) {
            values[0][x] = 0;
        }
        for (int i = 0; i < numOfItems; i++) {
            for (int x = 0; x < capacity; x++) {
                if (i == 0) {
                    values[i][x] = 0;
                } else if (items.get(i).getSize() <= x) {
                    values[i][x] = Integer.max(values[i - 1][x],
                            values[i - 1][x - items.get(i).getSize()] + items.get(i).getValue());
                } else {
                    values[i][x] = values[i - 1][x];
                }
            }
        }
        System.out.println("sol. is ==> " +values[numOfItems-1][capacity - 1]);
    }

//    static public int bigKnapsack(ArrayList<Item> items, int numOfItems, int capacity) {
//        int[][] values = new int[2][capacity];
//        boolean toggle = true;
//        for (int x = 0; x < capacity; x++) {
//            values[0][x] = 0;
//        }
//        for (int i = 0; i < numOfItems; i++) {
//            for (int x = 0; x < capacity; x++) {
//                if (i == 0) {
//                    values[i][x] = 0;
//                } else if (items.get(i).getSize() <= x) {
//                    if (toggle) {
//                        values[1][x] = Integer.max(values[0][x],
//                                values[0][x - items.get(i).getSize()] + items.get(i).getValue());
////                        toggle = false;
//                    } else {
//                        values[0][x] = Integer.max(values[1][x],
//                                values[1][x - items.get(i).getSize()] + items.get(i).getValue());
////                        toggle = true;
//                    }
//
//                } else {
//                    if (toggle) {
//                        values[1][x] = values[0][x];
////                        toggle = false;
//                    }else{
//                        values[0][x] = values[1][x];
////                        toggle = true;
//                    }
//                }
//               if(toggle){
//                   toggle = false;
//               } else{
//                   toggle = true;
//               }
//            }
//        }
//        return Integer.max(values[0][capacity - 1], values[1][capacity - 1]);
//    }

}
