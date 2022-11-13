<h1 align="center">EncurtadorUrlComSpring</h1>

## Descrição
<p>
  O Encurtador de URL com Spring consegue pegar qualquer url e gerar uma nova bem mais curta e fácil de compartilhar com outras pessoas.
</p>

## Como funciona
O projeto é uma API que contém dois endpoints: 
  - POST: que recebe a URL como queryParameter, gera um token único baseado no domínio da URL, faz a persistência no banco de dados e retorna
  uma curta e nova URL.
  

  
  
  - GET: faz o redirecionamento para a URL de origem.

