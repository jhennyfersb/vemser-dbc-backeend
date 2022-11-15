
db.createCollection("alunos")

db.alunos.insert(
    {
        "nome" : "Paulo santos", 
        "data_nascimento" : new Date (1992,06,27)
    }
)
db.alunos.insert(
    {
        "nome" :  "Marcus Antunius", 
        "data_nascimento" :new Date(1995,11,01)
    }
)
db.alunos.insert(
    {
        "nome" : "Cassia Sobrinho",
        "data_nascimento" :new Date(1995,11,01)
    }
)
db.alunos.insert(
    {
        "nome" : "Jhennyfer Sobrinho",
	"data_nascimento" :new Date(1995,12,06)
    }
)

db.alunos.find({})

db.alunos.find(
    { 
      "nome" : "Jhennyfer Sobrinho"
    }
    ).pretty()
    
    db.alunos.find({
        "nome" : "Cassia Sobrinho"
    }
    ).pretty()   