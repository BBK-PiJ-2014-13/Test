package one;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo {
	public static void main(String[] args) {
		// Create a list of integer values
		ArrayList<Integer> myList = new ArrayList<>();
		myList.add(7);
		myList.add(18);
		myList.add(10);
		myList.add(24);
		myList.add(17);
		myList.add(5);

		System.out.println("Original list: " + myList);

		// Obtain a Stream to the array list.
		Stream<Integer> myStream = myList.stream();

		// Obtain the minimum and maximum value by uses of min(),
		// max(), isPresent(), and get().
		Optional<Integer> minVal = myStream.min(Integer::compare);
		if (minVal.isPresent()) {
			System.out.println("Minimum value: " + minVal.get());
		}

		// Must obtain a new stream because previous call to min()
		// is a terminal operation that consumed the stream.
		myStream = myList.stream();
		myStream = myList.stream();
		Optional<Integer> maxVal = myStream.max(Integer::compare);
		if (maxVal.isPresent()) {
			System.out.println("Maximum value: " + maxVal.get());
		}
		
		// Sort the stream by use of sorted().
		Stream<Integer> sortedStream = myList.stream().sorted();
		
		// Display the sorted stream by use of forEach().
		System.out.print("Sorted stream: ");
		sortedStream.forEach((n) -> System.out.print(n + " "));
		System.out.println();

	}
}
