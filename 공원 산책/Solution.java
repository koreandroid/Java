class Solution {

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    public int[] solution(String[] park, String[] routes) {
        // Store the park dimensions for boundary checks.
        int h = park.length;
        int w = park[0].length();

        int[] loc = getStartLocation(park);
        for (String route : routes) {
            int i = mapToIndex(route.charAt(0));
            int n = route.charAt(2) - '0';

            int[] dest = {loc[0] + dr[i] * n, loc[1] + dc[i] * n};
            if (!(0 <= dest[0] && dest[0] <= h - 1
                 && 0 <= dest[1] && dest[1] <= w - 1)) {
                continue;
            }

            // Check each step because an obstacle may exist along the path.
            int[] exp = loc.clone();

            int j = 0;
            for (; j < n; j++) {
                exp[0] += dr[i];
                exp[1] += dc[i];
                if (park[exp[0]].charAt(exp[1]) == 'X') {
                    break;
                }
            }
            if (j < n) {
                continue;
            }

            loc[0] = dest[0];
            loc[1] = dest[1];
        }

        return loc;
    }

    private int[] getStartLocation(String[] park) {
        for (int i = 0; i < park.length; i++) {
            int j = park[i].indexOf('S');
            if (j != -1) {
                return new int[]{i, j};
            }
        }

        throw new IllegalArgumentException();
    }

    private int mapToIndex(char op) {
        if (op == 'N') {
            return 0;
        } else if (op == 'E') {
            return 1;
        } else if (op == 'S') {
            return 2;
        } else if (op == 'W') {
            return 3;
        }

        throw new IllegalArgumentException();
    }
}
