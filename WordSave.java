package WordTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class WordSave {

public void sortMapByKeys(Map<String, Integer> Map) throws IOException{  
		
        Set<Entry<String,Integer>> mapEntries = Map.entrySet();    
        LinkedList<Entry<String, Integer>> List = new LinkedList<Entry<String,Integer>>(mapEntries);
        
        Collections.sort(List, new Comparator<Entry<String,Integer>>() {  
            @Override  
            public int compare(Entry<String, Integer> ele1,  Entry<String, Integer> ele2) {
                return ele1.getKey().compareTo(ele2.getKey());  
            }  
        });  
        Map<String,Integer> Map2 = new LinkedHashMap<String, Integer>();  
        for(Entry<String,Integer> entry: List) {  
            Map2.put(entry.getKey(), entry.getValue());  
        } 
        
        File file = new File("src/result.txt");
        	if(file.exists()) {
        		file.createNewFile();
        	}
        	FileWriter fop = new FileWriter(file.getAbsoluteFile());
        	for(Entry<String,Integer> entry : Map2.entrySet()) {
        		fop.write(entry.getKey()+":\t"+"出现"+entry.getValue()+"次"+"\n");
        	}
        	fop.close();
        	System.out.println("存放成功！");
        }
	} 


