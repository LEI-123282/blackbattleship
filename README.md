# ⚓ BlackBattleship

## 👥 Equipa
**Grupo Tp03_LEI-PL-4**

**Nickname:** Tp03_LEI-PL-4  
**Curso:** Licenciatura em Engenharia Informática em Pós-Laboral

| Nome | Nº de Aluno |
|:---:|:---:|
| Aloísio Ferreira | 129373 |
| Carmen González | 98455 |
| Cíntia Brandão | 123282 |
---

# Product Backlog — Batalha Naval Online (Papergames.io)

Product Backlog estruturado em *User Stories* Scrum numeradas, elaborado a partir da análise funcional das páginas oficiais da plataforma **Papergames.io** (`battleship`, `shop`, `pricing/plus`, `pricing/gruppo`, `pricing/games-as-a-service`, `docs/game-guides`, `blog/ranka`, `changelog`, `developers`, `blog/content-moderation-policy`, `blog/privacy-policy` e `blog/terms-conditions`).

---

## Sumário de Épicos

| ID | Épico | User Stories |
| :--- | :--- | :--- |
| **EP-01** | Jogabilidade Principal e Mecânicas de Batalha Naval | `US-01` a `US-06` |
| **EP-02** | Modos de Jogo e Emparelhamento (*Matchmaking*) | `US-07` a `US-10` |
| **EP-03** | Gestão de Contas, Perfis e Privacidade | `US-11` a `US-14` |
| **EP-04** | Torneios Públicos, Privados e Plano *Gruppo* | `US-15` a `US-17` |
| **EP-05** | Classificações (*Leaderboards*), ELO e Sistema *RANKA* | `US-18` a `US-20` |
| **EP-06** | Economia Virtual, Loja (*Shop*) e Subscrição *Plus* | `US-21` a `US-23` |
| **EP-07** | Funcionalidades Sociais, Comunicação e Moderação | `US-24` a `US-28` |
| **EP-08** | Multiplataforma Móvel e API *Games as a Service* (GaaS) | `US-29` a `US-31` |

---

## Épico 1: Jogabilidade Principal e Mecânicas de Batalha Naval

### US-01 — Inicialização de tabuleiro e frota aleatória
> **Enquanto** jogador de Batalha Naval, **quero** iniciar imediatamente uma partida numa grelha de 10×10 com uma frota de 5 navios (tamanhos 5, 4, 3, 3 e 2 quadrículas) posicionados aleatoriamente, **para que** possa começar a disparar sem perder tempo na configuração manual.

- [ ] Grelha de 100 quadrículas para cada jogador.
- [ ] Total de 17 quadrículas de navios por frota.
- [ ] Visualização simultânea da grelha de ataque (adversário) e da grelha de defesa (frota própria).

### US-02 — Sistema de disparos por turnos e turno extra
> **Enquanto** jogador em partida, **quero** alternar turnos disparando mísseis simples (1 quadrícula) sobre a grelha do adversário e receber um disparo adicional sempre que acertar num navio, **para que** possa encadear jogadas táticas e afundar a frota inimiga.

- [ ] Exibição de ícone de fogo em caso de acerto e salpico de água em caso de falha.
- [ ] Manutenção do turno ativo enquanto o jogador acertar em alvos válidos.

### US-03 — Utilização de armas especiais com áreas de impacto distintas
> **Enquanto** jogador de Batalha Naval, **quero** dispor de armas especiais além do míssil simples, **para que** possa atingir múltiplas quadrículas em simultâneo e maximizar as hipóteses de localizar navios ocultos.

- [ ] Início da partida com 2 *Big Missiles* (impacto em cruz de 5 quadrículas).
- [ ] Suporte para *Missile Rain* (até 7 disparos em quadrículas aleatórias).
- [ ] Suporte para *Nuclear Missile* (área ampla de 13 quadrículas).

### US-04 — Recolha de presentes (*Gifts*) no tabuleiro
> **Enquanto** jogador em partida, **quero** que surjam caixas de presente no tabuleiro após algumas jogadas de ambos os participantes e poder atingi-las com um míssil, **para que** obtenha armas extra aleatórias durante o duelo.

- [ ] Geração dinâmica de presentes após um número definido de turnos.
- [ ] Atribuição imediata de *Big Missile*, *Missile Rain* ou *Nuclear Missile* ao jogador que acertar no presente.

### US-05 — Condição de vitória, abandono e reinício de partida
> **Enquanto** jogador, **quero** que o sistema declare automaticamente o vencedor assim que as 17 quadrículas da frota adversária forem afundadas, permitindo também abortar partidas ou pedir desforra, **para que** o fluxo de jogo seja claro e contínuo.

- [ ] Apresentação clara do resultado no final da partida.
- [ ] Opção de abortar partida (*Abort game*) e botão de desforra respeitando as regras de intervalo em torneios.

