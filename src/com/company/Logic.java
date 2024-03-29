package com.company;

public class Logic {

    public <T> void changeList(DoublyLinkedList<T> list, T value) throws Exception {
        for (int i = 0; i < list.size(); i++) {
            if (checkSimple((Integer) list.get(i))) {
                list.addNext(value, i);
                list.addPrevious(value, i);
                i += 2;
            }
        }
    }

    public boolean checkSimple(Integer number) {
        if (number < 2) {
            return false;
        }
        double numberRoot = Math.sqrt(number);
        for (int i = 2; i <= numberRoot; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }


}
