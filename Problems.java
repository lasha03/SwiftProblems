import java.util.*;

public class Problems {

    public int singleNumber(int[] nums){
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int k : nums) {
            if (numCount.containsKey(k)) {
                numCount.put(k, numCount.get(k) + 1);
            } else {
                numCount.put(k, 1);
            }
        }

        for(int key : numCount.keySet()){
            if(numCount.get(key) == 1) return key;
        }

        return 0;
    }

    public int minSplit(int amount){
        int[] dp = new int[amount + 1];
        int[] coins = {1, 5, 10, 20, 50};
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for(int curAmount = 1; curAmount <= amount; curAmount++){
            for(int coin : coins){
                if(coin <= curAmount){
                    dp[curAmount] = Math.min(dp[curAmount], dp[curAmount - coin] + 1);
                }
            }
        }

        return dp[amount];
    }

    public int notContains(int[] array){
        int result = 1;
        Arrays.sort(array);
        for(int num : array){
            if(num == result){
                result = num + 1;
            }
        }

        return result;
    }

    public String sumBinary(String num1, String num2){
        StringBuilder result = new StringBuilder();
        int num1Index = num1.length() - 1;
        int num2Index = num2.length() - 1;
        int carry = 0;

        while(num1Index >= 0 || num2Index >= 0){
            int sum = carry;
            if(num1Index >= 0) sum += num1.charAt(num1Index--) - '0';
            if(num2Index >= 0) sum += num2.charAt(num2Index--) - '0';
            carry = sum / 2;
            result.append(sum % 2);

        }

        if(carry != 0) result.append('1');

        return result.reverse().toString();
    }


    public int countVariants(int stairsCount){
        int[] dp = new int[stairsCount];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < stairsCount; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[stairsCount - 1];
    }



    private class MyStruct <T> {
        private final HashMap<T, Integer> data;

        public MyStruct(){
            data = new HashMap<>();
        }

        public void add(T elem){
            if(data.containsKey(elem)){
                data.put(elem, data.get(elem) + 1);
            } else {
                data.put(elem, 1);
            }
        }

        public void delete(T elem){
            if(data.containsKey(elem) && data.get(elem) > 1){
                data.put(elem, data.get(elem) - 1);
            } else {
                throw new RuntimeException("invalid argument");
            }
        }
    }

}
