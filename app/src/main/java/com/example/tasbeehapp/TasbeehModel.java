package com.example.tasbeehapp;

public class TasbeehModel  {
    private int Id;
    private String today_date;
    private int Kalma_Count;
    private  int Darood_Count;
    private int Astgfar_Count;


    public TasbeehModel(String today_date, int kalma_Count, int darood_Count, int astgfar_Count) {
        this.today_date = today_date;
        Kalma_Count = kalma_Count;
        Darood_Count = darood_Count;
        Astgfar_Count = astgfar_Count;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getToday_date() {
        return today_date;
    }

    public void setToday_date(String today_date) {
        this.today_date = today_date;
    }

    public int getKalma_Count() {
        return Kalma_Count;
    }

    public void setKalma_Count(int kalma_Count) {
        Kalma_Count = kalma_Count;
    }

    public int getDarood_Count() {
        return Darood_Count;
    }

    public void setDarood_Count(int darood_Count) {
        Darood_Count = darood_Count;
    }

    public int getAstgfar_Count() {
        return Astgfar_Count;
    }

    public void setAstgfar_Count(int astgfar_Count) {
        Astgfar_Count = astgfar_Count;
    }
}
