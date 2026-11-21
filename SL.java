/**
 * Method contract for the SuperList assignment.
 *
 * Declare your class as: public class SuperList<E> implements SL<E>
 * All implementing methods must be public.
 *
 * Interfaces cannot check constructors, fields, running time, or behavior.
 * SuperList must still have an empty-list constructor, and ListNode must
 * still have a constructor accepting its initial element.
 */
public interface SL<E> {

    /**
     * Returns YOUR first and last name as a String. Used for Mr. Haver's testing
     */
    String getAuthor(); // e.g. return "jane doe";

    /** Appends value to the end. O(1). */
    void add(E value);

    /** Returns the number of elements. O(1). */
    int size();

    /** Returns contents such as [1, 2, 3], or [] when empty. O(n). */
    String toString();

    /**
     * Inserts value at index. Valid indexes: 0 through size(), inclusive.
     * Throws ArrayIndexOutOfBoundsException for an invalid index. O(n).
     */
    void add(int index, E value);

    /** Removes and returns the element at index. */
    E remove(int index);

    /** Returns true if the list contains no elements. */
    boolean isEmpty();

    /** Removes all elements. O(1). */
    void clear();

    /** Returns true if value occurs in the list. O(n). */
    boolean contains(E value);

    /** Adds value to the end and returns that value. O(1). */
    E push(E value);

    /**
     * Removes and returns the last element. O(1).
     * Throws java.util.EmptyStackException if empty.
     */
    E pop();

    /** Removes and returns the first element, or null if empty. O(1). */
    E poll();

    /**
     * Returns the last element without removing it. O(1).
     * Throws java.util.EmptyStackException if empty.
     */
    E stackPeek();

    /** Returns the first element without removing it, or null if empty. O(1). */
    E queuePeek();

    /**
     * Returns the element at index. Valid indexes: 0 through size() - 1.
     * Throws ArrayIndexOutOfBoundsException for an invalid index. O(n).
     */
    E get(int index);

    /**
     * Replaces the element at index and returns its previous value.
     * Valid indexes: 0 through size() - 1.
     * Throws ArrayIndexOutOfBoundsException for an invalid index. O(n).
     */
    E set(int index, E val);

    void insertList(int index, SL<E> other);
}