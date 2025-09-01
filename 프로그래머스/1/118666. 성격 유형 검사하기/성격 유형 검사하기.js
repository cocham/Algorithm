function solution(survey, choices) {
    let ctgry = {'RT' : 0, 'CF' : 0, 'JM' : 0, 'AN' : 0};
    const score = {1 : -3, 2 : -2, 3 : -1, 4 : 0, 5 : 1, 6 : 2, 7 : 3};
    
    for (let i = 0; i < survey.length; i++){
        let key = survey[i];
        const scr = choices[i];
        if (ctgry[key] === undefined){
            newkey = [...key].reverse().join('');
            ctgry[newkey] -= score[scr];
        }
        else {
            ctgry[key] += score[scr];
        }
    }
    
    const answer = Object.entries(ctgry).reduce((acc, [k,v]) => {
        return acc + (v <= 0 ? k[0] : k[1])
    }, "");

    return answer;
}