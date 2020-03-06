# Relatório Mini-Projeto 2
## Introdução á Programação Orientada por Objetos
## Ano Letivo: 2015/2016

### Professor Fausto

# Autorrádio

### Hugo Pereira nº 150 221 038
### João Gomes nº 150 221 001

## Escola Superior de Tecnologia de Setúbal


## Introdução
Neste projeto iremos desenvolver utilizando a linguagem java e a Programação orientadada por objetos (POO), uma aplicação que tem como objetivo o controlo e a gestão de um autorradio, este irá possuir um radio com dois tipos de bandas em que tem já implementado 10 canais de memória com informações sobre a banda e a frequência ainda dá para adicionar canais.
Neste projeto irá também ser implementando um leitor de Cd´s de músicas em formato mp3.
Irá também apresentar um classe gravador que simula o processo de gravação de músicas num cd, esta classe é independente do autorrádio.


## Desenvolvimento
Este projeto foi desenvolvido utilizando a linguagem Java, colocando em prática os seus conceitos fundamentais do paradigma de Programação Orientada por Objetos, utilizando as regras de codificação convencionais do java nomeadamente notação camelCase, para todos os nomes dos métodos e os seus parâmetros sejam de variável local ou atributos definidos, e também utilizamos a notação PascalCase para identificar todos os nomes das classes. A implementação deste programa consiste em oito entidades que se convergem entre si para representar os elementos, estes são:

* Musica: Representa um ficheiro de música que possui um título, um intérprete, e um tamanho em kB.

* Cd: Um suporte digital em que tem uma capacidade em Mb, este poderão ser formatados, e fechados. Vão servir para guardar uma coleção de ficheiros de músicas, que serão gravados a partir do gravador.

* Gravador: Esta classe servirá para gravar os cd´s com uma coleção de ficheiros de músicas, possuirá já uma coleção de músicas interna em que se poderá adicionar ou remover. Também tem a capacidade de formatar e fechar os cd´s.

* Leitor de Cd´s: Está classe tem como função inserir e ejetar os cd´s, possui também dois tipos de reprodução dos mesmos, e poderá navegar entre as coleções de ficheiros em que o cd possui.

* Gestor de Canais: Está classe vai possuir canais memorizados para cada uma das bandas (AM/FM), irá também permitir adicionar e remover canais memorizados. Possui assim a informação do canal atualmente selecionada, está classe é simplesmente responsável pela gestão dos canais que possui.

* Banda: Está é uma classe do tipo Enumerado, que possui dos tipos de bandas utilizados pelo Autorrádio.


* Canal: Está classe tem como função adicionar as informações essenciais num canal estas são a banda a frequência e o nome do canal que quisermos escolher.


* Autorrádio: Esta é a classe principal deste projeto, pois convergindo com as outras classes irá permitir entre reproduzir um cd ou ouvir um canal de radio. Esta classe pode-se selecionar entre as bandas existentes, e em cada banda possui 10 botões para os canais memorizados.

Na opção de reproduzir um cd poderá também navegar entre eles como na metodologia já implementada no leitor de cd´s.

Está classe tem também todas as informações do estado do autorrádio, (ligado/desligado; opção: radio/Cd; e na reprodução a informação relativa: musica/canal).
Escola Superior de Tecnologia de Setúbal

## Classes

* Musica: Nesta classe tivemos o objetivo de criar um objeto ficheiro de música, em que neste estará implementado um título da música, um interprete e este ficheiro possuirá um determinado tamanho não inferior a 1 kb. Em todos estes atributos foram implementados normas de validação, para criar um ficheiro válido para ser utilizado em classes posteriores. Nesta classe estão também implementado todos os métodos para selecionar e modificar os atributos selecionados, como também um método toString para retornar estes atributos.

* CD: Nesta classe tivemos o objetivo de criar um suporte digital para armazenar uma coleção de ficheiros e musicas, tivemos então de implementar uma ArrayList para armazenar essa coleção.
Este suporte irá possuir uma capacidade válida.
Irá também possuir um título que só se poderá atribuir quando este suporte tiver sido formatado. No método formatar consiste em atribuir uma arrayList nova.
Nesta classe também será permitido gravar que consiste em adicionar ficheiro de músicas á coleção com a condição que este não se encontra fechado (método que impossibilita a gravação do cd).
Nesta classe é possível saber a capacidade do cd já com a convergência entre Mb e Kb. Será também possível ir retornar uma música de um determinado índice da Array.
Nesta classe podemos também pedir a lista de faixas já com a informação da classe musica através do método toString. A classe por si tem todos os métodos seletores dos atributos representados.
Escola Superior de Tecnologia de Setúbal

