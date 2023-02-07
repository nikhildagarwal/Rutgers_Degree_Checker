package data;
import enumerated.Grade;

public class Description implements Comparable<Description>{

    private CourseC courseC;
    private Semester semester;
    private int credits;
    private Grade grade;

    public Description(CourseC courseC,Semester semester,int credits,Grade grade){
        this.courseC = courseC;
        this.semester = semester;
        this.credits = credits;
        this.grade = grade;

    }

    @Override
    public boolean equals(Object obj){
        Description description = (Description) obj;
        return courseC.equals(description.courseC) && semester.equals(description.semester) && credits==description.credits;
    }

    @Override
    public String toString(){
        return courseC+" "+credits+" "+grade+" "+semester;
    }

    @Override
    public int compareTo(Description description){
        if(courseC.equals(description.courseC)){
            if(credits==description.credits){
                int gradeCompare = grade.compareWith(description.grade);
                if(gradeCompare==0){
                    return semester.compareTo(description.semester);
                }else{
                    return gradeCompare;
                }
            }else{
                return Integer.compare(credits,description.credits);
            }
        }else{
            return courseC.compareTo(description.courseC);
        }
    }

    public CourseC getCourseC(){
        return courseC;
    }

    public Semester getSemester(){
        return semester;
    }

    public int getCredits(){
        return credits;
    }

    public Grade getGrade(){
        return grade;
    }

}
