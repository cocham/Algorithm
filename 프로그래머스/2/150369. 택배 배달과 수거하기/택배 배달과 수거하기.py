def solution(cap, n, deliveries, pickups):
    
    """
    배달과 수거는 동시에 처리 가능
    물류창고 -> 집 -> 물류창고
    
    배달과 수거를 해야되는 각각의 가장 먼집을 찾는다
    1. 가장 먼 집까지 갈 수 있도록 배달 상자를 싣는다.
    - 근데 무조건 가야되는 건 아님
    - 문제를 보면 가장 먼 집에 있는 짐만큼 가져가지 않음(예시 1)
    2. 가장 먼 집부터 가까운 집으로 돌아오면서 배달한다.
    3. 돌아오는 길에 수거 상자도 싣는다.
    
    어차피 제일 먼 곳부터 왕복으로 처리하는 게 낫지않나
    제일 먼 곳이 거리가 제일 크니까
    왕복 거리 = (i + 1) * 2
    
    수거/배달 최대 개수는 cap만큼
    cap보다 작으면 왕복 1번
    cap보다 크면 cap으로 나눈 만큼 왕복
    
    수거 || 배달 중 더 큰 값에 왕복이 좌우됨.
    (수거/배달은 동시에 가능하기 때문에 왔다가 또 갈 필요는 없음. 한큐에 해결하면됨)
    
    그럼 수거/배달 중 더 큰 거에 맞춰서 왕복 비용을 구하자
    
    수거/배달을 독립적으로 하지 않고 한 집 처리하고 남으면 다른 집도 처리함
    그럼 걍 배달/수거를 각각 누적합으로 만들어서 cap만큼 빼자
    음수면 패스 양수면 왕복 1회 추가
    """
    
    dist = 0
    
    needP = needD = 0
    
    for i in range(n - 1, -1, -1):

        needD += deliveries[i]
        needP += pickups[i]
        
        while (needD > 0 or needP > 0):
            needD -= cap
            needP -= cap
            dist += (i + 1) * 2
            
    return dist



"""


dist = 0
    
    for i in range(n - 1, -1, -1):

        needD = deliveries[i]
        needP = deliveries[i]
        
        while (needD > 0 or needP > 0):
            needD -= cap
            needP -= cap
            
            print (needD, " ", needP)
            dist += (i + 1) * 2
            
            print(dist)
    
    return dist

"""
