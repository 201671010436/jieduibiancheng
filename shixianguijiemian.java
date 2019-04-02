package a.a;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
public class shixianguijiemian {
    //定义Jframe框架
    private JFrame frame;
    //模式对话框
    private FileDialog openFile;
    //文本域
    private JTextArea area;
    private JButton button;
    private JButton button1;
    private JLabel label;
    PreparedStatement psql;//
    HashMap<String, Integer> hashMap=null;
    public shixianguijiemian() {
        init();
        addEvents();
    }
    public void init() {
        //new出菜单的对象
        frame = new JFrame("菜单测试");
        frame.setBounds(500, 400, 400, 400);
        frame.setLayout(null);
        button = new JButton("选择文件");
        button.setBounds(120, 30, 100, 40);
        button1 = new JButton("执行选词");
        button1.setBounds(120, 100, 100, 40);
        //文本域
        area = new JTextArea(10,5);
        area.setLineWrap(true);
        area.setBounds(20,200,360,100);
        label=new JLabel("执行结果:");
        label.setBounds(140,150,100,40);
        frame.add(button);
        frame.add(button1);
        frame.add(area);
        frame.add(label);
        frame.setVisible(true);
    }
    //关闭窗体
    public void addEvents() {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //打开文件
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //创建一个文件对话框
                openFile = new FileDialog(frame, "打开文件", FileDialog.LOAD);
                openFile.setVisible(true);
                //得到文件信息
                String dirName = openFile.getDirectory();//调用FileDialog对象的getDirectory()方法，得到String的目录
                String fileName = openFile.getFile();//调用FileDialog对象的getFile()方法，得到String的文件名称
                //读取展示文件
                if (dirName == null || fileName == null) {
                    return;
                }
                File file = new File(dirName, fileName);
                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String line;
                    StringBuilder text = new StringBuilder();//存放文件内容
                    while ((line = br.readLine()) != null) {
                        text.append(line);
                    }
                    String spilrStr1 = String.valueOf(text);
                    //先用","分割成字符数组(含".")
                    String[] word1 = spilrStr1.split(",");
                    //字符数组转化为字符串
                    String spilrStr2 = StringUtils.join(word1);
                    //用"."分割字符数组(只剩空格)
                    String[] word2 = spilrStr2.split("\\.");
                    //转化为字符串
                    String spilrStr3 = StringUtils.join(word2);
                    //根据空格分开
                    String[] word3 = spilrStr3.split(" ");
                    String spilrStr4 = StringUtils.join(word3, " ");
                    //按字典输出
                    String[] sortword = Sort(word3);
                    //统计单词出现的频率
                    HashMap<String, Integer> map = new HashMap();
                    for (String str : sortword) {
                        if (!map.containsKey(str)) {//当str不存在,
                            map.put(str, 1);
                        } else {
                            //否则获得c的值并且加1
                            map.put(str, map.get(str) + 1);
                        }
                        //System.out.println(str + "出现的次数为:" + map.get(str)+"次");
                    }
                    hashMap=map;
//                    //结果写入文件
//                    String filestr = String.valueOf(map);
//                    BufferedWriter writer = new BufferedWriter(new FileWriter("D://out.txt"));
//                    writer.write(filestr);
//                    writer.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //写入数据库
                Conn conn = new Conn();
                Connection connection = null;
                try {
                    connection = conn.getCon();
                    System.out.println("数据库连接成功");
                    for (String key : hashMap.keySet()) {
                        psql = connection.prepareStatement("insert into words(wordName,counts) values(?,?)");
                        psql.setString(1, key);
                        psql.setInt(2, hashMap.get(key));
                        psql.executeUpdate();
                    }
                    psql.close();
                    connection.close();
                    System.out.println("数据库存放成功!");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                String str= String.valueOf(hashMap.toString());
                String[] str1=str.split(",");
                String str2 = StringUtils.join(str1, " ");
                area.setText(str2);
            }
        });
    }
    //按字典输出
    public String[] Sort(String[] word3) {
        String temp;
        for (int i = 0; i < word3.length; i++) {
            for (int j = word3.length - 1; j > i; j--) {
                if (word3[j - 1].compareTo(word3[j]) > 0) {
                    temp = word3[j - 1];
                    word3[j - 1] = word3[j];
                    word3[j] = temp;
                }
            }
        }
        return word3;
    }
    public static void main(String[] args) {
        new shixianguijiemian();
    }
}
