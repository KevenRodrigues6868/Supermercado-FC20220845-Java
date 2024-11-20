public abstract class Produto {
    String name;
    int codigo;
    float valor;
    
    // Ajuste para calcular o valor
    public float calcValor() {
        return valor;
    }
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + name + " R$ " + valor;
    }
}
