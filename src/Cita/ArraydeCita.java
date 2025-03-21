package Cita;
//Pedro Guillo

import java.util.ArrayList;
public class ArraydeCita {
    protected ArrayList<Cita>citas;

    public ArraydeCita() {
        this.citas=new ArrayList<>();
    }
    private  int findCita(Cita cita){
        int index= citas.indexOf(cita);
        return index;
    }
    private int findCita(int ID_cita){
        for(int i = 0; i< citas.size(); i++){
            if(citas.get(i).getID_cita()==ID_cita){
                return i;
            }
        }
        return -1;

    }

    public  boolean addNewCita(Cita cita){
        int index=findCita(cita);
        if(index==-1){
            citas.add(cita);
            return true;
        }else{
            return false;
        }
    }
    public  Cita queryCita(int ID_cita){
        int index=findCita(ID_cita);
        if(index>=0){
            return citas.get(index);
        }else{
            return null;
        }
    }
    public  boolean removeCita(Cita cita){
        int index=findCita(cita);
        if(index>=0){
            citas.remove(index);
            return true;
        }else{
            return false;
        }

    }
    public  boolean updatecita(Cita citanueva, Cita citaantigua){
        int index=findCita(citaantigua);
        if(index>=0){
            citas.set(index,citanueva);
            return true;
        }else{
            return false;
        }
    }
    public  void printcita(){
        System.out.println("Tenemos " + citas.size() + " elementos en el arraylist");
        for(int i = 0; i< citas.size(); i++){
            System.out.print((i+1) + ".");
            System.out.println("ID_cita:" + citas.get(i).getID_cita() + " Fecha_cita " + citas.get(i).getFecha_cita() + " Hora_cita " + citas.get(i).getHora_cita() + " Diagnosis " + citas.get(i).getDiagnosis());
        }

    }
    public void printXML(){
        if(citas.isEmpty()){
            System.out.println("No hay ninguna cita disponible");
        }else{
            System.out.println("<CITAS>");
            for(int i=0;i<citas.size();i++){
                System.out.println("<CITA>");
                System.out.println("<ID_cita>" + citas.get(i).getID_cita() + "</ID_cita>");
                System.out.println("<fecha_cita>" + citas.get(i).getFecha_cita() + "</fecha_cita>");
                System.out.println("<hora_cita>" + citas.get(i).getHora_cita() + "</hora_cita>");
                System.out.println("<ID_Consulta>" + citas.get(i).getDiagnosis() + "</ID_Consulta>");
                System.out.println("</CITA>");
                System.out.println();
            }
            System.out.println("</CITAS>");
        }
    }
}

