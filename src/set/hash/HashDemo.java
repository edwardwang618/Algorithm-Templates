package set.hash;

import java.util.HashSet;
import java.util.Set;

public class HashDemo {
    public static void main(String[] args) {
        System.out.println(((Integer) 42).hashCode());
        System.out.println(((Integer) (-42)).hashCode());
        System.out.println(((Double) 3.1415926).hashCode());
        
        System.out.println("imooc".hashCode());
        Student student = new Student(3, 2, "bobo", "liu");
        System.out.println(student.hashCode());
        
        Set<Student> set = new HashSet<>();
        set.add(student);
        Student student2 = new Student(3, 2, "bobo", "liu");
        System.out.println(student2.hashCode());
    }
}

class Student {
    int grade;
    int cls;
    String firstName;
    String lastName;
    
    public Student(int grade, int cls, String firstName, String lastName) {
        this.grade = grade;
        this.cls = cls;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    @Override
    public int hashCode() {
        int B = 31;
        int hash = 0;
        hash = hash * B + grade;
        hash = hash * B + cls;
        hash = hash * B + firstName.hashCode();
        hash = hash * B + lastName.hashCode();
        return hash;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Student another = (Student) o;
        return this.grade == another.grade && this.cls == another.cls && this.firstName.equals(another.firstName) && this.lastName.equals(another.lastName);
    }
}