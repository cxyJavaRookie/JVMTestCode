package com.jvm.test.code;
/** 
 *	测试引用计数算法
 * @author chenxingyu
 */
public class TestReferenceCounting {
	
	public Object instance;
	
	private static final int _1MB = 1024*1024;
	
	/*
	 *这个属性就是用来占用内存,以便可以在GC日志中看清楚是否被回收过. 
	 */
	private byte[] bigSize = new byte[_1MB * 2];
	
	public static void main(String[] args) {
		
		TestReferenceCounting objA = new TestReferenceCounting();
		TestReferenceCounting objB = new TestReferenceCounting();
		
		objA.instance = objB;
		objB.instance = objA;
		
		objA = null;
		objB = null;
		
		//假设在这里发生GC,objA和objB是否能被回收.
		System.gc();
	}
	
	
}
