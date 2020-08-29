package ds.common;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Optional;

public class FileStorage {
    private static final Logger log = LogManager.getLogger(FileStorage.class.getName());

    public static <T> void writeObjToFile(T objectToSerialize, String filepath, boolean verbose) {
        try (
                FileOutputStream fileOut = new FileOutputStream(filepath);
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)
        ) {
            objectOut.writeObject(objectToSerialize);
            if (verbose) {
                log.info("The Object was successfully written to file");
            }
        } catch (FileNotFoundException e) {
            log.warn("File was not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> Optional<T> readObjFromFile(String filepath, boolean verbose) {
        T obj = null;
        try (
                FileInputStream fileIn = new FileInputStream(filepath);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn)
        ) {
            obj = (T) objectIn.readObject();
            if (verbose) {
                log.info("The Object has been read from file");
            }
        } catch (FileNotFoundException e) {
            log.warn("File was not found");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(obj);
    }

}
