# Target Solutions - Challenge

Sistema responsável por manter Funcionários e realizar a conversão de seus salários de Dólar para Real.

## Stacks:
 
▸ Java - Versão 11                                                                                                                                                              
▸ Spring (Boot, Data JPA, Validation)                                                                                                                                                     
▸ Maven                                                                                                                  
▸ MySql                                                                                                                                                                   

## Instruções:

▸ Download zip do projeto - [download](https://github.com/Patricknunnes/target-solutions-api-rest/archive/refs/heads/master.zip)                                       
▸ Download do JDK 11.0.15 - [download](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)                                              
▸ Download MySql Server - [download](https://dev.mysql.com/downloads/mysql)                                                                                       
▸ Necessário setar em application.properties o user e o password que foram criados na instalação do MySql Server:
![image](https://user-images.githubusercontent.com/86694806/187119707-16a8c2ee-9696-4936-a170-9cdd8c7ef5bc.png)                                                                                                                                                                                                        
![image](https://user-images.githubusercontent.com/86694806/187119487-7261e064-2a6a-4f08-abac-6e8abf89eb57.png)                                                                                                       
▸ Depois disso, apenas Build o projeto.

### Para rodar o projeto:

▸ Rode a classe ChallengeApplication:                                                                                                         
![image](https://user-images.githubusercontent.com/86694806/187120298-c01c1ae4-a532-425b-884f-3642e7db40f4.png)                                                                                                                   

### Para rodar os testes:

▸ Rode a classe ChallengeApplicationTests:                                                                                                                                
![image](https://user-images.githubusercontent.com/86694806/187120632-17847b08-ee62-4785-b1f9-70e3ea139f4b.png)

Após isso é possível acessar o Swagger(Documentação) do projeto pelo Link:

[Link do Swagger](http://localhost:8080/swagger-ui.html)

## Adicionais:

▸ Por simplicidade optei por desenvolver o projeto usando o padrão "Layered Architecture". 

Controller --> Service --> Repository

▸ No problema não estava claro como deveriam ser executadas as operações, decidi por usar uma API REST.                                               
▸ Por breviedade, não foi desenvolvido testes para 100% de cobertura, mas apenas uma amostra de como eu faria no "mundo real".                                             
▸ Como dito anteriormente, a documentação foi feita usando o Swagger.
