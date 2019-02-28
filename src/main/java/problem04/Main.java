package problem04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<String> problemList = new ArrayList<String>();
		ArrayList<Integer> answerList = new ArrayList<Integer>();

		int correctCount = 0;
		int startTime = 0;
		int endTime = 0;
		int answer = 0;
		int randomNumber = 0;
		int randomIndex = 0;
		int problemNumber = 1;

		for (int i = 0; i < 2; i++) {
			for (int j = 1; j < 10; j++) {
				randomNumber = (int) (Math.random() * 9) + 1;
				problemList.add(j + "x" + randomNumber);
				answerList.add(j * randomNumber);
			}
		}

		startTime = (int) (System.currentTimeMillis() / 1000);
		while (problemList.size() != 0) {
			randomIndex = (int) (Math.random() * problemList.size());
			System.out.println(problemNumber++ + ". " + problemList.get(randomIndex) + " ?");
			answer = sc.nextInt();
			if (answerList.get(randomIndex) == answer) {
				correctCount++;
			}
			problemList.remove(randomIndex);
			answerList.remove(randomIndex);
		}
		endTime = (int) (System.currentTimeMillis() / 1000);
		
		
		System.out.println(correctCount);
		System.out.println(endTime - startTime);
		
		Recode recode = new Recode(correctCount, endTime - startTime);
		ArrayList<Recode> recodeList = new ArrayList<Recode>();
			FileInputStream fis = null;
			ObjectInputStream ois = null;
			
		try{
			
			// object.dat 파일로 부터 객체를 읽어오는 스트림을 생성한다.
			fis = new FileInputStream("object.dat");
			ois = new ObjectInputStream(fis);
			
			while(ois.readObject()!=null) {
				
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			// 스트림을 닫아준다.
			if(fis != null) try{fis.close();}catch(IOException e){}
			if(ois != null) try{ois.close();}catch(IOException e){}
		}
		
		
	}
}
