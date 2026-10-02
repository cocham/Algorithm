def solution(board, moves):
    size = len(board)
    reverse_board = []
    
    for c in range(size):
        row = []
        for r in range(size):
            row.append(board[r][c])
        reverse_board.append(row);
    
    pops = []
    answer = 0
    
    for m in moves:
        real_move = m - 1;
        
        for j in range(size):
            num = reverse_board[real_move][j]
            if (num != 0):
                if (len(pops) != 0 and pops[len(pops) - 1] == num):
                    pops.pop()
                    answer += 2
                else:
                    pops.append(num)
                    
                reverse_board[real_move][j] = 0
                break


    return answer