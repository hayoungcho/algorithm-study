package programmers.challenges.level3;

public class Challenge_60059 {
	public static boolean solution(int[][] key, int[][] lock) {
        int point = key.length - 1;
        for(int i = 0; i < point + lock.length; i++) {
        	for(int j = 0; j < point + lock.length; j++) {
        		for(int r = 0; r < 4; r++) {
        			int[][] expansionLock = rotationKey(key, lock, point);
        			
        			match(expansionLock, key, r, i, j);
        			if(check(expansionLock, point, lock.length))
        				return true;
        		}
        	}
        }
        return false;
    }
    
    public static int[][] rotationKey(int[][] key, int[][] lock, int point){
    	int[][] expansionLock = new int[lock.length + key.length * 2][lock.length + key.length * 2];
		for(int i = 0; i < lock.length; i++) {
			for(int j = 0; j < lock.length; j++)
				expansionLock[i + point][j + point] = lock[i][j];
		}
		return expansionLock;
    }
    
    public static void match(int[][] expansionLock, int[][] key, int rot, int x, int y) {
    	int len = key.length;
    	for(int i = 0; i < len; i++) {
    		for(int j = 0; j < len; j++) {
    			if(rot == 0)
                    expansionLock[x + i][y + j] += key[i][j];
                else if(rot == 1)
                    expansionLock[x + i][y + j] += key[j][len - i - 1];
                else if(rot == 2)
                    expansionLock[x + i][y + j] += key[len - i - 1][len- j - 1];
                else
                    expansionLock[x + i][y + j] += key[len - j - 1][i];
    		}
    	}
    }
    
    public static boolean check(int[][] expansionLock, int point, int len) {
    	for(int i = 0; i < len; i++) {
    		for(int j = 0; j < len; j++) {
    			if(expansionLock[point + i][point + j] != 1)
    				return false;
    		}
    	}
    	return true;
    }
	
	public static void main(String[] args) {
		int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		
		System.out.println(solution(key, lock));
	}
}
