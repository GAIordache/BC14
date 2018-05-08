package mapex1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static String __text = "Doamne, ce om vrednic și cu bunătate mai era! Prin îndemnul său, ce mai pomi s-au pus în țintirim, care era îngrădit cu zăplaz de bârne, streșinit cu șindilă, și ce chilie durată s-a făcut la poarta bisericii pentru școală; ș-apoi, să fi văzut pe neobositul părinte cum umbla prin sat din casă în casă, împreună cu bădița Vasile a Ilioaei, dascălul bisericii, un holtei zdravăn, frumos și voinic, și sfătuia pe oameni să-și dea copiii la învățătură. Și unde nu s-au adunat o mulțime de băieți și fete la școală, între care eram și eu, un băiat prizărit, rușinos și fricos și de umbra mea.\r\n" + 
			"\r\n" + 
			"Și cea dintâi școlăriță a fost însăși Smărăndița popii, o zgâtie de copilă ageră la minte și așa de silitoare, de întrecea mai pe toți băieții și din carte, dar și din nebunii. Însă părintele mai în toată ziua da pe la școală și vedea ce se petrece... Și ne pomenim într-una din zile că părintele vine la școală și ne aduce un scaun nou și lung, și după ce-a întrebat de dascăl, care cum ne purtăm, a stat puțin pe gânduri, apoi a pus nume scaunului „Calul Balan“ și l-a lăsat în școală.\r\n" + 
			"\r\n" + 
			"În altă zi ne trezim că iar vine părintele la școală, cu moș Fotea, cojocarul satului, care ne aduce, dar de școală nouă, un drăguț de biciușor de curele, împletit frumos, și părintele îi pune nume „Sfântul Nicolai“, după cum este și hramul bisericii din Humulești... Apoi poftește pe moș Fotea că, dacă i-or mai pica ceva curele bune, să mai facă așa, din când în când, câte unul, și ceva mai grosuț, dacă se poate... Bădița Vasile a zâmbit atunci, iară noi, școlarii, am rămas cu ochii holbați unii la alții. Și a pus părintele pravilă și a zis că în toată sâmbăta să se procitească băieții și fetele, adică să asculte dascălul pe fiecare de tot ce-a învățat peste săptămână; și câte greșeli va face să i le însemne cu cărbune pe ceva, iar la urma urmelor, de fiecare greșeală să-i ardă școlarului câte un sfânt-Nicolai. Atunci copila părintelui, cum era sprințară și plină de incuri, a bufnit în râs. Păcatul ei, sărmana!";

	public static void main(String[] args) {
		Map<String, Integer> wordFrequencyMap = new HashMap<String, Integer>();
		__text = __text.replaceAll(",", " ");
		__text = __text.replaceAll("\\.", " ");

		__text = __text.replaceAll("!", " ");
		__text = __text.replaceAll("\r", " ");
		__text = __text.replaceAll("\n", " ");

		__text = __text.replaceAll(";", " ");
		while(__text.indexOf("  ") >= 0) {
			__text = __text.replaceAll("  ", " ");
		}

		String[] words = __text.split(" ");
		System.out.println(Arrays.toString(words));
		for(String word : words) {
			if(wordFrequencyMap.containsKey(word)) {
				// add 1 to word frequency
				Integer oldCount = wordFrequencyMap.get(word);
				wordFrequencyMap.put(word, Integer.valueOf(oldCount.intValue() + 1));
			} else {
				// first occurrence
				wordFrequencyMap.put(word, 1);
			}
		}
		System.out.println(wordFrequencyMap);
		// Calcul frecventa relativa
		Map<String, Double> wordRelativeFrequencyMap = new HashMap<String, Double>();
		for(Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
			wordRelativeFrequencyMap.put(entry.getKey(), entry.getValue().intValue()*1.0/words.length);
		}
		System.out.println(wordRelativeFrequencyMap);
		double frequencySum = 0;
		for(double d : wordRelativeFrequencyMap.values()) {
			frequencySum += d;
		}
		System.out.println(frequencySum);

		Double sum = wordRelativeFrequencyMap.values().stream().reduce( Double::sum).get();
		System.out.println(sum);

	}

}
