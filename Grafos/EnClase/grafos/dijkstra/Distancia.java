package grafos.dijkstra;

public class Distancia implements Comparable<Distancia>{
    private String vertice;
    private Double distancia;
    
    public Distancia(String vertice, Double distance) {
        this.vertice = vertice;
        this.distancia = distance;
    }
    
    public String getVertice() {
        return vertice;
    }
    public Double getDistancia() {
        return distancia;
    }
    @Override
    public int compareTo(Distancia o) {
        return distancia.compareTo(o.getDistancia());
    }
}
