def solution(myString):
    answer = []
    
    cnt = 0

    for i in range(len(myString)):
        if (myString[i] != "x"):
            cnt += 1
        else:
            answer.append(cnt)
            cnt = 0
            
    answer.append(cnt)
    return answer