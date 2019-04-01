package WordTest;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import javax.swing.JFrame;
public class Main extends JFrame{
	private static final long serialVersionUID = 1L;
	public static String[] WordCount;
	public static Map<String, Integer> WordsCount;
	public static void main(String[] args) throws IOException{
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String line = "src/word.txt";
		File file = new File(line);
		InputStreamReader is = new InputStreamReader(new FileInputStream(file), "utf-8");
		BufferedReader buff = new BufferedReader(is);
		List<String> list = new ArrayList<String>();//list中只存放纯单词文本
		String readLine = null;
		while((readLine = buff.readLine())!=null){
			String[] WordsArr = readLine.split("[^a-zA-z]");
			for(String word:WordsArr){
				if(word.length()!=0){
					list.add(word);
				}
				
			}
		}
		buff.close();
		WordsCount = new TreeMap<String,Integer>();
		for(String lists:list){
			if(WordsCount.get(lists)!=null){
				WordsCount.put(lists, WordsCount.get(lists)+1);
			}else{
				WordsCount.put(lists, 1);
			}
		}
		System.out.println("请输入1~5之间的整数然后按提示操作：");

		int i = in.nextInt();
		switch(i){
		case 1:WordCount wc = new WordCount();
				System.out.println("请输入需要查询的单词(单词之间用',隔开')：");
				String s = in.next();
				wc.query(WordsCount, s);
				break;
		case 2:	WordCount wc1 = new WordCount();
   				System.out.println("请输入需要查询的单词(单词之间用',隔开')：");
   				String s1 = in.next();
   				WordCount = wc1.query(WordsCount, s1);
   				Main demo = new Main();
   				demo.setVisible(true);
   				break;
		case 3:	HighCount hwc = new HighCount();
				System.out.println("请输入要查询单词的个数k(正整数)：");
				int n = in.nextInt();
				hwc.SortMap(WordsCount, n);
				break;
		case 4:	WordSave wo = new WordSave();
				wo.sortMapByKeys(WordsCount);
				break;
		case 5: 	
				break;
}
}  
	public Main(){
		super();
		setTitle("绘制柱形图");
		setBounds(WordCount.length, 200, 450, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void paint(Graphics g){
		int Width = getWidth();
		int Height = getHeight();
		int leftMargin = 50;
		int topMargin = 50;
		Graphics2D g2 = (Graphics2D) g;
		int ruler = Height-topMargin;
		int rulerStep = ruler/20;
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, Width, Height);
		g2.setColor(Color.LIGHT_GRAY);
		for(int i=0;i<rulerStep;i++){
			g2.drawString((400-20*i)+"个", 8, topMargin+rulerStep*i);
		}
		g2.setColor(Color.BLUE);
		int m=0;
		for(int i = 0;i<WordCount.length;i++){
			int value = WordsCount.get(WordCount[i]);
			int step = (m+1)*40;
			g2.fillRoundRect(leftMargin+step*2,Height-value, 40, value, 40, 10);
			g2.drawString(WordCount[i], leftMargin+step*2, Height-value-5);		
			m++;
		}
	}
	}
