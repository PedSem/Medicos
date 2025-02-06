package Cita;
//Pedro Guillo
import java.util.Date;

public class Cita {
    protected int ID_cita;
    protected int fecha_cita;
    protected int hora_cita;
    protected String diagnosis;

    public Cita(int ID_cita,int fecha_cita, int hora_cita,String diagnosis) {
        this.ID_cita = ID_cita;
        this.fecha_cita = fecha_cita;
        this.hora_cita = hora_cita;
        this.diagnosis=diagnosis;

    }

    public int getID_cita() {
        return ID_cita;
    }

    public void setID_cita(int ID_cita) {
        this.ID_cita = ID_cita;
    }

    public int getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(int fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public int getHora_cita() {
        return hora_cita;
    }

    public void setHora_cita(int hora_cita) {
        this.hora_cita = hora_cita;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}
