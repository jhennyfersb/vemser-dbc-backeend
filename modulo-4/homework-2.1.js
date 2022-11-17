db.createCollection("locacoes")
db.locacoes.insert(
    {
      "dataLocacao": "2023-03-05",
      "dataDevolucao": "2023-03-10",
      "valorLocacao": 1100,
      "clienteEntity": {
        "nome": "Thiago",
        "cpf": "85226595885",
        "idCliente": 1
      },
      "veiculoEntity": {
        "marca": "Honda",
        "modelo": "Civic",
        "cor": "Preto",
        "ano": 2019,
        "quilometragem": 250000,
        "valorLocacao": 220,
        "placa": "APT0192",
        "disponibilidadeVeiculo": "ALUGADO",
        "idVeiculo": 1
      },
      "cartaoCreditoEntity": {
        "numero": "9999 8888 2222 5555",
        "bandeiraCartao": "VISA",
        "validade": "05/2030",
        "limite": 50000,
        "idCartaoCredito": 1
      },
      "funcionarioEntity": {
        "idFuncionario": 1,
        "nome": "Jhenny",
        "cpf": "09123740521",
        "email": "maifa@javamail.com.br",
        "matricula": 34
      }
    })

    db.locacoes.insert(
    {
        "dataLocacao": "2023-03-10",
        "dataDevolucao": "2023-03-12",
        "valorLocacao": 320,
        "clienteEntity": {
          "nome": "Marcos",
          "cpf": "75335795188",
          "idCliente": 2
        },
        "veiculoEntity": {
          "marca": "Honda",
          "modelo": "Fit",
          "cor": "Preto",
          "ano": 2020,
          "quilometragem": 59000,
          "valorLocacao": 160,
          "placa": "TSR1635",
          "disponibilidadeVeiculo": "ALUGADO",
          "idVeiculo": 2
        },
        "cartaoCreditoEntity": {
          "numero": "3333 7777 7777 6666",
          "bandeiraCartao": "MASTERCARD",
          "validade": "08/2030",
          "limite": 75000,
          "idCartaoCredito": 2
        },
        "funcionarioEntity": {
          "idFuncionario": 2,
          "nome": "Luciano Huck",
          "cpf": "89512595125",
          "email": "jhennyffersobrinho@gmail.com",
          "matricula": 456
        }
    })
    db.locacoes.insert(
      {
          "dataLocacao": "2023-03-10",
          "dataDevolucao": "2023-03-12",
          "valorLocacao": 680,
          "clienteEntity": {
            "nome": "Marcos",
            "cpf": "75335795188",
            "idCliente": 2
          },
          "veiculoEntity": {
            "marca": "Honda",
            "modelo": "Fit",
            "cor": "Preto",
            "ano": 2020,
            "quilometragem": 59000,
            "valorLocacao": 160,
            "placa": "TSR1635",
            "disponibilidadeVeiculo": "ALUGADO",
            "idVeiculo": 2
          },
          "cartaoCreditoEntity": {
            "numero": "3333 7777 7777 6666",
            "bandeiraCartao": "MASTERCARD",
            "validade": "08/2030",
            "limite": 75000,
            "idCartaoCredito": 2
          },
          "funcionarioEntity": {
            "idFuncionario": 2,
            "nome": "Luciano Huck",
            "cpf": "89512595125",
            "email": "jhennyffersobrinho@gmail.com",
            "matricula": 456
          }
      })
      
    db.locacoes.insert(
    {
        "dataLocacao": "2023-03-10",
        "dataDevolucao": "2023-03-20",
        "valorLocacao": 2200,
        "clienteEntity": {
          "nome": "Carlos",
          "cpf": "11122233344",
          "idCliente": 3
        },
        "veiculoEntity": {
          "marca": "Toyota",
          "modelo": "Corolla",
          "cor": "Cinza",
          "ano": 2019,
          "quilometragem": 12000,
          "valorLocacao": 220,
          "placa": "BEH8574",
          "disponibilidadeVeiculo": "ALUGADO",
          "idVeiculo": 3
        },
        "cartaoCreditoEntity": {
          "numero": "1111 8888 7777 6666",
          "bandeiraCartao": "VISA",
          "validade": "05/2025",
          "limite": 30000,
          "idCartaoCredito": 3
        },
        "funcionarioEntity": {
          "idFuncionario": 3,
          "nome": "Michael Jackson",
          "cpf": "19735795108",
          "email": "jhennyffersobrinho@gmail.com",
          "matricula": 789
        }
      })

