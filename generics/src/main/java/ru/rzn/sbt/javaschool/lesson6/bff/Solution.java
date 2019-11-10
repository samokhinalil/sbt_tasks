package ru.rzn.sbt.javaschool.lesson6.bff;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Solution {

	/**
	 * 1. Создайте обобщённый класс TwoItems, параметризовынный типом <T> и хранящий две ссылки на объекты типа T.
	 * Введите конструктор, принимающий два аргумента и get-методы.
	 * <p>
	 * 2. В {@link Collection} persons найдите персоны, у которых взаимно совпадают ссылки на лучших друзей
	 * {@link Person#bestFriend}, сформируйте из них экземпляры класса TwoItems<Person> и разместите
	 * в {@link Collection}<TwoItems>.
	 * <p>
	 * 3. В качестве результата выполнения метода {@link Solution#findBestFriends(Collection)} верните размер коллекции
	 * с парами лучших друзей.
	 */
	public static int findBestFriends(Collection<Person> persons) {
		Collection<TwoItems<Person>> friends = new ArrayList<>();

		for (Person p1 : persons) {
			Person p2 = p1.getBestFriend();
			if (p2 != null) {
				TwoItems<Person> friendsItem = new TwoItems<>(p1, p2);

				if (p1.equals(p2.getBestFriend()) && !contains(friends, friendsItem)) {
					friends.add(friendsItem);
				}
			}
		}

		return friends.size();
	}

	private static <T> boolean contains(Collection<TwoItems<T>> items, TwoItems<T> item1) {
		for (TwoItems<T> item : items) {
			if (item.getItem1().equals(item1.getItem1()) && item.getItem2().equals(item1.getItem2()) ||
					item.getItem1().equals(item1.getItem2()) && item.getItem2().equals(item1.getItem1())) {
				return true;
			}
		}
		return false;
	}
}
