import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict); // For O(1) average time complexity lookups
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // Base case: an empty string can be segmented

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // If dp[i] is true, no need to check further for this i
                }
            }
        }
        return dp[s.length()];
    }
}