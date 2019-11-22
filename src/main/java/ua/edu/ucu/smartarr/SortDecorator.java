package ua.edu.ucu.smartarr;
import ua.edu.ucu.functions.MyComparator;
import java.util.Arrays;


// Sorts elements using MyComparator to compare them
public class SortDecorator extends  SmartArrayDecorator{
    MyComparator myComp;
    Object[] myArr;

    public SortDecorator(SmartArray smart_arr, MyComparator comp) {
        super(smart_arr);
        this.myComp = comp;
        this.myArr = Arrays.stream(smart_arr.toArray()).sorted(comp).toArray();
    }

    @Override
    public Object[] toArray() {
        return this.myArr;
    }

    @Override
    public String operationDescription() {
        return "Sorts elements using MyComparator to compare them";
    }

    @Override
    public int size() {
        return super.smartArray.size();
    }
}
