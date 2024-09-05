package dz.esisba.ms1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api")
public class Controller {

    // Light CPU and Memory load
    @GetMapping("/test")
    public String lightLoad() {
        // Light memory load (50MB)
        allocateMemory(50 * 1024 * 1024);

        // Light CPU load (sorting 1,000 elements)
        int[] array = IntStream.range(0, 1000).toArray();
        bubbleSort(array);

        return "Light CPU and memory load completed!";
    }

    // Utility method for bubble sort (CPU-intensive)
    private void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Utility method to allocate memory (Memory-intensive)
    private void allocateMemory(int sizeInBytes) {
        byte[] memoryLoad = new byte[sizeInBytes];
        Random random = new Random();
        random.nextBytes(memoryLoad); // Fill the array with random data
    }
}

