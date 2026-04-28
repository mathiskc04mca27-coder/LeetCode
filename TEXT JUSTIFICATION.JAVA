import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            
            // Determine how many words fit in this line
            while (last < words.length) {
                if (words[last].length() + count + 1 > maxWidth) break;
                count += words[last].length() + 1;
                last++;
            }

            StringBuilder builder = new StringBuilder();
            int diff = last - index - 1; // Number of gaps between words

            // Case 1: Last line or a line with only one word (Left Justified)
            if (last == words.length || diff == 0) {
                for (int i = index; i < last; i++) {
                    builder.append(words[i]);
                    if (i < last - 1) builder.append(" ");
                }
                while (builder.length() < maxWidth) {
                    builder.append(" ");
                }
            } 
            // Case 2: Middle lines with multiple words (Fully Justified)
            else {
                int spaces = (maxWidth - (count - diff));
                int r = spaces % diff; // Extra spaces to distribute on the left
                int q = spaces / diff; // Base number of spaces per gap

                for (int i = index; i < last; i++) {
                    builder.append(words[i]);
                    if (i < last - 1) {
                        int currentSpaces = q + (i - index < r ? 1 : 0);
                        for (int s = 0; s < currentSpaces; s++) {
                            builder.append(" ");
                        }
                    }
                }
            }

            result.add(builder.toString());
            index = last;
        }

        return result;
    }
}
