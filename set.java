package set;
import java.util.HashSet;
import java.util.Set;


public class set {
	public static void main (String a[]) {
		Set<Integer> set=new HashSet<Integer>();
		set.add(20);
		set.add(15);
		set.add(40);
		System.out.println(set);
		Set<Integer> num=new HashSet<Integer>();
		num.add(13);
		num.add(25);
		num.add(15);
		num.add(20);
		num.add(15);
		System.out.println(num);
		
		//performing Union function
		Set<Integer> union=new HashSet<Integer>();
		union.addAll(set);
		union.addAll(num);
		System.out.println("union:" +union);
		//Performing Intersection function
		Set<Integer> intersection=new HashSet<Integer>();
		intersection.addAll(num);
		intersection.retainAll(set);
		System.out.println("Intersection:" + intersection);
		//performing difference
		Set<Integer> diference=new HashSet<Integer>();
		diference.addAll(num);
		diference.removeAll(set);
		System.out.println("difference:" + diference);
		
		}

}
