package dz.esisba.ms3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api")
public class Controller {

    // Heavy CPU and Memory load
    @GetMapping("/test")
    public String heavyLoad() {
        // Heavy memory load (500MB)
        allocateMemory(500 * 1024 * 1024);

        // Heavy CPU load (intensive prime number calculation)
        calculatePrimes(1000000);

        return "Heavy CPU and memory load completed!";
    }

    // Utility method for prime number calculation (CPU-intensive)
    private void calculatePrimes(int limit) {
        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) {
                // Do nothing, just calculate primes
            }
        }
    }

    // Check if a number is prime (helper method)
    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(num) + 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Utility method to allocate memory (Memory-intensive)
    private void allocateMemory(int sizeInBytes) {
        byte[] memoryLoad = new byte[sizeInBytes];
        Random random = new Random();
        random.nextBytes(memoryLoad); // Fill the array with random data
    }
}
