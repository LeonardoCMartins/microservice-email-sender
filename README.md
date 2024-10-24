# Microservice email sender
<br>
<p> é um microsserviço responsável por enviar e-mails de forma assíncrona utilizando RabbitMQ como gerenciador de fila de mensagens. Ele recebe informações sobre e-mails a serem enviados, processa essas informações 
e faz a entrega do e-mail. O serviço é configurado para enviar e-mails com templates HTML dinâmicos.</p>

# Funcionalidades
- Envio de e-mails com templates HTML.
- Suporte a mensagens enfileiradas via RabbitMQ.
- Integração com o Spring Boot para facilidade de configuração e injeção de dependências.
- Logs e tratamento básico de erros no envio de e-mails.

# Tecnologias Utilizadas
- Java 17
- Spring Boot 3
- RabbitMQ
- Spring Mail 
- MySQL
- Docker

# Exemplo de Uso
O serviço espera receber mensagens no formato JSON com os dados do e-mail. Exemplo de payload esperado:

```json
{
  "emailTo": "destinatario@exemplo.com",
  "subject": "Assunto do E-mail",
  "username": "Nome do Usuário"
}
```
Assim que a mensagem for recebida na fila RabbitMQ, o serviço enviará o e-mail utilizando o template HTML configurado.


