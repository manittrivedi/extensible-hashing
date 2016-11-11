import java.util.Scanner;

import VO.*;

/**
 * @author 16MCEC26
 *
 */
public class ExtHashing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DirectoryList d = new DirectoryList();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the amount of numbers : ");
		int n = scan.nextInt();
		int[] numbers = new int[n];
		System.out.println("Enter Numbers : ");
		for (int i = 0; i < n; i++) {
			numbers[i] = scan.nextInt();
		}
		int dirNo;
		for (int i = 0; i < numbers.length; i++) {
			dirNo = d.hashFunction(numbers[i]);
			Directory dir = d.getDirectories().get(dirNo);
			if(dir.getBucket().getBucketSpace() == 2){
				dir.getBucket().setBucketValue1(numbers[i]);
				dir.getBucket().setBucketSpace(1);
			}
			else if(dir.getBucket().getBucketSpace() == 1){
				dir.getBucket().setBucketValue2(numbers[i]);
				dir.getBucket().setBucketSpace(0);
			}
			else if(dir.getBucket().getBucketSpace() == 0){
				d.checkRef(dirNo, numbers[i]);
			}
		}
	}

}