### US-06 — Controlos de acessibilidade, som e feedback visual
> **Enquanto** utilizador com ou sem necessidades especiais, **quero** navegar e jogar através de atalhos de teclado, efeitos sonoros, música e animações responsivas, **para que** a experiência seja inclusiva e envolvente em qualquer dispositivo.

- [ ] Suporte a atalhos de teclado.
- [ ] Controlos de ativação/desativação de som, música e tema nas definições.
- [ ] Resposta háptica nos dispositivos móveis compatíveis.

---

## Épico 2: Modos de Jogo e Emparelhamento (*Matchmaking*)

### US-07 — Jogar online contra adversário aleatório (*Play online*)
> **Enquanto** jogador, **quero** clicar em «Play online» para ser emparelhado automaticamente em tempo real com outro jogador disponível, **para que** possa competir rapidamente a nível mundial.

- [ ] Fila de emparelhamento em tempo real.
- [ ] Impedimento de emparelhamento entre dois jogadores com o mesmo endereço IP.
- [ ] Prevenção de emparelhamento repetido imediato.

### US-08 — Jogar contra o computador (*Play vs robot*)
> **Enquanto** jogador, **quero** iniciar uma partida contra a inteligência artificial a qualquer hora, **para que** possa treinar estratégias mesmo sem ligação a outros jogadores humanos.

- [ ] Disponibilidade 24/7.
- [ ] Identificação clara do adversário como robô quando selecionado manualmente.
- [ ] Disponibilidade de múltiplos níveis de dificuldade.

### US-09 — Jogar com um amigo através de hiperligação direta (*Play with a friend*)
> **Enquanto** jogador, **quero** gerar uma sala privada e partilhar uma hiperligação única com um amigo, **para que** possamos jogar Batalha Naval num clique.

- [ ] Geração instantânea de URL de convite.
- [ ] Início automático da partida assim que o segundo jogador acede à ligação.

### US-10 — Preenchimento automático de filas com bots transparentes nas regras
> **Enquanto** gestor da plataforma, **quero** que o sistema possa atribuir adversários automatizados em filas públicas durante períodos de baixa afluência, **para que** os tempos de espera se mantenham reduzidos e as estatísticas continuem a funcionar.

- [ ] Contabilização normal de pontos, classificação e estatísticas conforme previsto nos Termos e Condições.

---

## Épico 3: Gestão de Contas, Perfis e Privacidade

### US-11 — Acesso imediato como convidado (*Guest*)
> **Enquanto** novo visitante, **quero** jogar Batalha Naval imediatamente escolhendo apenas um nome de exibição, **para que** experimente o jogo sem fricção de registo prévio.

- [ ] Criação automática de conta temporária de convidado.
- [ ] Possibilidade de converter posteriormente a conta de convidado numa conta registada mantendo o progresso.

### US-12 — Registo e autenticação de conta permanente
> **Enquanto** jogador regular, **quero** registar-me e iniciar sessão com e-mail e palavra-passe ou através de contas Google, Facebook, Discord ou Apple, **para que** o meu historial, moedas e classificações fiquem guardados.

- [ ] Validação de e-mail por código de 4 dígitos.
- [ ] Proteção dos formulários com Google reCAPTCHA.
- [ ] Armazenamento seguro de palavras-passe (*salted hash*).
- [ ] Exibição de insígnia Discord no perfil quando associado.

### US-13 — Perfil público e pesquisa de jogadores
> **Enquanto** jogador registado, **quero** consultar o meu perfil público e pesquisar outros jogadores por nome de exibição, ID de conta ou e-mail exato, **para que** possa acompanhar estatísticas e adicionar amigos.

- [ ] Exibição pública de nome, avatar, bandeira do país (derivada via IP/Cloudflare), estado online, ELO, historial de partidas e troféus.
- [ ] Ocultação permanente do endereço de e-mail.

### US-14 — Gestão de preferências e eliminação definitiva da conta (RGPD)
> **Enquanto** titular de dados, **quero** editar o meu nome de exibição, configurar o idioma e eliminar permanentemente a minha conta nas definições, **para que** tenha controlo total sobre os meus dados pessoais.

- [ ] Eliminação imediata de perfil, moedas, itens, amigos, torneios criados, subscrições Stripe ativas e identificadores de dispositivo.
- [ ] Conformidade com RGPD e lei suíça (FADP).

---

## Épico 4: Torneios Públicos, Privados e Plano *Gruppo*

### US-15 — Participação automática no torneio diário público
> **Enquanto** jogador de Batalha Naval, **quero** entrar automaticamente no torneio diário de 24 horas ao disputar partidas online, **para que** possa competir pelo topo da tabela diária sem inscrições manuais.

