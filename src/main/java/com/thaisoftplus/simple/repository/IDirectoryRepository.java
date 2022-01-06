package com.thaisoftplus.simple.repository;

import java.io.IOException;
import java.util.List;

public interface IDirectoryRepository {
    List<String> listFilesUsingFileWalk(String dir, int depth) throws IOException;
}
