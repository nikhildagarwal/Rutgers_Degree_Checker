package structure;
import data.*;
import enumerated.Grade;

import java.util.ArrayList;

public class CourseList {

    private ArrayList<Description> list;
    private int totalCredits;
    private int creditsToGpa;
    private double weightedSum;

    public static final int NOT_FOUND = -1;

    public int getTotalCredits(){
        return totalCredits;
    }

    public int getCreditsToGpa(){
        return creditsToGpa;
    }

    public double getWeightedSum(){
        return weightedSum;
    }

    public CourseList(){
        this.list = new ArrayList<Description>();
        this.totalCredits = 0;
        this.creditsToGpa = 0;
        this.weightedSum = 0.0;
    }

    public Description get(int index){
        return list.get(index);
    }

    public void add(Description description){
        list.add(description);
        Grade currGrade = description.getGrade();
        if(currGrade!=Grade.PA && currGrade!=Grade.AP){
            creditsToGpa+=description.getCredits();
            double cred = (double) description.getCredits();
            weightedSum+=cred*currGrade.getPoints();
        }
        totalCredits+=description.getCredits();

    }

    public void remove(int index){
        Description removed = list.remove(index);
        totalCredits-=removed.getCredits();
        Grade currGrade = removed.getGrade();
        if(currGrade!=Grade.PA && currGrade!=Grade.AP){
            creditsToGpa-=removed.getCredits();
            double cred = removed.getCredits();
            weightedSum-=cred*currGrade.getPoints();
        }
    }

    public void remove(Description description){
        for(int i=0;i<list.size();i++){
            if(list.get(i).equals(description)){
                Description removed = list.remove(i);
                totalCredits-=removed.getCredits();
                Grade currGrade = removed.getGrade();
                if(currGrade!=Grade.PA && currGrade!=Grade.AP){
                    creditsToGpa-=removed.getCredits();
                    double cred = removed.getCredits();
                    weightedSum-=cred*currGrade.getPoints();
                }
                return;
            }
        }
    }

    public boolean contains(Description description){
        for(Description currD:list){
            if(currD.equals(description)){
                return true;
            }
        }
        return false;
    }

    public int getIndex(Description description){
        for(int i =0;i<list.size();i++){
            if(list.get(i).equals(description)){
                return i;
            }
        }
        return NOT_FOUND;
    }

    public int size(){
        return list.size();
    }
}
