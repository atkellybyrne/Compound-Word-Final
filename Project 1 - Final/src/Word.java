import java.util.ArrayList;

public class Word {
	private String word;
	private int index;
	private boolean compound;
	private int difficulty;
	private String topic1;
	private String topic2;
	private String topic3;
	
	
	public Word(String word1, int index1, int difficulty1) {
		word = word1;
		index = index1;
		if(index <=0) {
			compound = false;
		}
		else {
			compound = true;
		}

		difficulty = difficulty1;
		
		
		
	}
	
	
	public String getWord() {
		return word;
	}
	
	public void setString(String word1) {
		word = word1;
	}

	public int getIndex() {
		return index;
	}
	
	public void setIndex(int index1) {
		index = index1;
	}
	
	public boolean isCompound() {
		return compound;
	}
	
	public void setCompound(boolean compound1) {
		compound = compound1;
	}
	
	public int getDifficulty() {
		return difficulty;
	}
	
	public void setDifficulty(int dif) {
		difficulty = dif;
	}
	
	public String getTopic1() {
		return topic1;
	}
	
	public void setTopic1(String topic11) {
		topic1 = topic11;
	}
	
	public String getTopic2() {
		return topic2;
	}
	
	public void setTopic2(String topic11) {
		topic2 = topic11;
	}
	
	public String getTopic3() {
		return topic3;
	}
	
	public void setTopic3(String topic11) {
		topic3 = topic11;
	}
	
	
	
	
}
