package student;

public class StudentC implements Comparable<StudentC>{

    private String fio;
    private int db, matan, prolog, java;

    public StudentC(String fio, int db, int matan, int prolog, int java){
        this.fio = fio;
        this.db = db;
        this.matan = matan;
        this.prolog = prolog;
        this.java = java;

    }

    @Override
    public String toString() {
        return "Student {" +
                "fio = '" + fio + '\'' +
                ", db = " + db +
                ", matan = " + matan +
                ", prolog = " + prolog +
                ", java = " + java +
                ", Average Rating: " + averageRating() +
                '}';
    }

    private double averageRating(){
        return (db+matan+prolog+java)/4.0;
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
