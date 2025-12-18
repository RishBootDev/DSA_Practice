public class WateringPlants {

    public int wateringPlants(int[] plants, int capacity) {

        int fill=capacity;
        int distance=0;

        for(int i=0;i<plants.length;i++){

            if(plants[i]>capacity){
                capacity=fill-plants[i];
                distance+=(2*(i))+1;
            }else {
                capacity-=plants[i];
                distance++;
            }
        }

        return distance;
    }
}
