$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("teste1.feature");
formatter.feature({
  "line": 2,
  "name": "Escreva algo que descreva essa funcionalidade",
  "description": "",
  "id": "escreva-algo-que-descreva-essa-funcionalidade",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@TagFuncionalidade"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "Cen�rio 1",
  "description": "",
  "id": "escreva-algo-que-descreva-essa-funcionalidade;cen�rio-1",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@tagCenario"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "Passo 1",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Passo 2",
  "keyword": "When "
});
formatter.match({
  "location": "Test.passo1()"
});
formatter.result({
  "duration": 28586641127,
  "status": "passed"
});
formatter.match({
  "location": "Test.passo2()"
});
formatter.result({
  "duration": 1641754689,
  "status": "passed"
});
});