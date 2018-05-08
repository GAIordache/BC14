package streamex3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	static class Person {
		String mNume;
		
		Person(String nume) {
			mNume = nume;
		}

		@Override
		public String toString() {
			return "Person [mNume=" + mNume + "]";
		}
		
		
	}

	public static void main(String[] args) {
		String[] nume = {
		"George","Ion","Vasile","Gheorghe"		
		};
		List<Person> list = Arrays.asList(nume).stream()
				.map((s) -> new Person(s)).collect(Collectors.toList());
		System.out.println(list);
	}
}
