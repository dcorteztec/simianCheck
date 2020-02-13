# Simian check DNA
Em um futuro distante, na cadeia de evolução, os símios e os humanos estão
cada vez mais próximos. Por esse motivo ficou muito difícil distinguir quem é
humano e quem é símio.

Esse projeto foi feito para detectar se uma sequência de DNA é humana ou de um símio
	
## POST https://simiancheck.herokuapp.com/simian
Este serviço recebe a sequencia de DNA e avalia se é um símio ou não.
```
{
	“dna”:["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}
```
Caso o DNA seja identificado como um símio , você deve retornar um HTTP 200-OK , caso contrário um
HTTP 403-FORBIDDEN
	
## GET https://simiancheck.herokuapp.com/stats
Esse serviço informar a quantidade de DNA’s símios, quantidade de DNA’s humanos, e a proporção de símios para a população humana.
```
{ “count_simian_dna”:40, “count_human_dna”:100: “ratio”:0.4}
```