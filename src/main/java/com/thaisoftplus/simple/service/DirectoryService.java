package com.thaisoftplus.simple.service;

import java.util.ArrayList;
import java.util.List;

import com.thaisoftplus.simple.repository.IDirectoryRepository;

public class DirectoryService implements IDirectoryService {
    private IDirectoryRepository directoryRepository;

    public DirectoryService(IDirectoryRepository directoryRepository) {
        this.directoryRepository = directoryRepository;
    }

    @Override
    public List<String> getFiles(String dir) {
        try {
            return this.directoryRepository.listFilesUsingFileWalk(dir, 1);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
