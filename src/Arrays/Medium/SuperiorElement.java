package Arrays.Medium;

import java.util.*;


public class SuperiorElement {
    public static List< Integer > superiorElements(int []a){
        List< Integer > superior = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i< a.length; i++){
            if(st.isEmpty()){
                st.push(a[i]);
            }
            else {
                while( !st.isEmpty() && a[i] >= st.peek()){
                    st.pop();
                }
                st.push(a[i]);
            }
        }
        while(!st.isEmpty()){
            superior.add(st.pop());
        }
        Collections.sort(superior);

        return superior;
    }

    public static void main(String[] args) {
        int[] a = {1,2,2,1};
        System.out.println(superiorElements(a));
    }
}
