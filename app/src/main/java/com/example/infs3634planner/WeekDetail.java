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
    public String getLab(){return lab;}
    public void setLab(String lab){this.lab = lab;}
    public void setLec(String lec){this.lec=lec;}
    public String getLec(){return lec;}
    public String getWeekNo(){return weekNo;}
    public String getDateString(){
        DateTimeFormatter md = DateTimeFormatter.ofPattern("dd MMM");
        String s = this.date.format(md);
        return s;}
    public String getDateEnd(){
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("dd MMM");
        LocalDate end = this.date.plusDays(6);
        String s = end.format(mdy);
        return s;
    }


    public static ArrayList<WeekDetail> getWeekDetail(){
        ArrayList<WeekDetail> weekDetails = new ArrayList<>();
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        int week = 1;
        String weekNo = "N/A";
        String lab = "N/A";
        String lec = "N/A";
        LocalDate date = LocalDate.parse("31-12-2018",mdy);

        for(int i=1;i<54;i++){

            if(week==8||week==23||week==38) { weekNo = "1"; lec = "Introduction & Android Fundamentals"; lab = "Android Studio, Git & App Basics";}
            else if(week==9||week==24||week==39) { weekNo = "2"; lec = "Activities, Lifecycle & Intents"; lab = "Activities & Intents";}
            else if(week==10||week==25||week==40) {weekNo = "3"; lec = "Layouts & UI"; lab = "Designing a UI";}
            else if(week==11||week==26||week==41) {weekNo = "4"; lec = "Lists & Adapters"; lab = "Displaying Items in a List";}
            else if(week==12||week==27||week==42) {weekNo = "5"; lec = "Fragments & Multi-layout Apps"; lab = "Fragments for Multi-Layout Apps";}
            else if(week==13||week==28||week==43) {weekNo = "6"; lec = "APIs, Permissions & Libraries"; lab = "APIs & JSON";}
            else if(week==14||week==29||week==44) {weekNo = "7"; lec = "Networking"; lab = "Networking";}
            else if(week==15||week==30||week==45) {weekNo = "8"; lec = "Threads & Async Tasks"; lab = "Async Tasks";}
            else if(week==16||week==31||week==46) {weekNo = "9"; lec = "Data Saving"; lab = "Database";}
            else if(week==17||week==32||week==47) {weekNo = "10"; lec = "Outlook & Course Summary"; lab = "Revision";}
            else {weekNo = "Break"; lab="N/A"; lec="N/A";}

            if(week==18){weekNo = "Study";}
            if(week==33||week==48||week==19||week==20||week==34||week==35){weekNo = "Exams";}
            if(week==49||week==50){weekNo = "Exams";}

            if(week>7&&week<18){weekNo = "T1 Week " + weekNo;}
            if(week>22&&week<33){weekNo = "T2 Week " + weekNo;}
            if(week>37&&week<48){weekNo = "T3 Week " + weekNo;}

            weekDetails.add(new WeekDetail(week, weekNo, date, lab, lec));
            week = week + 1;
            date = date.plusWeeks(1);
        }

        return weekDetails;
    }

}
