package maintanence;

public class HashTable {
	private int capacity = 4;
	private int hash;
	private int size;
	private int index;
	private Bucket[] hashtable = new Bucket[capacity];

	HashTable() {

	}

	public int HF(String key) {
		hash = 0;
		for (int i = 0; i < key.length(); i++) {
			char ch = key.charAt(i);
			hash += (int) ch;
		}
		return hash;
	}

	public int getIndex(String key) {
		index = HF(key) % capacity;
		return index;
	}

	public void put(String key, Object value) {
		if (size >= hashtable.length * .75) {
			resize();
		}
		if (key != null) {
			index = getIndex(key);
			for (int i = 0; i < hashtable.length; i++) {
				if (hashtable[index] != null) {
					index = (index % capacity) + 1;
				}
			}
			hashtable[index] = new Bucket(key, value);
		}
		size++;
	}

	private Bucket[] resize() {
		int newCapacity = capacity * 2;
		Bucket[] newHashTable = new Bucket[newCapacity];

		for (int i = 0; i < capacity; i++) {
			if (hashtable[i] != null) {
				if (HF(hashtable[i].key) % capacity == HF(hashtable[i].key) % newCapacity) {
					newHashTable[i] = hashtable[i];
				} else {
					index = HF(hashtable[i].key) % newCapacity;
					newHashTable[index] = hashtable[i];
				}
			}
		}
		this.hashtable = newHashTable;
		this.capacity = newCapacity;
		return hashtable;
	}

	public String toString() {
		String out = "<table>\n   NAME   | TICKET ID |  REQUEST \n================================\n";

		for (int i = 0; i < hashtable.length; i++) {
			Bucket item = hashtable[i];

			if (item != null) {
				out += hashtable[i].key;

				for (int j = 0; j < formatting(hashtable[i].key); j++) { // lines up the tables
					out += " ";
				}
				out += " (" + HF(hashtable[i].key) + ") " + "     " + hashtable[i].value + "\n";
			}
		}
		return out;
	}

	public int formatting(String key) {
		if (key.length() < 13) {
			int spaces = 13 - key.length();

			return spaces;
		}
		return 3;
	}

}
