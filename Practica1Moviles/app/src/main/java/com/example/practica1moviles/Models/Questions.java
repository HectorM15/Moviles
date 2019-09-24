package com.example.practica1moviles.Models;

public class Questions {

    private String ds_question;
    private Boolean it_answered;
    private Integer nm_puntuacion;
    private Boolean has_img;

    public Answer [] arr_answer;

    public Questions(String ds_question, Boolean it_answered, Integer nm_puntuacion, Boolean has_img) {
        this.ds_question = ds_question;
        this.it_answered = it_answered;
        this.nm_puntuacion = nm_puntuacion;
        this.has_img = has_img;
        this.arr_answer = new Answer[4];
    }

    public String getDs_question() {
        return ds_question;
    }

    public void setDs_question(String ds_question) {
        this.ds_question = ds_question;
    }

    public Boolean getIt_answered() {
        return it_answered;
    }

    public void setIt_answered(Boolean it_answered) {
        this.it_answered = it_answered;
    }

    public Integer getNm_puntuacion() {
        return nm_puntuacion;
    }

    public void setNm_puntuacion(Integer nm_puntuacion) {
        this.nm_puntuacion = nm_puntuacion;
    }
}
