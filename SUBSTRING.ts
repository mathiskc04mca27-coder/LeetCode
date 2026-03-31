function lengthOfLongestSubstring(s: string): number {
    let maxLength = 0;
    let left = 0;
    
    const charMap = new Map<string, number>();

    for (let right = 0; right < s.length; right++) {
        const currentChar = s[right];

        if (charMap.has(currentChar) && charMap.get(currentChar)! >= left) {
           
            left = charMap.get(currentChar)! + 1;
        }

     
        charMap.set(currentChar, right);

        
        const currentWindowLength = right - left + 1;
        maxLength = Math.max(maxLength, currentWindowLength);
    }

    return maxLength;
}


console.log(lengthOfLongestSubstring("abcabcbb")); 
console.log(lengthOfLongestSubstring("bbbbb"));    
console.log(lengthOfLongestSubstring("pwwkew"));   
