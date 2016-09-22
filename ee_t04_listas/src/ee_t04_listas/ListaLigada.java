/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee_t04_listas;

/**
 *
 * @author JUAN ANTONIO JUAREZ OLIVERA
 */
public class ListaLigada<T extends Comparable<T>>{
	
    private Nodo<T> inicio;
       
    public ListaLigada(){
    	inicio = null;
    }
    public Nodo<T> getInicio(){
        return inicio;
    }
    
    //))METODOS DE LA CLASE J
    public void insertarInicio(T dato){
        Nodo<T> nuevo = new Nodo<T>(dato);
        nuevo.setSiguiente(inicio);
        inicio = nuevo;
    }
    
    public void insertarFinal(T dato){
        Nodo<T> tempo = inicio;
        if(inicio == null)
           insertarInicio(dato);
        else{
             while(tempo.getSiguiente() != null)
                   tempo = tempo.getSiguiente();
             tempo.setSiguiente(new Nodo<T>(dato));
        }        
    }
   public void insertarAntesDe(T dato, T referencia) {
        boolean band=true;
        Nodo<T> tempo, buscado;
        tempo=inicio;
        buscado=tempo;
                     
           while( (tempo.getDato()!= referencia)&&band) {
               if(tempo.getSiguiente()!=null){
                   buscado=tempo;
                   tempo=tempo.getSiguiente();
                }else{
                    band=false;
                }
              
           }
           
          
           if(band){
               if(tempo==inicio){
                   insertarInicio(dato);
                }else{
                    Nodo<T> nuevo=new Nodo (dato);
                    nuevo.setSiguiente(tempo);
                    buscado.setSiguiente(nuevo);
                    System.out.println ("se agrego antes de : "+referencia);
                }
            }
          
    }
   
   public void insertarDespuesDe(T dato, T referencia){
    Nodo<T> tempo, nuevo;
    boolean band=true;
    tempo=inicio;
    while( tempo.getDato()!=referencia && band){
    if(tempo.getSiguiente()!=null){
    tempo=tempo.getSiguiente();
    }
    
    else{
    band=false;    
    }
    }
    if(band){
    if(tempo==inicio){
    
    }
    
    else{
        
     nuevo= new Nodo(dato);
     nuevo.setSiguiente(tempo.getSiguiente());
     tempo.setSiguiente(nuevo);
    }
    }
    } 
    
    public void eliminaElemento(T dato){
   Nodo tempo, ini, nuevo=null;
   boolean band;
   ini=inicio;
   tempo=inicio;
   band=true;
   while(tempo.getDato()!=dato && band==true){
    if(tempo.getSiguiente()!=null){
    nuevo=tempo;
    tempo=tempo.getSiguiente();
    }
    else{
    band=false;
    }
    }
    if(band==false){
    System.out.println("El elemento no se encuentra en tu lista");
    }
   else{
    if(ini==tempo){
    inicio=tempo.getSiguiente();
    }
    else{
    nuevo.setSiguiente(tempo.getSiguiente());
    }
    nuevo.setSiguiente(tempo.getSiguiente());
    }
    
    } 
    public void eliminarAntesDe(T referencia){
    Nodo tempo, anterior, nuevo;
    boolean band=true;
    tempo=inicio;
    nuevo=tempo;
    anterior=null;
    while(tempo.getDato()!=referencia && band){
    if(tempo.getSiguiente()!=null){
    anterior=tempo;
    tempo=tempo.getSiguiente();
    }
    else{
    band=false;
    }
    
    }
    if(band){
    if(tempo==inicio){
    
    }
    else{
    nuevo.setSiguiente(tempo);
    tempo=null;
    anterior.setSiguiente(nuevo);
    
       }
    }
   }
    
    
     public void eliminaPrimero(){
    Nodo tempo=inicio;
    if(tempo.getSiguiente()!=null){
    inicio=tempo.getSiguiente();
    }
    else{
    inicio=null;
    }
   } 
     
     public void eliminaUltimo(){
    Nodo tempo, ante=null ;
    tempo=inicio;
    
    if(inicio.getSiguiente()==null){
    inicio=null;
    }
    else{
    while(tempo.getSiguiente()!=null){
    ante=tempo;
    tempo=tempo.getSiguiente();
    }
    ante.setSiguiente(null);    
    }
    } 
  public void busquedaDesordenada (T dato){
    Nodo tempo;
    tempo=inicio;
    while(tempo!=null && tempo.getDato()!=dato){
    tempo=tempo.getSiguiente();
    }
    if(tempo==null){
    System.out.println("El elemento no se encuentra en la lista");;
    
    }
    else{
    System.out.println("El elemento ha sido encontrado");
    }
    }
  
  public void busquedaRecursiva(T dato){
    Nodo tempo;
    tempo=inicio;
    if(tempo!=null){
   if(tempo.getDato()==dato){ 
    System.out.println("El elemento si se encuentra en la lista");
    }
   else{
    busquedaRecursiva(dato);
    tempo=tempo.getSiguiente();
    } 
   }
   else{
    System.out.println("El elemento no se encuentra en la lista");
    }
   }
  
  public void recorreRecursivo(Nodo<T> aux){
		
if (aux != null){
		 
 System.out.println(aux.getDato());
		
  recorreRecursivo(aux.getSiguiente());
		
}
}
  
  public void recorreIterativo(){
        Nodo<T> tempo=inicio;
        if(inicio==null)
           System.out.println ("No esta vacio");
           else {
               System.out.println ("Los elementos de la lista son:");
               while (tempo!=null){
                   System.out.print("["+tempo.getDato ()+"]-> ");
                   tempo=tempo.getSiguiente();
                }
                System.out.println ("\n");
            }
           
    }

  public void insertaOrdenado(T d){
        Nodo<T>tempo,nodoencontrado=null,nuevo; 
        boolean band=true;
        tempo=inicio;

        if(inicio==null){
            insertarInicio(d);
        }else{
            while(d.compareTo(tempo.getDato())==1&& band){
                if(tempo.getSiguiente()!=null){
                    nodoencontrado=tempo;
                    tempo=tempo.getSiguiente();
                }else{
                    band=false;
                }
            }
            if(band){
                if(tempo==inicio){
                    insertarInicio(d);
                }else{
                    nuevo=new Nodo(d);
                    nuevo.setSiguiente(tempo);
                    nodoencontrado.setSiguiente(nuevo);
                }

            }else{
                insertarFinal(d);
            }
        }
    }	
    
}


    
  
    


