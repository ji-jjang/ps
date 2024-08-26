class Solution {
	public String solution(int[] numbers, String hand) {
		int[][] keypad = {
			{3, 1},
			{0, 0},
			{0, 1},
			{0, 2},
			{1, 0},
			{1, 1},
			{1, 2},
			{2, 0},
			{2, 1},
			{2, 2},
			{3, 0},
			{3, 2} 
		};
		int[] left = keypad[10];
		int[] right = keypad[11];

		StringBuilder sb = new StringBuilder();
        
		for (var num : numbers) {
			if (num == 1 || num == 4 || num == 7) {
				sb.append("L");
				left = keypad[num];
			} else if (num == 3 || num == 6 || num == 9) {
				sb.append("R");
				right = keypad[num];
			} else {
				int ld = Math.abs(left[0] - keypad[num][0]) + Math.abs(left[1] - keypad[num][1]);
				int rd = Math.abs(right[0] - keypad[num][0]) + Math.abs(right[1] - keypad[num][1]);

				if (ld < rd) {
					sb.append("L");
					left = keypad[num];
				} else if (rd < ld) {
					sb.append("R");
					right = keypad[num];
				} else {
					if (hand.equals("left")) {
						sb.append("L");
						left = keypad[num];
					} else {
						sb.append("R");
						right = keypad[num];
					}
				}
			}
		}

		return sb.toString();
	}
}