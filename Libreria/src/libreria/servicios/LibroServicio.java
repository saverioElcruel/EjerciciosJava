
package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.persistencia.DAOLibro;
import libreria.persistencia.DAOAutor;
import libreria.persistencia.DAOEditorial;

public class LibroServicio {
    
    private final DAOLibro DAO;
    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    
    public LibroServicio(){
        this.DAO = new DAOLibro();
    }
    
    public void crearLibro() throws Exception{
        Libro codice = new Libro();
        System.out.println("ISBN:");
        long isbn = sc.nextLong();
        
        // Validación del ISBN. Que no exista en la base de datos
        long anterior = 0;
        try{
            anterior = DAO.buscarPorISBN(isbn).getIsbn();
        }catch(Exception e){
            System.out.println("Ningún libro cargado aún con este ISBN");
        }
        
        if(isbn==anterior){
            System.out.println("Un libro con este ISBN ya fue cargado. El libro es " + DAO.buscarPorISBN(isbn).getIsbn());
            crearLibro();
        }else{
            codice.setIsbn(isbn);
        }
        
        System.out.println("Título:");
        String titulo = sc.next();
        codice.setTitulo(titulo);
        System.out.println("Año:");
        Integer anio = sc.nextInt();
        codice.setAnio(anio);
        System.out.println("Ejemplares:");
        Integer ejemplares = sc.nextInt();
        codice.setEjemplares(ejemplares);
        
        // Listar autores existentes y preguntar si está en la lista
        // Ir al AutorServicios y llamar al método listarAutores desde ahí
        AutorServicio representante = new AutorServicio();
        Autor autor = new Autor();
        int contador = 1;
        System.out.println("Seleccione el autor de la lista");
        System.out.println("Ingrese 0 (cero) para ingresar un nuevo autor");
        for (Autor escritor : representante.listarAutores()) {
            System.out.println("("+contador+")"+escritor.getNombre());
            contador++;
        }
        System.out.println("(0) Otro");
        int opcion = sc.nextInt();
        if(opcion==0){
            System.out.println("Nombre y apellido del/a autor/a:");
            String nombreAutor = sc.next();
            autor.setNombre(nombreAutor);
            autor.setAlta(true);
            representante.cargarAutor(autor);
            codice.setAutor(autor);
        }else{
            autor = representante.buscarPorNombre(representante.listarAutores().get(opcion-1).getNombre());
            codice.setAutor(autor);
        }
        
        // Listar editoriales
        EditorialServicio editor = new EditorialServicio();
        Editorial editorial = new Editorial();
        int contadorx = 1;
        System.out.println("Seleccione la editorial de la lista");
        System.out.println("Ingrese 0 (cero) para ingresar una nueva editorial");
        for (Editorial editoriale : editor.listarEditoriales()) {
             System.out.println("("+contador+")"+editoriale.getNombre());
             contador++;
        }
        System.out.println("(0) Otra");
       int opcione = sc.nextInt();
        if(opcione==0){
            System.out.println("Nombre de la editorial:");
            String nombreEditorial = sc.next();
            editorial.setNombre(nombreEditorial);
            editorial.setAlta(true);
            editor.crearEditoriale(editorial);
            codice.setEditorial(editorial);
        }else{
            editorial = editor.buscarPorNombre(editor.listarEditoriales().get(opcion-1).getNombre());
            codice.setEditorial(editorial);
        }
       
        
        Boolean activo = true;
        codice.setAlta(activo);
        DAO.guardar(codice);
        
        
    }
    /*
        En este proyecto vamos a eliminar entidades, pero no es considerado una buena
        práctica. Por esto, además de eliminar nuestras entidades, vamos a practicar que nuestras
        entidades estén dadas de alta o de baja. Por lo que las entidades tendrán un atributo “activo”
        de tipo booleano, que estará en true al momento de crearlas y en false cuando las demos de
        baja, para evitar eliminarlas de la base de datos.
    */
    
    // 7) Crear los métodos para dar de alta/bajo o editar dichas entidades.
    public void darDeBajaLibro(Libro broli){
        broli.setAlta(Boolean.FALSE);
    }
     public void darDeAltaEditorial(Libro broli){
        broli.setAlta(Boolean.TRUE);
    }
    
}
