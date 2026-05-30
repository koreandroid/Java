import java.util.Arrays;

class Solution {

    public int[] solution(String[] keymap, String[] targets) {
        int[] pushCount = new int[26];
        Arrays.fill(pushCount, Integer.MAX_VALUE);

        for (String km : keymap) {
            for (int i = 0; i < km.length(); i++) {
                if (i + 1 < pushCount[km.charAt(i) - 'A']) {
                    pushCount[km.charAt(i) - 'A'] = i + 1;
                }
            }
        }

        int[] totalCounts = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            for (char ch : targets[i].toCharArray()) {
                if (pushCount[ch - 'A'] == Integer.MAX_VALUE) {
                    totalCounts[i] = -1;
                    break;
                }

                totalCounts[i] += pushCount[ch - 'A'];
            }
        }

        return totalCounts;
    }
}
