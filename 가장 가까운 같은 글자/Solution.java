import java.util.Arrays;

class Solution {

    public int[] solution(String s) {
        int[] previousIndices = new int[26];
        Arrays.fill(previousIndices, -1);

        int[] dists = new int[s.length()];
        Arrays.fill(dists, -1);
        for (int i = 0; i < s.length(); i++) {
            if (previousIndices[s.charAt(i) - 'a'] != -1) {
                dists[i] = i - previousIndices[s.charAt(i) - 'a'];
            }

            previousIndices[s.charAt(i) - 'a'] = i;
        }

        return dists;
    }
}
