package a.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class dancizongshu {
public static void main(String[] args) {
int count = 0;
File file = new File("src/word.txt");
String s = "";
StringBuffer buffer = new StringBuffer();
try {
BufferedReader br = new BufferedReader(new FileReader(file));
try {
while ((s = br.readLine()) != null) {
buffer.append(s + '\n');
}
br.close();
} catch (IOException e) {
e.printStackTrace();
}
} catch (FileNotFoundException e) {
e.printStackTrace();
}
Pattern p = Pattern.compile("\\b[a-zA-Z]+\\b");
Matcher m = p.matcher(buffer.toString());
while(m.find()) {
System.out.println(m.group());
count ++ ;
}
System.out.println("总共：" + count + "个单词");
}
}