function solution(s){
    let stack = [];
    
    for (let i = 0; i < s.length; i++){
        stack.push(s[i]);
        if (s[i] === ')') {
            if (stack[stack.length - 2] === '('){
                stack.pop();
                stack.pop();
            }
        }
    }
    
    if (stack.length !== 0) return false;
    return true;
}
