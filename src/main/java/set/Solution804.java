package set;

import java.util.HashSet;

/**
 * 804. 唯一摩尔斯密码词
 */
public class Solution804 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<String>();

        for (String word : words) {
            StringBuilder mCode = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                mCode.append(codes[word.charAt(i) - 'a']);
            }
            set.add(mCode.toString());
        }
        return set.size();
    }
}
