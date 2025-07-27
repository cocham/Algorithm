function solution(rows, columns, queries) {
    const arr = [];
    const answer = [];

    var n = 1;
    for (let i = 0; i < rows; i++){
        const part = []
        for (let j = 0; j < columns; j++){
            part.push(n);
            n++;
        }
        arr.push(part);
    }
    

     for (const [x1, y1, x2, y2] of queries) {
        const i1 = x1 - 1, j1 = y1 - 1;
        const i2 = x2 - 1, j2 = y2 - 1;

        const coords = [];
        for (let j = j1; j <= j2; j++) coords.push([i1, j]);      // 상
        for (let i = i1 + 1; i <= i2; i++) coords.push([i, j2]);  // 우
        for (let j = j2 - 1; j >= j1; j--) coords.push([i2, j]);  // 하
        for (let i = i2 - 1; i > i1; i--) coords.push([i, j1]);   // 좌
    
        const values = coords.map(([i,j]) => arr[i][j]);
        values.unshift(values.pop());
        answer.push(Math.min(...values));
        
        let idx = 0;
        for (const [i,j] of coords){
            arr[i][j] = values[idx];
            idx ++;
        }  
    }
    return answer;
}