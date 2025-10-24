# CoffeShop

Projeto Integrador Transdisciplinar em Engenharia de Software II - Cruzeiro Sul

_Esse é um projeto que funcionará como um Coffee shop para uma pequena empresa. 
Ele faz parte de um trabalho acadêmico e utiliza conceitos aprendidos durante o curso. 
Tenha em mente que este é um projeto acadêmico e não atende aos requisitos para ser utilizado em produção._

 #### 🔥 Sinta-se à vontade para contribuir com o código (; 🔥

 ## Como rodar o projeto *local*?

## Obs: Apenas Android(Phone ou Tablet)

Baixe o apk na area release:
apenas clicar no arquivo apk e será feito o download
~~~sh
  https://github.com/MonteiroNeto/CoffeShop/releases/tag/V1.0.0
~~~
Permissões:
- **Ao tentar instalar no android permita a instalação de fontes de desconhecidas**


### Informações Adicionais

- **Linguagem Back-end**: Firebase NoSql + kotlin + Java 
- **Front-end**: Kotlin + Java
- **Banco de Dados**: Firebase Realtime
- **Hospedagem**: GitHub
- **Plataforma**: Android (smartphone e tablet)

A estrutura do projeto é organizada da seguinte forma:

O projeto utiliza arquitetura MVVM

- `Android Manifest`: *Contém arquivos permissões que o app precisara usar para funcionar.*
- `kotlin + java`: *Responsável pela logica do sistema.*
- `res`: *Engloba todos os arquivos referente a layouts e cores e textos.*
- `Gradle`: *Engloba todas as importacoes de bibliotecas adicionais.*  
- **LOGICA kotlin + java**
- `adapter`: *Está todos os adapters para as listas que são renderizadas na tela.*
- `helper`: *Banco de dados local para armazenar e organizar os items do carrinho.*
- `model`: *Define os modelos de dados utilizados na aplicação.*
- `repository`: *Responsável pelo acesso e manipulação dos dados.*
- `ui`: *Relacionado as interfaces do usuario.*
- `util`: *Utilitários diversos.*
- `view_model`: *Responsavel pela logica do negocio,Sua função principal é expor os dados e o estado da interface do usuário.*

### Tecnologias Utilizadas

- **Linguagens**: Kotlin, Java, Firebase Realtime, Json
- **IDE e Bibliotecas**: [IDE: Android studio] - [Implementações](  
   //my implementation  
    implementation("com.google.code.gson:gson:2.13.1")
    implementation("com.github.bumptech.glide:glide:4.16.0")
    implementation("com.github.Dimezis:BlurView:version-2.0.3")
  
    //Firebase  
    implementation(platform("com.google.firebase:firebase-bom:34.3.0"))) 


### Autoria

Este projeto foi desenvolvido por Monteiro Neto (<https://github.com/MonteiroNeto>) como parte do Projeto Integrador Transdisciplinar em Engenharia de Software II - Cruzeiro Sul.

## Imagens

- **App:**  
  ![Intro](https://github.com/MonteiroNeto/CoffeShop/blob/main/Coffee%20Shop%20screenshot/01-intro.png)
  ![Main](https://github.com/MonteiroNeto/CoffeShop/blob/main/Coffee%20Shop%20screenshot/02-main.png)
  ![Category](https://github.com/MonteiroNeto/CoffeShop/blob/main/Coffee%20Shop%20screenshot/03-category.png)
  ![Item_Detail](https://github.com/MonteiroNeto/CoffeShop/blob/main/Coffee%20Shop%20screenshot/04-item_detail.png)
  ![Cart](https://github.com/MonteiroNeto/CoffeShop/blob/main/Coffee%20Shop%20screenshot/05-cart.png)   


