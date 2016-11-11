package VO;

import java.util.ArrayList;

/**
 * @author mtechcse
 *
 */
public class DirectoryList {

	ArrayList<Directory> directories = new ArrayList<Directory>();
	private int noOfDirectories = 2;
	private int directoryDepth = 1;

	public DirectoryList() {
		directories.add(new Directory());
		directories.add(new Directory());
		directories.get(0).setBucket(new Bucket());
		directories.get(1).setBucket(directories.get(0).getBucket());
		directories.get(1).getBucket().setBucketRef(true);
	}

	public ArrayList<Directory> getDirectories() {
		return directories;
	}

	public void setDirectories(ArrayList<Directory> directories) {
		this.directories = directories;
	}
	
	public int getDirectoryDepth() {
		return directoryDepth;
	}

	public void setDirectoryDepth(int directoryDepth) {
		this.directoryDepth = directoryDepth;
	}

	public int getNoOfDirectories() {
		return noOfDirectories;
	}

	public void setNoOfDirectories(int noOfDirectories) {
		this.noOfDirectories = noOfDirectories;
	}
	
	public int hashFunction(int number){
		long binary = 0;
		int dirNo = 0;
		int remainder, i = 1, n = number;
		int depth = directoryDepth;

	    while (depth>0 && n!=0){
	        remainder = n%2;
	        n /= 2;
	        binary += remainder*i;
	        i *= 10;
	        depth--;
	    }
	    remainder = 0; i = 0;
	    do {
			remainder = (int)binary%10;
			binary /= 10;
			dirNo += remainder*Math.pow(2, i);
			i++;
		} while (binary>0);
		return dirNo;
	}
		
	public void bucketSplit(int dirNo){
		
	}

	public void directorySplit(int dirNo, int number){
		directoryDepth++;
		for (int i = 0; i < noOfDirectories; i++) {
			directories.add(new Directory());
		}
		noOfDirectories *= 2;
		
		int[] num = new int[3];
		num[0] = number;
		num[1] = getDirectories().get(dirNo).getBucket().getBucketValue1();
		num[2] = getDirectories().get(dirNo).getBucket().getBucketValue2();
		
		getDirectories().get(dirNo).getBucket().setBucketValue1(null);
		getDirectories().get(dirNo).getBucket().setBucketValue2(null);
		getDirectories().get(dirNo).getBucket().setBucketSpace(2);

		int[] temp = new int[3];
		temp[0] = hashFunction(num[0]);
		temp[1] = hashFunction(num[1]);
		temp[2] = hashFunction(num[2]);
		for (int j = 0; j < 3; j++) {
			if(getDirectories().get(temp[j]).getBucket().getBucketSpace() == 2){
				getDirectories().get(temp[j]).getBucket().setBucketValue1(num[j]);
				getDirectories().get(temp[j]).getBucket().setBucketSpace(1);
			}
			else if(getDirectories().get(temp[j]).getBucket().getBucketSpace() == 1){
				getDirectories().get(temp[j]).getBucket().setBucketValue2(num[j]);
				getDirectories().get(temp[j]).getBucket().setBucketSpace(0);
			}
		}
		
	}
	
	public void checkRef(int dirNo, int number){
		Bucket b = getDirectories().get(dirNo).getBucket();
		int bucketDepth = getDirectories().get(dirNo).getBucket().getBucketDepth();
		int[] dirNos = new int[bucketDepth];
		int j=0;
		for (int i = 0; i < getNoOfDirectories(); i++) {
			if((b == getDirectories().get(i).getBucket()) && (j<bucketDepth)){
				dirNos[j] = i;
				j++;
			}
		}
	}
	
}
