package DoubleMyLinkedList;

import java.rmi.Remote;

public class testDemo {
    public static void main(String[] args) {
        DoubleMyLinkedList list = new DoubleMyLinkedList();
        list.addfirst(4);
        list.addfirst(3);
        list.addfirst(2);
        list.addfirst(1);
        list.addlast(5);
        list.addlast(88);
        list.addindex(1,88);
        list.display();
//        list.remove(88);
//        list.display();
        list.removeall(88);
        list.display();
    }
}
