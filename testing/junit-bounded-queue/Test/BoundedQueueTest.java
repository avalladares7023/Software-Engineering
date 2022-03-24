import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoundedQueueTest {
    // Initialize the class object under test
    private BoundedQueue boundedQueue;

    // Set up the queue with a valid capacity number for each test
    @BeforeEach
    public void init() {
        this.boundedQueue = new BoundedQueue(3);
    }

    // Test enQueue() method to check that it adds elements to the queue
    @Test
    public void enQueueTest() {
        this.boundedQueue.enQueue(1);
        this.boundedQueue.enQueue(2);
        this.boundedQueue.enQueue(3);

        // Print statement(s) if assert fails
        assertEquals("[1, 2, 3]", this.boundedQueue.toString(),
                "The queue elements do not match what was added");
        assertFalse(boundedQueue.isEmpty(), "The queue is empty");
    }

    // Test deQueue() method to check that it removes and returns last element in the queue
    @Test
    public void dequeueTest() {
        this.boundedQueue.enQueue(1);
        // Print statement if assert fails
        assertEquals(1, this.boundedQueue.deQueue(),
                "The deQueue method did not remove and/or element");
    }

    // Test isFull() method
    @Test
    public void fullQueueTest() {
        this.boundedQueue.enQueue(1);
        this.boundedQueue.enQueue(2);
        this.boundedQueue.enQueue(3);

        // Print statement if assert fails
        assertTrue(this.boundedQueue.isFull(),
                "The queue is not full");
    }
    // Test isEmpty() method
    @Test
    public void emptyBoundedQueueTest() {
        assertTrue(this.boundedQueue.isEmpty());
    }

    // Test toString() method to return a string of the queue contents
    @Test
    public void toStringTest() {
        this.boundedQueue.enQueue(5);
        this.boundedQueue.enQueue(10);
        assertEquals("[5, 10]", this.boundedQueue.toString());
    }

    // Test enQueue() method with null value (NullPointerException)
    @Test
    public void enQueueNullTest() {
        // Unable to assertThrows without making enQueue() method static
        try {
            this.boundedQueue.enQueue(null);
        } catch (Exception e) {
            assertTrue(e instanceof NullPointerException);
            assertEquals(e.getMessage(), "BoundedQueue.enQueue");
        }
        fail();
    }

    // Test enQueue() method with full queue (IllegalStateException)
    @Test
    public void enQueueFullTest() {
        try {
            this.boundedQueue.enQueue(1);
            this.boundedQueue.enQueue(2);
            this.boundedQueue.enQueue(3);
            this.boundedQueue.enQueue(4);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalStateException);
            assertEquals(e.getMessage(), "BoundedQueue.enQueue");
        }
        fail();
    }

    // Test deQueue() method with an empty queue (IllegalStateException)
    @Test
    public void deQueueEmptyTest() {
        try {
            this.boundedQueue.deQueue();
        } catch (Exception e) {
            assertTrue(e instanceof IllegalStateException);
            assertEquals(e.getMessage(), "BoundedQueue.deQueue");
        }
        fail();
    }

    // Test BoundedQueue creation with a negative capacity (IllegalArgumentException)
    @Tag("skipBeforeEach")
    @Test
    public void BoundedQueueNegativeCapacityTest() {
        try {
            this.boundedQueue = new BoundedQueue(-1);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertEquals(e.getMessage(), "BoundedQueue.constructor");
        }
        fail();
    }
}