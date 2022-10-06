public class Salario {
    private int id;
    private double salario;

    public Salario(int id, double salario) {
        this.id = id;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Salario{" +
                "id=" + id +
                ", salario=" + salario +
                '}';
    }
}
