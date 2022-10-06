

import java.util.*;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        List<Pessoa> lista = new ArrayList<>();
        int i = 0;
        lista.add(new Pessoa(++i, "Paulo", 6500, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Pedro Paulo", 5300, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Enzo", 2350, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Joel", 6000, "Arquiteto"));
        lista.add(new Pessoa(++i, "Henrique", 1000, "Estagiário"));
        lista.add(new Pessoa(++i, "Gabriel", 1000, "Estagiário"));
        lista.add(new Pessoa(++i, "Gustavo", 18000, "Diretor"));

        //1- listar todas as pessoas
        lista.stream().
                map(Pessoa::getNome)
                .forEach(System.out::println);
        System.out.println();

        //2- filtrar todas as pessoas com salario maior do que 5 mil (filter)
        List<Pessoa> listaFiltrada = lista.stream()
                .filter(pessoa -> pessoa.getSalario() > 5000)
                .toList();
        System.out.println(listaFiltrada);
        System.out.println();

        //3- filtrar todas as pessoas que são desenvolvedoras e organizar por salário crescente (filter, sorted)
        List<Pessoa> listaFiltradaSalario = lista.stream()
                .filter(pessoa -> pessoa.getCargo().equals("Desenvolvedor"))
                .sorted(Comparator.comparing(Pessoa::getSalario))
                .toList();
        System.out.println(listaFiltradaSalario);
        System.out.println();

        //4- fazer a média salarial de todos
        OptionalDouble average = lista.stream()
                .mapToDouble(Pessoa::getSalario)
                .average();
        System.out.println(average);
        System.out.println();


        //5- verificar na lista (utilizando o método anyMatch) se tem alguém que ganha mais do que 20 mil
        boolean b = lista.stream()
                .anyMatch(pessoa -> pessoa.getSalario() > 20000);
        System.out.println(b);
        System.out.println();

        //6- retornar uma lista de todos os ids das pessoas
        lista.stream().
                map(pessoa -> pessoa.id)
                .forEach(System.out::println);
        System.out.println();

        //7- criar uma nova classe Salario com ID e Salário, utilizando a função "map" do stream, retornar uma lista desse novo objeto
        lista.stream().map(pessoa -> new Salario(pessoa.id, pessoa.salario))
                .toList()
                .forEach(System.out::println);
        System.out.println();

        //8- retornar um HashMap (estrutura de dados, e não uma função map) contendo os ids e os nomes dos colaboradores
        Map<Integer, String> hashMap = lista.stream().
                collect(Collectors.toMap(Pessoa::getId, Pessoa::getNome));
        System.out.println(hashMap);
        System.out.println();

        //9- com o mapa da 8, retornar o nome com o id=2
        System.out.println(hashMap.get(2));
        System.out.println();

        //10- verificar se tem alguém que contenha o nome "Paulo" (containsignorecase) na lista e retornar o primeiro elemento que encontrar (findFirst).
        //    Imprimir o nome e salário dessa pessoa
        Optional<Pessoa> paulo = lista.stream()
                .filter(pessoa -> pessoa.getNome().toLowerCase()
                        .contains("paulo"))
                        .findFirst();
        paulo.ifPresent(pessoa -> System.out.println("Nome : " + pessoa.getNome() +
                "\nSalario : " + pessoa.getSalario()));
    }

    static class Pessoa {
        private int id;
        private String nome;
        private double salario;
        private String cargo;

        public Pessoa(int id, String nome, double salario, String cargo) {
            this.id = id;
            this.nome = nome;
            this.salario = salario;
            this.cargo = cargo;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public double getSalario() {
            return salario;
        }

        public void setSalario(double salario) {
            this.salario = salario;
        }

        public String getCargo() {
            return cargo;
        }

        public void setCargo(String cargo) {
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return "Pessoa{" +
                    "id=" + id +
                    ", nome='" + nome + '\'' +
                    ", salario=" + salario +
                    '}';
        }
    }
}