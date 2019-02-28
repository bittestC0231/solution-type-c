package problem04;

import java.io.Serializable;
import java.util.Comparator;

public class Recode implements Serializable, Comparator<Recode>{

	private int correctNumber;
	private int gameTime;

	public Recode() {
	}
	public Recode(int correctNumber , int gameTime) {
		
		this.correctNumber=correctNumber;
		this.gameTime = gameTime;
		
	}
	
	public int getCorrectNumber() {
		return correctNumber;
	}


	public void setCorrectNumber(int correctNumber) {
		this.correctNumber = correctNumber;
	}


	public int getGameTime() {
		return gameTime;
	}

	public void setGameTime(int gameTime) {
		this.gameTime = gameTime;
	}

	@Override
	public int compare(Recode o1, Recode o2) {
		if(o1.gameTime<o2.gameTime && o1.correctNumber>o2.correctNumber) {
			return -1;
		}else if(o1.gameTime > o2.gameTime && o1.correctNumber<o2.correctNumber) {
			return 1;
		}else {
			return 0;
		}
	}

}
