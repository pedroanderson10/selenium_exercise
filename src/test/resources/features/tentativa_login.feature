Feature:Tentativa de Login
    #As Como um usuário do sistema Solidarity
    #I Eu quero realizar o login no sistema
    #To Para ter acesso às funcionalidades do sistema

Scenario:Realizar Login com Sucesso
    Given Dado que o usuário está na página de login e possui cadastro no sistema
    When Quando ele preenche os campos "Usuário" e "Senha"
        | usuario | senha |
        | fulano | pass   |
    And Ele clica no botão "Login"
    Then Então o sistema deve redirecionar o usuário para a página inicial do sistema


