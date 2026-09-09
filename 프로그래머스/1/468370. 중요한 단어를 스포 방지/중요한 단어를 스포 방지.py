def solution(message, spoiler_ranges):
    answer = 0
     
    # 단어 위치 저장
    word_pos = {}
    word = ""
    s = 0

    while (s < len(message)):
        if (message[s] != " "):
            if (len(word) == 0):
                start = s
            word += message[s]
                
        else:
            if (len(word) != 0):
                e = s - 1
                if (word not in word_pos):
                    word_pos[word] = []
                word_pos[word].append((start, e))
                word = ""
        s += 1
        
    if (len(word) != 0):
        e = len(message) - 1    
        if (word not in word_pos):
            word_pos[word] = []
        word_pos[word].append((start, e))
    
    
    total = 0    
    
    for word, poses in word_pos.items():
        is_important = True
        
        for pos in poses:
            start = pos[0]
            end = pos[1]
            
            overlapped = False
            for scope in spoiler_ranges:
                spoS = scope[0]
                spoE = scope[1]
                if (start <= spoE and end >= spoS):
                    overlapped = True
                    break
            
            if not overlapped:
                is_important = False
                break
        
        if is_important:
            total += 1
        
    return total