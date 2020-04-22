
package ui;

import domein.Student;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class StudentApp {
    
    
    public void start(){
        List<Student> studenten = new ArrayList<>();
        studenten.add(new Student(123456,"Janssens","Jan","Oudenaarde"));
        studenten.add(new Student(23584,"Pieters","Piet"));
        studenten.add(new Student(123457,"Boomans","Luc"));
        studenten.add(new Student(123455,"Lauwers","Frederik","Antwerpen"));
                
        Student s1 = new Student(123457,"Boomans","Luc");
        
        for (Student s : studenten)
            if (s.equals(s1))
                System.out.printf("Student gevonden: %d - %s %s%n", s.getStamboeknr(), s.getVoornaam(), s.getNaam());
                    
        start2();
    }
    
    public void start2(){
        Student[] studenten = new Student[4];
        studenten[0] = new Student(123456,"Janssens","Jan","Oudenaarde");
        studenten[1] = new Student(23584,"Pieters","Piet");
        studenten[2] = new Student(123457,"Boomans","Luc");
        studenten[3] = new Student(123455,"Lauwers","Frederik","Antwerpen");
        
       Arrays.sort(studenten);
    }
}
