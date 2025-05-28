package modeloExamenOrdinariaColecciones;

public class Encuesta {
    private String pregunta;
    private String respuesta;
    private double puntuacion; // 1.0 … 5.0
    private String comentario;

    public Encuesta(String pregunta, String respuesta, double puntuacion, String comentario) {
        this.pregunta   = pregunta;
        this.respuesta  = respuesta;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
    }

    // getters y setters
    public String getPregunta()    { return pregunta; }
    public String getRespuesta()   { return respuesta; }
    public double getPuntuacion()  { return puntuacion; }
    public String getComentario()  { return comentario; }
    public void setPregunta(String pregunta)       { this.pregunta = pregunta; }
    public void setRespuesta(String respuesta)     { this.respuesta = respuesta; }
    public void setPuntuacion(double puntuacion)   { this.puntuacion = puntuacion; }
    public void setComentario(String comentario)   { this.comentario = comentario; }

    @Override
    public String toString() {
        return "Encuesta[preg=" + pregunta
            + ", resp=" + respuesta
            + ", punt=" + puntuacion
            + ", com="  + comentario + "]";
    }
}
