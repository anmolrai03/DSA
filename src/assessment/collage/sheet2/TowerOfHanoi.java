package assessment.collage.sheet2;

public class TowerOfHanoi {
   static void toi(int n , String source , String destination , String auxiliary){
      //base case.
      if(n <= 0){
         System.out.println("not possible.");
         return;
      }
      if(n == 1){
         System.out.printf("Move dist %d from %s to %s", n , source, destination);
         return;
      }

      toi(n-1, source, destination , auxiliary);
      System.out.printf("Move dist %d from %s to %s", n , source, destination);
//      toi(n-1 , source, destination)
   }
}
