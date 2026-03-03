class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if (strs.empty()) return "";
        
        // Sort the strings
        sort(strs.begin(), strs.end());
        
        string first = strs[0];
        string last = strs[strs.size() - 1];
        int i = 0;
        
        // Compare the first and last string only
        while (i < first.length() && i < last.length() && first[i] == last[i]) {
            i++;
        }
        
        return first.substr(0, i);
    }
};
