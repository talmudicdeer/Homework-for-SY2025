//Alexis Baker//
//Running time complexity of O(n)//

public class levenshteinChecker {

    public static boolean isOneEditAway(String s1, String s2) {
        String[] words = s1.trim().split("\\s+");
        String[] words2 = s2.trim().split("\\s+");

        String word1 = words[0];
        String word2 = words2[0];

        if (Math.abs(word1.length() - word2.length()) > 1) {
            return false;
        }

        if (word1.length() == word2.length()) {
            return oneReplacementAway(word1, word2);
        }

        if (word1.length() + 1 == word2.length()) {
            return oneInsertionAway(word1, word2);
        } else if (word1.length() == word2.length() + 1) {
            return oneInsertionAway(word2, word1);
        }

        return false;
    }

    private static boolean oneReplacementAway(String s1, String s2) {
        int differences = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                differences++;
                if (differences > 1) {
                    return false;
                }
            }
        }
        return differences == 1;
    }

    private static boolean oneInsertionAway(String shorter, String longer) {
        int i = 0, j = 0;
        while (i < shorter.length() && j < longer.length()) {
            if (shorter.charAt(i) != longer.charAt(j)) {
                j++;

                if (j - i > 1) {
                    return false;
                }

            } else {
                i++;
                j++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isOneEditAway("pale", "pIe"));   // true
        System.out.println(isOneEditAway("pales", "pale")); // true
        System.out.println(isOneEditAway("pale", "bale"));  // true
        System.out.println(isOneEditAway("pale", "bake"));  // false
    }
}