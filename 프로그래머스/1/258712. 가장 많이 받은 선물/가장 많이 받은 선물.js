function solution(friends, gifts) {
    const n = friends.length;
    var fobj = {};
    friends.forEach((f, idx) => fobj[f] = idx);
    var giftcnt = Array.from(Array(n), () => Array(n).fill(0)); //i가 j에게 준선물수
    var giftPoints = Array(n).fill(0); //선물지수
    var points = Array(n).fill(0); //다음달받을선물
    
    for (const g of gifts){
        const giver = g.split(" ")[0], recver = g.split(" ")[1];
        const i = fobj[giver], j = fobj[recver];
        giftcnt[i][j] += 1;
        giftPoints[i] += 1;
        giftPoints[j] -= 1;
    }
    
    for (let i = 0; i < n; i++){
        for (let j = i + 1; j < n; j++){
            if (giftcnt[i][j] > giftcnt[j][i]) points[i]++; //i가 선물을 더 많이 줬는가
            else if (giftcnt[j][i] > giftcnt[i][j]) points[j]++; //j가 선물을 더 많이 줬는가
            else if (giftPoints[i] > giftPoints[j]) points[i]++; //i가 선물지수가 큰가
            else if (giftPoints[j] > giftPoints[i]) points[j]++; //j가 선물지수가 큰가   
        }
    }
    
    return Math.max(...points);
    
}