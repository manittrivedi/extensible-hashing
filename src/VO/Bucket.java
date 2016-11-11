package VO;

/**
 * @author 16MCEC26
 *
 */
public class Bucket {
	
	private Integer bucketValue1;
	private Integer bucketValue2;
	private int bucketSpace = 2;
	private int bucketDepth = 1;
	private boolean isBucketRef = false;
		
	public Integer getBucketValue1() {
		return bucketValue1;
	}
	public void setBucketValue1(Integer bucketValue1) {
		this.bucketValue1 = bucketValue1;
	}
	public Integer getBucketValue2() {
		return bucketValue2;
	}
	public void setBucketValue2(Integer bucketValue2) {
		this.bucketValue2 = bucketValue2;
	}
	public int getBucketSpace() {
		return bucketSpace;
	}
	public void setBucketSpace(int bucketSpace) {
		this.bucketSpace = bucketSpace;
	}
	public int getBucketDepth() {
		return bucketDepth;
	}
	public void setBucketDepth(int bucketDepth) {
		this.bucketDepth = bucketDepth;
	}
	public boolean isBucketRef() {
		return isBucketRef;
	}
	public void setBucketRef(boolean isBucketRef) {
		this.isBucketRef = isBucketRef;
	}
}
