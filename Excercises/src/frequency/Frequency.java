package frequency;

import java.util.Set;

public interface Frequency<E> {
	/**
	 * Ökar antal förekomster av e med nbr.
	 */
	void incNbr(E e, int nbr);
	
	/**
	 * Returnerar antalet förekomster av e.
	 */
	int getNbr(E e);

	/**
	 * Returnerar en mängd med alla element som vars antal förekomster ligger i
	 * intervallet min...max.
	 */
	Set<E> elements(int min, int max);
}
