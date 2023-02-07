package data;

public class CourseC implements Comparable<CourseC>{
    private int schoolCode;
    private int departmentCode;
    private int courseCode;

    public CourseC(int schoolCode,int departmentCode,int courseCode){
        this.schoolCode = schoolCode;
        this.departmentCode = departmentCode;
        this.courseCode = courseCode;
    }

    @Override
    public boolean equals(Object obj){
        CourseC courseC = (CourseC) obj;
        return schoolCode==courseC.schoolCode && departmentCode==courseC.departmentCode && courseCode==courseC.courseCode;
    }

    @Override
    public String toString(){
        String colon = ":";
        String sc = Integer.toString(schoolCode);
        while(sc.length()<2){
            sc = "0"+sc;
        }
        String dc = Integer.toString(departmentCode);
        while(dc.length()<3){
            dc = "0"+dc;
        }
        String cc = Integer.toString(courseCode);
        while(cc.length()<3){
            cc = "0"+cc;
        }
        return sc+colon+dc+colon+cc;
    }

    @Override
    public int compareTo(CourseC courseC){
        if(schoolCode==courseC.schoolCode){
            if(departmentCode==courseC.departmentCode){
                return Integer.compare(courseCode,courseC.courseCode);
            }else{
                return Integer.compare(departmentCode,courseC.departmentCode);
            }
        }else{
            return Integer.compare(schoolCode,courseC.schoolCode);
        }
    }

    public int getSchoolCode(){
        return schoolCode;
    }

    public int getDepartmentCode(){
        return departmentCode;
    }

    public int getCourseCode(){
        return courseCode;
    }

}
