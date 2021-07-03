package com.itwn.homework.task0703;

import java.io.File;
import java.util.Arrays;

public class FileUtil {

	public static void countFiles(File file,int[] counts){

		if (file.exists()){
			if (file.isFile()){
				counts[0]++;
			}else {
				counts[1]++;
				for(File file1:file.listFiles()){
					countFiles(file1,counts);
				}
			}
		}else {
			System.out.println("不存在");
		}
	}

	public static void main(String[] args) {
		File file=new File("src");
		int[] counts=new int[2];
		FileUtil.countFiles(file,counts);
		System.out.println(Arrays.toString(counts));
	}

}
