package tech.itpark.itpark2021.lesson29.service.impl;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import org.springframework.stereotype.Service;
import tech.itpark.itpark2021.lesson29.service.ZipFiles;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ZipFilesImpl implements ZipFiles {

    private static ZipParameters ZIP_PARAMETERS;
    private static String PATH_TO_ADD = "./src/main/resources/lesson28/add/";

    static {
        ZIP_PARAMETERS = new ZipParameters();
        ZIP_PARAMETERS.setEncryptFiles(true);
        ZIP_PARAMETERS.setCompressionLevel(CompressionLevel.NORMAL);
        ZIP_PARAMETERS.setEncryptionMethod(EncryptionMethod.AES);
    }

    @Override
    public boolean createZipFile(String filename, String addingFileName, char[] password) {
        try (ZipFile zipFile = new ZipFile(PATH_TO_ADD + filename, password)) {
            zipFile.addFile(addingFileName, ZIP_PARAMETERS);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean createZipFiles(String filename, List<File> files, char[] password) {
        try (ZipFile zipFile = new ZipFile(PATH_TO_ADD + filename, password)) {
            zipFile.addFiles(files, ZIP_PARAMETERS);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean createZipFileByFolder(String filename, File folder, char[] password) {
        try (ZipFile zipFile = new ZipFile(PATH_TO_ADD + filename, password)) {
            zipFile.addFolder(folder, ZIP_PARAMETERS);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
