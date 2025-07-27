function solution(s) {
    var answer = s.length;
    const len = s.length;
    
    for (let idx = 1; idx <= Math.floor(len / 2); idx++){
        let compressed = "";
        let cnt = 1;
        let prev = s.substring(0, idx); 
        
        for (let i = idx; i < len; i += idx){
            let curr = s.substring(i, i + idx);
            if (prev == curr) cnt++;
            else {
                compressed += (cnt > 1 ? cnt : "") + prev;
                prev = curr;
                cnt = 1;
            }
        }
        
        compressed += (cnt > 1 ? cnt : "") + prev;
        
        answer = Math.min(answer, compressed.length)
    }

    return answer;
}