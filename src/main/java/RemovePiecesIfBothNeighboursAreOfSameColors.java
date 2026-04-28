public class RemovePiecesIfBothNeighboursAreOfSameColors {

    public boolean winnerOfGame(String colors) {

        int step1 = 0;
        int step2 = 0;

        for (int i = 1; i < colors.length() - 1; i++) {
            if(colors.charAt(i) == colors.charAt(i-1) && colors.charAt(i+1) == colors.charAt(i) && colors.charAt(i) == 'A'){
                step1++;
            }
            else if(colors.charAt(i) == colors.charAt(i-1) && colors.charAt(i+1) == colors.charAt(i) && colors.charAt(i) == 'B'){
                step2++;
            }
        }

        return step1 > step2;
    }
}
