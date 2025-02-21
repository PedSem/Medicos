package Cita;
//Pedro Guillo
import java.util.Date;
import java.util.Objects;

public class Cita {
    protected int ID_cita;
    protected Date fecha_cita;
    protected int hora_cita;
    protected String diagnosis;

    public Cita(int ID_cita, Date fecha_cita, int hora_cita, String diagnosis) {
        this.ID_cita = ID_cita;
        this.fecha_cita = fecha_cita;
        this.hora_cita = hora_cita;
        this.diagnosis=diagnosis;
    }

    public int getID_cita() {
        return ID_cita;
    }

    public Date getFecha_cita() {
        return fecha_cita;
    }
    public int getHora_cita() {
        return hora_cita;
    }
    public String getDiagnosis() {
        return diagnosis;
    }
    public static Cita createCita(int ID_cita,Date Fecha_cita,int hora_cita,String diagnosis){
        return new Cita(ID_cita,Fecha_cita,hora_cita,diagnosis);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cita cita  = (Cita) o;
        return ID_cita == cita.ID_cita;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID_cita, fecha_cita, hora_cita, diagnosis);
    }
}
