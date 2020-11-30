package Repository;

import Contracts.Contract;

import java.util.Comparator;

public class MergeSorter {
    public Contract[] repository;
    public int contractsQuantity;
    public MergeSorter(Contract[] repository, int contractsQuantity){
        this.repository = repository;
        this.contractsQuantity = contractsQuantity;
    }
    public void sort(Comparator<Contract> comp){
        mSort(repository,0,contractsQuantity-1,comp);
    }
    /**
     *
     * @param array сортируемый массив
     * @param left левая граница массива
     * @param right правая граница массива
     * @param comp компаратор, по которму будет происходить сортировка
     */
    private void mSort(Contract[] array, int left, int right,Comparator<Contract> comp){
        if (right <= left) return;
        int mid = (left+right)/2;
        mSort(array, left, mid,comp);
        mSort(array, mid+1, right,comp);
        merge(array, left, mid, right,comp);
    }
    /**
     * Функция слияния
     * @param array сортируемый массив
     * @param left левая граница массива
     * @param mid середина массива
     * @param right правая граница массива
     * @param comp компаратор, по которму будет происходить сортировка
     */
    private void merge(Contract[] array, int left, int mid, int right,Comparator<Contract> comp){
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;

        // создаем временные подмассивы
        Contract leftArray[] = new Contract [lengthLeft];
        Contract rightArray[] = new Contract [lengthRight];

        // копируем отсортированные массивы во временные
        for (int i = 0; i < lengthLeft; i++)
            leftArray[i] = array[left+i];
        for (int i = 0; i < lengthRight; i++)
            rightArray[i] = array[mid+i+1];

        // итераторы содержат текущий индекс временного подмассива
        int leftIndex = 0;
        int rightIndex = 0;

        // копируем из leftArray и rightArray обратно в массив
        for (int i = left; i < right + 1; i++) {
            // если остаются нескопированные элементы в R и L, копируем минимальный
            if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                if (comp.compare(leftArray[leftIndex],rightArray[rightIndex])<0) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                }
                else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
            // если все элементы были скопированы из rightArray, скопировать остальные из leftArray
            else if (leftIndex < lengthLeft) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            }
            // если все элементы были скопированы из leftArray, скопировать остальные из rightArray
            else if (rightIndex < lengthRight) {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }
}
