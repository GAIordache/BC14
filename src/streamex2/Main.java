package streamex2;

import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	static class AccumulatorAvg {
		double sum;
		int count;
	}

	public static void main(String[] args) {
		Stream<Double> stream = Stream.generate(() ->  Math.random()).limit(1000000);
		AccumulatorAvg accFinal = stream.reduce(new AccumulatorAvg(), 
				(AccumulatorAvg acc, Double v) -> { acc.sum += v; acc.count++; return acc;},
				(AccumulatorAvg acc1,AccumulatorAvg acc2) -> { acc1.sum += acc2.sum; 
				acc1.count += acc2.count;
				return acc1;});
		System.out.println(accFinal.sum/accFinal.count);
		
		DoubleSummaryStatistics result = Stream.generate(() ->  Math.random()).limit(1000000)
				.collect(Collectors.summarizingDouble((d)-> d*10));
		System.out.println(result);
	}
}
