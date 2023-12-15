package com.example.demo.service;

import com.example.demo.domain.Student;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@ComponentScan
public class HeapSortService implements SortingTechnique {

    private MinHeap minHeap;

    public HeapSortService() {
        this.minHeap = new MinHeap();
    }

    @Override
    public List<Student> sort(List<Student> studentList) {
        for (Student element : studentList) {
            minHeap.add(element);
        }

        List<Student> sortedList = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            sortedList.add(minHeap.removeMin());
        }

        return sortedList;
    }

    private class MinHeap {

        private List<Student> data;

        public MinHeap() {
            this.data = new ArrayList<>();
        }

        public boolean isEmpty() {
            return data.isEmpty();
        }

        public void add(Student element) {
            data.add(element);
            bubbleUp(data.size() - 1);
        }

        public Student removeMin() {
            Student root = data.remove(0);
            if (!data.isEmpty()) {
                swap(data, 0, data.size() - 1);
                heapifyDown(0);
            }
            return root;
        }

        private void bubbleUp(int index) {
            while (index > 0 && compare(data.get(parent(index)), data.get(index)) > 0) {
                swap(data, index, parent(index));
                index = parent(index);
            }
        }

        private void heapifyDown(int index) {
            int leftChild = left(index);
            int rightChild = right(index);
            int smallestChild = leftChild;

            if (rightChild < data.size() && compare(data.get(leftChild), data.get(rightChild)) > 0) {
                smallestChild = rightChild;
            }

            if (index < data.size() && compare(data.get(index), data.get(smallestChild)) > 0) {
                swap(data, index, smallestChild);
                heapifyDown(smallestChild);
            }
        }

        private int parent(int index) {
            return (index - 1) / 2;
        }

        private int left(int index) {
            return 2 * index + 1;
        }

        private int right(int index) {
            return 2 * index + 2;
        }

        private void swap(List<Student> list, int i, int j) {
            Student temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }

        private int compare(Student o1, Student o2) {
          return o1.getPerformance()>o2.getPerformance()? 1:  0;
            //return 0; // replace with actual comparison logic
        }
    }
}
