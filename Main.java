import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        A[] els = new A[3];
        els[0] = new A(1,"test");
        els[1] = new A(2,"test2");
        els[2] = new A(4,"test3");

        List<A> list = Arrays.asList(els);

        // Gjeni gjithe elementet qe kane A.a = 2
        List<A> a2s = list.stream().filter(a -> a.a == 2).collect(Collectors.toList());
        System.out.println(a2s);
        // Gjeni gjithe elementet qe kane A.b = "test2"
        List<A> a3s = list.stream().filter(a -> a.b == "test2").collect(Collectors.toList());
        System.out.println(a3s);
        // Gjeni elementin e pare qe ka vleren b = test3
        A a4s = list.stream().filter(a -> a.b.equals("test3")).findFirst().orElse(null);
        System.out.println(a4s);
        // Konvertoni Listen e A ne nje List<String> (vlerat e b only)
        List<String> lStr = list.stream().map(a -> a.b).collect(Collectors.toList());
        System.out.println(lStr);
        // Konvertoni Listen e A ne nje List<Integer> (vlerat e a only)
        List<Integer> lInt = list.stream().map(a -> a.a).collect(Collectors.toList());
        System.out.println(lStr);

        // GJeni nqs te gjitha elementet e listes qe kane test ne body
        boolean res =  list.stream().allMatch(e -> e.b.contains("test"));

        // Gjeni nqs nje prej elementeve te listes ka vleren 5
        boolean res2 =  list.stream().anyMatch(e -> e.a == 5);

    }


}
class A {
    int a;
    String b;
    public A(int a, String b){
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "{a = " + a +" b = " + b +" }";
    }
}
