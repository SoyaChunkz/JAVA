package org.sammo.java_collections_framework.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class MyComparator implements Comparator<String> {

    /*
    Negative ⇒ swap not needed (correct order for ascending)
    Positive ⇒ swap needed (descending order desired) */

    @Override
    public int compare(String s1, String s2) {
//        return s1.compareTo(s2);  // asc
        return s2.compareTo(s1);  // desc
    }
}

class Student {

    private final String name;

    private final double cgpa;

    public Student (String name, double cgpa) {
        this.name = name;
        this.cgpa = cgpa;
    }

    public String getName () {
        return name;
    }

    public double getCgpa () {
        return cgpa;
    }
}

public class ComparatorPractice {

    public static void main(String[] args) {


        List<String> fruits = new ArrayList<>();
        fruits.add("Orange");
        fruits.add("Mango");
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Pineapple");
        fruits.add("Watermelon");
        fruits.add("Grape");

//        MyComparator myComparator = new MyComparator();
//        fruits.sort(new MyComparator());

        fruits.sort((s1, s2) -> {
            if (s2.length() != s1.length()) return s2.length() - s1.length();
            else return s2.compareTo(s1);
        });
//        System.out.println(fruits);

/*
*
*
*
*
*
*
*
*
*  */

       List<Student> students = new ArrayList<>();
       students.add(new Student("sammo", 5.00));
       students.add(new Student("bob", 9.50));
       students.add(new Student("mikel", 9.80));
       students.add(new Student("alice", 9.80));
       students.add(new Student("sammo", 10.00));

//       students.sort((s1, s2) -> {
//           // CGPA DESC
//           if (s2.getCgpa() - s1.getCgpa() > 0) return 1;
//           else if (s2.getCgpa() - s1.getCgpa() < 0) return -1;
//           // Name ASC
//           else return s1.getName().compareTo(s2.getName());
//       });

        Comparator<Student> comparator = Comparator.comparing(Student::getName, Comparator.naturalOrder())        // Name ASC
                                                     .thenComparing(Student::getCgpa, Comparator.reverseOrder()); // CGPA DESC
        students.sort(comparator);

       for (Student s : students) System.out.println(s.getName() + "--" + s.getCgpa());
    }
}
