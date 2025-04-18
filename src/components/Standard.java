package components;

/**
 * Interface for {@code newInstance}, {@code clear}, and {@code transferFrom}
 * methods that are expected of every mutable type in the "components" type
 * families.
 *
 * Each of the {@code Standard} methods results in some variable having "an
 * initial value" of its type. The meaning of this phrase, indeed the meaning of
 * the "clears" parameter mode in all contracts in the "components" type
 * families, is as follows. If the type {@code T} has a no-argument constructor,
 * then the initial value satisfies the contract of the no-argument constructor.
 * If the type does not have a no-argument constructor, then the initial value
 * satisfies the contract of the constructor call that was used to initialize
 * the variable whose old value is relevant in the contract of the method.
 *
 * @param <T>
 *            type with these methods
 */
public interface Standard<T> {

    /**
     * Returns a new object with the same <i>dynamic</i> type as {@code this},
     * having an initial value.
     *
     * If the type {@code T} has a no-argument constructor, then the value of
     * the new returned object satisfies the contract of the no-argument
     * constructor for {@code T}. If {@code T} does not have a no-argument
     * constructor, then the value of the new returned object satisfies the
     * contract of the constructor call that was used to initialize {@code this}
     * .
     *
     * @return new object "like" {@code this} with an initial value
     * @ensures is_initial(newInstance)
     */
    T newInstance();

    /**
     * Resets {@code this} to an initial value.
     *
     * If the type {@code T} has a no-argument constructor, then {@code this}
     * satisfies the contract of the no-argument constructor for {@code T}. If
     * {@code T} does not have a no-argument constructor, then {@code this}
     * satisfies the contract of the constructor call that was used to
     * initialize {@code #this}.
     *
     * @clears this
     */
    void clear();

    /**
     * Sets {@code this} to the incoming value of {@code source}, and resets
     * {@code source} to an initial value; the declaration notwithstanding, the
     * <i>dynamic</i> type of {@code source} must be the same as the
     * <i>dynamic</i> type of {@code this}.
     *
     * If the type {@code T} has a no-argument constructor, then {@code source}
     * satisfies the contract of the no-argument constructor for {@code T}. If
     * {@code T} does not have a no-argument constructor, then {@code source}
     * satisfies the contract of the constructor call that was used to
     * initialize {@code #source}.
     *
     * @param source
     *            object whose value is to be transferred
     * @replaces this
     * @clears source
     * @ensures this = #source
     */
    void transferFrom(T source);

}

