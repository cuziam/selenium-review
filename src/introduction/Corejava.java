package introduction;

import java.util.ArrayList;

public class Corejava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int myNum=5;
		
		System.out.println(myNum+" Hello everyone!");
		
		int[] arr=new int[5];
		arr[0]=0;
		arr[1]=1;
		arr[2]=2;
		for(int i=0; i<=2;i++) {
			System.out.println(arr[i]);
		}
		for(int k: arr) {
			System.out.println(k);
		}
		
		
		String[] names = {"kang","kim","neo"};
		for(String s: names) {
			System.out.println(s);
		}
		
		ArrayList<String> a=new ArrayList<>();
		a.add("Saul");
		a.add("Jack");
		a.add("white");
		System.out.println(a.get(0));
		
	}

}
