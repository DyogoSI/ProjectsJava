/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author dyogo
 */
public class Pilha<T> {
    private int topo;
    private T[] elementos;
    
    public Pilha(int tamanho){
          elementos =(T[]) new Object[tamanho];
          this.topo = -1;
    }
    public boolean isFull(){
        return topo==elementos.length-1;
        /*if(topo==elementos.length-1)
            return true;
        return false; */
    }
    public boolean isEmpty(){
        // return this.topo==-1;
        if(this.topo==-1)
            return true;
        return false;
    }
    public boolean push(T novoDado){
        if(!this.isFull()){
            //this.topo++;
            elementos[++topo] = novoDado;
            return true;
        }// fim if
        return false;
    }// fim push
    public T pop(){
        T retorno = elementos[topo];
        topo--;
        return retorno;
        //return elementos[topo--];
    }// fim pop
    public int size(){
        return topo+1;
    }
    
    public T peek(){
        return elementos[topo];
    }
    
    @Override
    public String toString(){
        StringBuilder retorno = new StringBuilder();
        for(int i=topo;i>=0;i--)
            retorno.append(elementos[i] + "\n");
        retorno.append("-----------");
        return retorno.toString();
    }
    
    
}



