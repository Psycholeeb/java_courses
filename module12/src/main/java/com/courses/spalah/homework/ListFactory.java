package com.courses.spalah.homework;

public class ListFactory {
    public static <E> MyList<E> createList(ListType listType) {
        if (listType == ListType.SINGLY_LINKED_LIST) {
            // возвращаем вашу имплементацию односвязного списка
            return new MyListElements<>();
        }
        return null;
    }
}
