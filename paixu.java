				//按字典排序
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
