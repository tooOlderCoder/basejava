import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        int count = 0;
        while (count < storage.length) {
            if (storage[count] == null) {
                storage[count] = r;
                break;
            } else {
                count++;
            }
        }
    }

    Resume get(String uuid) {
        for (Resume resume : storage) {
            if (resume.toString().equals(uuid)) {
                return resume;
            } else {
                return null;
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length - 1; i++) {
            if (storage[i].toString().equals(uuid)) {
                storage[i] = null;
            } else {
                break;
            }
        }
        for (int i = 0; i < storage.length - 1; i++) {
            if (storage[i] == null) {
                storage[i] = storage[i + 1];
                storage[i + 1] = null;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int count = 0;
        for (Resume resume : storage) {
            if (resume != null) {
                count++;
            }
        }
        Resume[] noNull = new Resume[count];
        for (int i = 0; i < noNull.length; i++) {
            noNull[i] = storage[i];
        }
        return noNull;
    }

    int size() {
        int size = 0;
        for (Resume resume : storage) {
            if (resume != null) {
                size++;
            }
        }
        return size;
    }
}
