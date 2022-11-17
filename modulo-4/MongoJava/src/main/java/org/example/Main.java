package org.example;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.match;

public class Main {
    public static void main(String[] args) {
        String uri = "mongodb://root:root@localhost:27017/?authSource=admin&readPreference=primary&directConnection=true&ssl=false";
        MongoClient mongoClient = MongoClients.create(uri);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("vemserdbc");

        MongoCollection<Document> alunos = mongoDatabase.getCollection("alunos");
        MongoCollection<Document> orders = mongoDatabase.getCollection("orders");

        Document novoAluno = new Document("nome", "Rafael")
                //.append("_id", 4)
                .append("data_nascimento", new Date(2003, 10, 10))
                .append("curso", new Document("nome", "Historia"))
                .append("notas", Arrays.asList(10, 9, 8))
                .append("habilidades", Arrays.asList(new Document()
                                .append("nome", "Ingles ")
                                .append("nível", "Básico"),
                        new Document()
                                .append("nome", "Espanhol")
                                .append("nível", "Básico")));

        Document novoAluno1 = new Document("nome", "Ana")
                .append("data_nascimento", new Date(1993, 02, 12))
                .append("curso", new Document("nome", "Arquitetura"))
                .append("notas", Arrays.asList(7, 9, 8))
                .append("habilidades", Arrays.asList(new Document()
                        .append("nome", "Ingles ")
                        .append("nível", "Básico")
                        .append("habilidades", Arrays.asList(new Document()
                                        .append("nome", "AutoCad ")
                                        .append("nível", "Básico"),
                                new Document()
                                        .append("nome", "Espanhol")
                                        .append("nível", "Básico")))));

        Document novoAluno2 = new Document("nome", "Gabriel")
                .append("data_nascimento", new Date(1998, 12, 18))
                .append("curso", new Document("nome", "Fisica"))
                .append("notas", Arrays.asList(9, 9, 8))
                .append("habilidades", Arrays.asList(new Document()
                        .append("nome", "Ingles ")
                        .append("nível", "Básico")
                        .append("habilidades", Arrays.asList(new Document()
                                        .append("nome", "Fisica estatica")
                                        .append("nível", "Básico"),
                                new Document()
                                        .append("nome", "Espanhol")
                                        .append("nível", "Básico")))));

        List<Document> alunosNovos = new ArrayList<>();
        alunosNovos.add(novoAluno);
        alunosNovos.add(novoAluno1);
        alunosNovos.add(novoAluno2);
        alunos.insertMany(alunosNovos);

        System.out.println("-- Aluno");
        Document aluno = alunos.find(new Document("nome", "Ana"))
                .first();
        System.out.println(aluno);

        System.out.println("-- Aluno");
        Document aluno1 = alunos.find(new Document("nome", "Gabriel"))
                .first();
        System.out.println(aluno1);

        System.out.println("-- Cursos");
        alunos.aggregate(Arrays.asList(
                match(Filters.empty()),
                group("$curso.nome", Accumulators.sum("qtd", 1))))
                .forEach(doc -> System.out.println(doc.toJson()));

        System.out.println("-- Notas");
        alunos.aggregate(Arrays.asList(
                        match(Filters.empty()),
                        group("notas.nome", Accumulators.sum("qtd", 1))))
                .forEach(doc -> System.out.println(doc.toJson()));

        System.out.println("-- Habilidades");
        alunos.aggregate(Arrays.asList(
                        match(Filters.empty()),
                        group("habilidades.nome", Accumulators.sum("qtd", 1))))
                .forEach(doc -> System.out.println(doc.toJson()));

        alunos.updateOne(Filters.eq("nome","Gabriel"),
        new Document("$set", new Document("data_nascimento",new Date(1995,06,11))));

        alunos.updateOne(Filters.eq("nome","Gabriel"),
                new Document("$set", new Document("nome",("Gabriela"))));

        alunos.updateOne(Filters.eq("nome","Gabriel"),
                new Document("$set", new Document("habilidades",("pontos fortes"))));

        alunos.deleteOne(Filters.eq("nome","Gabriel"));
        alunos.deleteOne(Filters.eq("nome","Rafael"));
        alunos.deleteOne(Filters.eq("curso",new Document("nome", "Arquitetura")));
        //alunos.deleteOne(Filters.eq("nome", "Gabriel"), ("habilidades","Fisica estatica");
    }
}