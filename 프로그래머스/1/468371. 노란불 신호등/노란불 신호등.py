import math

def solution(signals):
    n = len(signals)
    
    cycles = [g + y + r for g, y, r in signals]
    lcm = math.lcm(*cycles) #언패킹 연산자
    
    arr = []
    for g,y,r in signals:
        arr.append([g, g + y, g + y + r]) #각 불의 종료시간

    for t in range(1, lcm + 1):
        flag = True
        
        for i in range(n): #각 신호등 순회
            if (t > arr[i][2]): #신호등 구간이 넘어갔을 시
                cycle = cycles[i] #각 사이클 만큼 시간 증가
                arr[i][0] += cycle
                arr[i][1] += cycle
                arr[i][2] += cycle
                
            if (not arr[i][0] < t <= arr[i][1]):
                flag = False
        
        if (flag):
            return t
    
    return -1