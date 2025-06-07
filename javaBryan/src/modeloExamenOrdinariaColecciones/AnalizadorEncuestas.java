package modeloExamenOrdinariaColecciones;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class AnalizadorEncuestas {
    // 1) Mapa pregunta → (respuesta → conteo)
    private HashMap<String, HashMap<String, Integer>> conteosPorRespuesta;
    // 2) Mapa puntuación → lista de comentarios
    private TreeMap<Double, ArrayList<String>> comentariosPorPuntuacion;
    // Nuevo: Mapa pregunta → lista de puntuaciones
    private HashMap<String, ArrayList<Double>> puntuacionesPorPregunta;

    public AnalizadorEncuestas() {
        conteosPorRespuesta       = new HashMap<>();
        comentariosPorPuntuacion  = new TreeMap<>();
        puntuacionesPorPregunta   = new HashMap<>();
    }

    /** 1) Agrega una encuesta:
     *   – Incrementa el conteo de respuesta para la pregunta
     *   – Guarda comentario en el map por puntuación
     *   – Guarda la puntuación para luego poder calcular la media */
    public void agregar(Encuesta e) {
        // —— conteosPorRespuesta ——
        String preg = e.getPregunta();
        String resp = e.getRespuesta();
        // si no hay mapa para esta pregunta, créalo
        if (!conteosPorRespuesta.containsKey(preg)) {
            conteosPorRespuesta.put(preg, new HashMap<>());
        }
        Map<String,Integer> mapaResp = conteosPorRespuesta.get(preg);
        // suma 1 al contador de esta respuesta
        mapaResp.put(resp, mapaResp.getOrDefault(resp, 0) + 1);

        // —— comentariosPorPuntuacion ——
        double p = e.getPuntuacion();
        comentariosPorPuntuacion
            .computeIfAbsent(p, k -> new ArrayList<>())
            .add(e.getComentario());

        // —— puntuacionesPorPregunta ——
        puntuacionesPorPregunta
            .computeIfAbsent(preg, k -> new ArrayList<>())
            .add(p);
    }

    /** 2) Devuelve conteos de respuestas para una pregunta (o vacío) */
    public Map<String,Integer> getConteos(String pregunta) {
        Map<String,Integer> m = conteosPorRespuesta.get(pregunta);
        if (m == null) {
            return new HashMap<>();
        }
        // devolvemos copia para no exponer el interno
        return new HashMap<>(m);
    }

    /** 3) Comentarios cuyas puntuaciones estén entre minP y maxP (ambos inclusive) */
    public List<String> comentariosDe(double minP, double maxP) {
        SortedMap<Double,ArrayList<String>> sub = 
            comentariosPorPuntuacion.subMap(minP, true, maxP, true);
        List<String> resultado = new ArrayList<>();
        for (ArrayList<String> lista : sub.values()) {
            resultado.addAll(lista);
        }
        return resultado;
    }

    /** 4) Conjunto ordenado de todas las preguntas */
    public Set<String> preguntas() {
        return new TreeSet<>(conteosPorRespuesta.keySet());
    }

    /** 5) Calcula la puntuación media para una pregunta */
    public double puntuacionMedia(String pregunta) {
        List<Double> lista = puntuacionesPorPregunta.get(pregunta);
        if (lista == null || lista.isEmpty()) {
            return 0;
        }
        double suma = 0;
        for (Double v : lista) {
            suma += v;
        }
        return suma / lista.size();
    }
}
