package problem04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
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

		ArrayList<Recode> recodeList = new ArrayList<Recode>();

		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream("object.dat");
			ois = new ObjectInputStream(fis);

			while (ois.readObject() != null) {
				recodeList.add((Recode) ois.readObject());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
				}
			if (ois != null)
				try {
					ois.close();
				} catch (IOException e) {
				}
		}

		Recode recode = new Recode(correctCount, endTime - startTime);
		recodeList.add(recode);
		Recode r = new Recode();
		Collections.sort(recodeList, r);

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {

			fos = new FileOutputStream("object.dat");
			oos = new ObjectOutputStream(fos);

			for (int i = 0; i < recodeList.size(); i++) {
				oos.writeObject(recodeList.get(i));
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
				}
			if (oos != null)
				try {
					oos.close();
				} catch (IOException e) {
				}
		}

	}
}
