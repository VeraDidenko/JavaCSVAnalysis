import csv.CsvAnalyser;
import student.StudentC;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CsvAnalyser analyser = new CsvAnalyser();
        try {
            Scanner sc = new Scanner(System.in);
            List<StudentC> studentsC = analyser.read(args[0]);
            System.out.println("Sort ascending(1) or descending(2)?: ");
            int sortOrder = sc.nextInt();
            System.out.println("------------------------------------------------------");
            Collections.sort(studentsC);
            if(sortOrder == 2){
                Collections.reverse(studentsC);
            }
            System.out.println("Students: ");
            studentsC.forEach(System.out::println);
            System.out.println("------------------------------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
