package TestDriven;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class TestDriven
{
    public static String getRange( int[] values )
    {
        int[] sortedValues = Arrays.stream(values).sorted().toArray();
        ArrayList<ArrayList<Integer>> rangeGroups = splitIntoRanges(sortedValues);
        rangeGroups = removeDuplicates(rangeGroups);
        HashMap rangeCounts = getRangeCounts(rangeGroups);
        String masterOutout = convertToString(rangeCounts);

        return masterOutout;
    }

    public static ArrayList<ArrayList<Integer>> splitIntoRanges(int[] values){

        ArrayList<Integer> range = new ArrayList<>();
        ArrayList<Integer> sourceInput = (ArrayList<Integer>) Arrays.stream(values).boxed().collect(Collectors.toList());
        sourceInput.add(-999);
        ArrayList<ArrayList<Integer>> rangeSet = new ArrayList<>();

        range.add(sourceInput.get(0));
        for( int i=1; i<sourceInput.size(); i++){

            if( sourceInput.get(i) - 1 <= sourceInput.get(i-1) && i!= sourceInput.size()-1 ){
                range.add(sourceInput.get(i));
            }else {
                rangeSet.addAll(Collections.singleton((ArrayList<Integer>) range.stream().map(val -> new Integer(val)).collect(Collectors.toList())));
                range.clear();
                range.add(sourceInput.get(i));
            }

        }

        return rangeSet;

    }


    public static ArrayList<ArrayList<Integer>> removeDuplicates(ArrayList<ArrayList<Integer>> rangeGroups){

        ArrayList<ArrayList<Integer>> newRangeGroup = new ArrayList<>();
        for(ArrayList<Integer> range : rangeGroups){
            if( range.get(0).intValue() != range.get(range.size()-1).intValue() )
                newRangeGroup.addAll(Collections.singleton((ArrayList<Integer>) range.stream().map(val -> new Integer(val)).collect(Collectors.toList())));
        }
        return newRangeGroup;

    }

    public static HashMap<String, String> getRangeCounts(ArrayList<ArrayList<Integer>> rangeGroups){

        HashMap<String, String> rangeCounts = new HashMap<>();

        for(ArrayList<Integer> range : rangeGroups){
            String rangeString = range.get(0) + "-" + range.get(range.size()-1);
            String rangeLength = String.valueOf(range.size());
            rangeCounts.put(rangeString, rangeLength);
        }

        return rangeCounts;
    }

    public static String convertToString(HashMap<String, String> rangeCounts){
        String masterOutput = new String();

        Enumeration<String> keys = Collections.enumeration(rangeCounts.keySet());
        while (keys.hasMoreElements()){
            String rangeAsKey = keys.nextElement();
            masterOutput = masterOutput + rangeAsKey + ", " + rangeCounts.get(rangeAsKey) + "\n";
        }
        return masterOutput.trim();
    }
}