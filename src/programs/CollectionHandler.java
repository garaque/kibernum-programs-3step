package programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionHandler {

	public static void main(String arg[]) {

		String entryCollection[] = { "xy", "xy", "xyz" };
		String queryCollection[] = { "xy", "ab", "xyz" };

		if (!collectionRestrictionValidation(entryCollection)) {
			System.out.println(
					"It does not satisfy the restriction: The size of the input string collection must be greater than zero.");

		} else if (!collectionRestrictionValidation(queryCollection)) {
			System.out.println(
					"It does not satisfy the restriction: The size of the query string collection must be greater than zero..");
		} else {
			List<Integer> collectionOutput = countQueryCollectionInEntryCollection(entryCollection, queryCollection);

			if (!answerRestrictionValidation(collectionOutput)) {

				System.out.println(
						"It does not satisfy the restriction: Response collection size must be greater than zero.");

			} else {

				System.out.println(collectionOutput);

			}
		}

	}

	public static boolean collectionRestrictionValidation(String collection[]) {
		boolean answer = false;
		if (collection != null && collection.length > 0) {
			answer = true;
		}

		return answer;
	}

	public static boolean answerRestrictionValidation(List<Integer> collectionOutput) {
		boolean answer = false;

		if (collectionOutput != null && collectionOutput.size() > 0) {
			answer = true;
		}

		return answer;
	}

	public static List<Integer> countQueryCollectionInEntryCollection(String entryCollection[], String queryCollection[]) {

		List<Integer> result = new ArrayList<Integer>();

		Map<String, Integer> count = new HashMap<>();

		for (String value : entryCollection) {

			count.merge(value, 1, Integer::sum);
		}

		for (String value : queryCollection) {

			result.add(count.get(value) != null ? count.get(value) : 0);
		}

		return result;
	}

}
