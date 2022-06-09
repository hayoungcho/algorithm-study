package programmers.challenges.level2;

import java.util.HashSet;

//후보키
public class Challenge_42890 {
	static HashSet<String> set;
	static String[][] relations;
	
	public static int solution(String[][] relation) {
		relations = relation;
        set = new HashSet<String>();
        
        //i : 후보키 개수
        for(int i = 0; i < relation.length; i++) {
        	int[] chk = new int[relation[i].length];
        	getCombi(0, 0, i, chk);
        }
        
        return set.size();
    }
	public static void getCombi(int idx, int cnt, int size, int[] chk) {
		if(cnt == size) {
			String cols = "";
			for(int i = 0; i < chk.length; i++) {
				if(chk[i] == 1)
					cols += i;
			}
			
			if(check(cols, chk))
				set.add(cols);
			
		}else {
			if(idx >= chk.length)
				return;
			
			//dfs
			chk[idx] = 1;
			getCombi(idx + 1, cnt + 1, size, chk);
			chk[idx] = 0;
			getCombi(idx + 1, cnt, size, chk);
		}
	}
	
	public static boolean check(String cols, int[] chk) {
		for(String s : set) {
			boolean flag = true;
			for(int i = 0; i < s.length(); i++) {
				if(!cols.contains(s.charAt(i) + ""))
					flag = false;
			}
			
			if(flag)
				return false;
		}

		HashSet<String> values = new HashSet<String>();
        int[] col_name = new int[cols.length()];
        int idx = 0;
        for (int i = 0; i < chk.length; i++) {
            if(chk[i] == 1)
                col_name[idx++] = i;
        }

        for (int i = 0; i < relations.length; i++) {
        	String value = "";
            for (int j = 0; j < col_name.length; j++) 
                value += relations[i][col_name[j]];
            
            if(values.contains(value))
                return false;
            else
                values.add(value);
        }

        return true;
	}
	
	public static void main(String[] args) {
		String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
		
		System.out.println(solution(relation));
	}

}
