import java.io.*;
import java.util.*;

public class Noah {
	String make;
	String model;
	int year;
	
	
	public Noah(String make, String model, int year) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
	}


	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("noah.dat"));
		int n = scan.nextInt();
		scan.nextLine();
		List<Noah> list = new ArrayList<Noah>();
		while (n-- > 0) {
			String arr [] = scan.nextLine().split(",");
			list.add(new Noah(arr[0],arr[1],Integer.parseInt(arr[2])));
		}
		Comparator<Noah> comp1 = (a,b)->a.make.compareTo(b.make);
		Comparator<Noah> comp2 = (a,b)->a.model.compareTo(b.model);
		Comparator<Noah> comp3 = (a,b)->a.year-b.year;
		list.sort(comp1.thenComparing(comp2).thenComparing(comp3));
		System.out.println("---Data Breakdown---");
		list.forEach(a->System.out.println(a.make + " "+ a.model + " " + a.year));
		System.out.println();
		System.out.println("---Make Breakdown---");
		Map <String, Integer> map1 = new TreeMap<>();	
		Map <String, Integer> map2 = new TreeMap<>();	
		Map <Integer, Integer> map3 = new TreeMap<>();	
		for (Noah obj:list) {
			map1.putIfAbsent(obj.make,0);
			map2.putIfAbsent(obj.model,0);
			map3.putIfAbsent(obj.year,0);
			map1.put(obj.make,map1.get(obj.make)+ 1);
			map2.put(obj.model,map2.get(obj.model)+ 1);
			map3.put(obj.year,map3.get(obj.year)+ 1);
		}
		map1.entrySet().stream().forEach(a->System.out.println(a.getKey()+" "+ a.getValue()));
		System.out.println();
		System.out.println("---Model Breakdown---");
		map2.entrySet().stream().forEach(a->System.out.println(a.getKey()+": "+ a.getValue()));
		System.out.println();
		System.out.println("---Year Breakdown---");
		map3.entrySet().stream().forEach(a->System.out.println(a.getKey()+": "+ a.getValue()));
	}

}
