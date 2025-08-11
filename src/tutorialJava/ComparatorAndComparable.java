package tutorialJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorAndComparable {

   // class to implement comparable.
   static class Student implements Comparable<Student> {

      int age;
      String name;

      public Student(int age , String name){
         this.age = age;
         this.name = name;
      }

      @Override
      public int compareTo(Student other) {
         return this.age > other.age ? 1: -1;
      }

      public String toString(){
         return "["+this.name+" "+this.age+"]";
      }
   }
   public static void main(String[] args) {
       //for normal list of Integer
      List<Integer> list = new ArrayList<>();
      list.add(34);
      list.add(67);
      list.add(89);
      list.add(15);

      //comparator object for changing the logic to compare inside the Collection.sort().

      Comparator<Integer> com = new Comparator<Integer>() {
         @Override
         public int compare(Integer o1, Integer o2) {
            if(o1%10 > o2%10) return 1;
            return -1;
         }
      };


      //changing the above commented code into lambda expression.
      Comparator<Integer> lamCom = (i , j) -> i%10 > j % 10 ? 1: -1;

//      Collections.sort(list);
//      System.out.println(list);

      //using class method of Compartor
//      Collections.sort(list, com);
//      System.out.println("using Comparator object: \n"+list);

      Collections.sort(list, lamCom);
      System.out.println("using Comparator object: \n"+list);

      List<Student> stud = new ArrayList<>();
      stud.add(new Student(19 , "Eren Yeager"));
      stud.add(new Student(36 , "Itachi Uchiha"));
      stud.add(new Student(32 , "Roronoa Zoro"));
      stud.add(new Student(16 , "Tanjiro Kamado"));


      Comparator<Student> studCom = (i , j) -> i.age%10 > j.age%10 ? 1: -1;
      Comparator<Student> studComName = (i , j) -> i.name.charAt(0) > j.name.charAt(0) ? 1: -1;


      //using compartor of the class itself
//      Collections.sort(stud);
//      System.out.println(stud);

      //using custom created comparator studCom.
//      Collections.sort(stud, studCom);
//      System.out.println(stud);

      //using custom created comparator studComName;
      Collections.sort(stud, studComName);
      System.out.println(stud);
   }
}
