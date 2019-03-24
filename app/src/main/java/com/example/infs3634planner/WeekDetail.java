package com.example.infs3634planner;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class WeekDetail {
    private int week;
    private LocalDate date;
    private String lab;
    private String lec;
    private String weekNo;

    public WeekDetail(){

    }

    public WeekDetail(int week, String weekNo, LocalDate date, String lab, String lec){
        this.week = week;
        this.weekNo = weekNo;
        this.date = date;
        this.lab = lab;
        this.lec = lec;
    }


    public void setWeek(int week){ this.week = week;}
    public int getWeek(){return week;}
    public void setDate(LocalDate date){this.date = date;}
    public LocalDate getDate(){return date;}
    public String getDateString(){
        DateTimeFormatter md = DateTimeFormatter.ofPattern("dd MMM");
        String s = this.date.format(md);
        return s;}
    public String getDateEnd(){
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("dd MMM yy");
        LocalDate end = this.date.plusDays(6);
        String s = end.format(mdy);
        return s;
    }

    public String getLab(){return lab;}
    public void setLab(String lab){this.lab = lab;}
    public void setLec(String lec){this.lec=lec;}
    public String getLec(){return lec;}
    public String getWeekNo(){return weekNo;}


    public static ArrayList<WeekDetail> getWeekDetail(){
        ArrayList<WeekDetail> weekDetails = new ArrayList<>();
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        int weekNo = 1;
        String termWeek = "N/A";
        String lab = "N/A";
        String lec = "N/A";
        LocalDate dateNo = LocalDate.parse("31-12-2018",mdy);

        for(int i=1;i<54;i++){

            if(weekNo==8||weekNo==23||weekNo==38) { termWeek = "1"; lec = "Introduction & Android Fundamentals"; lab = "Android Studio, Git & App Basics";}
            else if(weekNo==9||weekNo==24||weekNo==39) { termWeek = "2"; lec = "Activities, Lifecycle & Intents"; lab = "Activities & Intents";}
            else if(weekNo==10||weekNo==25||weekNo==40) {termWeek = "3"; lec = "Layouts & UI"; lab = "Designing a UI";}
            else if(weekNo==11||weekNo==26||weekNo==41) {termWeek = "4"; lec = "Lists & Adapters"; lab = "Displaying Items in a List";}
            else if(weekNo==12||weekNo==27||weekNo==42) {termWeek = "5"; lec = "Fragments & Multi-layout Apps"; lab = "Fragments for Multi-Layout Apps";}
            else if(weekNo==13||weekNo==28||weekNo==43) {termWeek = "6"; lec = "APIs, Permissions & Libraries"; lab = "APIs & JSON";}
            else if(weekNo==14||weekNo==29||weekNo==44) {termWeek = "7"; lec = "Networking"; lab = "Networking";}
            else if(weekNo==15||weekNo==30||weekNo==45) {termWeek = "8"; lec = "Threads & Async Tasks"; lab = "Async Tasks";}
            else if(weekNo==16||weekNo==31||weekNo==46) {termWeek = "9"; lec = "Data Saving"; lab = "Database";}
            else if(weekNo==17||weekNo==32||weekNo==47) {termWeek = "10"; lec = "Outlook & Course Summary"; lab = "Revision";}
            else {termWeek = "Break"; lec = "N/A"; lab = "N/A";}

            if(weekNo==18){termWeek = "Study";}
            if(weekNo==33||weekNo==48||weekNo==19||weekNo==20||weekNo==34||weekNo==35){termWeek = "Exams";}
            if(weekNo==49||weekNo==50){termWeek = "Exams";}

            if(weekNo>7&&weekNo<18){termWeek = "T1 Week " + termWeek;}
            if(weekNo>22&&weekNo<33){termWeek = "T2 Week " + termWeek;}
            if(weekNo>37&&weekNo<48){termWeek = "T3 Week " + termWeek;}

            weekDetails.add(new WeekDetail(weekNo, termWeek, dateNo, lab, lec));
            weekNo = weekNo + 1;
            dateNo = dateNo.plusWeeks(1);
        }

        return weekDetails;
    }

}
