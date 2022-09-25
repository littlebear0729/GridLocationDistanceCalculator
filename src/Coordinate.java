public class Coordinate {

    private Position lat;
    private Position lon;

    public Coordinate(Position lat, Position lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public Position getLat() {
        return lat;
    }

    public void setLat(Position lat) {
        this.lat = lat;
    }

    public Position getLon() {
        return lon;
    }

    public void setLon(Position lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Coordinate: Latitude: " + lat +
                ", Longitude: " + lon;
    }

    public static double distance(Coordinate c1, Coordinate c2) {

        final int R = 6371; // Radius of the earth

        double lat1 = c1.getLat().toDecimal();
        double lon1 = c1.getLon().toDecimal();
        double lat2 = c2.getLat().toDecimal();
        double lon2 = c2.getLon().toDecimal();

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        //Result in kilometer
        return R * c;
    }

    public static void main(String[] args) {
        Position bj_lat = new Position(39.873322);
        Position bj_lon = new Position(116.472786);

        Coordinate bj = new Coordinate(bj_lat, bj_lon);
        System.out.println(bj);

        Position bj_lat_2 = new Position(40.073322);
        Position bj_lon_2 = new Position(116.482786);
        Coordinate bj_2 = new Coordinate(bj_lat_2, bj_lon_2);

        System.out.println(distance(bj, bj_2));
    }
}
