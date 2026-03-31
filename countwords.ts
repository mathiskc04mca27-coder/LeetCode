function wordCount(startWords: string[], targetWords: string[]): number {
    const startMasks = new Set<number>();

    for (let i = 0; i < startWords.length; i++) {
        let mask = 0;
        const word = startWords[i];
        for (let j = 0; j < word.length; j++) {
            mask |= (1 << (word.charCodeAt(j) - 97));
        }
        startMasks.add(mask);
    }

    let result = 0;

   
    for (let i = 0; i < targetWords.length; i++) {
        const word = targetWords[i];
        let targetMask = 0;
        
        
        for (let j = 0; j < word.length; j++) {
            targetMask |= (1 << (word.charCodeAt(j) - 97));
        }

        let isPossible = false;
        
        
        for (let j = 0; j < word.length; j++) {
            const charBit = 1 << (word.charCodeAt(j) - 97);
            const reducedMask = targetMask ^ charBit; 

            if (startMasks.has(reducedMask)) {
                isPossible = true;
                break;
            }
        }

        if (isPossible) {
            result++;
        }
    }

    return result;
}
