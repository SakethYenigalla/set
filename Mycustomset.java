package set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Mycustomset<e> implements Set <e>{
	
	private HashSet<e> list= new HashSet<>();


	@Override
	public int size() {
		
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		
		return list.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		
		return list.contains(o);
	}

	@Override
	public Iterator<e> iterator() {
		
		return list.iterator();
	}

	@Override
	public Object[] toArray() {
		list.toArray();
		return null;
	}
	@Override
	public <T> T[] toArray(T[] e) {
		list.toArray();
		return null;
	}

	@Override
	public boolean add(e e) {
		
		return list.add(e);
	}

	@Override
	public boolean remove(Object o) {
		
		return list.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		
		return list.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends e> c) {
		
		return list.addAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		
		return list.retainAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		
		return list.removeAll(c);
	}

	@Override
	public void clear() {
		list.clear();
		
	}
	
	
	
@Override
	public String toString() {
		return "Mycustomset [list=" + list + "]";
	}

public static void main(String a[]) {
	Set<Integer> set=new Mycustomset<Integer>();
	set.add(20);
	set.add(15);
	set.add(40);
	set.add(40);
	List<Integer> data = new ArrayList<>();
	data.add(1);
	data.add(1);
    set.addAll(data);
	System.out.println(set);
	Set<Integer> num=new Mycustomset<Integer>();
	num.add(13);
	num.add(25);
	num.add(15);
	num.add(20);
	num.add(15);
	System.out.println(num);
	
	//performing Union function
	Set<Integer> union=new Mycustomset<Integer>();
	union.addAll(set);
	union.addAll(num);
	System.out.println("union:" +union);
	//Performing Intersection function
	Set<Integer> intersection=new Mycustomset<Integer>();
	intersection.addAll(num);
	intersection.retainAll(set);
	System.out.println("Intersection:" + intersection);
	//performing difference
	Set<Integer> diference=new Mycustomset<Integer>();
	diference.addAll(num);
	diference.removeAll(set);
	System.out.println("difference:" + diference);
	
	}

}

