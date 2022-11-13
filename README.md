<h1 align="center">EncurtadorUrlComSpring</h1>

## Descrição
<p>
  O Encurtador de URL com Spring consegue pegar qualquer url e gerar uma nova bem mais curta e fácil de compartilhar com outras pessoas.
</p>

## Como funciona
O projeto é uma API que contém dois endpoints: 
  - POST: que recebe a URL como queryParameter, gera um token único baseado no domínio da URL, faz a persistência no banco de dados e retorna
  uma curta e nova URL.
  
   ![Exemplo POST](https://user-images.githubusercontent.com/60411725/201532141-79a84a80-7d72-4320-930b-90e39d483b0e.png)

  
  
  - GET: faz o redirecionamento para a URL de origem.

  ![Exemplo GET](https://user-images.githubusercontent.com/60411725/201532186-0686cb43-399d-4609-b7c1-a9c3fcd3604c.png)
