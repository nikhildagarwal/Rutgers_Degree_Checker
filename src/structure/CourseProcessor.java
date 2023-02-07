package structure;
import java.util.Scanner;
import java.util.Arrays;
import data.*;
import structure.*;
import enumerated.*;

public class CourseProcessor {

    public void runChecker(){
        CourseList courseList = new CourseList();
        System.out.println("Course reader is running...");
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String[] tokens = processLine(scanner.nextLine());
            try{
                String cc = tokens[0];
                int cred = Integer.parseInt(tokens[1]);
                String seas = tokens[2];
                int year = Integer.parseInt(tokens[3]);
                String gr = tokens[4];
                Grade grade = fetchGrade(gr);
                String[] code = cc.split(":",5);
                Description d = new Description(new CourseC(Integer.parseInt(code[0]),Integer.parseInt(code[1]),Integer.parseInt(code[2])),new Semester(seas,year),cred,grade);
                courseList.add(d);
            }catch (Exception e){

                try{
                    if(tokens[0].equals("Q")){
                        ystem.out.println("Reader terminated.");
                        System.out.println("");
                        System.out.println("** Course List **");
                        for(int i =0;i<courseList.size();i++){
                            System.out.println(courseList.get(i));
                        }
                        System.out.println("");
                        System.out.println("Total Number of Credits: "+courseList.getTotalCredits());
                        System.out.println("Total Number of Credits Used In GPA Calculation: "+courseList.getCreditsToGpa());
                        double credToG = courseList.getCreditsToGpa();
                        System.out.println(courseList.getWeightedSum()/credToG);
                        return;
                    }
                }catch (Exception e1){

                }
            }
        }

    }

    private Grade fetchGrade(String gr){
        switch(gr){
            case "A":
                return Grade.A;
            case "B+":
                return Grade.Bp;
            case "B":
                return Grade.B;
            case "C+":
                return Grade.Cp;
            case "C":
                return Grade.C;
            case "D":
                return Grade.D;
            case "F":
                return Grade.F;
            case "PA":
                return Grade.PA;
            case "AP":
                return Grade.AP;
        }
        return null;
    }

    private String[] processLine(String command){
        String[] line = command.split("\\s");
        int counter = 0;
        String[] newLine = new String[line.length];
        for(String token:line){
            if(!token.equals("")){
                newLine[counter] = token;
                counter++;
            }
        }
        return newLine;
    }
}
