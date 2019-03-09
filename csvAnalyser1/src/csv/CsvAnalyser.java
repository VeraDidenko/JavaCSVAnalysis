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
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathname))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                records.add(Arrays.asList(values));
            }
        }
        records.forEach(this::createStudent);
        return this.students;
    }

    private void createStudent(List<String> data) {
        int db = Integer.parseInt(data.get(1));
        int matan = Integer.parseInt(data.get(2));
        int prolog = Integer.parseInt(data.get(3));
        int java = Integer.parseInt(data.get(4));
        students.add(new StudentC(data.get(0),db,matan,prolog,java));
    }

}