* Gestor de Canais:
Está classe tem como objetivos a gestão dos canais de radio criados, sendo que permite adicionar e remover canais e permite retornar a informação de cada um deles.
Nesta classe tivemos de obedecer às regras de implementação que nos foram transmitidas e criar um Array para os canais FM e AM, tendo sempre um canal e uma banda selecionadas.
Na criação deste gestor, construímos também um array com 10 canais para FM e AM selecionando assim uma banda e um canal na sua criação.
No método para adicionarCanal este recebe a posição e um canal, validando assim a posição e o objeto, visto que a posição faz referência á posição no array tivemos de subtrair uma unidade, assim para adicionar o canal no array este irá para a posição pretendida.
No método removerCanal este recebe a posição e faz as mesmas validações do mesmo, mas desta vez coloca a posição a null. Nos métodos avançar / retroceder canal este verifica a banda selecionada, procura o canal selecionado e avança / retrocede uma posição sendo exceção na posição 0 e 9 que são os limites do array neste caso eles comportam-se de outra maneira passando para a posição 9 e 0 respetivamente. Temos também que retorna a informação do canal selecionado.



* Gravador:
O gravador consiste numa classe independente do Autorrádio pois a sua metodologia não é representada num Autorrádio convencional. Este tem como finalidade gravar os Cd´s, este já possui uma coleção interna de músicas, nesta coleção pode-se adicionar e remover ficheiros de músicas. Existe métodos inserir e ejetar o cd. Em inserir este recebe como parâmetro um cd validando-o para poder defini-lo como inserido. Em ejetar faz a mesma validação mas este caso impõe outra condição de modo a que se faça uma copia do cd inserido para que se retorne a copia e se passe o cd inserido a null.
A sua metodologia em gravarCd recebe como parâmetro booleano fechar (em que decide se se o cd fica fechado ou não). Neste método valida-se todos os elementos necessários como exemplo disso se existe cd, se existe espaço suficiente, se o cd é formatado, depois de passar todas estas validações é que será gravada a coleção interna, para o cd.
Esta classe possui métodos para trocar e inserir músicas nas posições da coleção.

* Banda: Esta classe do tipo enumerada tem como objetivo guardar dois tipos de bandas (AM/FM) para serem utilizadas em classe como Gestor de Canais e canal.

* Canal: Esta classe irá representar um canal de rádio, este é representado pelos atributos banda e frequência.
Na criação de um canal este irá ter uma frequência valida para cada uma das bandas, além disso também é possível dar um nome para cada canal criado. Esta classe possui também um método toString que irá retornar a informação do canal sendo este a frequência e a determinada banda para essa frequência. Está classe possui também todos os métodos seletores e modificadores para os atributos que possui.


* Leitor de CD (s): Esta classe permite inserir e ejetar cd´s. Reproduzi-los dependendo do método pretendido (aleatório ou automático).
Avançar e retroceder na coleção de músicas do cd inserido. No método inserirCd, este recebe um cd e faz a validação do mesmo transformando-o em cd inserido. Em ejetar cd este faz a mesma validação do cd inserido, passando a validação este método faz uma cópia do cd inserido, retorna a cópia e passa o cd a null. Tendo dois tipos de reprodução, o método play toca a primeira musica da coleção, enquanto, o play automático verifica o estado da opção aleatória que implementamos com o método setAleatorio e se estiver false, e enquanto houver ficheiros ele toca a musica, se a opção aleatória estiver ligada este gera uma posição aleatória e toca essa musica.

* Autorádio:
O autorradio cria um leitor de cd´s , um gestor de canais, e coloca os atributos booleanos do radio e do estado do autorradio a true.
Existe métodos para introdução um botão para desligar e ligar que começa a tocar se estiver ligado e não toca desligado.
Existe métodos para adicionar e remover canal que foram implementados no gestor de canais.
Existe um botão para avançar/retroceder dependendo de se estar a ouvir radio ou reproduzir um cd com a condição do estado do autorradio estar ligado.



## Conclusão
Este projeto foi muto gratificante, pois podemos observar certos paradigmas que a linguagem convencional do java nos transmite.
Sentimos alguma dificuldade em testar o autorradio visto que existe muitas partes a serem consideradas, por observação não foi necessário a utilização do código anexado (MusicPlayer), para podermos testar o programa.
