# Microedu
Sistema de Gerenciamento Escolar

Usando Java, HTML, CSS, JavaScript, JQuery, BootStrap, SpringBoot, PostgresSQL, Apache FreeMarker, FlyWay, Hibernate.

# Criando e configurando o projeto
1° vá para o site https://start.spring.io/ e selecione todas as tecnologias seguintes:
PostgresSQL, Apache FreeMarker, FlyWay, Hibernate

2° Configure o Arquivo application.properties as tecnologias de JPA Hibernate, conexão com o banco e FreeMarker
Arquivo e configurações: https://github.com/Rogerio-Viana/microedu/blob/master/microedu/src/main/resources/application.properties

# Estrutura do Projeto
O projeto foi divido na seguinte estrutura.
- Controller: mapeando e recebendo todas as requisições HTTP.
- Service: Interface que decidirá todos os métodos que a camada de Controller terá acesso.
- ServiceImpl: implementação do Service.
- Repository: Interface de conexão com o banco de dados.
- Entidade: aonde ficaram todas Classe.java com o mapeamento do Spring, estas classes são representação das tabelas no banco de dados, assim que o sistema iniciar o Spring sera responsavél por conectar ao banco de dados e criar as tabelas caso não exista.

# Arquivos que enviados ao cliente (Páginas WEB)
microedu/microedu/src/main/resources/templates/ Ficará todos os arquivos HTML, JavaScript e CSS.
Como estamos utilizando um gerador de temples (Apache FreeMarker), criamos um arquivo chamdo template.html que terá todos os CDN's usados e o menu lateral que é comum em todas as páginas (neste arquivo ficará todos os arquivos e/ou objetos comuns nas páginas).

Como estamos usando o FlayWay que é um gerenciador de migração de banco de dados na pasta microedu/microedu/src/main/resources/db/migration/ ficará todos script que seram executados e gerenciados pela a ferramenta.
- Script's SQL do bancos de dados: https://github.com/Rogerio-Viana/microedu/tree/master/microedu/src/main/resources/db/migration


- Template: https://github.com/Rogerio-Viana/microedu/blob/master/microedu/src/main/resources/templates/template.html
- Página de Edição/Criação/Apagar : https://github.com/Rogerio-Viana/microedu/blob/master/microedu/src/main/resources/templates/pages/edicao-curso.html
- Listagem dos registros: https://github.com/Rogerio-Viana/microedu/blob/master/microedu/src/main/resources/templates/pages/listagem-curso.html


# Arquivos do servidor (Classes Java)
Como estamos focando em apenas uma única parte do sistema a dos cadastros de cursos/turmas, vamos falar somente dele
- 1° Criar e mapear Classe.java Curso 
- 2° Controller: Criamos uma Classe com a anotação de controller para ser gerenciados pelo Spring.
- 3° Colocamos todos os métodos e anotamos eles com os mapeamentos necessários, métodos para salvar/atualizar, deletar e criar as turmas/cursos de nosso sistema.
- 4° Após isto para cada mapeamento, o método responsavél por cada requisição irá chamar a Classe responsavél dentro do Service, a interface Service é injetada na Classe Controller (técnica/tecnologia chamda de CDI ou Injeção de depêndencia) para que tenha acesso a sua implementação e seja feito o processamento adequado a requisição.
- 5° Após os métodos do Controller ter acesso as implementações das assinaturas da interface Service o ServiceImpl usará o Repository para ter acesso direto ao banco de dados, tais quais como, criação de registros, atualização e remoção dos mesmos.


- Controller: https://github.com/Rogerio-Viana/microedu/blob/master/microedu/src/main/java/br/com/microedu/controller/CursoController.java
- Interface: https://github.com/Rogerio-Viana/microedu/blob/master/microedu/src/main/java/br/com/microedu/controller/CursoService.java
- Implementação: https://github.com/Rogerio-Viana/microedu/blob/master/microedu/src/main/java/br/com/microedu/controller/CursoServiceImpl.java
- Repository: https://github.com/Rogerio-Viana/microedu/blob/master/microedu/src/main/java/br/com/microedu/controller/CursoRepository.java

# Uso do sistema
1° Acesse o endereço: http://localhost:8080/curso ou caso já esteja dentro do sistema clicque no botão Turmas
![Acessar area de curso](https://user-images.githubusercontent.com/19811425/69339576-616c0500-0c44-11ea-9456-4a21684d75f8.PNG)

Caso queira editar uso registro de curso já existente clique no botão "Editar" do seu registro alvo
![editar curso](https://user-images.githubusercontent.com/19811425/69340043-5ebddf80-0c45-11ea-95ba-9be54b02e23c.PNG)

Após todas as suas alterações clique no botão "Salvar"
![salvar ediççoes](https://user-images.githubusercontent.com/19811425/69340150-92006e80-0c45-11ea-89dc-1379f95d9ef6.PNG)

Para criar um novo registro clique no botão "Criar Turma"
![criar](https://user-images.githubusercontent.com/19811425/69340328-fcb1aa00-0c45-11ea-92ec-f042bbf5c9f5.PNG)

Após todas adições clique no botão "Salvar"
![criar novo](https://user-images.githubusercontent.com/19811425/69340201-aba1b600-0c45-11ea-8a16-291a5423fb0d.PNG)

Ao salvar o registro a nova informação é listada na tela inicial de Turmas
![listagem de novos](https://user-images.githubusercontent.com/19811425/69340520-75b10180-0c46-11ea-9c01-d2cb04849eea.PNG)

Caso queira apagar um registro clique entre na edição do registro e clique no botão de apagar
![apagar](https://user-images.githubusercontent.com/19811425/69340715-da6c5c00-0c46-11ea-903b-bfb99231a02d.PNG)


