package csv;

import student.StudentC;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CsvAnalyser {
    private List<StudentC> students;

    public CsvAnalyser(){
        this.students = new ArrayList<>();
    }

    public List<StudentC> read(String pathname) throws IOException {
        List<ArrayList<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathname))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                records.add(new ArrayList<>(Arrays.asList(values)));
            }
        }
        records.forEach(this::createStudent);
        return this.students;
    }

    private void createStudent(ArrayList<String> data) {
        //Get name of student
        String fio = data.get(0);
        //Remove name and add each element to the grade list
        data.remove(0);
        ArrayList<Integer> grades = new ArrayList<>();
        data.forEach(grade -> grades.add(Integer.parseInt(grade)));
        //Add created Student object to list of students
        students.add(new StudentC(fio,grades));
    }

}
