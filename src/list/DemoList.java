package list;

import java.time.temporal.IsoFields;
import java.util.ArrayList;

public class DemoList {

    public static void printList(MyArrayList ages) {
        for (int i = 0; i < ages.size(); i++) {
            System.out.print(ages.get(i) + ",");
        }
        System.out.println("");
    }
    static  void main(){
//        ArrayList<Boolean> name = new ArrayList<>();
//        String name  = "quan";
//        System.out.println(name);
//        String copyName = name;
//        System.out.println(copyName);
//        name = "quan2";
//        System.out.println(copyName);
//        System.out.println(name);
//        int age = 18;
//        System.out.println(age);
//        int copyAge = age;
//        System.out.println(copyAge);
//        age = 19;
//        System.out.println(age);
//        System.out.println(copyAge);
        ArrayList<Integer> ages = new ArrayList<>();
        ages.add(1);
        ages.add(2);
        ages.add(3);
        System.out.println("ages:" + ages);
        ArrayList<Integer> copyAges = ages;
        System.out.println("copyAges:" + copyAges);
        ages.set(0,9);
        System.out.println("ages:" + ages + " copyAges" + copyAges);


    }
}
