package ua.edu.ucu.smartarr;
import ua.edu.ucu.functions.MyFunction;
import java.util.Arrays;


// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator{

    private MyFunction myfunc;
    private Object[] myArr;


    public MapDecorator(SmartArray smart_arr, MyFunction func){
        super(smart_arr);
        this.myfunc = func;
        this.myArr = Arrays.stream(smart_arr.toArray()).map(func :: apply).toArray();
    }
    @Override
    public Object[] toArray() {
        return this.myArr;
    }

    @Override
    public String operationDescription() {
        return "Map every element to another object using MyFunction";
    }

    @Override
    public int size() {
        return this.myArr.length;
    }
}
