public class Main {
    public static void main(String[] args) {
        Coordinate beijing = new Grid("OM89fu").getCoordinate();
        Coordinate japan = new Grid("PM97lg").getCoordinate();

        System.out.println(Coordinate.distance(beijing, japan));

        /*Coordinate pos = new Coordinate(new Position(39.0, 52.0, 20.0), new Position(116.0, 30.0, 8.0));
        System.out.println(new Grid(pos));

        System.out.println(new Grid("OM89aa"));
        System.out.println(new Grid("OM89ab"));
        System.out.println(new Grid("OM89ac"));

        System.out.println(new Grid("OM89aa"));
        System.out.println(new Grid("OM89ba"));
        System.out.println(new Grid("OM89ca"));*/

        // Bug
        Coordinate pos = new Coordinate(new Position(40.0, 00.0, 00.0), new Position(-80.0, 00.0, 0.0));
        System.out.println(new Grid(pos));
        pos = new Coordinate(new Position(40.0, 00.0, 00.0), new Position(-79.0, 55.0, 0.0));
        System.out.println(new Grid(pos));

        System.out.println(new Grid("FN00aa"));
        System.out.println(new Grid("FN00ba"));
        System.out.println(new Grid("FN00ca"));
        /*System.out.println(new Grid("FN00aa"));
        System.out.println(new Grid("FN00ab"));
        System.out.println(new Grid("FN00ac"));*/
    }
}