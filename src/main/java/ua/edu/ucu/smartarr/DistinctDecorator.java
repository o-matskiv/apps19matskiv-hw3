package ua.edu.ucu.smartarr;
import java.util.ArrayList;
import java.util.Arrays;
// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    private Object[] myArr;
    public DistinctDecorator(SmartArray smart_arr) {
        super(smart_arr);
        ArrayList<Object> arr = new ArrayList<>();
        ArrayList<Object> smatrArr = new ArrayList<>(Arrays.asList(smart_arr.toArray()));
        for (int i = 0; i < smatrArr.size(); i++) {
            for (int j = i + 1; j < smatrArr.size(); j++) {
                if ((!(arr.contains(smatrArr.get(i)))) && !(smatrArr.get(j).equals(smatrArr.get(i))) ) {
                    arr.add(smatrArr.get(i));
                }
            }
        }
        this.myArr = arr.toArray();


    }
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.myArr, this.myArr.length);

    }

    @Override
    public String operationDescription() {
        return "Remove duplicates from SmartArray";
    }

    @Override
    public int size() {
        return this.myArr.length;
    }
}
