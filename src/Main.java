public class Main {
    public static void main(String[] args) {
        Coordinate beijing = new Grid("OM89fu").getCoordinate();
        Coordinate japan = new Grid("PM97lg").getCoordinate();

        System.out.println(Coordinate.distance(beijing, japan));
    }
}