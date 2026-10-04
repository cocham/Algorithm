def solution(friends, gifts):
    
    totalF = len(friends)
    friendsIdx = {}
    
    for i in range(totalF):
        friendsIdx[friends[i]] = i
        
    giveTake = [[0 for _ in range(totalF)] for _ in range(totalF)]
    
    for gift in gifts:
        gift = gift.split()
        
        giveIdx = friendsIdx[gift[0]]
        takeIdx = friendsIdx[gift[1]]
        
        giveTake[giveIdx][takeIdx] += 1
    
    giftIndex = {} #선물지수
    for i in range(totalF):
        giftIndex[i] = 0
    
    for i in range(totalF):
        totalGive = 0
        totalTake = 0
        for j in range(totalF):
            totalGive += giveTake[i][j]
            totalTake += giveTake[j][i]
            
        giftIndex[i] = totalGive - totalTake
    
    
    receiveGifts = [0 for _ in range(totalF)] #받을 선물
    
    for i in range(totalF):
        curGiftIdx = giftIndex[i]
        
        for j in range(i + 1, totalF):
            
            otherGiftIdx = giftIndex[j]
            
            if (giveTake[i][j] > giveTake[j][i]):
                receiveGifts[i] += 1
                
            elif (giveTake[j][i] > giveTake[i][j]):
                    receiveGifts[j] += 1
            
            else:
                if (curGiftIdx > otherGiftIdx):
                    receiveGifts[i] += 1
                    
                elif (otherGiftIdx > curGiftIdx):
                    receiveGifts[j] += 1
                
            
    return max(receiveGifts)