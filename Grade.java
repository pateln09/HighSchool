import java.io.*;
import java.util.*;

public class Grade {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("grade.dat"));
		
		int noSets = scan.nextInt();
		scan.nextLine();
		
		ArrayList <Student> grades = new ArrayList <Student>();
		
		while (noSets -- > 0) {
			String lettergrade;
			String arr[] = scan.nextLine().split(" ");
			
			double num_grade = Double.parseDouble(arr[2]);
			
			lettergrade = num_grade <= 100 && num_grade >= 98? "A+": num_grade < 98 && num_grade >= 93? "A" : num_grade < 93 && num_grade >= 90? "A-" : num_grade < 89 && num_grade >= 97? "B+" : num_grade < 87 && num_grade >= 84? "B" : num_grade < 84 && num_grade >= 80? "B-" : num_grade < 79 && num_grade >= 78? "C+" : num_grade < 78 && num_grade >= 74? "C": num_grade < 74 && num_grade >= 70? "C-": "F";
			grades.add(new Student (arr[0], arr[1],lettergrade));
		}
		
		Comparator<Student> comp1 = (a,b) -> (a.last).compareTo(b.last);
		Collections.sort(grades, comp1);
		for (int i = 0; i < grades.size(); i++) {
			System.out.println(grades.get(i).first + " " + grades.get(i).last + " has an: " + grades.get(i).grade);
		}
			
		
	}

}
class Student{
	String first;
	String last;
	String grade;
	public Student(String first, String last, String grade) {
		super();
		this.first = first;
		this.last = last;
		this.grade = grade;
	}
}
