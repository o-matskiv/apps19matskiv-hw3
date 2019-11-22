package ua.edu.ucu.smartarr;
import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {
    private Object[] myArr;
    public BaseArray(Object[] arr) {
        this.myArr = arr;
    }

    public Object[] toArray(){

        return Arrays.copyOf(this.myArr, this.myArr.length);
    }

    public String operationDescription(){
        return "Descrition";
    }
    public int size(){
        return this.myArr.length;
    }

}
