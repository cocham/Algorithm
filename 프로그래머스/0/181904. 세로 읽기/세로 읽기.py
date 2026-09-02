def solution(my_string, m, c):
    answer = ''
    j = c - 1
    arr = []
    for i in range(0, len(my_string), m):
        arr.append(my_string[i : i + m])
    
    for str in arr:
        answer += str[j]
    return answer