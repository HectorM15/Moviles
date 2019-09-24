package com.example.practica1moviles.Models;

public class Answer {
    private String ds_answer;
    private Boolean it_correct;
    private int img;

    public Answer(String ds_answer, Boolean it_correct) {
        this.ds_answer = ds_answer;
        this.it_correct = it_correct;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDs_answer() {
        return ds_answer;
    }

    public void setDs_answer(String ds_answer) {
        this.ds_answer = ds_answer;
    }

    public Boolean getIt_correct() {
        return it_correct;
    }

    public void setIt_correct(Boolean it_correct) {
        this.it_correct = it_correct;
    }
}
