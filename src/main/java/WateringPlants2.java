
public class WateringPlants2 {

    public int minimumRefill(int[] plants, int capacityA, int capacityB) {

        if(plants.length%2==0){
            int mid=plants.length/2;

            int count=0;
            int temp=capacityA;
            for (int i = 0; i < mid; i++) {

                if(plants[i]>capacityA){
                    count++;
                    capacityA=temp-plants[i];
                }else{
                    capacityA-=plants[i];
                }
            }
            int bemp=capacityB;

            for (int i = plants.length-1; i >=mid ; i--) {
                if(plants[i]>capacityB){
                    count++;
                    capacityB=bemp-plants[i];
                }else{
                    capacityB-=plants[i];
                }
            }

            return count;
        }else{
            int mid=plants.length/2;

            int count=0;
            int temp=capacityA;
            for (int i = 0; i < mid; i++) {

                if(plants[i]>capacityA){
                    count++;
                    capacityA=temp-plants[i];
                }else{
                    capacityA-=plants[i];
                }
            }
            int bemp=capacityB;

            for (int i = plants.length-1; i >mid ; i--) {
                if(plants[i]>capacityB){
                    count++;
                    capacityB=bemp-plants[i];
                }else{
                    capacityB-=plants[i];
                }
            }

            if(capacityA==capacityB){
                if(capacityA<plants[mid]) count++;
            }else{
                int maxCapacity=Math.max(capacityA,capacityB);
                if(maxCapacity<plants[mid]) count++;
            }

            return count;

        }
    }
}
