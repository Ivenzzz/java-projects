public class RandomNumberCounter {
    public static void main(String[] args) {
        int[] counters = {0, 0, 0, 0, 0, 0};
        int randomSize = 1000;
        for(int i = 0; i < randomSize; i++) {
            int randomNumber = (int) Math.floor(Math.random() * 6);
            for(int j = 0; j < counters.length; j++) {
                if(randomNumber == j-1) {
                    counters[j-1]++;
                }
            }
            
        }

        System.out.println("Total Generated Outcomes: " + randomSize);
        for(int i = 0; i < counters.length; i++) {
            System.out.println("Number " + (i+1) + " = " + counters[i] + " outcomes");
        }
    }
}
