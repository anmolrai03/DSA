public class Rec01 {
  public static void main(String[] args) {
    printn(5);
  }

  static void printn(int n){

    //base condition.
    if(n== 0){
      return;
    }

    System.out.println(n);
    printn(n-1);
  }
}
