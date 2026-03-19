import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ClumsyFactorial {

    public static int clumsy(int n) throws ScriptException {

        int temp = 0;
        int x = n;
        int ans = 0;
        StringBuilder sb = new StringBuilder();

        while(x > 0) {
            sb.append(x--);
            if(x == 0) break;
            if(temp % 4 ==0) {
                sb.append("*");
            }else if(temp % 4 == 1) {
                sb.append("/");
            }else if(temp % 4 == 2) {
                sb.append("+");
            }else {
                sb.append("-");
            }

            temp ++;
        }

        System.out.println(sb);

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
        Object result = engine.eval(sb.toString());

        return (Integer)result;
    }

    public static void main(String[] args) throws ScriptException {
        System.out.println(clumsy(10));
    }
}
