package tough;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//451. Sort Characters By Frequency
//Given a string s, sort it in decreasing order based on the frequency of the 
//characters. The frequency of a character is the number of times it appears in the string.
//Return the sorted string. If there are multiple answers, return any of them.

//Input: s = "tree"
//Output: "eert"

//Input: s = "cccaaa"
//Output: "aaaccc"

//Input: s = "Aabb"
//Output: "bbAa"	

 
public class SortCharactersByFrequency {
 
	public static void main(String[] args) {
		
		String str = "tree";
		
		System.out.println(frequencySort(str));
		
	}

	private static String frequencySort(String str) {
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i = 0 ; i < str.length(); i++) {
			
			map.put(str.charAt(i), 1 + map.getOrDefault(str.charAt(i), 0));
		}
		
		List<Map.Entry<Character,Integer>> list = new ArrayList<Map.Entry<Character,Integer>>(
				map.entrySet());
		
		System.out.println("Unsorted List" + list);
		
		Collections.sort(list, (a,b) ->b.getValue().compareTo(a.getValue()));
		
		System.out.println("Sorted list on basis of frequency" +list);
		
		StringBuilder sb = new StringBuilder();
		
		for(Map.Entry<Character, Integer> e: list) {
			int val = e.getValue();
			while(val > 0) {
				sb.append(e.getKey());
				val--;
			}
		}
		
		return sb.toString();
	}
}
