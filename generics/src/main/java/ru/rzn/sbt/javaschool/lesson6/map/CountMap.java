package ru.rzn.sbt.javaschool.lesson6.map;

import java.util.Map;

/**
 * Контейнер со счётчиком ссылок
 */
public interface CountMap<T> {
    /**
     * Добавляет элемент в контейнер
     * @param o элемент
     */
    void add(T o);

    /**
     * Возвращает количество ссылок на элемент в контейнере
     * @param o элемент
     * @return количество ссылок на элемент в контейнере
     */
    int getCount(T o);

    /**
     * Удаляет ссылку на элемент контейнера и возвращает количество ссылок на элемент (до удаления)
     * @param o элемент
     * @return количество ссылок на элемент(до удаления)
     */
    int remove(T o);

    /**
     * Возвращает количество различных элементов
     * @return количество различных элементов
     */
    int size();

    /**
     * Добавить все элементы из source в текущий контейнер, при совпадении ключей суммировать значения
     * @param source контейнер
     */
    void addAll(CountMap<T> source);

    /**
     * Возвращает java.util.Map, где ключ - добавленный элемент, значение - количество его добавлений
     * @return java.util.Map, где ключ - добавленный элемент, значение - количество его добавлений
     */
    Map<T, Integer> toMap();

    /**
     * Тот же самый контракт как и toMap(), только всю информацию пришет в destination
     * @param destination контейнер
     */
    void toMap(Map<T, Integer> destination);
}
