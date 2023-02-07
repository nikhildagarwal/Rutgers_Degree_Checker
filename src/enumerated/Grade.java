package enumerated;

public enum Grade {
    A(4.0),
    Bp(3.5),
    B(3.0),
    Cp(2.5),
    C(2.0),
    D(1.0),
    F(0),
    PA(-1),
    AP(-2);

    private final double points;

    Grade(double points){
        this.points = points;
    }

    public double getPoints(){
        return points;
    }

    public int compareWith(Grade gpa){
        return Double.compare(points,gpa.points);
    }

    @Override
    public String toString() {
        if(points==4.0){
            return "A";
        }else if(points==3.5){
            return "B+";
        }else if(points==3.0){
            return "B";
        }else if(points==2.5){
            return "C+";
        }else if(points==2.0){
            return "C";
        }else if(points==1.0){
            return "D";
        }else if(points==0){
            return "F";
        }else if(points==-1){
            return "PA";
        }else{
            return "AP";
        }
    }
}
