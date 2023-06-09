package Entidad;

//Crear una clase llamada Libro que contenga los siguientes atributos:

import java.util.Scanner;

//ISBN, Título, Autor, Número de páginas

public class Libro {
    
    Scanner sc = new Scanner(System.in);
    
    private long isbn;
    private String titulo;
    private String autor;
    private int pp;
//    private String item;

//y un constructor con todos los
//atributos pasados por parámetro y un constructor vacío.

    public Libro(long isbn, String titulo, String autor, int pp) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.pp = pp;
    }
    

//public Libro(){
//    
//}

//Crear un método para cargar un libro pidiendo los datos al usuario y luego
//informar mediante otro método el número de ISBN, el título, el autor del
//libro y el número de páginas.

        // Creo getters y setters acá y el método en el main.

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }
    
//    public void setItem(String item){
        
//    }

    @Override
    public String toString() {
        return "Libro isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", pp=" + pp + '}';
    }



    

}

