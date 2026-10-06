
def solution(users, emoticons):
    global userCount, totalSales
    userCount = 0
    totalSales = 0
    
    dcInfo = [0] * len(emoticons) #할인조합
    
    dfs(0, dcInfo, users, emoticons)
    
    return [userCount, totalSales]

def dfs(emojiIdx, dcInfo, users, emoticons): #현재 할인하는 임티
    global userCount, totalSales

    disc = [10, 20, 30, 40]
    

    if (emojiIdx == len(emoticons)): #각 임티별로 할인 조합 생성
        curCount = 0
        curTotal = 0
        
        for user in users: 
            userDis = user[0]
            userMoney = user[1]
            curBuy = 0

            for i in range(len(emoticons)): #각 임티를 살 수 있는지 계산
                curDc = dcInfo[i]

                if (curDc >= userDis):
                    disEmoji = emoticons[i] - (emoticons[i] * (curDc / 100))
                    curBuy += disEmoji

            if (curBuy >= userMoney):
                curCount += 1
            else:
                curTotal += curBuy
        
        if (curCount > userCount): #1차 조건(가입자 최대)
            userCount = curCount
            totalSales = curTotal
        elif (curCount == userCount and curTotal > totalSales): #2차 조건(가입자 최대면서 판매액 최대)
            totalSales = curTotal
            
        return
            
    for idx in range(len(disc)):
        dcInfo[emojiIdx] = disc[idx]
        dfs(emojiIdx + 1, dcInfo, users, emoticons)