package com.JeffDev;

import java.util.ArrayList;
import java.util.Locale;

public class P7 {
    public static void main(String[] args) {
        StringProcessor processor = new StringProcessor();
        processor.voegProcesToe(new VervangProces("hij", "hij/zij"));
        Student student1 = new Student("Jeffrey");
        processor.voegProcesToe(new addStudentNameProcess("Een student", "De student: " + student1.getNaam()));
        processor.voegProcesToe(new HoofdletterProces());
        String inputString = "Een student loopt meestal in het derde jaar stage. Dan moet hij zelf een stageplek vinden.";
        String result = processor.verwerk(inputString);
        System.out.println(result);
    }
}

//interface OpmaakProcess
interface OpmaakProcess {
     public String maakOp(String input);
}

//klasse VervangProces
class VervangProces implements OpmaakProcess {
    private final String oud;
    private final String nieuw;

    VervangProces(String oud, String nieuw){
        this.oud = oud;
        this.nieuw = nieuw;
    }


    public String maakOp(String input){
        return input.replaceAll(oud, nieuw);
    }

}

//klasse HoofdletterProces
class HoofdletterProces implements OpmaakProcess{
    HoofdletterProces(){}

    public String maakOp(String input){
        return input.toUpperCase();
    }
}

class addStudentNameProcess implements OpmaakProcess{
    private final String oud;
    private final String nieuw;

    addStudentNameProcess(String oud, String nieuw){
        this.oud = oud;
        this.nieuw = nieuw;
    }


    public String maakOp(String input){
        return input.replaceAll(oud, nieuw);
    }
}

//Klasse StringProcessor
class StringProcessor{
    private ArrayList<OpmaakProcess> processen = new ArrayList<>();

    public StringProcessor(){}

    public String verwerk(String input){
        for (OpmaakProcess method : processen) {
            input = method.maakOp(input);
        }
        return input;
    }

    public void voegProcesToe(OpmaakProcess proces){
        processen.add(proces);
    }
}

class Student{
    private final String naam;
    public Student(String naam){
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }
}