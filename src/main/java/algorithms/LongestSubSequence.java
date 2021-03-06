package algorithms;

import strategy.IAlgorithmStrategy;
import static utilities.InputArrayParser.userInputArray;

/**
 * This class search the longest sequence difference one in the maximum sub sequence.
 *
 * @author Roman Berezhnov
 */
public class LongestSubSequence implements IAlgorithmStrategy {

    /**
     * This method provides the controller logic.
     *
     * @param rawArray  array of integers.
     * @return         length of the greatest sequence.
     */
    int getTheLongestOne(int[] rawArray) {

        if (rawArray == null) {
            return 0;
        }

        int[] sequences = sequencesArrayInitialization(rawArray.length);
        int[] filledSequences = searchSequences(rawArray, sequences);

        return findTheLongestSubSequence(filledSequences);
    }

    /**
     * Returns length of the greatest sequence.
     *
     * @return length of the greatest sequence.
     */
    private int findTheLongestSubSequence(int[] sequences) {

        int result = 1;

        for (int sequence : sequences) {
            if (result < sequence) {
                result = sequence;
            }
        }

        return result;
    }

    /**
     * Initializes all array elements as one.
     *
     * @param length length of integer array.
     * @return       initialized array.
     */
    private int[] sequencesArrayInitialization(int length) {

        int[] array = new int[length];

        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }

        return array;
    }

    /**
     * Searches sequences in integer array.
     */
    private int[] searchSequences(int[] array, int[] sequences) {

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] == (array[j] + 1) || array[i] == (array[j] - 1)) {
                    sequences[i] = Math.max(sequences[i], sequences[j] + 1);
                }
            }
        }
        return sequences;
    }

    @Override
    public void execute() {
        int[] array = userInputArray();
        System.out.println("This is the longest sub sequence - " + getTheLongestOne(array) + "\n");
    }
}
