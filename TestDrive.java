public class TestDrive {

    private final static String INPUT_STRING = "tggczcatbzfaba";

    public static void main(String[] args) {

        FirstSingleSymbolFinder finder = new FirstSingleSymbolFinder();
        System.out.println(finder.find(INPUT_STRING));

    }

}
