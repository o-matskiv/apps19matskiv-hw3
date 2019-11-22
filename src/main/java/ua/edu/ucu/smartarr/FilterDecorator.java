package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;
import java.util.Arrays;


// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate predict;
     Object[] myArr;

    public FilterDecorator(SmartArray smart_arr, MyPredicate pred) {
        super(smart_arr);
        this.predict = pred;
        this.myArr = Arrays.stream(smart_arr.toArray()).filter(predict :: test).toArray();
    }
    @Override
    public Object[] toArray() {
        return this.myArr;
    }

    @Override
    public String operationDescription() {
        return "Tests every element and filters";
    }

    @Override
    public int size() {
        return this.myArr.length;
    }
}
