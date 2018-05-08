package streamex1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		// Stream creation
		// 1 - from collections
		// 2 - Factory methods - enumeration, files,
		List<String> words = Arrays.asList("ala", "bala", "portocala", "xxxxxxx");
		Stream<String> stream = words.stream();
		stream = stream.filter((s) -> s.contains("a"));
		stream = stream.filter((s) -> s.length() >= 4);
		stream = stream.map((String s) -> s.toUpperCase());
		// stream.forEach((String s) -> System.out.println(s));
		List<String> l = stream.collect(Collectors.toList());
		System.out.println(l);
		// words.stream().filter((s) -> s.startsWith("p")).forEach(System.out::println);
		words.stream().map((String s) -> s.length()).forEach(System.out::println);
		words.stream().map((String s) -> s.length()).reduce(Integer::sum).ifPresent(System.out::println);
		int sum = words.stream().map((String s) -> s.length()).reduce(10, (Integer v1, Integer v2) -> v1 + v2);
		System.out.println(sum);
		int prod = words.stream().map((String s) -> s.length())
				.reduce(1, (Integer v1, Integer v2) -> v1 * v2);
		System.out.println(prod);
		int squaredSum = words.stream().map((String s) -> s.length())
				.reduce(0, (Integer acc, Integer v2) -> acc + v2*v2*v2);
		System.out.println(squaredSum);
		
		Stream<Integer> stream1 = Stream.iterate(1, (v) -> v + 1).limit(333);
		int cubeSum = stream1.reduce(0, (Integer acc, Integer v2) -> acc + v2*v2*v2);
		System.out.println(cubeSum);

	}

}
