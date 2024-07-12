# Ecommerce-React-Spring
Um site Ecommerce com o front-end feito em React e TypeScript e o back-end feito em Java Spring, dados guardados em Banco de dados MySQL.

## O que foi feito até agora:
Pagina inicial funcionando.

Pagina dinamica de compra funcionando, ao clicar na imagem de um produto uma pagina com as informações daquele produto e a opção de adicionar ao carrinho é criada.

Carrinho funcionando, persistencia de produtos funcionando.

Pagina de cadastro e login adicionadas e funcionando.

Estilização concluida.

Componentes feitos e organizados entre si.

Subi no github os scripts do banco de dados que fiz.

Ao finalizar a compra na pagina carrinho o pedido é subido no banco de dados, com calculo de estoque restante de cada produto e valor total do pedido feitos por trigger.

Ao cadastrar uma conta para poder logar é necessario clicar no link de confirmação mandado ao email.

O cliente ao logar e ir no perfil pode alterar seus dados, apenas é permitido alterar nome, telefone e senha.

O cliente logado pode clicar em excluir conta, que ira desativar sua conta, caso tente logar em uma conta desativada é enviado ao email um link para reativação.

Ao querer alterar senha necessario fornecer a senha atual, que sera validada para checar se corresponde a que foi cadastrada no banco de dados.

Após isto o sistema pega as credenciais da empresa e as usa para mandar ao cliente um email com o link para alteração de senha para confirmar que ele que solicitou.

Ao clicar no link o sistema checa se o token de autenticação esta certo e então o cliente tem acesso a pagina de alteração de senha, onde ele passa o novo valor que sera atualizado no banco de dados.

Alertar colocados em paginas como a de Login e Editar para notificar o usuario, alertando caso a senha passada na troca de senha seja invalida, ou se o Usuario passado no login não existir.

Login Admin em Router e Componente separado, feita a validação libera as seguintes opções:  
 * Opção de cadastrar um produto passando a URL de uma imagem que vai ser associada a este produto e guardada no banco de dados, que sera mostrada na pagina principal.
 * Opção de listar pedidos em /admin/pedidos, podendo filtar por Data e Ano de emissão do Pedido, caso não tenha logado como admin sera redirecionado a pagina de login.
 * Opção de abrir os detalhes de um pedido da lista, para ver seus produtos e qual Cliente o fez.
Ao abrir os detalhes do pedido existe a opção de finaliza-lo, a data final sera colocada como a data atual, e o status mudara para finalizado.

### * Metodo de pagamento implementado através de chave Pix e QRCode.

### * Validação de usuário feita agora a partir do SPRING SECURITY.

## Videos do Projeto:

Caso de uso de fazer um Pedido, retornando o QRCode e a Chave para pagamento em PIX pelo banco EFI.
[![Thumbnail do Video "Ecommerce Java Spring e React - Compra com PIX usando EFI"](https://img.youtube.com/vi/0bei6IDxqJU/0.jpg)](https://www.youtube.com/watch?v=0bei6IDxqJU)

