import java.io.*;
import java.util.*;

/**
 * Created by Morten on 17.10.2017.
 */
public class AnagramFinder {

    private Map<String, Collection<String>> map;
    private String file = "AnagramFinder\\eventyr.txt";

    public void findAnagram() {
        map = new HashMap<>();
        try {
            String line = null;
            FileInputStream fileReader = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileReader, "UTF-8"));

            while ((line = bufferedReader.readLine()) != null) {
                String word = line.trim();
                String sortedWord = radixSort(word);
                if (!map.containsKey(sortedWord)) {
                    map.put(sortedWord, new ArrayList<>());
                }
                map.get(sortedWord).add(word);
            }

            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    char[] countingSort(char arr[], int exp) {
        char[] output = new char[arr.length];
        int[] countArray = new int[10];

        for (int nr : arr) {
            countArray[getCorrectDigit(nr, exp)]++;
        }

        for (int i = 1; i < countArray.length; i++) {
            countArray[i] = countArray[i] + countArray[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[--countArray[getCorrectDigit(arr[i], exp)]] = arr[i];
        }
        return output;
    }

    String radixSort(String string) {
        int max = 256;
        char[] charArray = string.toCharArray();
        for (int exp = 1; max / exp > 0; exp *= 10) {
            charArray = countingSort(charArray, exp);
        }
        return new String(charArray);
    }


    private int getCorrectDigit(int integer, int divisor) {
        return (integer / divisor) % 10;
    }


    public static void main(String[] args) {
        AnagramFinder anagramFinder = new AnagramFinder();

        anagramFinder.findAnagram();


        //Print key and values
        for (String key : anagramFinder.map.keySet()) {
            if (anagramFinder.map.get(key).size() > 1) {
                System.out.println(key + " : " + anagramFinder.map.get(key));
            }
        }


    }
}
