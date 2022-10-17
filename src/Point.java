public class Point {

    private Double degree;
    private Double minute;
    private Double second;

    public Point(Double degree, Double minute, Double second) {
        this.degree = degree;
        this.minute = minute;
        this.second = second;
    }

//    public Point(Double decimal) {
//        if (decimal >= 0) {
//            this.degree = Math.floor(decimal);
//            this.minute = Math.floor((decimal - this.degree) * 60);
//            this.second = (decimal - this.degree - this.minute / 60) * 3600;
//        } else {
//            this.degree = Math.ceil(decimal);
//            this.minute = Math.ceil((decimal - this.degree) * 60);
//            this.second = (decimal - this.degree - this.minute / 60) * 3600;
//        }
//    }

    public Double toDecimal() {
        Double result = this.degree;
        result += (this.minute * 60 + this.second) / 3600;
        return result;
    }

    public Double getDegree() {
        return degree;
    }

    public void setDegree(Double degree) {
        this.degree = degree;
    }

    public Double getMinute() {
        return minute;
    }

    public void setMinute(Double minute) {
        this.minute = minute;
    }

    public Double getSecond() {
        return second;
    }

    public void setSecond(Double second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return String.format("Position = %d°%d'%.3f\" ", degree.intValue(), minute.intValue(), second);
    }

    public static void main(String[] args) {
        Point p = new Point(116.0, 45.0, 30.822);
        System.out.println(p);
        Double result = p.toDecimal();
        System.out.println(result);
    }
}