///////////////////////////////////////////////////////////
// metodos locacoes
db.locacoes.find(
    { 
        "funcionarioEntity.nome" : "Jhenny"
    }
    ).pretty()

db.locacoes.find({
        $or : [
            {"funcionarioEntity.nome" : "Jhenny"},
            {"funcionarioEntity.nome" : "Luciano Huck"}    
        ]
    })

    db.locacoes.updateMany(
      { "clienteEntity.idCliente": 3 },
      {
        $set: { "valorLocacao": 1600}           
      }
   )

   db.locacoes.updateMany(
    { "funcionarioEntity.nome": "Michael Jackson" },
    {
      $set: { "funcionarioEntity.email": "michaeljackson@gmail.com.br"}           
    }
 )

 db.locacoes.find({}, 
  {
    marca_modelo: { $concat: [ "$veiculoEntity.marca", " - ", "veiculoEntity.modelo"] },
   "clienteEntity.nome" : 1,
   "cartaoCreditoEntity.bandeiraCartao" : 1,
   "funcionarioEntity.nome" : 1
  })

  db.locacoes.find({}, 
    {
      marca_modelo: { $concat: [ "$funcionarioEntity.nome", " - ", "funcionarioEntity.email"] },
     "dataLocacao" : 1,
     "dataDevolucao" : 1,
     "valorLocacao" : 1
    })

    db.locacoes.aggregate( [
      { $match: {} },
      { $group: { _id: "$clienteEntity.nome", sumQuantity: {$sum: "$valorLocacao" }} }
   ] )

   db.locacoes.aggregate( [
    { $match: {"cartaoCreditoEntity.numero": "3333 7777 7777 6666" } },
    { $group: { _id: "$cartaoCreditoEntity.numero", sumQuantity: {$sum: "$cartaoCreditoEntity.limite" }} }
 ] )
 db.locacoes.deleteMany({valorLocacao:{$lte:680}})
 db.locacoes.deleteMany({"veiculoEntity.marca":"Toyota"},{"disponibilidadeVeiculo":"ALUGADO"})
 
 
/////////////////////////////////////////////////
db.createCollection("veiculos")

db.veiculos.insert(
    {
      "marca": "Toyota",
      "modelo": "Corolla",
      "cor": "Cinza",
      "ano": 2019,
      "quilometragem": 12000,
      "valorLocacao": 220,
      "placa": "BEH8574",
      "disponibilidadeVeiculo": "ALUGADO",
      "idVeiculo": 3
    })

  db.veiculos.insert(
    {
      "marca": "Honda",
      "modelo": "Fit",
      "cor": "Preto",
      "ano": 2020,
      "quilometragem": 59000,
      "valorLocacao": 160,
      "placa": "TSR1635",
      "disponibilidadeVeiculo": "ALUGADO",
      "idVeiculo": 2
    })

    db.veiculos.insert(
        {
          "marca": "Honda",
          "modelo": "Civic",
          "cor": "Preto",
          "ano": 2000,
          "quilometragem": 250000,
          "valorLocacao": 220,
          "placa": "APT0192",
          "disponibilidadeVeiculo": "ALUGADO",
          "idVeiculo": 1
        })


db.veiculos.find({ano:{$gte:2020}})
db.veiculos.find({"quilometragem":{$lt:50000}})

db.veiculos.updateMany({"ano":{$gte:2020}},{$set:{"valorLocacao":300}})
db.veiculos.updateOne({"modelo":"Corolla"},{$set:{disponibilidadeVeiculo:"DISPONIVEL"}})


db.veiculos.aggregate( [
  { $match: {"marca": "Honda" } },
  { $group: { _id: "$marca", sumQuantity: {$sum: "$quilometragem" }} }
] )

db.veiculos.aggregate( [
  { $match: {} },
  { $group: { _id: "$valorLocacao", sumQuantity: {$sum: "$valorLocacao" }} }
] )

db.veiculos.find({}, 
  {
    veiculo : { $concat: [ "$marca", " - ", "modelo"] },
   "ano" : 1,
   "disponibilidadeVeiculo" : 1,
   "placa" : 1,
   "valorLocacao" : 1
  })

  db.veiculos.find({}, 
    {
      modelo_cor: { $concat: [ "$marca", " - ", "cor"] },
     "cor" : 1,
     "placa" : 1,
     "modelo" : 1,
     "quilometragem" : 1
    })

  db.veiculos.deleteMany({ano:{$lte:2010}})
  db.veiculos.deleteMany({"marca":"Toyota"},{"disponibilidadeVeiculo":"DISPONIVEL"})