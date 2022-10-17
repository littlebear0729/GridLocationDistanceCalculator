public class Location {

    private Point lat;
    private Point lon;

    public Location(Point lat, Point lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public Point getLat() {
        return lat;
    }

    public void setLat(Point lat) {
        this.lat = lat;
    }

    public Point getLon() {
        return lon;
    }

    public void setLon(Point lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Coordinate: Latitude: " + lat +
                ", Longitude: " + lon;
    }

    public static double distance(Location c1, Location c2) {

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
        Point bj_lat = new Point(39.0, 0.0, 0.0);
        Point bj_lon = new Point(116.0, 30.0, 30.0);

        Location bj = new Location(bj_lat, bj_lon);
        System.out.println(bj);

        Point bj_lat_2 = new Point(40.0, 30.0, 0.0);
        Point bj_lon_2 = new Point(116.0, 0.0, 0.0);
        Location bj_2 = new Location(bj_lat_2, bj_lon_2);

        System.out.println(distance(bj, bj_2));
    }
}
