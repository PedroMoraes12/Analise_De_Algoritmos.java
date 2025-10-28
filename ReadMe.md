
# Análise de Algoritmos de Ordenação

## Instituição
- Nome da Instituição: PUCPR - Pontifícia Universidade Católica do Paraná
- Disciplina: Resolução de Problemas Estruturados em Computação
- Professor: Andrey Cabral Meira

---

Este projeto, desenvolvido em Java, implementa e analisa o desempenho de seis algoritmos de ordenação. O objetivo é comparar a eficiência de algoritmos menos comuns (Comb Sort, Gnome Sort, Bucket Sort) contra algoritmos clássicos (Bubble Sort, Selection Sort, Cocktail Sort) em três cenários distintos: um vetor aleatório, um vetor já ordenado e um vetor em ordem invertida.

A análise foca em duas métricas principais:
1.  **Comparações**: O número de vezes que dois elementos são comparados.
2.  **Trocas**: O número de vezes que elementos mudam de posição.

---

## Algoritmos Implementados

O projeto inclui a implementação manual dos seguintes algoritmos:

* **Algoritmos em Análise:**
    1.  `Comb Sort`: Uma otimização do Bubble Sort que elimina "tartarugas" (valores pequenos no final do vetor) usando um *gap* que diminui.
    2.  `Gnome Sort`: Um algoritmo simples que se assemelha ao Insertion Sort, baseado na ideia de um gnomo de jardim que verifica os vasos de flores.
    3.  `Bucket Sort`: Um algoritmo de distribuição que divide os elementos em "baldes" e ordena cada balde individualmente.

* **Algoritmos de Base (Baseline):**
    4.  `Bubble Sort (com Flag)`: Versão otimizada que para se nenhuma troca é realizada em uma passagem.
    5.  `Selection Sort`: Algoritmo que encontra o menor elemento e o coloca na posição correta a cada iteração.
    6.  `Cocktail Sort`: Uma variação bidirecional do Bubble Sort, que ordena em ambas as direções.

---

## Regras e Restrições do Projeto

Este código foi desenvolvido sob regras estritas para focar na implementação pura dos algoritmos, sem auxílio de bibliotecas prontas.

1.  **Proibido o uso de `array.length`**: O tamanho dos vetores (`n`) é sempre passado como parâmetro para os métodos.
2.  **Proibido o uso de Estruturas da API Java**: Nenhuma classe como `ArrayList`, `List`, `Vector`, `HashMap`, etc., foi utilizada.
    * *Nota*: O `Bucket Sort` foi implementado usando arrays 2D (`int[][]`) e um array auxiliar (`int[]`) para contar o tamanho de cada balde.
3.  **Proibido o uso de Funções Prontas**: Todos os métodos auxiliares (como `trocar`, `copiarVetor`, etc.) foram implementados manualmente.

---

## Como Executar

1.  Clone o repositório (ou salve o arquivo `AnaliseDeAlgoritmos.java`).
2.  Certifique-se de ter o JDK (Java Development Kit) instalado.
3.  Abra um terminal e navegue até a pasta do arquivo.
4.  Compile o arquivo:
    ```bash
    javac AnaliseDeAlgoritmos.java
    ```
5.  Execute o programa:
    ```bash
    java AnaliseDeAlgoritmos
    ```
6.  A saída no console conterá os dados de comparações e trocas.

---

## Análise de Desempenho

A análise foi conduzida usando os três vetores a seguir, todos de tamanho `n = 20`.

* **Vetor 1 (Aleatório):** `{12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28}`
* **Vetor 2 (Ordenado):** `{5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32}`
* **Vetor 3 (Invertido):** `{99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6}`

### Tabela 1: Contagem Bruta de Operações

Os resultados abaixo foram obtidos executando o código `AnaliseDeAlgoritmos.java`.

#### VETOR 1 (Aleatório)
| Algoritmo | Comparações | Trocas |
| :--- | :---: | :---: |
| Bubble Sort (Flag) | 180 | 78 |
| Selection Sort | 190 | 18 |
| Cocktail Sort | 154 | 78 |
| Gnome Sort | 174 | 78 |
| Comb Sort | 129 | 22 |
| Bucket Sort | 52 | 4 |

