package com.sbt.collections_api.examples;

import com.sbt.collections_api.Person;
import com.sbt.collections_api.PersonFirstLoad;
import com.sbt.collections_api.Segment;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Example4_PriorityQueue {
	public static void main(String[] args) {
		Queue<Person> persons = new PriorityQueue<>();
		System.out.println("-1.--------------------------------");
		// инициализируйте вызовом PersonFirstLoad.init()
		// выведите содержимое вызовом PersonFirstLoad.print()
		// проанализируйте порядок элементов
		PersonFirstLoad.init(persons);
		PersonFirstLoad.print(persons);

		System.out.println("-3.--------------------------------");
		// сформируйте новый объект PriorityQueue, с использованием внешнего Comparator,
		// который будет отдавать приоритет при извлечении клиентам из сегмента Segment.VIP
		// инициализируйте вызовом PersonFirstLoad.init(persons)
		// последовательно извлеките все элементы из PriorityQueue и проанализируйте порядок извлечения
		Queue<Person> personsQueue = new PriorityQueue<>((o1, o2) -> {
			if (o1.getSegment() == (o2.getSegment())) return 0;
			return o1.getSegment() == (Segment.MASS) ? 1 : -1;
		});

		PersonFirstLoad.init(personsQueue);
		while (!personsQueue.isEmpty()) {
			System.out.println(personsQueue.poll());
		}

		System.out.println("-4.--------------------------------");
		// инициализируйте вызовом PersonFirstLoad.init()
		// попробуйте извлечь 20 элементов
		// проанализируйте результат
		PersonFirstLoad.init(persons);
		for (int i = 0; i < 20; i++) {
			persons.poll();
		}
	}

}
