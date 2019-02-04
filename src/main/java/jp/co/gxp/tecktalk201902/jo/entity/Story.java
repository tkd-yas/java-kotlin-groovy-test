package jp.co.gxp.tecktalk201902.jo.entity;

import java.util.Set;

import lombok.Data;

@Data
public class Story {

	private final Integer number;

	private final Set<Person> characters;

	public Story(Integer number, Set<Person> characters) {
		super();
		this.number = number;
		this.characters = characters;
	}

	public String getTitle() {
		return Title.titleByNumber(number);
	}

	public static enum Title {
		Part1(1, "Phantom Blood"), //
		Part2(2, "Battle Tendency"), //
		Part3(3, "Stardust Crusaders"), //
		Part4(4, "Diamond is Unbreakable"), //
		Part5(5, "VENTO AUREO"), //
		Part6(6, "Stone Ocean"), //
		Part7(7, "STEEL BALL RUN"), //
		Part8(8, "JoJolion");

		private final Integer storyNumber;
		private final String title;

		private Title(Integer storyNumber, String title) {
			this.storyNumber = storyNumber;
			this.title = title;
		}

		public Integer getStoryNumber() {
			return storyNumber;
		}

		public String getTitle() {
			return title;
		}

		public static String titleByNumber(Integer number) {
			for (Title t : values()) {
				if (t.storyNumber == number) {
					return t.title;
				}
			}
			return "";
		}

	}

}