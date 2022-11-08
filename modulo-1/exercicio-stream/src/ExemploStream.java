

import java.util.ArrayList;
import java.util.List;

public class ExemploStream {

        public static void main(String[] args) {
//        Pessoa maicon = new Pessoa(1, "Maicon", 20000);
//        System.out.println(maicon);

            List<Pessoa1> lista = new ArrayList<>();
            lista.add(new Pessoa1(1, "Maicon", 50000));
            lista.add(new Pessoa1(2, "Pedro", 53000));
            lista.add(new Pessoa1(3, "Joel", 60000));
//        System.out.println(lista);

//        for(Pessoa p : lista){
//            System.out.println(p);
//        }
//        lista.stream()
//                .forEach(pessoa -> {
//                    // sout
//                    System.out.println(pessoa);
//                });
//        lista.stream()
//                .forEach(System.out::println);
//        lista.stream()
//                .forEach(pessoa -> System.out.println(pessoa));

            List<Pessoa1> listaFiltrada = lista.stream()
                    .filter(pessoa -> pessoa.getId() >= 2)
                    .toList();
            System.out.println(lista);
            System.out.println(listaFiltrada);

//        List<Pessoa> listaFiltrada2 = lista.stream()
//                .filter(pessoa -> pessoa.getId() >= 2)
////                .sorted((p1, p2) -> p1.getNome().compareTo(p2.getNome()))
//                .sorted(Comparator.comparing(Pessoa::getNome))
//                .toList();
//        System.out.println(listaFiltrada2);

//        List<PessoaNomeId> listaFiltrada3 = lista.stream()
//                .filter(pessoa -> pessoa.getId() >= 2)
////                .sorted((p1, p2) -> p1.getNome().compareTo(p2.getNome()))
//                .sorted(Comparator.comparing(Pessoa::getNome))
//                .map(pessoa -> { // transformação de valores....
//                    // retorne uma pessoa com nome e id....
//                    return new PessoaNomeId(pessoa.getId(), pessoa.getNome());
//                })
//                .toList();
//        System.out.println(listaFiltrada3);


//        Double media = lista.stream()
//                .mapToDouble(Pessoa::getSalario)
//                .average()
//                .getAsDouble();
//        System.out.println(media);
//
//        boolean todosGanham5000 = lista.stream()
//                .allMatch(pessoa -> pessoa.getSalario() > 5000); // todos os meus registros atendem essa condição
//        System.out.println(todosGanham5000);
//
//        boolean alguemGanha = lista.stream()
//                .anyMatch(pessoa -> pessoa.getSalario() >= 60000);
//        System.out.println(alguemGanha);
//
//        Map<Integer,String> meuMapaDePessoasPorId = lista.stream()
//                .collect(Collectors.toMap(Pessoa::getId, Pessoa::getNome));
//        System.out.println(meuMapaDePessoasPorId);

//        Optional<Pessoa> possivelPessoa = lista.stream()
//                .filter(pessoa -> pessoa.getSalario() > 60000)
//                .findFirst();
//
//        System.out.println(possivelPessoa);
//        System.out.println(possivelPessoa.isPresent());
//        System.out.println(possivelPessoa.isEmpty());
//        System.out.println(possivelPessoa.orElse(new Pessoa(999, "João", 1000)));
//        if (possivelPessoa.isPresent()) {
//            System.out.println(possivelPessoa.get());
//        }

            List<Pessoa1> minhaLista = lista.stream()
                    .peek(System.out::println)
                    .toList();
        }
    }

