
package ua.edu.ucu;

import java.util.Arrays;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;




public class SmartArrayApp {

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {
                MyPredicate predict = new MyPredicate() {
                    @Override
                    public boolean test(Object st) {
                        return  (((Student) st).getYear() == 2)&&(((Student) st).getGPA() >= 4.0 );
                    }
                };
                MyComparator comparator = new MyComparator() {
                    @Override
                    public int compare(Object st1, Object st2) {
                        return ((Student) st1).getSurname().compareTo(((Student) st2).getSurname());
                    }
                };
                MyFunction func = new MyFunction() {
                    @Override
                    public Object apply(Object student) {
                        return ((Student) student).getSurname() + " " + ((Student) student).getName();
            }
        };


        SmartArray studentArr = new BaseArray(students);
        studentArr = new DistinctDecorator(studentArr);
        studentArr = new FilterDecorator(studentArr, predict);
        studentArr = new SortDecorator(studentArr, comparator);
        studentArr = new MapDecorator(studentArr, func);

        String[] result = Arrays.copyOf(studentArr.toArray(), studentArr.toArray().length, String[].class);
        return result;
    }
}
