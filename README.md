# projeto-cem-app

Esse é o projeto da disciplina de Conversão Eletromecânica de Energia. Pelo curso de Engenharia da Computação da Universidade de Pernambuco.

As especificações do projeto são: Elaborar um aplicativo para celular (Android ou Apple) para

1) Plotar a curva da corrente de excitação de um transformador 220/110 V cuja característica B-H está
mostrada no arquivo “Castings-Cast-Iron.xls”; Plotar a corrente nominal do enrolamento primário no mesmo
gráfico;
2) Calcular os parâmetros elétricos do transformador baseado nas medições dos ensaios de circuito aberto e
curto-circuito. As variáveis de entrada do aplicativo, neste caso, são a tensão, corrente e potência ativa
medidas em cada ensaio.

Dados


Dados da Rede Elétrica
- Tensão Vmax = 220; %Volts
- Frequência f = 60; %Hz
- Tempo/Intervalo de tempo em segundos t = [0:0.0001:0.1];

Dados do Transformador
- Potência Aparente S = 1000; % VA
- Número de Espiras Primário N = 860; %Espiras
- Número de Espiras Secundário N = 430; %Espiras
- Comprimento médio do Núcleo l = 35*10^-2; %m
- Área da seção transversal do núcleo A = 8*10^-4; % m2
