import java.util.Arrays;

class Solution {

    public int[] solution(String[] keymap, String[] targets) {
        int[] pushCounts = new int[26];
        Arrays.fill(pushCounts, Integer.MAX_VALUE);

        for (String km : keymap) {
            for (int i = 0; i < km.length(); i++) {
                if (i + 1 < pushCounts[km.charAt(i) - 'A']) {
                    pushCounts[km.charAt(i) - 'A'] = i + 1;
                }
            }
        }

        int[] totalCounts = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            for (char ch : targets[i].toCharArray()) {
                if (pushCounts[ch - 'A'] == Integer.MAX_VALUE) {
                    totalCounts[i] = -1;
                    break;
                }

                totalCounts[i] += pushCounts[ch - 'A'];
            }
        }

        return totalCounts;
    }
}