#### VETOR 2 (Ordenado)
| Algoritmo | Comparações | Trocas |
| :--- | :---: | :---: |
| Bubble Sort (Flag) | 19 | 0 |
| Selection Sort | 190 | 0 |
| Cocktail Sort | 19 | 0 |
| Gnome Sort | 19 | 0 |
| Comb Sort | 110 | 0 |
| Bucket Sort | 48 | 0 |

#### VETOR 3 (Invertido)
| Algoritmo | Comparações | Trocas |
| :--- | :---: | :---: |
| Bubble Sort (Flag) | 190 | 190 |
| Selection Sort | 190 | 10 |
| Cocktail Sort | 190 | 190 |
| Gnome Sort | 380 | 190 |
| Comb Sort | 129 | 18 |
| Bucket Sort | 96 | 47 |

---

### Tabela 2: Ranking de Desempenho (Menos é Melhor)

Com base nos dados brutos, os algoritmos foram ranqueados para cada cenário.

#### Ranking de COMPARAÇÕES
| Posição | Vetor 1 (Aleatório) | Vetor 2 (Ordenado) | Vetor 3 (Invertido) |
| :---: | :--- | :--- | :--- |
| **1º** | **Bucket Sort (52)** | **Bubble / Cocktail / Gnome (19)** | **Bucket Sort (96)** |
| 2º | Comb Sort (129) | Bucket Sort (48) | Comb Sort (129) |
| 3º | Cocktail Sort (154) | Comb Sort (110) | Bubble / Selection / Cocktail (190) |
| 4º | Gnome Sort (174) | Selection Sort (190) | Gnome Sort (380) |
| 5º | Bubble Sort (180) | - | - |
| 6º | Selection Sort (190) | - | - |

#### Ranking de TROCAS
| Posição | Vetor 1 (Aleatório) | Vetor 2 (Ordenado) | Vetor 3 (Invertido) |
| :---: | :--- | :--- | :--- |
| **1º** | **Bucket Sort (4)** | **(Empate Múltiplo - 0)** | **Selection Sort (10)** |
| 2º | Selection Sort (18) | - | Comb Sort (18) |
| 3º | Comb Sort (22) | - | Bucket Sort (47) |
| 4º | Bubble / Cocktail / Gnome (78)| - | Bubble / Cocktail / Gnome (190) |
| 5º | - | - | - |
| 6º | - | - | - |

---

## Conclusão

A análise dos resultados permite tirar as seguintes conclusões:

1.  **Melhor Desempenho Geral (Caso Médio/Aleatório):**
    * O **Bucket Sort** foi o vencedor absoluto, liderando com folga tanto em **comparações (52)** quanto em **trocas (4)**.
    * O **Comb Sort** foi o segundo melhor em ambos os quesitos (129 comparações, 22 trocas).
    * Os algoritmos $O(n^2)$ (Bubble, Cocktail, Gnome) tiveram um desempenho muito similar em trocas (78), sendo o Selection Sort o pior em comparações (190).

2.  **Melhor para Dados Ordenados (Melhor Caso):**
    * **Bubble Sort (com Flag)**, **Cocktail Sort** e **Gnome Sort** foram os mais eficientes, atingindo complexidade linear $O(n)$ com apenas **19 comparações** e **0 trocas**.
    * O **Selection Sort** teve o *pior* desempenho neste cenário, pois sempre executa $O(n^2)$ comparações (190), independentemente da ordem inicial.

3.  **Melhor para Dados Invertidos (Pior Caso):**
    * **Bucket Sort (96)** e **Comb Sort (129)** se mostraram muito mais eficientes em *comparações* do que os algoritmos $O(n^2)$ (190).
    * O **Gnome Sort** teve o pior desempenho de todos, com **380 comparações**.
    * O **Selection Sort** manteve sua vantagem clássica em número de *trocas*, realizando apenas **10**. O **Comb Sort** foi o segundo melhor, com 18.
