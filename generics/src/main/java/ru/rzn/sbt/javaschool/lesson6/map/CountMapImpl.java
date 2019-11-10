package ru.rzn.sbt.javaschool.lesson6.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CountMapImpl<T> implements CountMap<T> {

	private Map<T, Integer> map;

	public CountMapImpl() {
		map = new HashMap<>();
	}

	@Override
	public void add(T o) {
		Objects.requireNonNull(o);
		Integer value = map.get(o);
		if (value != null) value++;
		else value = 1;
		map.put(o, value);
	}

	@Override
	public int getCount(T o) {
		Objects.requireNonNull(o);
		Integer value = map.get(o);
		if (value == null) return 0;
		else return value;
	}

	@Override
	public int remove(T o) {
		Objects.requireNonNull(o);
		Integer value = map.get(o);
		if (value == null) {
			return 0;
		} else {
			int newValue = --value;
			if (newValue == 0) map.remove(o);
			else map.put(o, newValue);
			return value;
		}
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public void addAll(CountMap<T> source) {
		for (T k : source.toMap().keySet()) {
			Integer mapValue = map.get(k);
			int sourceValue = source.getCount(k);
			if (map.containsKey(k)) {
				map.put(k, mapValue + sourceValue);
			} else {
				map.put(k, sourceValue);
			}
		}
	}

	@Override
	public Map<T, Integer> toMap() {
		return map;
	}

	@Override
	public void toMap(Map<T, Integer> destination) {
		Objects.requireNonNull(destination);
		map.entrySet().forEach(e -> destination.put(e.getKey(), e.getValue()));
	}
}
