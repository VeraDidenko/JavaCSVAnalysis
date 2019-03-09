package student;

import java.util.ArrayList;

public class StudentC implements Comparable<StudentC>{

    private String fio;
    private ArrayList<Integer> grades;

    public StudentC(String fio, ArrayList<Integer> grades){
        this.fio = fio;
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Student {" +
                "fio = '" + fio + '\'' +
                ", grades = " + grades +
                ", Average Rating: " + averageRating() +
                '}';
    }

    private double averageRating(){
        double amount = grades.size();
        int sum = grades.stream().reduce(0, (a, b) -> a + b);
        return sum/amount;
    }

    @Override
    public int compareTo(StudentC o) {
        if(this.averageRating()>o.averageRating())
            return -1;
        else if(o.averageRating()>this.averageRating())
            return 1;
        return 0;
    }
}
