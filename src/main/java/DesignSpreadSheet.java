import java.util.HashMap;
import java.util.Map;

public class DesignSpreadSheet {
    private int rows;
    private Map<String, Integer> map;

    public DesignSpreadSheet(int rows) {
        this.rows = rows;
        this.map = new HashMap<>();
    }

    public void setCell(String cell, int value) {
        int rowNum = Integer.parseInt(cell.substring(1));
        if(rowNum > this.rows) return;
        map.put(cell, value);
    }

    public void resetCell(String cell) {
        map.remove(cell);
    }

    public int getValue(String formula) {

        int plusIndex = formula.indexOf('+');

        String x = formula.substring(1, plusIndex);
        String y = formula.substring(plusIndex + 1);

        int a, b;

        if(Character.isLetter(x.charAt(0))) a = map.getOrDefault(x, 0);
        else a = Integer.parseInt(x);

        if(Character.isLetter(y.charAt(0))) b = map.getOrDefault(y, 0);
        else b = Integer.parseInt(y);

        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("0126"));
    }
}
