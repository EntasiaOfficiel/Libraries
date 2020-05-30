package fr.entasia.apis.other;

import fr.entasia.errors.EntasiaException;
import it.unimi.dsi.fastutil.doubles.Double2BooleanLinkedOpenHashMap;

import java.util.Random;

public class Randomiser {

	public static Random random = new Random();

	private final int max;
	private double r;
	private double cPercent = 0;

	public Randomiser(){
		this(1000);
	}

	public Randomiser(int max){
		this.max = max;
		this.r = random.nextInt(max);
	}


	public boolean isInNext(double percents){
		if(cPercent ==-1)throw new EntasiaException("Value already found !");
		cPercent +=percents;
		if(cPercent >= max)throw new EntasiaException("Excedded maximum !");

		if(r<cPercent){
			cPercent = -1;
			return true;
		}
		return false;
	}

	public double getNumber(){
		return r;

	}
	public double getCPercent(){
		return cPercent;
	}




//	private ArrayList<Integer> list = new ArrayList<>();
//	private boolean finalized = false;

//	public Randomiser add(int index, int percent){
//		if(finalized)throw new EntasiaException("Already initialized !");
//		list.add(index, percent);
//		return this;
//	}
//
//	public Randomiser finish(){
//		int n = 0;
//		for (Integer integer : list) n += integer;
//		if(n!=100)throw new EntasiaException("Not 100%");
//		finalized = true;
//		return this;
//	}
//
//	public int random(){
//		if(finalized){
//			int price = random.nextInt(100);
//			int n = 0;
//			int i = 0;
//			for (Integer integer : list) {
//				n += integer;
//				if (price < n) {
//					return i;
//				}
//				i++;
//			}
//			return -10;
//		}else throw new EntasiaException("Not finalized");
//	}
}
