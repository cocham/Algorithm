from collections import deque

def solution(queue1, queue2):    
    cnt = 0
    queue1 = deque(queue1)
    queue2 = deque(queue2)
    size = len(queue1)
    
    """
    q1의 합과 q2의 합 중 더 큰 큐에서 값을 작은 큐로 보낸다.(매번)    
    """
    sum_q1 = sum(queue1)
    sum_q2 = sum(queue2)
    
    while (len(queue1) != 0 and len(queue2) != 0):
        if (cnt >= size * 10):
            break
            
        if (sum_q1 == sum_q2):
            return cnt
        
        elif (sum_q1 > sum_q2):
            pop_q1 = queue1.popleft()
            queue2.append(pop_q1)
            cnt += 1
            sum_q2 += pop_q1
            sum_q1 -= pop_q1
        
        elif (sum_q2 > sum_q1):
            pop_q2 = queue2.popleft()
            queue1.append(pop_q2)
            cnt += 1
            sum_q2 -= pop_q2
            sum_q1 += pop_q2
        
        
    
    return -1
    
    