import java.util.Arrays;

public class Grid {

    private Point Lat;
    private Point Lon;

    private String QTH;

    public Grid(Location location) {
        this.Lat = location.getLat();
        this.Lon = location.getLon();

        this.QTH = Location2Grid(location);
    }

    public Grid(String grid) {
        this.QTH = grid;
        Location location = Grid2Location(grid);
        if (location != null) {
            this.Lat = location.getLat();
            this.Lon = location.getLon();
        }
    }

    public Location getCoordinate() {
        return new Location(this.Lat, this.Lon);
    }

    public Location Grid2Location(String QTH) {
        if (QTH.length() != 4 && QTH.length() != 6) return null;
        if (!isValidLocator(QTH)) return null;
        int lonFirst, latFirst, lonSecond, latSecond;
        double lonThird, latThird;
        if (QTH.length() == 4) {
            lonFirst = (QTH.charAt(0) - 'A') * 20;
            latFirst = (QTH.charAt(1) - 'A') * 10;
            lonSecond = (QTH.charAt(2) - '0') * 2;
            latSecond = QTH.charAt(3) - '0';
            return new Location(new Point((double) (latFirst + latSecond + (1.0 / 48.0) - 90), 0.0, 0.0), new Point((double) (lonFirst + lonSecond + (1.0 / 24.0) - 180), 0.0, 0.0));
        } else {
            lonFirst = (QTH.charAt(0) - 'A') * 20;
            latFirst = (QTH.charAt(1) - 'A') * 10;
            lonSecond = (QTH.charAt(2) - '0') * 2;
            latSecond = QTH.charAt(3) - '0';
            lonThird = (QTH.charAt(4) - 'a') / 12.0 + (1.0 / 24.0) - 180;
            latThird = (QTH.charAt(5) - 'a') / 24.0 + (1.0 / 48.0) - 90;
            return new Location(new Point(latFirst + latSecond + latThird, 0.0, 0.0), new Point(lonFirst + lonSecond + lonThird, 0.0, 0.0));
        }
    }

    public String Location2Grid(Location location) {
        if (!isValidLocation(location)) return null;
        Double lat = location.getLat().toDecimal(), lon = location.getLon().toDecimal();
        double tempLon = lon > 180.0 ? lon - 180 : lon;
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWX";
        String lower = "abcdefghijklmnopqrstuvwx";
        double longitude = tempLon + 180, latitude = lat + 90;
        char lonFirst = upper.charAt((int) (longitude / 20));
        char latFirst = upper.charAt((int) (latitude / 10));
        String lonSecond = String.valueOf((int) ((longitude / 2) % 10));
        String latSecond = String.valueOf((int) (latitude % 10));
        char lonThird = lower.charAt((int) ((longitude % 2) * 12));
        char latThird = lower.charAt((int) ((latitude % 1) * 24));
        return String.format("%c%c%s%s%c%c", lonFirst, latFirst, lonSecond, latSecond, lonThird, latThird);
    }

    private boolean isValidLocator(String grid) {
        return grid.matches("[a-xA-X][a-xA-X][0-9][0-9][a-xA-X]?[a-xA-X]?");
    }

    private boolean isValidLocation(Location location) {
        Point lat = location.getLat(), lon = location.getLon();
        return (lat.toDecimal() >= -90 && lat.toDecimal() <= 90) && (lon.toDecimal() >= -180 && lon.toDecimal() <= 180);
    }

    @Override
    public String toString() {
        String result = String.format("QTH:%s Lat:%f Lon:%f", QTH, Lat.toDecimal(), Lon.toDecimal());
        return result;
    }

    public static void main(String[] args) {
        Point bj_lat = new Point(39.0, 10.0, 10.0);
        Point bj_lon = new Point(116.0, 30.0, 30.0);

        Location bj = new Location(bj_lat, bj_lon);
        Grid bjGrid = new Grid(bj);

        System.out.println(bj);
        System.out.println(bjGrid);

        bjGrid = new Grid("OM89fu");
        System.out.println(bjGrid);

        bjGrid = new Grid("OM89");
        System.out.println(bjGrid);
    }

}
