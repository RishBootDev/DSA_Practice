import java.util.HashMap;
import java.util.Map;

class FrequencyTracker {

    Map<Integer, Integer> numberFreq;
    Map<Integer, Integer> freqCount;

    public FrequencyTracker() {
        numberFreq = new HashMap<>();
        freqCount = new HashMap<>();
    }

    public void add(int number) {
        int oldFreq = numberFreq.getOrDefault(number, 0);
        int newFreq = oldFreq + 1;

        if (oldFreq > 0) {
            freqCount.put(oldFreq, freqCount.get(oldFreq) - 1);
        }

        numberFreq.put(number, newFreq);
        freqCount.put(newFreq, freqCount.getOrDefault(newFreq, 0) + 1);
    }

    public void deleteOne(int number) {
        if (!numberFreq.containsKey(number)) return;

        int oldFreq = numberFreq.get(number);
        int newFreq = oldFreq - 1;

        freqCount.put(oldFreq, freqCount.get(oldFreq) - 1);

        if (newFreq == 0) {
            numberFreq.remove(number);
        } else {
            numberFreq.put(number, newFreq);
            freqCount.put(newFreq, freqCount.getOrDefault(newFreq, 0) + 1);
        }
    }

    public boolean hasFrequency(int frequency) {
        return freqCount.getOrDefault(frequency, 0) > 0;
    }
}