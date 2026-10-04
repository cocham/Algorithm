def solution(id_list, report, k):
    members = len(id_list)
    
    idIdx = {}
    for i in range(members):
        idIdx[id_list[i]] = i
    
    reports = {} #피신고자: 신고자들
    reportsCnt = [0 for _ in range(members)]
    suspend = set() # 정지 ID _ 중복 안 되게 
    
    for r in report:
        r = r.split()
        
        reporter = r[0]
        reported = r[1]
        
        reporterIdx = idIdx[reporter]
        reportedIdx = idIdx[reported]
        
        if reportedIdx not in reports:
            reports[reportedIdx] = [False for _ in range(members)]
        
        if reports[reportedIdx][reporterIdx]:
            continue
        
        reports[reportedIdx][reporterIdx] = True
        reportsCnt[reportedIdx] += 1
        
        if (reportsCnt[reportedIdx] >= k):
            suspend.add(reportedIdx)
    
    emailCnt = [0 for _ in range(members)]
    
    for ban in suspend:
        for i in range(members):
            if (reports[ban][i]):
                emailCnt[i] += 1
    
    return emailCnt