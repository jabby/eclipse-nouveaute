package fr.jabbytechs.api;

import java.util.ArrayList;

public class AllKindOfCode {

	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(1000);
	}

	class RawPaste {

		public void menuRawPaste() {
			String chaine = "Hello\t\nTours JUG";
			String copyEscaped = "";
			String copyNonEscaped = "";
		}
		
	}
	
	class QuickAssist {
		public void staticFavorites() {
			System.out.println(Math.sqrt(2));
		}
		
		public void extractLambdaBodyToMethod() {
			var list = new ArrayList<String>();
			list.stream().filter(s -> s.length() > 0).findFirst();
		}
		
	}
}