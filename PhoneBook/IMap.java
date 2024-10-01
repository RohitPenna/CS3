public interface IMap <K,V>
{
	/**
	 * Add the key/value pair to the table
	 * @return the number previously associated with person, or null
	 */
	V put(K person, V phone);

	/**
	 * perform a table lookup
	 * @param person
	 * @return phone number mapped to this person
	 */
	V get(K person);

	/** return the current number of key/value pairs in the map */
	int size();
	
	/**
	 * Remove supplied key (person)
	 * @return value mapped to supplied person, or null
	 */
	V remove(K person);
}
