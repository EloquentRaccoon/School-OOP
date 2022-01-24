package com.JeffDev.P9a;
import java.text.NumberFormat;

public class P9a {

    public static void main(String[] args) {
        System.out.println(Utils.euroBedrag(3.11314));
        System.out.println(Utils.euroBedrag(3.11314, 1));
    }
}

class Utils{
    public static String euroBedrag(double bedrag, int... precisieArg) {
        int precisie = precisieArg.length > 0 ? precisieArg[0] : 2;
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(precisie);
        nf.setMinimumFractionDigits(0);
        return nf.format(bedrag);
    }
}
