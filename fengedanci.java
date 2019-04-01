package a.a;
 					// spilrStr1为文件的内容
                   //String spilrStr1 = String.valueOf(text);
                    //先用","分割成字符数组(含".")
                    String spilrStr2 = StringUtils.join(word1);
                    //用"."分割字符数组(只剩空格)
                    String[] word2 = spilrStr2.split("\\.");
                    //转化为字符串
                    String spilrStr3 = StringUtils.join(word2);
                    //根据空格分开
                    String[] word3 = spilrStr3.split(" ");
                    String spilrStr4 = StringUtils.join(word3, " ");