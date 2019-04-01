package a.a;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class tongjidancishumu{
	private static Map<String, Integer> words = new HashMap<String,Integer>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	String src = "E:/Word.txt";
	String wenzhang=ReadSrc(src);
	words = Count(wenzhang);
	Iterator<String> it = words.keySet().iterator();
	while(it.hasNext()){
		Object key = it.next();
		System.out.println(key);
		System.out.println(words.get(key));
	}
	
	}
	public static String ReadSrc(String path) throws IOException{
		String Src="";
		FileReader read = null;
		BufferedReader br = null;
		String word = null;
		try{
		read = new FileReader(path);
		br = new BufferedReader(read);
		word = br.readLine();
		while(word!=null){
			Src+=word;
			word=br.readLine();
		}
		}
		catch(IOException e){
			
		}finally{
			if(read!=null){
				read.close();
			}
			if(br!=null){
				br.close();
			}
		}
		return Src;
	}
	public static Map<String , Integer> Count(String wenzhang){
		Map<String , Integer> endmap = new HashMap<String , Integer>();
		String src = wenzhang;
		src=src.replaceAll(",", " ");
		src=src.replace(".", " ");
		String[] ss = src.split(" ");
		for(String s:ss){
			if(s.toString().trim().length()!=0){
				if(endmap.containsKey(s)){
					endmap.put(s, endmap.get(s)+1);
				}
				else{
					endmap.put(s, 1);
				}
			}
		}
		return endmap;
	}
}