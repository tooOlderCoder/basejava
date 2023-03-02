import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume r) {
        int count = 0;
        while (count < storage.length) {
            if (storage[count] == null) {
                storage[count] = r;
                size++;
                break;
            } else {
                count++;
            }
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].toString().equals(uuid)) {
                return storage[i];
            } else {
                return null;
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length - 1; i++) {
            if (storage[i].toString().equals(uuid)) {
                storage[i] = storage[size -1];
                storage[size - 1] = null;
                size--;
            } else {
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] noNull = new Resume[size];
        System.arraycopy(storage, 0, noNull, 0, noNull.length);
        return noNull;
    }

    int size() {
        return size;
    }
}
