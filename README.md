<h1 align="center"> Ecommerce-React-Spring </h1>

<p align="center">
  <image
  src="https://img.shields.io/github/languages/count/Gustav0Felipe/Ecommerce-React-Spring"
  />
  <image
  src="https://img.shields.io/github/languages/top/Gustav0Felipe/Ecommerce-React-Spring"
  />
  <image
  src="https://img.shields.io/github/last-commit/Gustav0Felipe/Ecommerce-React-Spring"
  />

</p>

# Sumário 

- [Objetivos](#id01)
- [Funções Usuário:](#id01.01)
- [Funções Admin:](#id01.02)
- [Tecnologias utilizadas](#id02)
- [Ambiente de codificação](#id03)
- [Videos](#id04)


# Objetivos <a name="id01"></a>
Um site Ecommerce com o front-end feito em React e TypeScript e o back-end feito em Java Spring, dados guardados em Banco de dados MySQL.

## Funções Usuário <a name="id01.01"></a>
* Comprar: ao clicar em uma imagem de produto mostra os detalhes do produto e a opção adicionar ao carrinho.

* Carrinho: possui persistencia de produtos na sessão, produtos podem ser acrescentados e retirados, possui opção finalizar compra - necessario login.

* Cadastro de cliente: feito no banco de dados, possui codigo de verificação, link para verificar mandado por email ao cliente.

* Login de clientes: Autenticado por Spring Security, o usuário será alertado se o Cliente não existir.

* Finalizar Compra: o pedido é subido no banco de dados, que por Trigger's calcula o valor total do pedido e se é possivel faze-lo com a quantia do produto em estoque.

* Pagar: É gerada uma Chave-Aleatoria e QRCode PIX para pagar o Pedido.

* Scripts do Banco de Dados disponibilizados.

* Alterar Dados: O Cliente pode alterar seus dados no Perfil, nome telefone e senha.

* Alterar Senha: O Cliente pode alterar sua senha contanto que forneça sua senha atual que corresponda ao banco de dados (gera um alerta caso invalida), sendo assim enviado a ele um Email para alteração de senha, validado por Token de Autenticação.

* Excluir Conta: desativa a conta do cliente no banco de dados, ao tentar logar em uma conta desativada é mandado ao cliente um Email para reativa-la.


## Funções Admin (Validação feita por Spring Security) <a name="id01.02"></a>

 * Cadastrar Produto: /loja/admin/cadastrar-produto, Cadastra um novo produto, associa o URL de Imagem a ele e será mostrado na tela principal.

 * Listar Pedidos: loja/admin/pedidos, lista os Pedidos podendo filtrar por Data e Ano de emissão, caso não tenha logado como Admin será redirecionado a pagina de Login.

 * Abrir Detalhes do Pedido: abre os detalhes do Pedido na Lista, mostra seus produtos, qual Cliente o fez e a entrega pode ser Finalizada.
 
 * Finalizar Pedido: Finaliza a Entrega do Pedido, a Data Final do Pedido será atualizada para a Data Atual, e o Status para finalizado.




## Tecnologias utilizadas <a name="id02"></a>
 <img align="center" alt="Java" src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
    <img align="center" alt="Spring" src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
    <img align="center" alt="React" src="https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB"/>
    <img align="center" alt="Typescript" src="https://img.shields.io/badge/TypeScript-007ACC?style=for-the-badge&logo=typescript&logoColor=white"/>
    <img align="center" alt="MySQL" src="https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white"/>
    <img align="center" alt="html5" src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white"/>
    <img align="center" alt="CSS" src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white"/>
 

## Ambiente de codificação <a name="id03"></a>

<div  align='center'> 

![eclipse](https://img.shields.io/badge/Eclipse-2C2255?style=for-the-badge&logo=eclipse&logoColor=white)
![](https://img.shields.io/badge/VSCode-0D1117?style=for-the-badge&logo=visual%20studio%20code&logoColor=blue)
![node](https://img.shields.io/badge/Nodejs-0D1117?style=for-the-badge&logo=node.js&logoColor=green)
![git](https://img.shields.io/badge/GIT-0D1117?style=for-the-badge&logo=git&logoColor=red)
![github](https://img.shields.io/badge/Github-0D1117?style=for-the-badge&logo=github&logoColor=fff)
![mysql](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)
</div>

## Videos do Projeto <a name="id04"></a>

Usuário Finalizar Pedido, retornando o QRCode e a Chave Aleatória para pagamento em PIX pelo Banco EfiPay:
<br/>
[![Thumbnail do Video "Ecommerce Java Spring e React - Compra com PIX usando EFI"](https://img.youtube.com/vi/0bei6IDxqJU/0.jpg)](https://www.youtube.com/watch?v=0bei6IDxqJU)

<div  align='center'>
Feito por Gustavo Felipe - Desenvolvedor Fullstack Jr

[![Linkedin](https://img.shields.io/badge/LinkedIn-0D1117?style=for-the-badge&logo=linkedin&logoColor=blue)](https://www.linkedin.com/in/gustavofelipecustodio/)
<a href = "gustavo.custodio55@hotmail.com">
![Hotmail](https://img.shields.io/badge/Microsoft_Outlook-0078D4?style=for-the-badge&logo=microsoft-outlook&logoColor=white)</a>
[![github](https://img.shields.io/badge/Github-0D1117?style=for-the-badge&logo=github&logoColor=fff)](https://www.github.com/Gustav0Felipe)
</div>
