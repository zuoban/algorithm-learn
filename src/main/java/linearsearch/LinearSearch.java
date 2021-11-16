package linearsearch;

import java.util.Objects;

public class LinearSearch {
    private LinearSearch() {
    }

    public static void main(String[] args) {
        Integer[] data = {24, 18, 12, 9, 16, 66, 32, 4};
        int res = search(data, 16);
        System.out.println("res = " + res);

        int res2 = search(data, 666);
        System.out.println("res2 = " + res2);


        Student[] students = {new Student("Alice"), new Student("Bob"), new Student("Charles")};
        int res3 = search(students, new Student("Bob"));
        System.out.println("res3 = " + res3);
    }

    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (Objects.equals(data[i], target)) {
                return i;
            }
        }
        return -1;
    }
}
