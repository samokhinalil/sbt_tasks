package com.sbt.collections_api.examples;

import com.sbt.collections_api.Person;
import com.sbt.collections_api.PersonFirstLoad;
import com.sbt.collections_api.Segment;

import java.util.LinkedList;

public class Example3_LinkedList {
	public static void main(String[] args) {
		LinkedList<Person> persons = new LinkedList<>();
		System.out.println("-1.-------------------------------");
		// инициализируйте вызовом PersonFirstLoad.init()
		// выведите содержимое вызовом PersonFirstLoad.print()
		// проанализируйте порядок элементов
		PersonFirstLoad.init(persons);
		PersonFirstLoad.print(persons);

		System.out.println("-2.-------------------------------");
		// выведите элемент LinkedList с индексом 5
		System.out.println(persons.get(5));

		System.out.println("-3.-------------------------------");
		// проверьте наличие в LinkedList клиента new Person(10L, "Бирюков Виктор Валерьевич", "79185551234", Segment.MASS)
		System.out.println(persons.contains(new Person(10L, "Бирюков Виктор Валерьевич", "79185551234", Segment.MASS)));

		System.out.println("-4.-------------------------------");
		// выведите 4 элемента LinkedList с извлечением
		// выведите содержимое LinkedList вызовом PersonFirstLoad.print()
		// проанализируйте состав элементов
		for (int i = 0; i < 4; i++) {
			System.out.println(persons.removeLast());
		}

		System.out.println("-5.-------------------------------");
		// Добавьте в LinkedList клиента new Person(30L, "Шишкин Кирилл Иванович", "79185551332", Segment.MASS)
		// выведите последний элемент LinkedList без извлечения
		// выведите содержимое LinkedList вызовом PersonFirstLoad.print()
		// проанализируйте состав элементов
		persons.add(new Person(30L, "Шишкин Кирилл Иванович", "79185551332", Segment.MASS));
		System.out.println(persons.peekLast());
		PersonFirstLoad.print(persons);

		System.out.println("-6.-------------------------------");
		// выведите содержимое LinkedList, используя метод forEach
		persons.forEach(p -> System.out.println(p));

		System.out.println("-7.-------------------------------");
		// Выведите последний элемент LinkedList с извлечением
		System.out.println(persons.removeLast());

		System.out.println("-8.-------------------------------");
		// Выведите первый элемент LinkedList с извлечением
		System.out.println(persons.removeFirst());
	}
}
