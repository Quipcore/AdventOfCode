package advent2021.day4;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import utils.DataCollector;

public class Day4 {

	public static void main(String[] args) throws IOException {
		String pbrickFil = "src/advent2021/day4/puzzleBrickor";
		String pnummerFil = "src/advent2021/day4/puzzleNummer";
		int result = part2(pbrickFil,pnummerFil);
		System.out.println("Part 2: " + result);
	}

	public static int part1(String brickFil, String nummerFil) throws IOException {
		String[] input = DataCollector.getStringArray(brickFil);
		List<Bricka> brickor = new LinkedList<>();

		int index = 0;
		while (index < input.length) {
			List<String> rows = new LinkedList<>();
			for (int i = index; i < index + 5; i++) {
				rows.add(input[i]);
			}
			brickor.add(new Bricka(rows));
			index += 6;
		}

		String[] strArr = (DataCollector.getFirstLine(nummerFil)).split(",");
		int[] nummer = new int[strArr.length];
		for (int i = 0; i < strArr.length; i++) {
			nummer[i] = Integer.valueOf(strArr[i]);
		}
		
		
		for (int i = 0; i < nummer.length; i++) {
			for(Bricka br : brickor) {
				br.checkNumber(nummer[i]);
				if(br.isBingo()) {
					return nummer[i]*br.sumOfUnmarked();
				}
			}
		}

		return 0;

	}

	public static int part2(String brickFil, String nummerFil) throws IOException {
		// TODO Auto-generated method stub
		String[] input = DataCollector.getStringArray(brickFil);
		List<Bricka> brickor = new LinkedList<>();

		int index = 0;
		while (index < input.length) {
			List<String> rows = new LinkedList<>();
			for (int i = index; i < index + 5; i++) {
				rows.add(input[i]);
			}
			brickor.add(new Bricka(rows));
			index += 6;
		}

		String[] strArr = (DataCollector.getFirstLine(nummerFil)).split(",");
		int[] nummer = new int[strArr.length];
		for (int i = 0; i < strArr.length; i++) {
			nummer[i] = Integer.valueOf(strArr[i]);
		}
		
		index = -1;
		List<Bricka> copiedList = new LinkedList<>();
		copiedList.addAll(brickor);
		while(brickor.size() > 1) {
			index++;
			for(Bricka br : copiedList) {
				br.checkNumber(nummer[index]);
				if(br.isBingo()) {
					brickor.remove(br);
				}
			}
			copiedList.clear();
			copiedList.addAll(brickor);
		}
		for(int i = index; i <nummer.length;i++) {
			
			brickor.get(0).checkNumber(nummer[i]);
			if(brickor.get(0).isBingo()) {
				return nummer[i]*brickor.get(0).sumOfUnmarked();
			}
		}
		
		return 0;
	}

}
