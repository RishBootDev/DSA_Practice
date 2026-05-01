public class CheckIfAllAAppearsBeforeB {

    public boolean checkString(String s) {

        int idx = s.indexOf('b');

        for (int i = idx; i < s.length(); i++) {
            if(s.charAt(i) == 'a') return false;
        }
        return true;
    }
}