- [ ] Duração de 24 horas com contagem decrescente visível.
- [ ] Pontuação inicial de 1000 pontos.
- [ ] Penalização de `-15` pontos por abandono intencional (*rage-quit*) de partida em curso.

### US-16 — Criação e gestão de torneios personalizados
> **Enquanto** utilizador registado, **quero** criar um torneio de Batalha Naval definindo nome, descrição, formato e regras de tempo, **para que** possa organizar competições com o meu grupo.

- [ ] Suporte para formatos *Leaderboard*, Eliminação Simples, Eliminação Dupla e *Round Robin*.
- [ ] Configuração de séries (À melhor de 1, 3 ou 5) e tempo limite por turno/jogador.
- [ ] Acesso à área «My tournaments».

### US-17 — Organização de eventos de grande escala sem anúncios (*Plano Gruppo*)
> **Enquanto** organizador escolar, terapeuta ou líder de equipa remota, **quero** subscrever o passe *Gruppo* (30 dias ou anual), **para que** possa realizar torneios ilimitados com mais de 4 participantes e num ambiente sem anúncios seguro para crianças.

- [ ] Remoção do limite gratuito de 4 jogadores.
- [ ] Emparelhamento automático de participantes.
- [ ] Bloqueio total de publicidade e filtragem de conteúdo sensível para todos os participantes do torneio.

---

## Épico 5: Classificações (*Leaderboards*), ELO e Sistema *RANKA*

### US-18 — Classificação geral deslizante de 30 dias (*RANKA*)
> **Enquanto** jogador competitivo, **quero** acumular pontos *RANKA* com base nos meus resultados acima de 1000 pontos nos torneios diários dos últimos 30 dias, **para que** a minha consistência diária seja refletida na tabela geral.

- [ ] Conversão do excedente acima de 1000 pontos no fim de cada torneio diário em pontos *RANKA*.
- [ ] Expiração automática dos pontos ganhos após 31 dias.

### US-19 — Distribuição automática de prémios e troféus de torneio
> **Enquanto** participante de torneios diários, **quero** receber notificações e recompensas em moedas de jogo no encerramento de cada torneio consoante a minha posição final, **para que** o meu desempenho competitivo seja recompensado.

- [ ] Atribuição escalonada de moedas no encerramento do torneio:

| Classificação Final | Recompensa em Moedas |
| :--- | :--- |
| 1.º Lugar | `+1000` moedas |
| 2.º Lugar | `+700` moedas |
| 3.º Lugar | `+500` moedas |
| 4.º Lugar | `+400` moedas |
| 5.º Lugar | `+490` moedas |
| Posições seguintes | Decréscimo de `10` moedas por posição (mínimo de `+100` moedas) |

### US-20 — Cálculo de classificação ELO e visualização de repetições (*Replays*)
> **Enquanto** jogador de Batalha Naval, **quero** acompanhar a evolução da minha pontuação ELO e rever partidas anteriores jogada a jogada, **para que** possa analisar os meus erros e melhorar a minha tática.

- [ ] Atualização de ELO após vitórias e derrotas (sem alteração em empates).
- [ ] Leitor de repetições no historial de partidas com controlos de avanço e recuo responsivos em telemóveis e computadores.

---

## Épico 6: Economia Virtual, Loja (*Shop*) e Subscrição *Plus*

### US-21 — Aquisição e gestão de moedas virtuais
> **Enquanto** jogador, **quero** receber moedas gratuitas no registo e em torneios, bem como comprar pacotes adicionais na loja, **para que** tenha saldo para personalizar a minha conta.

- [ ] Integração de pagamentos via Xsolla na versão web, Apple App Store no iOS e Google Play no Android.
- [ ] Saldo intransmissível e sem valor monetário real.

### US-22 — Compra de avatares, emojis e multiplicadores na Loja (*Shop*)
> **Enquanto** jogador, **quero** gastar as minhas moedas na loja online para desbloquear avatares («Monsters»), *emojis* e multiplicadores de pontos (*Boosters*), **para que** possa expressar-me nas partidas e acelerar a minha pontuação.

- [ ] Catálogo dividido por categorias (`Coins`, `Monsters`, `Emojis`, `Boosters`).
- [ ] Aplicação correta de multiplicadores de pontos (ex.: *Booster* x2) nos torneios elegíveis.

### US-23 — Remoção de anúncios para ambos os jogadores (*Papergames Plus*)
> **Enquanto** subscritor do plano *Plus* (mensal ou anual), **quero** jogar sem anúncios e remover também os anúncios do ecrã do meu adversário durante as nossas partidas, **para que** ambos tenhamos uma experiência limpa e sem distrações.

