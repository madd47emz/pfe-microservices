package dz.esisba.ms2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api")
public class Controller {

    // Medium CPU and Memory load
    @GetMapping("/test")
    public String mediumLoad() {
        // Medium memory load (200MB)
        allocateMemory(100 * 1024 * 1024);

        return "Medium CPU and memory load completed!";
    }

    // Utility method to allocate memory (Memory-intensive)
    private void allocateMemory(int sizeInBytes) {
        byte[] memoryLoad = new byte[sizeInBytes];
        Random random = new Random();
        random.nextBytes(memoryLoad); // Fill the array with random data
    }
}

