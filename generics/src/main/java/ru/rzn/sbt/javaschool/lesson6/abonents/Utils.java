package ru.rzn.sbt.javaschool.lesson6.abonents;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;
import java.util.function.Predicate;

public class Utils {
	public static <T, R> Collection<R> transform(Collection<T> src, Function<T, R> function) {
		Collection<R> collection = new ArrayList<>();
		src.forEach(t -> collection.add(function.apply(t)));
		return collection;
	}

	public static <T> Collection<T> filter(Collection<T> src, Predicate<T> predicate) {
		Collection<T> result = new ArrayList<>();
		src.forEach(t -> {
			if (predicate.test(t)) result.add(t);
		});
		return result;
	}

	public static <T> int count(Collection<T> src, Predicate<T> predicate) {
		int count = 0;
		for (T t : src) {
			if (predicate.test(t)) count++;
		}
		return count;
	}

	public static <T> boolean contains(Collection<T> src, Predicate<T> predicate) {
		for (T t : src) {
			if (predicate.test(t)) {
				return true;
			}
		}
		return false;
	}
}