- [ ] Processamento de subscrição via Stripe.
- [ ] Caixa de verificação obrigatória no *checkout* sobre o início imediato do serviço e renúncia ao direito de retratação de 14 dias (UE).
- [ ] Cancelamento autónomo nas definições da conta.

---

## Épico 7: Funcionalidades Sociais, Comunicação e Moderação

### US-24 — Gestão de amigos e caixa de entrada privada (*Inbox*)
> **Enquanto** jogador com conta, **quero** enviar e aceitar pedidos de amizade e trocar mensagens persistentes na caixa de entrada com os meus amigos, **para que** possamos combinar partidas de Batalha Naval.

- [ ] Envio de mensagens privadas permitido apenas após aceitação mútua de amizade.
- [ ] Armazenamento do histórico de conversas.
- [ ] Notificações *push* e por e-mail para novas mensagens.

### US-25 — Chat efémero em partida e envio de *emojis*
> **Enquanto** jogador numa partida ativa, **quero** enviar mensagens de texto (até 2000 caracteres) e *emojis* ao meu adversário em tempo real, **para que** possamos reagir às jogadas durante o duelo.

- [ ] Mensagens visíveis apenas para os dois jogadores (ocultas para espectadores) e nunca armazenadas após o fim da partida.
- [ ] Hiperligações apresentadas apenas como texto simples sem pré-visualização.

### US-26 — Moderação automática por IA e filtros de conteúdo
> **Enquanto** administrador da plataforma, **quero** que nomes de exibição, mensagens de chat/inbox e textos de torneios sejam verificados automaticamente por listas de palavras proibidas e modelos de IA (OpenAI), **para que** a comunidade se mantenha segura e livre de abuso.

- [ ] Substituição imediata de nomes impróprios por nomes gerados pelo sistema (confiança `>85%`).
- [ ] Ocultação/remoção automática de mensagens sinalizadas.
- [ ] Bloqueio na gravação de torneios com títulos ou descrições ofensivas.

### US-27 — Denúncia de jogadores, bloqueio e medidas disciplinares
> **Enquanto** jogador, **quero** denunciar e bloquear utilizadores por abuso verbal, batota, inatividade propositada (*stalling*) ou manipulação de classificação (*sandbagging*), **para que** comportamentos tóxicos sejam punidos.

- [ ] Formulário de denúncia por categorias com opção de bloqueio imediato.
- [ ] Escalamento prioritário para moderadores humanos (resposta até 4 horas).
- [ ] Banimento automático à segunda advertência do mesmo tipo, restringindo contas banidas a partidas contra robôs e bloqueando IP/dispositivo.

### US-28 — Deteção anti-batota em tempo real
> **Enquanto** sistema de jogo, **quero** verificar a existência de *scripts* de batota conhecidos no navegador ao entrar em filas de torneio e validar estados no servidor (Redis), **para que** a integridade competitiva da Batalha Naval seja preservada.

- [ ] Sinalização automática de contas que utilizem *scripts* externos ou manipulação de pedidos.

---

## Épico 8: Multiplataforma Móvel e API *Games as a Service* (GaaS)

### US-29 — Experiência nativa nas aplicações móveis iOS e Android
> **Enquanto** utilizador de smartphone, **quero** jogar Batalha Naval nas aplicações oficiais da Google Play Store e Apple App Store sem anúncios e com reconexão imediata ao desbloquear o ecrã, **para que** possa jogar confortavelmente em mobilidade.

- [ ] Ausência de anúncios nas aplicações móveis.
- [ ] Notificações *push* via Firebase/APNs.
- [ ] Reconexão automática de sessão WebSocket após suspensão do telemóvel.

### US-30 — Integração da Batalha Naval em plataformas externas via API (*GaaS*)
> **Enquanto** programador ou empresa parceira, **quero** gerar chaves de API (ambientes `dev`, `preprod` e `prod`) e iniciar sessões de Batalha Naval incorporáveis via `iframe` na minha aplicação ou intranet, **para que** os meus utilizadores possam jogar sem sair do meu produto.

- [ ] Disponibilização de plano gratuito (até 150 pedidos/mês) e plano *Pro* (pedidos ilimitados, acesso a todos os jogos incluindo Batalha Naval e remoção da marca Papergames.io).
- [ ] Suporte a modos *Player vs Player* e *Player vs Random*.

### US-31 — Monitorização de *Webhooks* e registos HTTP no portal de programadores
> **Enquanto** integrador da API *Games as a Service*, **quero** configurar *endpoints* de *webhooks* e consultar os registos de pedidos HTTP no painel de programador, **para que** receba os resultados das partidas (nomes, pontuações e IDs) e diagnostique falhas de integração.

- [ ] Envio automático dos resultados da partida para o *webhook* configurado.
- [ ] Histórico de registos de pedidos HTTP e gestão independente de múltiplas chaves de API.
