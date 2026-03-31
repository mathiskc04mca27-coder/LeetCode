function nextGreatestLetter(letters: string[], target: string): string {
    let low = 0;
    let high = letters.length - 1;

    while (low <= high) {
        const mid = Math.floor(low + (high - low) / 2);

        if (letters[mid] <= target) {
            
            low = mid + 1;
        } else {
      
            high = mid - 1;
        }
    }

    
    return letters[low % letters.length];
}
