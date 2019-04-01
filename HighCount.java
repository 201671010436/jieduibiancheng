package WordTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class HighCount {

	public void SortMap(Map<String,Integer> oldmap,int n){  
        ArrayList<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(oldmap.entrySet());
        
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>(){  
            @Override  
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {  
                return o2.getValue() - o1.getValue();
            }  
        }); 
        for(int i = 0; i<n; i++){  
            System.out.println(list.get(i).getKey()+ ": " +list.get(i).getValue());  
        }     
    }
}
