public class Main {
    public static void main(String[] args) {
        Location beijing = new Grid("OM89fu").getCoordinate();
        Location japan = new Grid("PM97lg").getCoordinate();

        System.out.println(Location.distance(beijing, japan));

        /*Coordinate pos = new Coordinate(new Position(39.0, 52.0, 20.0), new Position(116.0, 30.0, 8.0));
        System.out.println(new Grid(pos));

        System.out.println(new Grid("OM89aa"));
        System.out.println(new Grid("OM89ab"));
        System.out.println(new Grid("OM89ac"));

        System.out.println(new Grid("OM89aa"));
        System.out.println(new Grid("OM89ba"));
        System.out.println(new Grid("OM89ca"));*/

/*        // Bug
        Coordinate pos = new Coordinate(new Position(40.0, 00.0, 00.0), new Position(-80.0, 00.0, 0.0));
        System.out.println(new Grid(pos));
        // Should be FN00aa
        pos = new Coordinate(new Position(40.0, 00.0, 00.0), new Position(-79.0, 55.0, 0.0));
        System.out.println(new Grid(pos));
        // Should be FN00ma

        System.out.println(new Grid("FN00aa"));
        // Should be 40.00.00N 80.00.00W
        System.out.println(new Grid("FN00ba"));
        // Should be 79.55.00W
        System.out.println(new Grid("FN00ca"));
        // Should be 79.50.00W*/

        System.out.println(new Grid("FN00"));
        System.out.println(new Grid("FN10"));
        System.out.println(new Grid("FN20"));
    }
}