import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int n = cards.length;
        
        int target = n + 1;
        List<Integer> cardStack = new ArrayList<>();
        List<Integer> hand = new ArrayList<>();
        for (int i = 0; i < n / 3; ++i) hand.add(cards[i]);
        
        int cursor = n / 3; 
        int ans = 1;
        while (true) {
            if (cursor < n) cardStack.add(cards[cursor++]);
            if (cursor < n) cardStack.add(cards[cursor++]);

            boolean isSearched = search(hand, target);
            if (isSearched) {
                ++ans;
                continue;
            }
            
            isSearched = false;
            if (coin > 0) {
                for (int i = 0; i < hand.size(); i++) {
                    int find = target - hand.get(i);
                    if (cardStack.contains(find)) {
                        cardStack.remove(Integer.valueOf(find));
                        coin--;
                        isSearched = true;
                        break;
                    }
                }
            }  
            if (isSearched) {
                ++ans;
                continue;
            }

            if (coin >= 2) {
                isSearched = search(cardStack, target);
                if (isSearched) {
                    coin -= 2;
                    ++ans;
                    continue;
                }
            }

            break;
        }

        return Math.min(ans, n / 3 + 1);
    }

    boolean search(List<Integer> list, int target) {
        for (int i = 0; i < list.size(); ++i) {
            for (int j = i + 1; j < list.size(); ++j) {
                if (list.get(i) + list.get(j) == target) {
                    list.remove(j);
                    list.remove(i);
                    return true;
                }
            }
        }
        return false;
    }
}

