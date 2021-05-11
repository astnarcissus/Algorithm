package leetcode;

import java.util.ArrayList;

/**
 * @author: 言叶长琴
 */
public class Test {

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        ArrayList<Integer> list2 = new ArrayList<>();

        list2.addAll(list1);
        list2 = list1;
        System.out.println(list2);

    }

}
