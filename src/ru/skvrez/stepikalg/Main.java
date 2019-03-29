package ru.skvrez.stepikalg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class SortByX2 implements Comparator<Segment> {
    public int compare(Segment a, Segment b) {
        if ( a.getX2() < b.getX2() ) return -1;
        else if ( a.getX2() == b.getX2() ) return 0;
        else return 1;
    }
}

class Segment {
    private int x1;
    private int x2;

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }


    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

}

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> lstPoint = new ArrayList();
        int n=input.nextInt();
        Segment[] arSeg = new Segment[n];
        for (int i=0; i<n;i++) {
            Segment curSeg = new Segment();
            curSeg.setX1(input.nextInt());
            curSeg.setX2(input.nextInt());
            arSeg[i]=curSeg;
        }

        Arrays.sort(arSeg, new SortByX2());

        lstPoint.add(arSeg[0].getX2());
        int max = arSeg[0].getX2();
        for (int i=1; i<n; i++){

            if (arSeg[i].getX1()>max){
                lstPoint.add(arSeg[i].getX2());
                max = arSeg[i].getX2();
            }
        }

        System.out.println(lstPoint.size());
        for (int i = 0; i< lstPoint.size(); i++) System.out.print(lstPoint.get(i) + " ");

        }

}

