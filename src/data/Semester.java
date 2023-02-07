package data;

public class Semester implements Comparable<Semester>{

    private String season;
    private int year;

    public Semester(String season,int year){
        this.season = season;
        this.year = year;
    }

    @Override
    public boolean equals(Object obj){
        Semester semester = (Semester) obj;
        return season.equals(semester.season) && year==semester.year;
    }

    @Override
    public String toString(){
        return "("+season+" "+year+")";
    }

    @Override
    public int compareTo(Semester semester){
        if(season.compareTo(semester.season)==0){
            return Integer.compare(year,semester.year);
        }else{
            return season.compareTo(semester.season);
        }
    }

    public String getSeason(){
        return season;
    }

    public int getYear(){
        return year;
    }

}
