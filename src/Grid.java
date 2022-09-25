import java.util.Arrays;

public class Grid {

    private Position Lat;
    private Position Lon;

    private String LonField;
    private String LatField;

    private String LonSquare;
    private String LatSquare;

    private String LonSubSquare;
    private String LatSubSquare;

    private final char[] words = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private final char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public Grid(Coordinate coordinate) {
        this.Lat = coordinate.getLat();
        this.Lon = coordinate.getLon();

        this.LatField = LatDegree2Field(Lat.getDegree());
        this.LonField = LonDegree2Field(Lon.getDegree());

        this.LatSquare = LatDegree2Square(Lat.getDegree());
        this.LonSquare = LonDegree2Square(Lon.getDegree());

        this.LatSubSquare = LatMinute2SubSquare(Lat.getMinute(), Lat.getSecond());
        this.LonSubSquare = LonMinute2SubSquare(Lon.getMinute());
    }

    public Grid(String grid) {
        // grid string can be length of 4 or 6
        this.LonField = grid.substring(0, 1);
        this.LatField = grid.substring(1, 2);

        this.LonSquare = grid.substring(2, 3);
        this.LatSquare = grid.substring(3, 4);

        this.Lat = new Position(LatField2Degree(LatField) + LatSquare2Degree(LatSquare), 0.0, 0.0);
        this.Lon = new Position(LonField2Degree(LonField) + LonSquare2Degree(LonSquare), 0.0, 0.0);

        if (grid.length() == 6) {
            this.LonSubSquare = grid.substring(4, 5);
            this.LatSubSquare = grid.substring(5, 6);
            this.Lat = new Position(LatField2Degree(LatField) + LatSquare2Degree(LatSquare), LatSubSquare2Minute(LatSubSquare), LatSubSquare2Second(LatSubSquare));
            this.Lon = new Position(LonField2Degree(LonField) + LonSquare2Degree(LonSquare), LonSubSquare2Minute(LonSubSquare), 0.0);
        }

    }

    public Coordinate getCoordinate() {
        return new Coordinate(this.Lat, this.Lon);
    }

    public String LatDegree2Field(Double latDegree) {
        latDegree += 90;
        int latField = (int) Math.floor(latDegree / 10);
        return String.valueOf(words[latField]);
    }

    public String LonDegree2Field(Double lonDegree) {
        lonDegree += 180;
        int lonField = (int) Math.floor(lonDegree / 20);
        return String.valueOf(words[lonField]);
    }

    public String LatDegree2Square(Double latDegree) {
        int latSquare = latDegree.intValue() % 10;
        return String.valueOf(numbers[latSquare]);
    }

    public String LonDegree2Square(Double lonDegree) {
        int latSquare = (lonDegree.intValue() % 20) / 2;
        return String.valueOf(numbers[latSquare]);
    }

    public String LatMinute2SubSquare(Double latMinute, Double latSecond) {
        int latSubSquare = (int) ((latMinute + (latSecond / 60)) / 2.5);
        return String.valueOf(words[latSubSquare]).toLowerCase();
    }

    public String LonMinute2SubSquare(Double lonMinute) {
        int lonSubSquare = (int) (lonMinute / 5);
        return String.valueOf(words[lonSubSquare]).toLowerCase();
    }

    public Double LatField2Degree(String latField) {
        int latFieldIndex = Arrays.binarySearch(words, latField.charAt(0));
        return (double) latFieldIndex * 10 - 90;
    }

    public Double LonField2Degree(String lonField) {
        int lonFieldIndex = Arrays.binarySearch(words, lonField.charAt(0));
        return (double) lonFieldIndex * 20 - 180;
    }

    public Double LatSquare2Degree(String latSquare) {
        int latSquareIndex = Arrays.binarySearch(numbers, latSquare.charAt(0));
        return (double) latSquareIndex;
    }

    public Double LonSquare2Degree(String lonSquare) {
        int lonSquareIndex = Arrays.binarySearch(numbers, lonSquare.charAt(0));
        return (double) lonSquareIndex * 2;
    }

    public Double LatSubSquare2Minute(String latSubSquare) {
        int latSubSquareIndex = Arrays.binarySearch(words, latSubSquare.toUpperCase().charAt(0));
        return (double) latSubSquareIndex * 2.5;
    }

    public Double LatSubSquare2Second(String latSubSquare) {
        int latSubSquareIndex = Arrays.binarySearch(words, latSubSquare.toUpperCase().charAt(0));
        double r = latSubSquareIndex * 2.5;
        return (r - (int) r) * 60;
    }

    public Double LonSubSquare2Minute(String lonSubSquare) {
        int lonSubSquareIndex = Arrays.binarySearch(words, lonSubSquare.toUpperCase().charAt(0));
        return (double) lonSubSquareIndex * 5;
    }

    @Override
    public String toString() {
        return String.format("Grid = %s%s%s%s%s%s\n" + this.Lat + this.Lon, LonField, LatField, LonSquare, LatSquare, LonSubSquare, LatSubSquare);
    }

    public static void main(String[] args) {
        Double lat = 39.872965;
        Double lon = 116.472465;

        Position bj_lat = new Position(lat);
        Position bj_lon = new Position(lon);

        Coordinate bj = new Coordinate(bj_lat, bj_lon);
        Grid bjGrid = new Grid(bj);

        System.out.println(bj);
        System.out.println(bjGrid);

        bjGrid = new Grid("OM89fu");
        System.out.println(bjGrid);

        bjGrid = new Grid("OM89");
        System.out.println(bjGrid);
    }

}
