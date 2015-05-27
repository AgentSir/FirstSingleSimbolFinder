import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstSingleSymbolFinder {

    /**
     * Method returns first non-repeated symbol in the String.
     *
     * For optimal implementation:
     *      used LinkedHashMap, Object-marker(oneTime), null-marker(if symbol meets several times)
     *      proceed all work in two loops
     *
     * Overall this method is in O(n) (by Big "O" Notation)
     *
     * @param inputString
     * @return first un-repeatable symbol from inputString or null if string hasn't required symbol
     */
    public Character find(String inputString) {

        // Object "marker" that will show that symbol meets only one time
        Object oneTime = new Object();

        LinkedHashMap<Character, Object> symbolsCounter = new LinkedHashMap<>();
        char[] symbols = inputString.toLowerCase().toCharArray();             // represent string as array of symbols in lower case
        for(char chr: symbols) {
            if (!symbolsCounter.containsKey(chr)) {                           // if symbol not met yet
                symbolsCounter.put(chr, oneTime);                             // set counter for "OneTime"
            } else {                                                          // if symbol is already present
                symbolsCounter.put(chr, null);                                // set counter to null. This means that character was met several times
            }
        }

        // iterate symbolsCounter
        // return character when meet element with value --> Object-marker 
        Iterator<Map.Entry<Character, Object>> iterator = symbolsCounter.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<Character, Object> symbolCounter = iterator.next();
            if(symbolCounter.getValue() instanceof Object) {
                return symbolCounter.getKey();
            }
        }
        return null;
    }
}
