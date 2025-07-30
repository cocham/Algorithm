function solution(s){
    const stack = [];
    s = s.split('')
    if (s[0] === ')') return false;

    stack.push(s[0])
    s = s.slice(1);
    
    for (const p of s){
        if (stack.at(-1) === p || stack.length === 0){
            stack.push(p);
        }
        if (stack.at(-1) !== p){
            if (stack.at(-1) === ')'){
                continue;
            }
            stack.pop();
        }
    }
    if (stack.length !== 0) return false;
    return true;
}
