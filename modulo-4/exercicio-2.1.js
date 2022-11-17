db.alunos.insert(
    {
        "nome" :  "Pedro Santos", 
        "data_nascimento" :new Date(1999,04,12)
    },
    {
        "nome" :  "Jessica Santos", 
        "data_nascimento" :new Date(1994,08,02)
    }
    ,
    {
        "nome" :  "Julia Serena", 
        "data_nascimento" :new Date(1999,04,12)
    }
)

db.alunos.deleteOne( { nome: "Julia Serena"} )

db.alunos.updateOne(
    { nome: "Pedro Santos" },
    {
      $set: { "nome": "Pedro",  "data_nascimento" :new Date(1994,08,02)
     }           
    }
 )
 db.alunos.find({"data_nascimento" : {$eq :new Date('1996-01-06T02:00:00.000Z')}})

 db.alunos.insertMany([
    { "_id" : 1, "nome" : "aaa", "ativo" : "ID" },
    { "_id" : 2, "nome" : "bbb", "desativado" : "ID" },
    { "_id" : 3, "nome" : "fff", "ativo" : "ID" },
    { "_id" : 4, "nome" : "eee", "desativado" : "ID" },
    { "_id" : 5, "nome" : "ddd", "ativo" : "ID" }
    ])
db.alunos.find({ ativo: "ID" }).sort( { nome: -1, _id : 1 } )  
db.alunos.find({ desativado: "ID" }).sort( { nome: -1, _id : 1 } )  
db.alunos.find({ desativado: "ID" }).sort( { id: -1 } ) 

