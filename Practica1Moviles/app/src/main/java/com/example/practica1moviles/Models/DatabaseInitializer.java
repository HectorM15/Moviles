package com.example.practica1moviles.Models;

import java.util.ArrayList;

public class DatabaseInitializer {

    private Questions [] arr_questions = new Questions[5];

    public void initializer(){

        arr_questions[0] = new Questions("¿Cuál de las siguientes tiene más neuronas?",false,0);
        arr_questions[1] = new Questions("¿Cuál fue el primer emperador romano de origen hispano?",false,0);
        arr_questions[2] = new Questions("¿Dónde se produce la respiración celular?",false,0);
        arr_questions[3] = new Questions("¿Cuánto mide el Everest?",false,0);
        arr_questions[4] = new Questions("¿De qué continente son originarios los ornitorrincos?",false,0);

        //PREGUNTA 1
        arr_questions[0].arr_answer[0]= new Answer("Gato",false);
        arr_questions[0].arr_answer[1]= new Answer("Banana",false);
        arr_questions[0].arr_answer[2]= new Answer("Estómago",true);
        arr_questions[0].arr_answer[3]= new Answer("Brazo",false);

        //PREGUNTA 2
        arr_questions[1].arr_answer[0]= new Answer("Julio César",false);
        arr_questions[1].arr_answer[1]= new Answer("Calígula",false);
        arr_questions[1].arr_answer[2]= new Answer("Trajano",true);
        arr_questions[1].arr_answer[3]= new Answer("Tibero Claudio Cesar",false);

        //PREGUNTA 3
        arr_questions[2].arr_answer[0]= new Answer("Lisosoma",false);
        arr_questions[2].arr_answer[1]= new Answer("Vacuolas",false);
        arr_questions[2].arr_answer[2]= new Answer("Ribosomas",false);
        arr_questions[2].arr_answer[3]= new Answer("Mitocondrias",true);

        //PREGUNTA 4
        arr_questions[3].arr_answer[0]= new Answer("8848 metros",true);
        arr_questions[3].arr_answer[1]= new Answer("8488 metros",false);
        arr_questions[3].arr_answer[2]= new Answer("8884 metros",false);
        arr_questions[3].arr_answer[3]= new Answer("9 kilómetros",false);

        //PREGUNTA 5
        arr_questions[4].arr_answer[0]= new Answer("Australia",false);
        arr_questions[4].arr_answer[1]= new Answer("Europa",false);
        arr_questions[4].arr_answer[2]= new Answer("America",false);
        arr_questions[4].arr_answer[3]= new Answer("Africa",true);
    }

    public Questions[] getArr_questions() {
        return arr_questions;
    }

    public void setArr_questions(Questions[] arr_questions) {
        this.arr_questions = arr_questions;
    }
}
