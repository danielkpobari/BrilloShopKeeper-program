
A Java program that allows the shopkeeper to make pancakes, and the 3 users can eat the pancakes simultaneously. A single user can eat maximum 5 pancakes within 30 seconds. Also, the shopkeeper can make a maximum of 12 pancakes every 30 seconds. The system should randomly decide the number of pancakes that each of the 3 users want to eat in the 30 second’s period; but cannot exceed the maximum 5 pancakes rule.
Technologies used:
Java 17.
How to run the program:
1.	Clone the repository
git clone https://github.com/danielkpobari/BrilloShopKeeper-program.git
2. Build the project
3. Run the shopKeepernonConcurrentPancake class
4. Run the shopKeeperConcurrentPancake class






## **Compare and contrast both versions of the code and state your observations.**

Concurrency: The non-concurrent version executes the pancake eating process sequentially, while the concurrent version uses threads to allow the three users to eat pancakes simultaneously.

Thread Management: In the concurrent version, each user is represented by a separate thread, stored in the userThreads array. The join() method is used to ensure that all user threads complete before proceeding with the calculations.

Data Sharing: In the concurrent version, the pancakesEaten array is shared among the user threads. Each thread updates its respective element in the array to record the number of pancakes eaten.

Output and Results: Both versions produce the same output, displaying the starting and ending time, whether the shopkeeper met the needs of the users, the number of wasted pancakes (if any), and the number of unmet pancake orders (if applicable).

Observations: The non-concurrent version is simpler and easier to understand since it follows a linear execution flow. However, it doesn't allow simultaneous pancake eating. The concurrent version provides concurrency by using threads, enabling parallel pancake eating. However, it introduces additional complexity with thread management and data sharing. In this scenario with a small number of users and simple operations, the non-concurrent version suffices. The concurrent version would be more beneficial in scenarios with more users or computationally intensive tasks where parallelism can lead to performance improvements.