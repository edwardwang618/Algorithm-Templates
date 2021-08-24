package set.hash;

import java.util.*;

public class HashDemo {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Mike");
        Student s2 = new Student(1, "Chris");
        System.out.println(s1.equals(s2));
        Set<Student> set = new HashSet<>();
        set.add(s1);
        System.out.println(set);
        s1.firstName = "Chris";
        System.out.println(set);
        set.add(s2);
        System.out.println(set);
        
        byte x = -20;
        System.out.println(Integer.toBinaryString(x));
        System.out.println(x & 0xff);
        
        int y = 13331;
        int z = (int) (Math.log(y) / Math.log(2));
        System.out.println(1 << 13);
    
        int N = (int) (2e5 + 5);
        System.out.println(1 << 18);
        System.out.println(Math.log(N) / Math.log(2) + 1);
    }
}

class Student {
    int grade;
    String firstName;
    
    public Student(int grade, String firstName) {
        this.grade = grade;
        this.firstName = firstName;
    }
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return grade == student.grade && Objects.equals(firstName, student.firstName);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(grade, firstName);
    }
    
    @Override
    public String toString() {
        return "Student{" +
                "grade=" + grade +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}