# Eleicoes

PROBLEMA:
Implementar um sistema orientado a objetos em Java para simulação de uma urna eletrônica
para votação em governador e deputado estadual.

ESCOPO DO DESENVOLVIMENTO:

Em uma eleição cada estado federativo possui diversas zonas eleitorais, sendo que cada zona
eleitoral deve possuir, pelo menos, uma seção eleitoral. Em cada seção apenas uma urna está
presente.
A urna eleitoral deve ser configurada para um determinado turno (primeiro ou segundo) de uma
eleição, bem como devem constar na urna os candidatos inscritos para os cargos de governador
e deputado estadual. Cada candidato concorre para um determinado cargo (governador ou
deputado estadual), sendo filiado a um determinado partido.

A urna estando homologada, no dia da realização de votação, o voto pode ser realizado. Cada
eleitor deverá votar para um governador e um deputado estadual, dependendo da configuração
da urna. Considere que a urna deve ser configurada para aceitar uma quantidade configurável
de eleitores (os quais não são identificados). A lista completa dos votos deve ser guardada na
urna.

Encerrada a votação, a urna totaliza os votos válidos (por candidato para cada cargo) e os votos
inválidos (brancos e nulos). Além disso, o sistema deve totalizar todas as urnas cadastradas e
informar quais foram os candidatos eleitos para cada cargo.
Considere algumas regras:

1. No cadastro do candidato deve ser informado seu número para votação. São válidos números
de 01 a 98. A tentativa de cadastro de número fora desta regra ou o cadastro de um número já
pertencente a outro candidato deve ser tratada pelo sistema.

2. Um voto válido é aquele cujo número do candidato digitado na urna é o número de um
candidato cadastrado para o cargo.

3. Um voto branco ocorre quando o eleitor não informa um número de candidato. Nesse caso,
deve ser atribuído valor 00 como um número de candidato.

4. Um voto nulo ocorre quando o eleitor informa qualquer número de candidato não cadastrado
para o cargo. Nesse caso deve ser atribuído valor 99 como um número de candidato.

5. A totalização dos votos para os deputados estaduais, deve levar em conta o cálculo do
quociente eleitoral para definir os candidatos eleitos: “Determina-se o quociente eleitoral
dividindo-se o número de votos válidos apurados pelo de lugares a preencher em cada
circunscrição eleitoral, desprezada a fração se igual ou inferior a meio, equivalente a um, se
superior" (Código Eleitoral, art. 106).

Para facilitar, considere que existem somente 03 vagas de deputado estadual na câmara.

RESTRIÇÕES DE ESCOPO:
Para simplificar este trabalho, o sistema contempla somente algumas das funcionalidades de
uma urna eletrônica, não abordando funcionalidades do sistema do mesário, por exemplo.
