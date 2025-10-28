package analisedealgoritmos;

public class AnaliseDeAlgoritmos {
    public static void main(String[] args) {
        int[] vetorBase1 = {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28};
        int[] vetorBase2 = {5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32};
        int[] vetorBase3 = {99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6};
        int n = 20;

        System.out.println("### INICIANDO ANÁLISE DE ALGORITMOS DE ORDENAÇÃO ###");

        System.out.println("\n--- VETOR 1 (Aleatório) ---");
        executarTestes("Bubble Sort (Flag)", vetorBase1, n, 1);
        executarTestes("Selection Sort", vetorBase1, n, 2);
        executarTestes("Cocktail Sort", vetorBase1, n, 3);
        executarTestes("Gnome Sort", vetorBase1, n, 4);
        executarTestes("Comb Sort", vetorBase1, n, 5);
        executarTestes("Bucket Sort", vetorBase1, n, 6);

        System.out.println("\n--- VETOR 2 (Ordenado) ---");
        executarTestes("Bubble Sort (Flag)", vetorBase2, n, 1);
        executarTestes("Selection Sort", vetorBase2, n, 2);
        executarTestes("Cocktail Sort", vetorBase2, n, 3);
        executarTestes("Gnome Sort", vetorBase2, n, 4);
        executarTestes("Comb Sort", vetorBase2, n, 5);
        executarTestes("Bucket Sort", vetorBase2, n, 6);

        System.out.println("\n--- VETOR 3 (Invertido) ---");
        executarTestes("Bubble Sort (Flag)", vetorBase3, n, 1);
        executarTestes("Selection Sort", vetorBase3, n, 2);
        executarTestes("Cocktail Sort", vetorBase3, n, 3);
        executarTestes("Gnome Sort", vetorBase3, n, 4);
        executarTestes("Comb Sort", vetorBase3, n, 5);
        executarTestes("Bucket Sort", vetorBase3, n, 6);
    }

    public static void executarTestes(String nomeAlgoritmo, int[] vetorBase, int n, int algIndex) {
        long[] counters = {0, 0};
        int[] vetorParaOrdenar = copiarVetor(vetorBase, n);

        switch (algIndex) {
            case 1: bubbleSortComFlag(vetorParaOrdenar, n, counters); break;
            case 2: selectionSort(vetorParaOrdenar, n, counters); break;
            case 3: cocktailSort(vetorParaOrdenar, n, counters); break;
            case 4: gnomeSort(vetorParaOrdenar, n, counters); break;
            case 5: combSort(vetorParaOrdenar, n, counters); break;
            case 6: bucketSort(vetorParaOrdenar, n, counters); break;
        }

        System.out.println(String.format("  %-20s | Comparações: %-10d | Trocas: %-10d", nomeAlgoritmo, counters[0], counters[1]));
        
    }

    public static int[] copiarVetor(int[] original, int n) {
        int[] copia = new int[n];
        for (int i = 0; i < n; i++) {
            copia[i] = original[i];
        }
        return copia;
    }

    public static void imprimirVetor(int[] arr, int n) {
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void trocar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSortComFlag(int[] arr, int n, long[] counters) {
        boolean trocou;
        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            for (int j = 0; j < n - 1 - i; j++) {
                counters[0]++;
                if (arr[j] > arr[j + 1]) {
                    trocar(arr, j, j + 1);
                    counters[1]++;
                    trocou = true;
                }
            }
            
            if (!trocou) {
                break;
            }
        }
    }

    public static void selectionSort(int[] arr, int n, long[] counters) {
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                counters[0]++;
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            if (minIndex != i) {
                trocar(arr, i, minIndex);
                counters[1]++;
            }
        }
    }

    public static void cocktailSort(int[] arr, int n, long[] counters) {
        boolean trocou = true;
        int inicio = 0;
        int fim = n - 1;

        while (trocou) {
            trocou = false;
            
            for (int i = inicio; i < fim; i++) {
                counters[0]++;
                if (arr[i] > arr[i + 1]) {
                    trocar(arr, i, i + 1);
                    counters[1]++;
                    trocou = true;
                }
            }
            
            if (!trocou) break;
            fim--;
            trocou = false;

            for (int i = fim - 1; i >= inicio; i--) {
                counters[0]++;
                if (arr[i] > arr[i + 1]) {
                    trocar(arr, i, i + 1);
                    counters[1]++;
                    trocou = true;
                }
            }
            inicio++;
        }
    }

    public static void gnomeSort(int[] arr, int n, long[] counters) {
        int pos = 0;
        while (pos < n) {
            if (pos == 0) {
                pos++;
            }
            counters[0]++;
            if (arr[pos] >= arr[pos - 1]) {
                pos++;
            } else {
                trocar(arr, pos, pos - 1);
                counters[1]++;
                pos--;
            }
        }
    }

    private static int getNextGap(int gap) {
        gap = (gap * 10) / 13;
        if (gap < 1) {
            return 1;
        }
        return gap;
    }
    
    public static void combSort(int[] arr, int n, long[] counters) {
        int gap = n;
        boolean trocou = true;

        while (gap != 1 || trocou) {
            gap = getNextGap(gap);
            trocou = false;

            for (int i = 0; i < n - gap; i++) {
                counters[0]++;
                if (arr[i] > arr[i + gap]) {
                    trocar(arr, i, i + gap);
                    counters[1]++;
                    trocou = true;
                }
            }
        }
    }

    public static void bucketSort(int[] arr, int n, long[] counters) {
        if (n <= 0) return;

        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < n; i++) {
            counters[0]++;
            if (arr[i] > max) {
                max = arr[i];
            }
            counters[0]++;
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        int numBuckets = 10;
        int[][] buckets = new int[numBuckets][n];
        int[] bucketSizes = new int[numBuckets];
        
        for (int i = 0; i < numBuckets; i++) {
            bucketSizes[i] = 0;
        }

        int range = max - min;
        if (range == 0) range = 1;
        
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) (((long)arr[i] - min) * (numBuckets - 1) / range);
            
            int currentBucketSize = bucketSizes[bucketIndex];
            buckets[bucketIndex][currentBucketSize] = arr[i];
            bucketSizes[bucketIndex]++;
        }

        for (int i = 0; i < numBuckets; i++) {
            if (bucketSizes[i] > 0) {
                insertionSortParaBucket(buckets[i], bucketSizes[i], counters);
            }
        }

        int index = 0;
        for (int i = 0; i < numBuckets; i++) {
            for (int j = 0; j < bucketSizes[i]; j++) {
                arr[index++] = buckets[i][j];
            }
        }
    }


    public static void insertionSortParaBucket(int[] bucket, int n, long[] counters) {
        for (int i = 1; i < n; i++) {
            int key = bucket[i];
            int j = i - 1;
            
            counters[0]++;
            while (j >= 0 && bucket[j] > key) {
                counters[0]++;
                bucket[j + 1] = bucket[j];
                counters[1]++;
                j--;
            }
            bucket[j + 1] = key;
        }
    }
}
