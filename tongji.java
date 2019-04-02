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
