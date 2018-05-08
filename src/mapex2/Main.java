package mapex2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// Numere aleatorii generate intre 0 si 99
		// Sa obtinem lista numerelor aleatorii generate pe subintervale 0-9,10-19,samd
		Random rnd = new Random();
		Map<Integer, List<Integer>> rndIntervalMap = new HashMap<>();
		for(int i=0;i < 10000;i++) {
			int rndValue = rnd.nextInt(100);
			int interval = rndValue/10;
			List<Integer> numbers = null;
			if(rndIntervalMap.containsKey(interval)) {
				numbers = rndIntervalMap.get(interval);
				//rndIntervalMap.put(interval, numbers);

			} else {
				numbers = new ArrayList<>();
				rndIntervalMap.put(interval, numbers);
			}
			numbers.add(rndValue);
		}
		System.out.println(rndIntervalMap);
		for(int i =0;i < 10;i++) {
			System.out.println(rndIntervalMap.get(i).size());
		}
	}

}
