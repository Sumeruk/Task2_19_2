package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoublyLinkedListUtils {
    private static List<Integer> readListFromFile(String fileName) throws FileNotFoundException {
        List<Integer> lines;
        try (Scanner scanner = new Scanner(new File(fileName))) {
            lines = new ArrayList<>();
            while (scanner.hasNext()) {
                lines.add(scanner.nextInt());
            }
        }
        return lines;
    }

    public static DoublyLinkedList<Integer> fileToDoublyLinkedList (String fileName) throws FileNotFoundException {
        DoublyLinkedList<Integer> linkedlist = new DoublyLinkedList<>();
        List<Integer> variables  = new ArrayList<>(readListFromFile(fileName));
        for (int i = 0; i<variables.size();i++){
            linkedlist.add(variables.get(i));
        }
        return linkedlist;
    }

    public static void doublyLinkedListToFile(String fileName, DoublyLinkedList<Integer> list)
            throws Exception {
        try (FileWriter out = new FileWriter(fileName)) {
            for (int i = 0; i < list.size(); i++) {
                int a = list.get(i);
                if (i != list.size()) {
                    out.write(a + " ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DoublyLinkedList<Integer> intToDoublyLinkedList(int[] arr){
        DoublyLinkedList<Integer> linkedlist = new DoublyLinkedList<>();
        for(int i = 0;i< arr.length;i++){
            linkedlist.addLast(arr[i]);
        }
        return linkedlist;
    }

    public static String[] convertToStringArray(DoublyLinkedList<Integer> list) throws Exception {
        String[] arr =  new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = String.valueOf(list.get(i));
        }
        return arr;
    }

}
