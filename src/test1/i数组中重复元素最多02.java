package test1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class i�������ظ�Ԫ�����02 {
	public static void sort(int[] a){
		int[] count=new int[10];
		int i=0;int max=0;int value=0;
		for(i=0;i<count.length;i++)
			count[i]=0;
		for(i=0;i<a.length;i++)
			count[a[i]]++;
		for(i=0;i<a.length;i++)
			if(max<count[a[i]])
				{
					max=count[a[i]];
					value=a[i];
				}
		System.out.println(max+"   "+value);
	}
	public static void MapSort(int[] a){
		//ʹ��Map������count[a[i]]���ּ�ֵӳ��
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<a.length;i++)
			if(map.containsKey(a[i]))
				map.put(a[i],map.get(a[i])+1);
			else
				map.put(a[i], 1);
		//���ҳ�������Ԫ�أ�����Map
		int most=0;int temp;int keys=0;
		Iterator<Entry<Integer, Integer>> it=map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>)it.next();
			int key=entry.getKey();
			temp=entry.getValue();
			if(most<temp)
			{
				most=temp;
				keys=key;
			}
		}
		System.out.println(most+" "+keys);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={1,2,2,3,8,8,8,2,2,1};
		MapSort(a);
		System.out.println(Integer.MAX_VALUE);
	}

}
